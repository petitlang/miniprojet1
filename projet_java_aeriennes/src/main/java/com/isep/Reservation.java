package com.isep;

import java.util.ArrayList;

public class Reservation{
    private int numeroReservation;
    private String dateReservation;
    private String statut;
    protected ArrayList<Vol> volsReserve;
    protected Passager passager;

    public Reservation(int numeroReservation, String dateReservation, String statut, Passager passager) {
        this.numeroReservation = numeroReservation;
        this.dateReservation = dateReservation;
        this.statut = statut;
        this.volsReserve = new ArrayList<Vol>();
        this.passager = passager;
    }

    public int getNumeroReservation() {
        return numeroReservation;
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

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public void confirmerReservation(int numeroReservation){
        for(Reservation reservation : passager.reservations){
            if(reservation.getNumeroReservation() == numeroReservation){
                reservation.setStatut("confirmée");
                System.out.println("Reservation confirmée pour le passager : "+ this.passager+"\n" + this.getNumeroReservation());
            }else{
                System.out.println("Pas de reservation correspendante pour "+ this.passager);
            }
        }
    }

    public void annulerReservation(int numeroReservation){
        for(Reservation reservation : passager.reservations){
            if(reservation.getNumeroReservation() == numeroReservation){
                passager.reservations.remove(reservation);
                System.out.println("Reservation annulée pour le passager : "+ this.passager+"\n" + this.getNumeroReservation());
            }else{
                System.out.println("Pas de reservation correspendante pour "+ this.passager);
            }
        }
    }

    public void modifierReservation(int numeroReservation){
        for(Reservation reservation : passager.reservations){
            if(reservation.getNumeroReservation() == numeroReservation){
                reservation.setStatut("modifiée");
                System.out.println("Reservation modifiée pour le passager : "+ this.passager+"\n" + this.getNumeroReservation());
            }else{
                System.out.println("Pas de reservation correspendante pour "+ this.passager);
            }
        }
    }
    
    public void addVol(int numeroVol){
        for(Vol vol : vols){
            if(vol.getNumeroVol() == numeroVol){
                volsReserve.add(vol);
            }
        }
    }

    public void obtenirReservations(int numeroReservation){
        for(Reservation reservation : passager.reservations){
            if(reservation.getNumeroReservation() == numeroReservation){
                System.out.println("Reservation : "+ reservation.getNumeroReservation() + ", Date : "+ reservation.getDateReservation() +
                ", Statut : "+ reservation.getStatut() + ", Passager : "+ reservation.passager + ", Vols : "+ reservation.volsReserve);
            }else{
                System.out.println("Pas de reservation correspendante pour "+ this.passager);
            }
            
        }
    }
}
