package com.isep;

public class Aeroport{
    private String Nom;
    private String Ville;
    private String Description;

    public Aeroport(String Nom, String Ville, String Description) {
        this.Nom = Nom;
        this.Ville = Ville;
        this.Description = Description;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getVille() {
        return Ville;
    }

    public void setVille(String Ville) {
        this.Ville = Ville;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    
    public void affecterVol(){
        System.out.println("Vol affecté à l'aéroport : " + this.getNom());
    }
}