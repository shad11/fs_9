package com.basic.happyFamily.entity;

import com.basic.happyFamily.enums.Species;
import com.basic.happyFamily.interfaces.IPet;

import java.util.Set;

public class Fish extends Pet implements IPet {
    {
        setSpecies(Species.FISH);
    }

    public Fish() {
        super();
    }

    public Fish(String nickname) {
        super(nickname);
    }

    public Fish(String nickname, double age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
    }

    @Override
    public void respond() {
        System.out.printf("Hi, my owner! I'm your fish %s. I missed you!\n", getNickname());
    }

    @Override
    public void foul() {
        System.out.println("I need to cover my tracks well...");
    }
}
