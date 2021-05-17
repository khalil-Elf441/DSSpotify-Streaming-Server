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

import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.headless.HeadlessMediaPlayer;

/**
 * Exemple de Streaming Audio en RTSP(Real Time Streaming Protocol) de fichier souf_sf.mp3 en java
 * source : http://www.javased.com/index.php?source_dir=vlcj/src/test/java/uk/co/caprica/vlcj/test/streaming/
 */ 
public class StreamRtsp { 
	
	String InterfaceAdress = "localhost";
	
    //lien de lancement de streaming
    public void Streaming() {
		try {
			start(InterfaceAdress, 5555,  "resource_files/Souf_sf.mp3", "souf");
			String soufStreaming = "rtsp://@" + InterfaceAdress + ":5555/souf";
			System.out.println("Streaming souf ON : " + soufStreaming);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    //creation de lien de streaming en RTSP 
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

    //options de Streaming
     void start(String address, int port, String music,String type) throws Exception {
        String media = music;
        String options = formatRtspStream(address, port, type);

        System.out.println("Streaming '" + media + "' to '" + options + "'");

        MediaPlayerFactory mediaPlayerFactory = new MediaPlayerFactory();
        HeadlessMediaPlayer mediaPlayer = mediaPlayerFactory.newHeadlessMediaPlayer();
        //Répétition de lecture de fichier audio
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