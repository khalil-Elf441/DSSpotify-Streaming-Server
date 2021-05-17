package TP;

import com.zeroc.Ice.Current;

import ServerSide.Mp3filesManager;

public class Mp3filesManagerImpl implements Mp3filesManager{

	
	public Mp3TempDB db = new Mp3TempDB();

	public Mp3filesManagerImpl() {
		super();
		StreamRtsp stmR = new StreamRtsp();
		stmR.Streaming();
	}

	@Override
	public String findByTitreAuteur(String title, String Auteur, Current current) {		
		return db.findByTitreAuteur(title, Auteur, current);
	}

	@Override
	public boolean ajouterMorceauMp3(String title, String Auteur, String path, Current current) {
		return db.ajouterMorceauMp3(title, Auteur, path, current);
	}



	@Override
	public boolean modifierMorceauMp3(String title, String Auteur, String newtitle, Current current) {
		return db.modifierMorceauMp3(title, Auteur, newtitle, current);
	}

	@Override
	public boolean supprimerMorceauMp3(String title, String path, Current current) {
		return db.supprimerMorceauMp3(title, path, current);
	}



}
