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
 * An example of how to stream a media file using RTSP. 
 * <p> 
 * The client specifies an MRL of <code>rtsp://@127.0.0.1:5555/demo</code> 
 */ 
public class StreamRtsp { 
	
	static String myNetworkInterface = "localhost";
 /*
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
  		startTele();
  		 //
  		
  	  // Don't exit 
        Thread.currentThread().join(); 
    } 
    */
    
    public static void Streaming() {
		try {
			String dataDir = "";
			start(myNetworkInterface, 5555, dataDir  + "resource_files/Souf_sf.mp3", "souf");
			String soufStreaming = "rtsp://@" + myNetworkInterface + ":5555/souf";
			System.out.println("Streaming souf ON : " + soufStreaming);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    /**
     * 
     * @param serverAddress
     * @param serverPort
     * @return  mediaOptions for rtp stream wih vlc
     */
    private static String formatRtspStream(String serverAddress, int serverPort, String id) {
        StringBuilder sb = new StringBuilder(60);
        sb.append(":sout=#rtp{sdp=rtsp://@");
        sb.append(serverAddress);
        sb.append(':');
        sb.append(serverPort);
        sb.append('/');
        sb.append(id);
        sb.append("}");
        return sb.toString();
    }

    /**
     * Start streaming of music by adding music to the playList
     * 
     * @param dir
     * @param address
     * @param port
     * @param musique
     * @throws Exception
     */
     static void start(String address, int port, String music,String type) throws Exception {
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