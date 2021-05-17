package TP;

import com.zeroc.Ice.Current;

import ServerSide.Mp3filesManager;

public class Mp3filesManagerImpl implements Mp3filesManager{

	
	

	public Mp3filesManagerImpl() {
		super();
		StreamRtsp stmR = new StreamRtsp();
		stmR.Streaming();
	}

	@Override
	public String findByTitreAuteur(String title, String Auteur, Current current) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String ajouterMorceauMp3(String title, String Auteur, String path, Current current) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String supprimerMorceauMp3(String path, Current current) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifierMorceauMp3(String title, String Auteur, String newtitle, Current current) {
		// TODO Auto-generated method stub
		
	}

}
