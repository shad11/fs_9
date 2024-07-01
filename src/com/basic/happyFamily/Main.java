package com.basic.happyFamily;

import com.basic.happyFamily.entity.Human;
import com.basic.happyFamily.entity.Family;
import com.basic.happyFamily.entity.Pet;
import com.basic.happyFamily.enums.DayOfWeek;
import com.basic.happyFamily.enums.Species;

public class Main {
    public static void main(String[] args) {
        Human human;

//        for (int i = 0; i < 100000; i++) {
//            human = new Human("Name" + i, "Surname" + i);
//        }

        Human motherTailor = new Human("Sara", "Tailor", 1986);
        Human fatherTailor = new Human("John", "Tailor", 1984);
        Family familyTailor = new Family(motherTailor, fatherTailor);
        Pet petTailor = new Pet(Species.DOG, "Tom", 2, 45, new String[]{});
        String[][] scheduleMother = {
                {DayOfWeek.MONDAY.name(), "go to work"},
                {DayOfWeek.SUNDAY.name(), "meet with friends"}
        };

        familyTailor.setPet(petTailor);
        motherTailor.setSchedule(scheduleMother);

        System.out.println("--------- Tailor Family ---------");
        System.out.println(familyTailor);
    }
}
