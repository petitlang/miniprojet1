package com.isep;

import java.util.ArrayList;

public class Pilote extends Employe{
    private String Licence;
    private String heuresDeVols;
    protected ArrayList<Vol> volsPilote = new ArrayList<Vol>();

    public static ArrayList<Pilote> pilotes = new ArrayList<Pilote>();

    public static ArrayList<Pilote> getPilotes() {
        return pilotes;
    }

    public Pilote(String Identifiant, String Nom, String Adresse, String Contact, String NumeroEmploye, String DataEmbauche, String Licence, String heuresDeVols) {
        super(Identifiant, Nom, Adresse, Contact, NumeroEmploye, DataEmbauche);
        this.Licence = Licence;
        this.heuresDeVols = heuresDeVols;
        volsPilote = new ArrayList<Vol>();
        pilotes.add(this);
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

    public void affecterVol(int numeroVol){
        for (Vol vol : Vol.getVols()) {
            if (vol.getNumeroVol() == numeroVol) {
                vol.setPilote(this.getNom());
                System.out.println("Vol " + numeroVol + " affecté à " + this.getNom());
            }
        }
    }

    public void obtenirVol(int numeroVol){
        for (Vol vol : Vol.getVols()) {
            if (vol.getNumeroVol() == numeroVol) {
                System.out.println(vol);
            }
        }
    }
}