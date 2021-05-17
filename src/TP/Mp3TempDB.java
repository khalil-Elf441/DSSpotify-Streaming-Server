package TP;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.zeroc.Ice.Current;


public class Mp3TempDB {
	

	static Set<Morceau> Mp3LogicFiles = new HashSet();
	
	
	public boolean ajouterMorceauMp3(String title, String Auteur, String path, Current current) {
		
		if(this.Mp3LogicFiles.add(new Morceau(title, Auteur, path)))return true;
		
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
		
		for (Morceau morceau : Mp3LogicFiles) {
	        if(morceau.getTitre().equals(title) && morceau.getAuteur().equals(Auteur)) {
	        	return morceau.toString();
	        }
	     }	
		return "No file found";
	}
	
	
	
	
	

}
