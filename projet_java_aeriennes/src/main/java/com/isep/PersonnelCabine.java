package com.isep;

import java.util.ArrayList;

public class PersonnelCabine extends Employe{
    private String qualification;

    public static ArrayList<PersonnelCabine> personnelCabines = new ArrayList<PersonnelCabine>();

    public static ArrayList<PersonnelCabine> getPersonnelCabines() {
        return personnelCabines;
    }

    public PersonnelCabine(String Identifiant, String Nom, String Adresse, String Contact, String NumeroEmploye, String DataEmbauche, String qualification) {
        super(Identifiant, Nom, Adresse, Contact, NumeroEmploye, DataEmbauche);
        this.qualification = qualification;
        personnelCabines.add(this);
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public void affecterVol(String numeroVol){
        for (Vol vol : Vol.getVols()) {
            if (vol.getNumeroVol() == numeroVol) {
                vol.setEquipeCabine(this.getNom());
                System.out.println("Vol " + numeroVol + " affecté à " + this.getNom());
            }
        }
    }

    public void obtenirVol(String numeroVol){
        for (Vol vol : Vol.getVols()) {
            if (vol.getNumeroVol() == numeroVol) {
                System.out.println(vol); 
            }
        }
    }
    
}
