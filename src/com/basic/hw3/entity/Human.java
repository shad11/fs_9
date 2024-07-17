package com.basic.hw3.entity;

import java.util.Arrays;
import java.util.Random;

public class Human {
    private String name;
    private String surname;
    private int year;
    private int iq;
    private String[][] schedule;
    private Family family;

    static {
        System.out.println("Class Human is loaded");
    }

    {
        schedule = new String[0][0];
        System.out.println("Instance " + this.getClass() + " is loaded");
    }

    public Human() {}

    public Human(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    public Human(String name, String surname, int year, int iq, String[][] schedule) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        this.schedule = schedule;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    public String[][] getSchedule() {
        return schedule;
    }

    public void setSchedule(String[][] schedule) {
        this.schedule = schedule;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())  // instanceof
            return false;

        Human human = (Human) obj;

        return name.equals(human.getName()) &&
                surname.equals(human.getSurname()) &&
                year == human.getYear() &&
                iq == human.getIq() &&
                family.equals(human.getFamily());
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;

        result = prime * result + (name == null ? 0 : name.hashCode());
        result = prime * result + (surname == null ? 0 : surname.hashCode());
        result = prime * result + year;
        result = prime * result + iq;
        result = prime * result + family.hashCode();

        return result;
    }

    @Override
    public String toString() {
        return "Human{name='%s', surname='%s', year=%d, iq=%d, schedule=%s}".formatted(
                name,
                surname,
                year,
                iq,
                Arrays.toString(schedule)
        );
    }

    public void greetPet() {
        Pet pet = getFamily().getPet();

        System.out.printf("Hi, %s\n", pet.getNickname());
    }

    public void describePet() {
        Pet pet = getFamily().getPet();

        String trickyMsg = pet.getTrickLevel() > 50 ? "very tricky" : "almost not tricky";

        System.out.printf("I have a %s, it's %.2f years old, it's %s\n",
                pet.getSpecies(),
                pet.getAge(),
                trickyMsg
        );
    }

    public boolean feedPet(boolean feed) {
        Pet pet = getFamily().getPet();
        int randomNumber = new Random().nextInt(101);
        boolean needFeed = feed || pet.getTrickLevel() > randomNumber;

        if (needFeed) {
            System.out.printf("Hm... I've fed %s\n", pet.getNickname());
            return true;
        } else {
            System.out.printf("I think, %s is not hungry )) \n", pet.getNickname());
            return false;
        }
    }
}
