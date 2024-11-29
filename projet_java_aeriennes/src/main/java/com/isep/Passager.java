package com.isep;

public class Passager extends Personne{
    private String Passeport;

    public Passager(String Identifiant, String Nom, String Adresse, String Contact, String Passeport) {
        super(Identifiant, Nom, Adresse, Contact);
        this.Passeport = Passeport;
    }

    public String getPasseport() {
        return Passeport;
    }

    public void setPasseport(String Passeport) {
        this.Passeport = Passeport;
    }

    public void reserverVol(int numeroVol, String numeroReservation){
        System.out.println("Vol réservé pour le passager : " + this.getNom());
    }

    public void annulerReservation(){
        System.out.println("Reservation annulée pour le passager : " + this.getNom());
    }

    public void obtenirReservation(){
        System.out.println("Reservation obtenue par le passager : " + this.getNom());
    }
}
