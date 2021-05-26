package TP;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import com.zeroc.Ice.Current;

import MorceauManager.Mp3filesManager;


/**
 * @author etudiant
 * Implementation des fonctions ice
 */
public class Mp3filesManagerImpl implements Mp3filesManager{

	
	public Mp3TempDB db = new Mp3TempDB();
	public StreamRtsp stmR = new StreamRtsp();

	public Mp3filesManagerImpl() {
		super();
		
		//stmR.Streaming("maroon-5-memories.mp3");
	}

	@Override
	public String findByTitreAuteur(String title, String Auteur, Current current) {		
		return db.findByTitreAuteur(title, Auteur, current);
	}
	
	
	public static void copyFile(String from, String to) throws IOException{ 
		Path src = Paths.get(from);
		Path dest = Paths.get(to); 
		Files.copy(src, dest, StandardCopyOption.REPLACE_EXISTING); 
	}

	

	@Override
	public boolean ajouterMorceauMp3(String title, String Auteur, String path, Current current) {
		System.out.println("Morceau added !");
		try {
			copyFile(path,"C:\\Users\\etudiant\\eclipse-workspace\\DSSpotify-Streaming-Server\\resource_files\\"+Auteur+"_"+title+".mp3");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return db.ajouterMorceauMp3(title, Auteur, path, current);
	}

	@Override
	public boolean modifierMorceauMp3(String title, String Auteur, String newtitle, Current current) {
		
		//String m = db.findByTitreAuteur("Memories", "Maroon-5", current);
		//File f1 = new File(m);
		
		//
		String path  = "C:\\Users\\etudiant\\eclipse-workspace\\DSSpotify-Streaming-Server\\resource_files\\" ;
		//File f2 = new File(path+Auteur+"_"+title+".mp3");
		
		Path source = Paths.get(path+Auteur+"_"+title+".mp3");

		  try{
		    Files.move(source, source.resolveSibling(Auteur+"_"+newtitle+".mp3"));		    
		    //System.out.println("Rename "+m+" to -> "+path+Auteur+"_"+newtitle+".mp3 OK");
			return true;

		  } catch (IOException e) {
		    e.printStackTrace();
		   // System.out.println("Rename "+m+" to -> "+path+Auteur+"_"+newtitle+".mp3 Failed");
			return false;
		  }
		
		  /*
		if(f1.renameTo(f2)) {
			System.out.println("Rename "+m+" to -> "+path+Auteur+"_"+newtitle+".mp3 OK");
			return true;
		}
	
		
		System.out.println("Rename "+m+" to -> "+path+Auteur+"_"+newtitle+".mp3 Failed");
		return false;
		*/
		
		
		//String path  = "C:\\Users\\etudiant\\eclipse-workspace\\DSSpotify-Streaming-Server\\resource_files\\" ;
		//File f1 = new File(path+"2OneRepublic_Counting-Stars.mp3");
		//File f2 = new File("newname.txt");
		//boolean b = f1.renameTo(f2);
		
		
		//return db.modifierMorceauMp3(title, Auteur, newtitle, current);
		//"Memories", "Maroon-5"
		
		//System.out.println(m);
		
		//return true;
	}

	@Override
	public boolean supprimerMorceauMp3(String title, String path, Current current) {
		
        File file = new File(path);
        
        if(file.delete())
        {
            System.out.println("File "+title+" deleted successfully");
        }
        else
        {
            System.out.println("Failed to delete the file "+title);
        }
        
		return db.supprimerMorceauMp3(title, path, current);
	}
	
	

	@Override
	public boolean arreterStream(Current current) {
		stmR.stopStream();
		return true;
	}



	@Override
	public boolean pauseStream(Current current) {
		stmR.pauseStream();;
		return true;
	}

	@Override
	public boolean resumeStream(Current current) {
		stmR.resumeStream();
		return false;
	}

	@Override
	public boolean startStream(String music, Current current) {		
		stmR.Streaming(music);
		return false;
	}

	@Override
	public String findByTitre(String title, Current current) {
		return db.findByTitre(title, current);
	}

	@Override
	public String findByAuteur(String Auteur, Current current) {
		return db.findByAuteur(Auteur, current);
	}



}
