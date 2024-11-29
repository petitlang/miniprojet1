package com.isep;

public class PersonnelCabine extends Employe{
    private String qualification;

    public PersonnelCabine(String Identifiant, String Nom, String Adresse, String Contact, String NumeroEmploye, String DataEmbauche, String qualification) {
        super(Identifiant, Nom, Adresse, Contact, NumeroEmploye, DataEmbauche);
        this.qualification = qualification;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public void affecterVol(){
        System.out.println("Vol affecté au personnel de cabine : " + this.getNom());
    }

    public void obtenirVol(){
        System.out.println("Vol obtenu par le personnel de cabine : " + this.getNom());
    }
    
}
