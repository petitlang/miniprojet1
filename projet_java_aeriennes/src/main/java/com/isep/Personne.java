package com.isep;

public class Personne {
    private String Identifiant;
    private String Nom;
    private String Adresse;
    private String Contact;

    public Personne(String Identifiant, String Nom, String Adresse, String Contact) {
        this.Identifiant = Identifiant;
        this.Nom = Nom;
        this.Adresse = Adresse;
        this.Contact = Contact;
    }

    public String getIdentifiant() {
        return Identifiant;
    }

    public void setIdentifiant(String Identifiant) {
        this.Identifiant = Identifiant;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String Contact) {
        this.Contact = Contact;
    }

    public void ObtenirInfos(){
        System.out.println("Identifiant : " + Identifiant);
        System.out.println("Nom : " + Nom);
        System.out.println("Adresse : " + Adresse);
        System.out.println("Contact : " + Contact);
    }
}
