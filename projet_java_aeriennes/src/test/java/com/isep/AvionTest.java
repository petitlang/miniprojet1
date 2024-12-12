package com.isep;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class AvionTest {
    private Avion avion;
    private Vol vol1;
    private Vol vol2;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @BeforeEach
    public void setUp() {
        try {
            Date dateHeureDepart1 = sdf.parse("2023-1-01 10:00:00");
            Date dateHeureArrivee1 = sdf.parse("2023-10-01 12:00:00");
            Date dateHeureDepart2 = sdf.parse("2024-10-01 10:56:00");
            Date dateHeureArrivee2 = sdf.parse("2024-11-01 12:00:00");
            avion = new Avion(123, "Boeing 737", 150);
            vol1 = new Vol("VOL001", "Paris", "New York", dateHeureDepart1, dateHeureArrivee1, "Planifié");
            vol2 = new Vol("VOL002", "London", "Tokyo", dateHeureDepart2, dateHeureArrivee2, "Planifié");
        } catch (ParseException e) {
            e.printStackTrace();
            fail("Setup failed due to ParseException");
        }
    }

    @Test
    public void testAffecterVol_Success() {
        avion.affecterVol(vol1);
        assertTrue(avion.verifierDisponibilite(vol2));
    }

    @Test
    public void testAffecterVol_Conflict() {
        Vol conflictingVol = vol1;
        avion.affecterVol(vol1);
        assertFalse(avion.verifierDisponibilite(conflictingVol));
    }

    @Test
    public void testSetDisponibilite() {
        avion.setDisponibilite(false);
        assertFalse(avion.verifierDisponibilite(vol1));
    }
}