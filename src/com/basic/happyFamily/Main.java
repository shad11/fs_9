package com.basic.happyFamily;

import com.basic.happyFamily.entity.*;
import com.basic.happyFamily.enums.DayOfWeek;

public class Main {
    public static void main(String[] args) {
        Human human;

//        for (int i = 0; i < 100000; i++) {
//            human = new Human("Name" + i, "Surname" + i);
//        }

        Woman motherTailor = new Woman("Sara", "Tailor", 1986, 180, new String[][]{});
        Man fatherTailor = new Man("John", "Tailor", 1984, 150, new String[][]{});
        Family familyTailor = new Family(motherTailor, fatherTailor);
        Pet petTailor = new Dog("Tom", 2, 45, new String[]{});
        String[][] scheduleMother = {
                {DayOfWeek.MONDAY.name(), "go to work"},
                {DayOfWeek.SUNDAY.name(), "meet with friends"}
        };

        familyTailor.setPet(petTailor);
        motherTailor.setSchedule(scheduleMother);

        System.out.println("--------- Tailor Family ---------");
        System.out.println(familyTailor);

        try {
            motherTailor.bornChild();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("--------- Tailor Family after a child as was born ---------");
        System.out.println(familyTailor);
    }
}
