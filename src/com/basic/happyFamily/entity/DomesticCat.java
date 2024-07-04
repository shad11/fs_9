package com.basic.happyFamily.entity;

import com.basic.happyFamily.enums.Species;
import com.basic.happyFamily.interfaces.IPet;

import java.util.Set;

public class DomesticCat extends Pet implements IPet {
    public DomesticCat() {
        super();
        setSpecies(Species.DOMESTIC_CAT);
    }

    public DomesticCat(String nickname) {
        super(nickname);
        setSpecies(Species.DOMESTIC_CAT);
    }

    public DomesticCat(String nickname, double age, int trickLevel, Set<String>  habits) {
        super(nickname, age, trickLevel, habits);
        setSpecies(Species.DOMESTIC_CAT);
    }

    @Override
    public void respond() {
        System.out.printf("Hi, my owner! I'm your cat %s. I missed you!\n", getNickname());
    }

    @Override
    public void foul() {
        System.out.println("I need to cover my tracks well...");
    }
}
