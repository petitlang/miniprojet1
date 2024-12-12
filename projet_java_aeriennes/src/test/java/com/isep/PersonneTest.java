package com.isep;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonneTest {

    @Test
    public void testGettersAndSetters() {
        Personne personne = new Personne("ID123", "John Doe", "123 Main St", "123-456-7890");

        assertEquals("ID123", personne.getIdentifiant());
        assertEquals("John Doe", personne.getNom());
        assertEquals("123 Main St", personne.getAdresse());
        assertEquals("123-456-7890", personne.getContact());

        personne.setIdentifiant("ID456");
        personne.setNom("Jane Doe");
        personne.setAdresse("456 Elm St");
        personne.setContact("098-765-4321");

        assertEquals("ID456", personne.getIdentifiant());
        assertEquals("Jane Doe", personne.getNom());
        assertEquals("456 Elm St", personne.getAdresse());
        assertEquals("098-765-4321", personne.getContact());
    }

    @Test
    public void testObtenirInfos() {
        Personne personne = new Personne("ID123", "John Doe", "123 Main St", "123-456-7890");

        // Redirecting System.out to capture the output
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        personne.ObtenirInfos();

        String expectedOutput = "Identifiant : ID123\n" +
                                "Nom : John Doe\n" +
                                "Adresse : 123 Main St\n" +
                                "Contact : 123-456-7890\n";
        assertEquals(expectedOutput, outContent.toString());

        // Resetting System.out to its original state
        System.setOut(System.out);
    }
}