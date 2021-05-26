package TP;

import java.io.File;
import java.io.FilenameFilter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.zeroc.Ice.Current;


/**
 * @author etudiant
 * stockage temporaire des morceaux
 */
public class Mp3TempDB {
	

	static Set<Morceau> Mp3LogicFiles = new HashSet();
	
	
	public boolean ajouterMorceauMp3(String title, String Auteur, String path, Current current) {
		
		if(this.Mp3LogicFiles.add(new Morceau(title, Auteur, path))) {
			//copy file
			return true;
		}
		
		return false;
	}

	
	public boolean supprimerMorceauMp3(String titre, String path, Current current) {
		
		for (Morceau morceau : Mp3LogicFiles) {
	        if(morceau.getTitre().equals(titre)) {
	        	Mp3LogicFiles.remove(morceau);
	        	return true;
	        }
	     }
	     
		return false;
	}

	
	public boolean modifierMorceauMp3(String title, String Auteur, String newtitle, Current current) {
		
		for (Morceau morceau : Mp3LogicFiles) {
	        if(morceau.getTitre().equals(title) && morceau.getAuteur().equals(Auteur)) {
	        	morceau.setTitre(newtitle);
	        	return true;
	        }
	     }
	     
		return false;
	}
	
	
	public String findByTitreAuteur(String title, String Auteur, Current current) {
		
		/*
		for (Morceau morceau : Mp3LogicFiles) {
	        if(morceau.getTitre().equals(title) && morceau.getAuteur().equals(Auteur)) {
	        	return morceau.toString();
	        }
	     }	
	     */
		
		 File dir = new File("C:\\Users\\etudiant\\eclipse-workspace\\DSSpotify-Streaming-Server\\resource_files");
		 
	      FilenameFilter filter = new FilenameFilter() {
	         public boolean accept (File dir, String name) { 
	            return name.contains(Auteur+"_"+title);
	         } 
	      }; 
	      
	      String[] children = dir.list(filter);
	      
	      if (children == null) {
	         System.out.println("dir does not exist"); 
	      } else { 
	         for (int i = 0; i< children.length; i++) {
	            String filename = children[i];
	            //System.out.println(filename);
	            //
	            return "C:\\Users\\etudiant\\eclipse-workspace\\DSSpotify-Streaming-Server\\resource_files\\"+filename;
	         } 
	      } 
		return "No file found";
	}
	
	
	public String findByTitre(String title, Current current) {
		
		/*
		for (Morceau morceau : Mp3LogicFiles) {
	        if(morceau.getTitre().equals(title)) {
	        	return morceau.toString();
	        }
	     }	
	     */
		
		 File dir = new File("C:\\Users\\etudiant\\eclipse-workspace\\DSSpotify-Streaming-Server\\resource_files");
		 
	      FilenameFilter filter = new FilenameFilter() {
	         public boolean accept (File dir, String name) { 
	            return name.contains(title);
	         } 
	      }; 
	      
	      String[] children = dir.list(filter);
	      
	      if (children == null) {
	         System.out.println("dir does not exist"); 
	      } else { 
	         for (int i = 0; i< children.length; i++) {
	            String filename = children[i];
	            //System.out.println(filename);
	            //
	            return "C:\\Users\\etudiant\\eclipse-workspace\\DSSpotify-Streaming-Server\\resource_files\\"+filename;
	         } 
	      } 
		return "No file found";
	}
	
	
	public String findByAuteur(String Auteur, Current current) {
		
		for (Morceau morceau : Mp3LogicFiles) {
	        if(morceau.getAuteur().equals(Auteur)) {
	        	return morceau.toString();
	        }
	     }	
		
		 File dir = new File("C:\\Users\\etudiant\\eclipse-workspace\\DSSpotify-Streaming-Server\\resource_files");
		 
	      FilenameFilter filter = new FilenameFilter() {
	         public boolean accept (File dir, String name) { 
	            return name.contains(Auteur);
	         } 
	      }; 
	      
	      String[] children = dir.list(filter);
	      
	      if (children == null) {
	         System.out.println("dir does not exist"); 
	      } else { 
	         for (int i = 0; i< children.length; i++) {
	            String filename = children[i];
	            //System.out.println(filename);
	            //
	            return "C:\\Users\\etudiant\\eclipse-workspace\\DSSpotify-Streaming-Server\\resource_files\\"+filename;
	         } 
	      } 
		return "No file found";
	}
	
	
	
	

}
