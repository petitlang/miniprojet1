package com.isep;

public class Pilote extends Employe{
    private String Licence;
    private String heuresDeVols;

    public Pilote(String Identifiant, String Nom, String Adresse, String Contact, String NumeroEmploye, String DataEmbauche, String Licence, String heuresDeVols) {
        super(Identifiant, Nom, Adresse, Contact, NumeroEmploye, DataEmbauche);
        this.Licence = Licence;
        this.heuresDeVols = heuresDeVols;
    }

    public String getLicence() {
        return Licence;
    }

    public void setLicence(String Licence) {
        this.Licence = Licence;
    }

    public String getHeuresDeVols() {
        return heuresDeVols;
    }

    public void setHeuresDeVols(String heuresDeVols) {
        this.heuresDeVols = heuresDeVols;
    }

    public void affecterVol(){
        System.out.println("Vol affecté au pilote : " + this.getNom());
    }

    public void obtenirVol(){
        System.out.println("Vol obtenu par le pilote : " + this.getNom());
    }
}