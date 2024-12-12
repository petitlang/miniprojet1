package com.isep;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class ReservationTest {

    private Reservation reservation;
    private Vol vol;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @BeforeEach
    public void setUp() {
        try {
            Date dateHeureDepart = sdf.parse("2023-10-01 10:00:00");
            Date dateHeureArrivee = sdf.parse("2023-10-01 12:00:00");
            vol = new Vol("AF123", "Paris", "New York", dateHeureDepart, dateHeureArrivee, "Planifié");
            reservation = new Reservation(1, "2023-10-01", "en attente", "A12345678");
            Vol.getVols().clear();
            Vol.getVols().add(vol);
        } catch (ParseException e) {
            e.printStackTrace();
            fail("Setup failed due to ParseException");
        }
    }

    @Test
    public void testAddVol() {
        reservation.addVol("V123");
        ArrayList<Vol> volsReserve = reservation.getVolsReserve();
        assertEquals(1, volsReserve.size());
        assertEquals("V123", volsReserve.get(0).getNumeroVol());
    }

    @Test
    public void testAddVolNotFound() {
        reservation.addVol("V999");
        ArrayList<Vol> volsReserve = reservation.getVolsReserve();
        assertEquals(0, volsReserve.size());
    }
}