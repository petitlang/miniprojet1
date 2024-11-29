package com.isep;

public class Employe extends Personne{
    private String NumeroEmploye;
    private String DataEmbauche;
    
    public Employe(String Identifiant, String Nom, String Adresse, String Contact, String NumeroEmploye, String DataEmbauche) {
        super(Identifiant, Nom, Adresse, Contact);
        this.NumeroEmploye = NumeroEmploye;
        this.DataEmbauche = DataEmbauche;
    }

    public String getNumeroEmploye() {
        return NumeroEmploye;
    }

    public void setNumeroEmploye(String NumeroEmploye) {
        this.NumeroEmploye = NumeroEmploye;
    }

    public String getDataEmbauche() {
        return DataEmbauche;
    }

    public void setDataEmbauche(String DataEmbauche) {
        this.DataEmbauche = DataEmbauche;
    }

    public String ObtenirRole(){
        return this.getIdentifiant();
    }
}
