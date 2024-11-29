package com.isep;

import java.util.ArrayList;

public class Reservation{
    private String numeroReservation;
    private String dateReservation;
    private String statut;
    protected ArrayList<Vol> volsReserve;

    public Reservation(String numeroReservation, String dateReservation, String statut) {
        this.numeroReservation = numeroReservation;
        this.dateReservation = dateReservation;
        this.statut = statut;
    }

    public String getNumeroReservation() {
        return numeroReservation;
    }

    public void setNumeroReservation(String numeroReservation) {
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

    public void confirmerReservation(){
        System.out.println("Reservation confirmée pour le passager : " + this.getNumeroReservation());
    }

    public void annulerReservation(){
        System.out.println("Reservation annulée pour le passager : " + this.getNumeroReservation());
    }

    public void modifierReservation(){
        System.out.println("Reservation modifiée pour le passager : " + this.getNumeroReservation());
    }
    
}
