package com.isep;

public class Main {
    public static void main(String[] args) {
        Aeroport aeroport = new Aeroport("CDG", "Paris", "Aeroport de Paris");
        aeroport.affecterVol();
        System.out.println("Nom de l'aeroport : " + aeroport.getNom());
        System.out.println("Ville de l'aeroport : " + aeroport.getVille());
        System.out.println("Description de l'aeroport : " + aeroport.getDescription());

        Personne personne = new Personne("1", "John Doe", "Paris", "0123456789");
        personne.ObtenirInfos();
        System.out.println("Identifiant de la personne : " + personne.getIdentifiant());
        System.out.println("Nom de la personne : " + personne.getNom());
        System.out.println("Adresse de la personne : " + personne.getAdresse());
        System.out.println("Contact de la personne : " + personne.getContact());

        Employe employe = new Employe("2", "Jane Doe", "Paris", "9876543210", "123", "01/01/2021");
        employe.ObtenirInfos();
        System.out.println("Identifiant de l'employe : " + employe.getIdentifiant());
        System.out.println("Nom de l'employe : " + employe.getNom());
        System.out.println("Adresse de l'employe : " + employe.getAdresse());
        System.out.println("Contact de l'employe : " + employe.getContact());
        System.out.println("Numero de l'employe : " + employe.getNumeroEmploye());
        System.out.println("Date d'embauche de l'employe : " + employe.getDataEmbauche());
        System.out.println("Role de l'employe : " + employe.ObtenirRole());

        Passager passager = new Passager("3", "Jack Doe", "Paris", "1234567890", "1234567890");
        passager.ObtenirInfos();
        System.out.println("Identifiant du passager : " + passager.getIdentifiant());
        System.out.println("Nom du passager : " + passager.getNom());
        System.out.println("Adresse du passager : " + passager.getAdresse());
        System.out.println("Contact du passager : " + passager.getContact());

    }
}