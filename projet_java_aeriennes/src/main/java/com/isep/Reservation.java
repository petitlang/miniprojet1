package com.isep;

import java.util.ArrayList;

public class Reservation{
    private int numeroReservation;
    private String dateReservation;
    private String statut;
    protected ArrayList<Vol> volsReserve;
    private String Passeport;

    public static ArrayList<Reservation> reservations = new ArrayList<Reservation>();

    public static ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public Reservation(int numeroReservation, String dateReservation, String statut, String Passeport) {
        this.numeroReservation = numeroReservation;
        this.dateReservation = dateReservation;
        this.statut = statut;
        this.volsReserve = new ArrayList<Vol>();
        this.Passeport = Passeport;
        reservations.add(this);
    }

    public int getNumeroReservation() {
        return numeroReservation;
    }

    public String getPasseport() {
        return Passeport;
    }

    public void setNumeroReservation(int numeroReservation) {
        this.numeroReservation = numeroReservation;
    }

    public String getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(String dateReservation) {
        this.dateReservation = dateReservation;
    }

    public String getStatut() {
        return statut;
    }

    public ArrayList<Vol> getVolsReserve() {
        return volsReserve;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public void confirmerReservation(int numeroReservation){
        for(Reservation reservation : reservations){
            if(reservation.getNumeroReservation() == numeroReservation){
                reservation.setStatut("confirmée");
                System.out.println("Reservation confirmée pour le passager : "+ reservation.getPasseport()+"\n" + reservation.getNumeroReservation());
            }
        }
    }

    public void annulerReservation(int numeroReservation){
        for(Reservation reservation : reservations){
            if(reservation.getNumeroReservation() == numeroReservation){
                reservations.remove(reservation);
                System.out.println("Reservation annulée pour le passager : "+ reservation.getPasseport()+"\n" + reservation.getNumeroReservation());
            }
        }
    }

    public void modifierReservation(int numeroReservation, String dateReservation){
        for(Reservation reservation : reservations){
            if(reservation.getNumeroReservation() == numeroReservation){
                reservation.setDateReservation(dateReservation);
                System.out.println("Reservation modifiée pour le passager : "+ reservation.getPasseport()+"\n" + reservation.getNumeroReservation());
            }
        }
    }
    
    public void addVol(String numeroVol){
        for(Vol vol : Vol.getVols()){
            if(vol.getNumeroVol() == numeroVol){
                volsReserve.add(vol);
            }
        }
    }

    public void obtenirReservations(int numeroReservation){
        for(Reservation reservation : reservations){
            if(reservation.getNumeroReservation() == numeroReservation){
                System.out.println("Reservation : "+ reservation.getNumeroReservation() + ", Date : "+ reservation.getDateReservation() +
                ", Statut : "+ reservation.getStatut() + ", Passager : "+ reservation.getPasseport() + ", Vols : "+ reservation.volsReserve);
            }            
        }
    }
}
