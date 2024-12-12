package com.isep;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;




public class VolTest {
    private Vol vol;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @BeforeEach
    public void setUp() throws ParseException {
        Date dateHeureDepart = sdf.parse("2023-10-01 10:00:00");
        Date dateHeureArrivee = sdf.parse("2023-10-01 12:00:00");
        vol = new Vol("AF123", "Paris", "New York", dateHeureDepart, dateHeureArrivee, "Planifié");
    }

    @Test
    public void testGetNumeroVol() {
        assertEquals("AF123", vol.getNumeroVol());
    }

    @Test
    public void testGetOrigine() {
        assertEquals("Paris", vol.getOrigine());
    }

    @Test
    public void testGetDestination() {
        assertEquals("New York", vol.getDestination());
    }

    @Test
    public void testGetDateHeureDepart() {
        assertNotNull(vol.getDateHeureDepart());
    }

    @Test
    public void testGetDateHeureArrivee() {
        assertNotNull(vol.getDateHeureArrivee());
    }

    @Test
    public void testGetEtat() {
        assertEquals("Planifié", vol.getEtat());
    }

    @Test
    public void testSetNumeroVol() {
        vol.setNumeroVol("AF456");
        assertEquals("AF456", vol.getNumeroVol());
    }

    @Test
    public void testSetOrigine() {
        vol.setOrigine("London");
        assertEquals("London", vol.getOrigine());
    }

    @Test
    public void testSetDestination() {
        vol.setDestination("Tokyo");
        assertEquals("Tokyo", vol.getDestination());
    }

    @Test
    public void testSetDateHeureDepart() throws ParseException {
        Date newDateHeureDepart = sdf.parse("2023-10-02 10:00:00");
        vol.setDateHeureDepart(newDateHeureDepart);
        assertEquals(newDateHeureDepart, vol.getDateHeureDepart());
    }

    @Test
    public void testSetDateHeureArrivee() throws ParseException {
        Date newDateHeureArrivee = sdf.parse("2023-10-02 12:00:00");
        vol.setDateHeureArrivee(newDateHeureArrivee);
        assertEquals(newDateHeureArrivee, vol.getDateHeureArrivee());
    }

    @Test
    public void testSetEtat() {
        vol.setEtat("Annulé");
        assertEquals("Annulé", vol.getEtat());
    }

    @Test
    public void testPlanifierVol() {
        vol.planifierVol();
        assertEquals("Planifié", vol.getEtat());
    }

    @Test
    public void testAnnulerVol() {
        vol.annulerVol();
        assertEquals("Annulé", vol.getEtat());
        assertNull(vol.getPilote());
        assertNull(vol.getEquipeCabine());
    }

    @Test
    public void testModifierVol() throws ParseException {
        Date newDateHeureDepart = sdf.parse("2023-10-03 10:00:00");
        Date newDateHeureArrivee = sdf.parse("2023-10-03 12:00:00");
        vol.modifierVol("Berlin", "Sydney", newDateHeureDepart, newDateHeureArrivee);
        assertEquals("Berlin", vol.getOrigine());
        assertEquals("Sydney", vol.getDestination());
        assertEquals(newDateHeureDepart, vol.getDateHeureDepart());
        assertEquals(newDateHeureArrivee, vol.getDateHeureArrivee());
    }

    @Test
    public void testImportVols() {
        ArrayList<Vol> vols = Vol.importVols("path/to/vols.csv");
        assertNotNull(vols);
        assertFalse(vols.isEmpty());
    }
}