package TP;


/**
 * @author khalil
 * structure principale des fichiers audio
 */
public class Morceau {
	
	
	private String Titre;
	private String Auteur;
	private String path;
		
	public Morceau(String titre, String auteur, String path) {
		super();
		Titre = titre;
		Auteur = auteur;
		this.path = path;
	}

	public String getTitre() {
		return Titre;
	}
	public void setTitre(String titre) {
		Titre = titre;
	}
	public String getAuteur() {
		return Auteur;
	}
	public void setAuteur(String auteur) {
		Auteur = auteur;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "Morceau [Titre=" + Titre + ", Auteur=" + Auteur + ", path=" + path + ", toString()=" + "]";
	}
	
	
	

}
