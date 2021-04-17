module ServerSide
{
    interface Mp3filesManager
    {
        string addNewMorceauMp3(string title, string Auteur, string path);
        string deleteMorceauMp3(string path);
        void setMorceauMp3(string title, string Auteur, string newtitle);
        string findByTitreAuteur(string title, string Auteur);
    }
}
    