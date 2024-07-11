package com.basic.happyFamily;

import com.basic.happyFamily.entities.Dog;
import com.basic.happyFamily.entities.DomesticCat;
import com.basic.happyFamily.enums.Species;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class DogTest {
    private Dog pet; // private Pet pet;
    private Species species;
    private String nickname;
    private double age;
    private int trickLevel;
    private Set<String> habits;

    {
        nickname = "Mafia";
        age = 2;
        trickLevel = 45;
        habits = new HashSet<>();
    }

    @BeforeEach
    public void setUp() {
        pet = new Dog(nickname, age, trickLevel, habits);
    }

    @Test
    public void testToString() {
        String expected = "DOG[canFly=false, numberOfLegs=4, hasFur=true]{nickname='Mafia', age=2.00, trickLevel=45, habits=[]}";
        String actual = pet.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void testEqualsThisObject() {
        Dog petNew = pet;

        assertEquals(pet, petNew);
    }

    @Test
    public void testEqualsSameObject() {
        Dog petNew = new Dog(nickname, age, trickLevel, habits);

        assertEquals(pet, petNew);
    }

    @Test
    public void testEqualsAnotherObject() {
        String str = "not a pet";

        assertNotEquals(pet, str);
    }

    @Test
    public void testEqualsAnotherPetObject() {
        DomesticCat petNew = new DomesticCat("Mafia");

        assertNotEquals(pet, petNew);
    }

    @Test
    public void testHashCodeEqual() {
        Dog petNew = new Dog(nickname, age, trickLevel, habits);
        int expected = pet.hashCode();
        int actual = petNew.hashCode();

        assertEquals(expected, actual);
    }

    @Test
    public void testHashCodeNotEqual() {
        Dog petNew = new Dog(nickname);
        int expected = pet.hashCode();
        int actual = petNew.hashCode();

        assertNotEquals(expected, actual);
    }
}
