package com.basic.happyFamily.entity;

import com.basic.happyFamily.enums.Species;

public class RoboCat extends Pet {
    public RoboCat() {
        super();
        setSpecies(Species.ROBO_CAT);
    }

    public RoboCat(String nickname) {
        super(nickname);
        setSpecies(Species.ROBO_CAT);
    }

    public RoboCat(String nickname, double age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
        setSpecies(Species.ROBO_CAT);
    }

    @Override
    public void respond() {
        System.out.printf("Hi, my owner! I'm your robot-cat %s. I missed you!\n", getNickname());
    }
}
