package com.basic.happyFamily;

import com.basic.happyFamily.entity.Pet;
import com.basic.happyFamily.enums.Species;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class PetTest {
    private Pet pet;
    private Species species;
    private String nickname;
    private double age;
    private int trickLevel;
    private String[] habits;

    {
        species = Species.DOG;
        nickname = "Mafia";
        age = 2;
        trickLevel = 45;
        habits = new String[]{};
    }

    @BeforeEach
    public void setUp() {
        pet = new Pet(species, nickname, age, trickLevel, habits);
    }

    @Test
    public void testToString() {
        String expected = "DOG[canFly=false, numberOfLegs=4, hasFur=true]{nickname='Mafia', age=2.00, trickLevel=45, habits=[]}";
        String actual = pet.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void testEqualsThisObject() {
        Pet petNew = pet;

        assertEquals(pet, petNew);
    }

    @Test
    public void testEqualsSameObject() {
        Pet petNew = new Pet(species, nickname, age, trickLevel, habits);

        assertEquals(pet, petNew);
    }

    @Test
    public void testEqualsAnotherObject() {
        String str = "not a pet";

        assertNotEquals(pet, str);
    }

    @Test
    public void testEqualsAnotherPetObject() {
        Pet petNew = new Pet(Species.CAT, "Mafia");

        assertNotEquals(pet, petNew);
    }

    @Test
    public void testHashCodeEqual() {
        Pet petNew = new Pet(species, nickname, age, trickLevel, habits);
        int expected = pet.hashCode();
        int actual = petNew.hashCode();

        assertEquals(expected, actual);
    }

    @Test
    public void testHashCodeNotEqual() {
        Pet petNew = new Pet(species, nickname);
        int expected = pet.hashCode();
        int actual = petNew.hashCode();

        assertNotEquals(expected, actual);
    }
}
