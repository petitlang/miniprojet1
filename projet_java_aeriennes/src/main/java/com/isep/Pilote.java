package com.isep;

import java.util.ArrayList;

public class Pilote extends Employe{
    private String Licence;
    private String heuresDeVols;
    protected ArrayList<Vol> volsPilote;

    public Pilote(String Identifiant, String Nom, String Adresse, String Contact, String NumeroEmploye, String DataEmbauche, String Licence, String heuresDeVols) {
        super(Identifiant, Nom, Adresse, Contact, NumeroEmploye, DataEmbauche);
        this.Licence = Licence;
        this.heuresDeVols = heuresDeVols;
        this.volsPilote = new ArrayList<Vol>();
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

    public void affecterVol(Vol vol){
        this.volsPilote.add(vol);
        System.out.println("Vol " + vol.getNumeroVol() + " , pilote - " + this.getNom() );
    }

    public void obtenirVol(int numeroVol){
        for (Vol vol : volsPilote) {
            if (vol.getNumeroVol() == numeroVol) {
                vol.obtenirVol();
            }
        }
    }
}