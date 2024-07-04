package com.basic.happyFamily.entity;

public final class Man extends Human {
    public Man() {}

    public Man(String name, String surname) {
        super(name, surname);
    }

    public Man(String name, String surname, int year) {
        super(name, surname, year);
    }

    public Man(String name, String surname, int year, int iq, String[][] schedule) {
        super(name, surname, year, iq, schedule);
    }
    @Override
    public void greetPet() {
        Pet pet = getFamily().getPet();

        System.out.printf("Hi, %s\n. I'm your daddy", pet.getNickname());
    }

    public void repairCar() {
        System.out.println("I can repair a car");
    }
}
