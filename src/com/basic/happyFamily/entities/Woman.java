package com.basic.happyFamily.entities;

import com.basic.happyFamily.interfaces.IHumanCreator;

import java.util.Map;
import java.util.Random;
import java.util.Set;

public final class Woman extends Human implements IHumanCreator {
    public Woman() {}

    public Woman(String name, String surname) {
        super(name, surname);
    }

    public Woman(String name, String surname, int year) {
        super(name, surname, year);
    }

    public Woman(String name, String surname, int year, int iq, Map<String, String> schedule) {
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

        System.out.printf("Hi, %s\n. I'm your mommy", nicknames);
    }

    @Override
    public Human bornChild() throws Exception {
        Human child = null;
        String surname;
        int randomNameIndex;
        Family family = getFamily();

        if (family == null) {
            throw new Exception("I don't have a family, can't born!");
        }

        Random random = new Random();
        Man father = family.getFather();

        surname = father.getSurname();

        if (random.nextBoolean()) {
            randomNameIndex = random.nextInt(IHumanCreator.girlNames.length);
            child = new Woman(IHumanCreator.girlNames[randomNameIndex], surname);
        } else {
            randomNameIndex = random.nextInt(IHumanCreator.boyNames.length);
            child = new Man(IHumanCreator.boyNames[randomNameIndex], surname);
        }

        int iq = (getIq() + father.getIq()) / 2;

        child.setIq(iq);

        // add to the family, setting for child a link to the family
        family.addChild(child);

        return child;
    }

    public void makeup() {
        System.out.println("I need my cosmetics to make a classic daily makeup");
    }
}