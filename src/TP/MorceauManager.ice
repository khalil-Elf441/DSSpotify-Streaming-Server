module MorceauManager
{
    interface Mp3filesManager
    {
        bool ajouterMorceauMp3(string title, string Auteur, string path);
        bool supprimerMorceauMp3(string title, string path);
        bool modifierMorceauMp3(string title, string Auteur, string newtitle);
        string findByTitreAuteur(string title, string Auteur);
	string findByTitre(string title);
	string findByAuteur(string Auteur);
	bool arreterStream();
	bool resumeStream();
	bool startStream(string music);
	bool pauseStream();
    }
}
    