package com.isep;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.text.SimpleDateFormat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Date;
import java.text.ParseException;

public class PersonnelCabineTest {
    private Vol vol1;
    private Vol vol2;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @BeforeEach
    public void setUp() {
        PersonnelCabine.personnelCabines.clear();
        try {
            Date dateHeureDepart1 = sdf.parse("2023-1-01 10:00:00");
            Date dateHeureArrivee1 = sdf.parse("2023-10-01 12:00:00");
            Date dateHeureDepart2 = sdf.parse("2024-10-01 10:56:00");
            Date dateHeureArrivee2 = sdf.parse("2024-11-01 12:00:00");
            vol1 = new Vol("VOL001", "Paris", "New York", dateHeureDepart1, dateHeureArrivee1, "Planifié");
            vol2 = new Vol("VOL002", "London", "Tokyo", dateHeureDepart2, dateHeureArrivee2, "Planifié");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPersonnelCabineCreation() {
        PersonnelCabine pc = new PersonnelCabine("ID1", "John Doe", "123 Street", "1234567890", "EMP001", "2023-01-01", "Pilot");
        assertEquals("Pilot", pc.getQualification());
        assertTrue(PersonnelCabine.getPersonnelCabines().contains(pc));
    }

    @Test
    public void testSetQualification() {
        PersonnelCabine pc = new PersonnelCabine("ID2", "Jane Doe", "456 Avenue", "0987654321", "EMP002", "2023-02-01", "Stewardess");
        pc.setQualification("Senior Stewardess");
        assertEquals("Senior Stewardess", pc.getQualification());
    }

    @Test
    public void testAffecterVol() {
        PersonnelCabine pc = new PersonnelCabine("ID3", "Alice", "789 Boulevard", "1122334455", "EMP003", "2023-03-01", "Pilot");
        pc.affecterVol("VOL001");
        assertEquals("Alice", vol1.getEquipeCabine());
    }

    @Test
    public void testObtenirVol() {
        PersonnelCabine pc = new PersonnelCabine("ID4", "Bob", "101 Road", "5566778899", "EMP004", "2023-04-01", "Co-Pilot");
        pc.affecterVol("VOL002");
        assertEquals("Bob", vol2.getEquipeCabine());
    }
}