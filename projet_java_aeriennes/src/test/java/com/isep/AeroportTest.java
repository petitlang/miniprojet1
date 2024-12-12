package com.isep;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AeroportTest {

    @Test
    public void testGetNom() {
        Aeroport aeroport = new Aeroport("Charles de Gaulle", "Paris", "Main airport in Paris");
        assertEquals("Charles de Gaulle", aeroport.getNom());
    }

    @Test
    public void testSetNom() {
        Aeroport aeroport = new Aeroport("Charles de Gaulle", "Paris", "Main airport in Paris");
        aeroport.setNom("Orly");
        assertEquals("Orly", aeroport.getNom());
    }

    @Test
    public void testGetVille() {
        Aeroport aeroport = new Aeroport("Charles de Gaulle", "Paris", "Main airport in Paris");
        assertEquals("Paris", aeroport.getVille());
    }

    @Test
    public void testSetVille() {
        Aeroport aeroport = new Aeroport("Charles de Gaulle", "Paris", "Main airport in Paris");
        aeroport.setVille("Lyon");
        assertEquals("Lyon", aeroport.getVille());
    }

    @Test
    public void testGetDescription() {
        Aeroport aeroport = new Aeroport("Charles de Gaulle", "Paris", "Main airport in Paris");
        assertEquals("Main airport in Paris", aeroport.getDescription());
    }

    @Test
    public void testSetDescription() {
        Aeroport aeroport = new Aeroport("Charles de Gaulle", "Paris", "Main airport in Paris");
        aeroport.setDescription("Secondary airport in Paris");
        assertEquals("Secondary airport in Paris", aeroport.getDescription());
    }

    @Test
    public void testAffecterVol() {
        Aeroport aeroport = new Aeroport("Charles de Gaulle", "Paris", "Main airport in Paris");
        aeroport.affecterVol();
        // This test will just ensure that the method runs without exceptions
    }
}