package com.basic.happyFamily.entity;

import java.util.Map;
import java.util.Set;

public final class Man extends Human {
    public Man() {}

    public Man(String name, String surname) {
        super(name, surname);
    }

    public Man(String name, String surname, int year) {
        super(name, surname, year);
    }

    public Man(String name, String surname, int year, int iq, Map<String, String> schedule) {
        super(name, surname, year, iq, schedule);
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
