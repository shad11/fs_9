package com.basic.happyFamily.entities;

import java.util.Map;
import java.util.Set;

public final class Man extends Human {
    public Man() {}

    public Man(String name, String surname) {
        super(name, surname);
    }

    public Man(String name, String surname, long birthDate) {
        super(name, surname, birthDate);
    }

    public Man(String name, String surname, String birthDate) {
        super(name, surname, birthDate);
    }

    public Man(String name, String surname, String birthDate, int iq) {
        super(name, surname, birthDate, iq);
    }

    public Man(String name, String surname, long birthDate, int iq, Map<String, String> schedule) {
        super(name, surname, birthDate, iq, schedule);
    }

    public Man(String name, String surname, String birthDate, int iq, Map<String, String> schedule) {
        super(name, surname, birthDate, iq, schedule);
    }

    @Override
    public void greetPet() {
        Set<Pet> pets = getFamily().getPets();
        String nicknames = "";

        if (pets.isEmpty()) {
            System.out.println("I don't have pets");
        }

        for (Pet pet : pets) {
            nicknames += pet.getNickname() + " ,";
        }

        System.out.printf("Hi, %s\n. I'm your daddy", nicknames);
    }

    public void repairCar() {
        System.out.println("I can repair a car");
    }
}
