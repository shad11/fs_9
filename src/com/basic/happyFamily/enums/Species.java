package com.basic.happyFamily.enums;

public enum Species {
    DOG(false, 4, true),
    DOMESTIC_CAT(false, 4, true),
    BIRD(true, 2, true),
    RABBIT(false, 4, true),
    SNAKE(false, 0, false),
    FISH(false, 0, false),
    ROBO_CAT(false, 4, false),
    UNKNOWN;

    private boolean canFly;
    private int numberOfLegs;
    private boolean hasFur;

    Species() {}

    Species(boolean canFly, int numberOfLegs, boolean hasFur) {
        this.canFly = canFly;
        this.numberOfLegs = numberOfLegs;
        this.hasFur = hasFur;
    }

    @Override
    public String toString() {
        return this.name() + "[" +
                "canFly=" + canFly +
                ", numberOfLegs=" + numberOfLegs +
                ", hasFur=" + hasFur +
                ']';
    }
}
