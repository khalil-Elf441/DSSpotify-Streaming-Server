module ServerSide
{
    interface Mp3filesManager
    {
        string ajouterMorceauMp3(string title, string Auteur, string path);
        string supprimerMorceauMp3(string path);
        void modifierMorceauMp3(string title, string Auteur, string newtitle);
        string findByTitreAuteur(string title, string Auteur);
    }
}
    