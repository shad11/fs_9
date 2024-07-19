package com.basic.happyFamily.entities;

import com.basic.happyFamily.enums.Species;

import java.util.HashSet;
import java.util.Set;

public abstract class Pet {
    private Species species;
    private String nickname;
    private double age;
    private int trickLevel;
    private Set<String> habits;

//    static {
//        System.out.println("Class Pet is loaded");
//    }

    {
        habits = new HashSet<>();
        species = Species.UNKNOWN;
//        System.out.println("Instance " + this.getClass() + " is loaded");
    }

    public Pet() {}

    public Pet(String nickname) {
        this.nickname = nickname;
    }

    public Pet(String nickname, double age, int trickLevel, Set<String> habits) {
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
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

    public Set<String> getHabits() {
        return habits;
    }

    public void setHabits(Set<String> habits) {
        this.habits = habits;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())  // instanceof
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
        String habitsStr = !habits.isEmpty() ? habits.toString() : "[]";

        return "%s{nickname='%s', age=%.2f, trickLevel=%d, habits=%s}".formatted(
                species.toString(),
                nickname,
                age,
                trickLevel,
                habitsStr
        );
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Pet object is deleted: " + this);
    }

    public void addHabit(String habit) {
        habits.add(habit);
    }

    public void eat() {
        System.out.println("I'm eating!");
    }

    public String prettyFormat() {
        String habitsStr = !habits.isEmpty() ? habits.toString() : "[]";

        return "species=%s: {nickname='%s', age=%.2f, trickLevel=%d, habits=%s}".formatted(
                species.toString(),
                nickname,
                age,
                trickLevel,
                habitsStr
        );
    }

    public abstract void respond();
}
