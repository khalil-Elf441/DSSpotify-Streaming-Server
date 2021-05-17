package TP;
/*
 * This file is part of VLCJ. 
 * 
 * VLCJ is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or 
 * (at your option) any later version. 
 * 
 * VLCJ is distributed in the hope that it will be useful, 
 * but WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the 
 * GNU General Public License for more details. 
 * 
 * You should have received a copy of the GNU General Public License 
 * along with VLCJ.  If not, see <http://www.gnu.org/licenses/>. 
 * 
 * Copyright 2009, 2010, 2011, 2012 Caprica Software Limited. 
 */
 
 
 
import com.sun.jna.Native;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.discovery.NativeDiscovery;
import uk.co.caprica.vlcj.player.MediaPlayerFactory; 
import uk.co.caprica.vlcj.player.headless.HeadlessMediaPlayer;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;
import uk.co.caprica.vlcj.test.VlcjTest; 
 
/**
 * Exemple de Streaming Audio en RTSP
 * source : http://www.javased.com/index.php?source_dir=vlcj/src/test/java/uk/co/caprica/vlcj/test/streaming/
 */ 
public class StreamRtsp { 
	
	static String myNetworkInterface = "localhost";
	
 /* Main Test
    public static void main(String[] args) throws Exception { 
    	
        //rechargement des fichier dll de VLC
		
  		 NativeDiscovery nd = new NativeDiscovery();
  		 if (!nd.discover()) {
  		     System.out.println("VLC not found");
  		     System.exit(-1);
  		 }   
  		 String vlcLibName = RuntimeUtil.getLibVlcLibraryName();
  		 String vlcLibCoreName = RuntimeUtil.getLibVlcLibraryName();
  		 Native.loadLibrary(vlcLibName, LibVlc.class);
 
       //
  		Streaming();
  		 //
  		
  	  // Don't exit 
        Thread.currentThread().join(); 
    } 
    */
    
    public void Streaming() {
		try {
			String dataDir = "";
			start(myNetworkInterface, 5555, dataDir  + "resource_files/Souf_sf.mp3", "souf");
			String soufStreaming = "rtsp://@" + myNetworkInterface + ":5555/souf";
			System.out.println("Streaming souf ON : " + soufStreaming);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    

    private String formatRtspStream(String serverAddress, int serverPort, String id) {
        StringBuilder stringbuilder = new StringBuilder(60);
        stringbuilder.append(":sout=#rtp{sdp=rtsp://@");
        stringbuilder.append(serverAddress);
        stringbuilder.append(':');
        stringbuilder.append(serverPort);
        stringbuilder.append('/');
        stringbuilder.append(id);
        stringbuilder.append("}");
        return stringbuilder.toString();
    }


      void start(String address, int port, String music,String type) throws Exception {
        String media = music;
        String options = formatRtspStream(address, port, type);

        System.out.println("Streaming '" + media + "' to '" + options + "'");

        MediaPlayerFactory mediaPlayerFactory = new MediaPlayerFactory();
        HeadlessMediaPlayer mediaPlayer = mediaPlayerFactory.newHeadlessMediaPlayer();
        mediaPlayer.setRepeat(true);
        mediaPlayer.playMedia(media,
            options,
            ":no-sout-rtp-sap",
            ":no-sout-standard-sap",
            ":sout-all",
            ":sout-keep"
        );
    }
}