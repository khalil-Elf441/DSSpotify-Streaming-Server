package TP;

import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.headless.HeadlessMediaPlayer;

/**
 * Exemple de Streaming Audio en RTSP(Real Time Streaming Protocol) de fichier souf_sf.mp3 en java
 * source : http://www.javased.com/index.php?source_dir=vlcj/src/test/java/uk/co/caprica/vlcj/test/streaming/
 */ 
public class StreamRtsp { 
	
	String InterfaceAdress = "localhost";
	 public static HeadlessMediaPlayer mediaPlayer;
	
    //lien de lancement de streaming
    public void Streaming(String music) {
		try {
			start(InterfaceAdress, 5555,  "resource_files/"+music, "music");			
			String soufStreaming = "rtsp://@" + InterfaceAdress + ":5555/music";
			System.out.println("Streaming "+music+" ON : " + soufStreaming);
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
         mediaPlayer = mediaPlayerFactory.newHeadlessMediaPlayer();
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
     
     public void pauseStream() {
    	 mediaPlayer.pause();
    	 System.out.println("Media Player Pause / "+mediaPlayer.getMediaState());  	
     }
     
     public void stopStream() {
    	 mediaPlayer.stop();
    	 System.out.println("Media Player Stop / "+mediaPlayer.getMediaState());
     }
     
     public void resumeStream() {
    	 mediaPlayer.start();
    	 mediaPlayer.setRepeat(true);
    	 System.out.println("Media Player Start / "+mediaPlayer.getMediaState());
     }
     
     
     
     
     
}