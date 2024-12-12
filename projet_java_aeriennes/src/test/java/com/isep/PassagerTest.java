package com.isep;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class PassagerTest {

    @BeforeEach
    public void setUp() {
        Passager.passagers.clear();
        Reservation.reservations.clear();
    }

    @Test
    public void testPassagerCreation() {
        Passager passager = new Passager("ID1", "John Doe", "123 Street", "1234567890", "P12345");
        assertEquals("P12345", passager.getPasseport());
        assertEquals(1, Passager.getPassagers().size());
    }

    @Test
    public void testReserverVol() {
        Passager passager = new Passager("ID1", "John Doe", "123 Street", "1234567890", "P12345");
        passager.reserverVol("V123", 1, "2023-10-01", "Confirmed");
        assertEquals(1, Reservation.reservations.size());
        assertEquals("V123", Reservation.reservations.get(0).volsReserve.get(0).getNumeroVol());
    }

    @Test
    public void testAnnulerReservation() {
        Passager passager = new Passager("ID1", "John Doe", "123 Street", "1234567890", "P12345");
        passager.reserverVol("V123", 1, "2023-10-01", "Confirmed");
        passager.annulerReservation(1);
        assertEquals(0, Reservation.reservations.size());
    }

    @Test
    public void testObtenirReservations() {
        Passager passager = new Passager("ID1", "John Doe", "123 Street", "1234567890", "P12345");
        passager.reserverVol("V123", 1, "2023-10-01", "Confirmed");
        passager.reserverVol("V124", 2, "2023-10-02", "Confirmed");
        passager.obtenirReservations();
        assertEquals(2, Reservation.reservations.size());
    }
}