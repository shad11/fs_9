package com.basic.happyFamily.service;

import com.basic.happyFamily.entities.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class FamilyServiceTest {
    private FamilyService familyService;
    private Woman motherTailor;
    private Woman motherSmith;
    private Man fatherTailor;
    private Man fatherSmith;

    {
        motherTailor = new Woman("Sara", "Tailor", "10/10/1986", 180, new HashMap<>());
        fatherTailor = new Man("John", "Tailor", "15/02/1984", 150, new HashMap<>());
        motherSmith = new Woman("Bella", "Smith", "20/08/1989");
        fatherSmith = new Man("James", "Smith", "25/11/1988");
    }

    @BeforeEach
    public void setUp() {
        familyService = new FamilyService();
    }

    @Test
    public void testCreateNewAndCountFamily() {
        familyService.createNewFamily(motherSmith, fatherSmith);

        int expected = 1;
        int actual = familyService.count();

        assertEquals(expected, actual);
    }

    @Test
    public void testGetFamilyById() {
        familyService.createNewFamily(motherSmith, fatherSmith);
        familyService.createNewFamily(motherTailor, fatherTailor);
        Family family = familyService.getFamilyById(1);

        assertNotNull(family);
    }

    @Test
    public void testGetAllFamiliesCount() {
        int expected = 1;

        familyService.createNewFamily(motherSmith, fatherSmith);
        List<Family> families = familyService.getAllFamilies();

        assertEquals(expected, families.size());
        assertEquals(expected, familyService.count());
    }

    @Test
    public void testDeleteFamilyByIndex() {
        familyService.createNewFamily(motherSmith, fatherSmith);
        familyService.createNewFamily(motherTailor, fatherTailor);

        assertTrue(familyService.deleteFamilyByIndex(1));
        assertFalse(familyService.deleteFamilyByIndex(20));
    }

    @Test
    public void testGetFamiliesBiggerThan() {
        familyService.createNewFamily(motherTailor, fatherTailor);

        List<Family> expected = new ArrayList<>(List.of(new Family(motherTailor, fatherTailor)));
        List<Family> actual = familyService.getFamiliesBiggerThan(1);

        assertEquals(expected, actual);
    }

    @Test
    public void testGetFamiliesLessThan() {
        familyService.createNewFamily(motherTailor, fatherTailor);

        List<Family> expected = new ArrayList<>(List.of(new Family(motherTailor, fatherTailor)));
        List<Family> actual = familyService.getFamiliesLessThan(20);

        assertEquals(expected, actual);
    }

    @Test
    public void testCountFamiliesWithMemberNumber() {
        familyService.createNewFamily(motherTailor, fatherTailor);

        int expected = 1;
        int actual = familyService.countFamiliesWithMemberNumber(2);

        assertEquals(expected, actual);
    }

    @Test
    public void testAdoptChild() {
        Woman adoptChild = new Woman("Jess", fatherTailor.getSurname(), "10/05/2010");
        Family family = new Family(motherTailor, fatherTailor);

        familyService.adoptChild(family, adoptChild);

        Family familyDao = familyService.getFamilyById(0);

        assertEquals(adoptChild, familyDao.getChildren().getFirst());
    }

    @Test
    public void testDeleteAllChildrenOlderThen() {
        Human adoptChild = new Woman("Jess", fatherTailor.getSurname(), "10/05/2010");
        Family family = new Family(motherTailor, fatherTailor);

        familyService.adoptChild(family, adoptChild);
        familyService.deleteAllChildrenOlderThen(5);

        Family familyDao = familyService.getFamilyById(0);
        assertTrue(familyDao.getChildren().isEmpty());
    }

    @Test
    public void testPets() {
        Pet dogSmith = new Dog("Tom", 2, 45, new HashSet<>());

        familyService.createNewFamily(motherSmith, fatherSmith);
        familyService.addPet(0, dogSmith);

        Set<Pet> pets = familyService.getPets(0);

        assertFalse(pets.isEmpty());
    }
}
