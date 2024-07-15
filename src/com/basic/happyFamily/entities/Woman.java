package com.basic.happyFamily.entities;

import com.basic.happyFamily.interfaces.IHumanCreator;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public final class Woman extends Human implements IHumanCreator {
    public Woman() {}

    public Woman(String name, String surname) {
        super(name, surname);
    }

    public Woman(String name, String surname, long birthDate) {
        super(name, surname, birthDate);
    }

    public Woman(String name, String surname, String birthDate) {
        super(name, surname, birthDate);
    }

    public Woman(String name, String surname, String birthDate, int iq) {
        super(name, surname, birthDate, iq);
    }

    public Woman(String name, String surname, long birthDate, int iq, Map<String, String> schedule) {
        super(name, surname, birthDate, iq, schedule);
    }

    public Woman(String name, String surname, String birthDate, int iq, Map<String, String> schedule) {
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

        System.out.printf("Hi, %s\n. I'm your mommy", nicknames);
    }

    @Override
    public Human bornChild(String boyName, String girlName) throws Exception {
        Human child = null;
        Family family = getFamily();

        if (family == null) {
            throw new Exception("I don't have a family, can't born!");
        }

        Random random = new Random();

        Man father = family.getFather();
        String surname = father.getSurname();

        if (random.nextBoolean()) {
            child = new Woman(girlName, surname);
        } else {
            child = new Man(boyName, surname);
        }

        int iq = (getIq() + father.getIq()) / 2;

        child.setIq(iq);
        child.setBirthDate(Instant.now().toEpochMilli());

        // add to the family, setting for child a link to the family
        family.addChild(child);

        return child;
    }

    @Override
    public Human bornChild() throws Exception {
        Random random = new Random();
        int randomIdxGirl = random.nextInt(IHumanCreator.girlNames.length);
        int randomIdxBoy = random.nextInt(IHumanCreator.boyNames.length);

        return bornChild(IHumanCreator.girlNames[randomIdxGirl], IHumanCreator.boyNames[randomIdxBoy]);
    }

    public void makeup() {
        System.out.println("I need my cosmetics to make a classic daily makeup");
    }
}
