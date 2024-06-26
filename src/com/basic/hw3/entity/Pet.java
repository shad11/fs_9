package com.basic.hw3.entity;

import java.util.Arrays;

public class Pet {
    private String species;
    private String nickname;
    private double age;
    private int trickLevel;
    private String[] habits;

    static {
        System.out.println("Class Pet is loaded");
    }

    {
        habits = new String[0];
        System.out.println("Instance " + this.getClass() + " is loaded");
    }

    public Pet() {}

    public Pet(String species, String nickname) {
        this.species = species;
        this.nickname = nickname;
    }

    public Pet(String species, String nickname, double age, int trickLevel, String[] habits) {
        this.species = species;
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public int getTrickLevel() {
        return trickLevel;
    }

    public void setTrickLevel(int trickLevel) {
        this.trickLevel = trickLevel;
    }

    public String[] getHabits() {
        return habits;
    }

    public void setHabits(String[] habits) {
        this.habits = habits;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Pet pet = (Pet) obj;

        return age == pet.getAge() &&
                species.equals(pet.getSpecies()) &&
                nickname.equals(pet.getNickname());
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;

        result = prime * result + (int)age;
        result = prime * result + (species == null ? 0 : species.hashCode());
        result = prime * result + (nickname == null ? 0 : nickname.hashCode());

        return result;

    }

    @Override
    public String toString() {
        return "%s{nickname='%s', age=%.2f, trickLevel=%d, habits=%s}".formatted(
                species,
                nickname,
                age,
                trickLevel,
                Arrays.toString(habits)
        );
    }

    public void eat() {
        System.out.println("I'm eating!");
    }

    public void respond() {
        System.out.printf("Hi, my owner! I'm %s. I missed you!\n", nickname);
    }

    public void foul() {
        System.out.println("I need to cover my tracks well...");
    }
}
