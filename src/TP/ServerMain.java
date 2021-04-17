package TP;
import com.sun.jna.Native;
import com.zeroc.Ice.Object;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.discovery.NativeDiscovery;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

public class ServerMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 //rechargement des fichier dll de VLC
		 NativeDiscovery nd = new NativeDiscovery();
		 if (!nd.discover()) {
		     System.out.println("VLC not found");
		     System.exit(-1);
		 }   
		 String vlcLibName = RuntimeUtil.getLibVlcName();
		 String vlcLibCoreName = RuntimeUtil.getLibVlcCoreName();
		 Native.loadLibrary(vlcLibName, LibVlc.class);
		 

		  try(com.zeroc.Ice.Communicator communicator = com.zeroc.Ice.Util.initialize(args)){

		    com.zeroc.Ice.ObjectAdapter adapter =
		             communicator.createObjectAdapterWithEndpoints("ServerSide", "default -p 10000");
		         adapter.add((Object) new StreamRtsp(), com.zeroc.Ice.Util.stringToIdentity("ServerSide"));
		         adapter.activate();
		         
		         System.out.println("Serveur is running !");

		         communicator.waitForShutdown();
		   }
		 
	}

}
