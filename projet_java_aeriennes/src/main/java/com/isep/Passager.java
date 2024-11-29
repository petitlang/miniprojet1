package com.isep;

import java.util.ArrayList;

public class Passager extends Personne{
    private String Passeport;
    protected ArrayList<Reservation> reservations;

    public Passager(String Identifiant, String Nom, String Adresse, String Contact, String Passeport) {
        super(Identifiant, Nom, Adresse, Contact);
        this.Passeport = Passeport;
        this.reservations = new ArrayList<Reservation>();
    }

    public String getPasseport() {
        return Passeport;
    }

    public void setPasseport(String Passeport) {
        this.Passeport = Passeport;
    }

    public void reserverVol(int numeroVol, int numeroReservation, String date, String statut) {
        Reservation newReservation = new Reservation(numeroReservation, date, statut, this);
        newReservation.addVol(numeroVol);
        this.reservations.add(newReservation);
        System.out.println("Vol " + numeroVol + " réservé avec succès pour " + this.getNom());
    }

    public void annulerReservation(int  numeroReservation) {
        for (Reservation reservation : reservations) {
            if (reservation.getNumeroReservation() == numeroReservation) {
                reservations.remove(reservation);
                System.out.println("Reservation " + numeroReservation + " annulée.");
            }else{
                System.out.println("Aucune réservation trouvée pour le numéro " + numeroReservation);
            }
        }
        
    }

    public void obtenirReservations() {
        for (Reservation reservation : reservations) {
            System.out.println("Réservation : " + reservation.getNumeroReservation() + ", Date : " + reservation.getDateReservation());
        }
    }
}
