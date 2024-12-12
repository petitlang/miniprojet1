package com.isep;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

public class PiloteTest {

    private Pilote pilote;
    private Vol vol;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @BeforeEach
    public void setUp() {
        try {
            Date dateHeureDepart = sdf.parse("2023-10-01 10:00:00");
            Date dateHeureArrivee = sdf.parse("2023-10-01 12:00:00");
            pilote = new Pilote("1", "John Doe", "123 Main St", "555-1234", "E123", "2020-01-01", "L123", "1000");
            vol = new Vol("AF123", "Paris", "New York", dateHeureDepart, dateHeureArrivee, "Planifié");
            Vol.getVols().clear();
            Vol.getVols().add(vol);
            Pilote.getPilotes().clear();
        } catch (ParseException e) {
            e.printStackTrace();
            fail("Setup failed due to date parsing error");
        }
    }

    @Test
    public void testPiloteCreation() {
        assertEquals("John Doe", pilote.getNom());
        assertEquals("L123", pilote.getLicence());
        assertEquals("1000", pilote.getHeuresDeVols());
    }

    @Test
    public void testAffecterVol() {
        pilote.affecterVol("V123");
        assertEquals("John Doe", vol.getPilote());
    }

    @Test
    public void testObtenirVol() {
        pilote.obtenirVol("V123");
        // Assuming obtenirVol prints the vol details, we can't assert the print output directly.
        // This test ensures no exceptions are thrown.
    }

    @Test
    public void testSetLicence() {
        pilote.setLicence("L456");
        assertEquals("L456", pilote.getLicence());
    }

    @Test
    public void testSetHeuresDeVols() {
        pilote.setHeuresDeVols("2000");
        assertEquals("2000", pilote.getHeuresDeVols());
    }

    @Test
    public void testGetPilotes() {
        Pilote newPilote = new Pilote("2", "Jane Doe", "456 Main St", "555-5678", "E124", "2021-01-01", "L124", "500");
        ArrayList<Pilote> pilotes = Pilote.getPilotes();
        assertTrue(pilotes.contains(pilote));
        assertTrue(pilotes.contains(newPilote));
    }
}