package com.isep;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmployeTest {

    private Employe employe;

    @BeforeEach
    public void setUp() {
        employe = new Employe("ID123", "John Doe", "123 Main St", "555-1234", "EMP001", "2023-01-01");
    }

    @Test
    public void testGetNumeroEmploye() {
        assertEquals("EMP001", employe.getNumeroEmploye());
    }

    @Test
    public void testSetNumeroEmploye() {
        employe.setNumeroEmploye("EMP002");
        assertEquals("EMP002", employe.getNumeroEmploye());
    }

    @Test
    public void testGetDataEmbauche() {
        assertEquals("2023-01-01", employe.getDataEmbauche());
    }

    @Test
    public void testSetDataEmbauche() {
        employe.setDataEmbauche("2023-02-01");
        assertEquals("2023-02-01", employe.getDataEmbauche());
    }

    @Test
    public void testObtenirRole() {
        assertEquals("ID123", employe.ObtenirRole());
    }
}