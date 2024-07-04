package com.basic.happyFamily;

import com.basic.happyFamily.entity.*;
import com.basic.happyFamily.enums.DayOfWeek;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Human human;

//        for (int i = 0; i < 100000; i++) {
//            human = new Human("Name" + i, "Surname" + i);
//        }

        Woman motherTailor = new Woman("Sara", "Tailor", 1986, 180, new HashMap<>());
        Man fatherTailor = new Man("John", "Tailor", 1984, 150, new HashMap<>());
        Family familyTailor = new Family(motherTailor, fatherTailor);
        Pet petTailor = new Dog("Tom", 2, 45, new HashSet<>());
        Map<String, String> scheduleMother =  new HashMap<>() {{
                put(DayOfWeek.MONDAY.name(), "go to work");
                put(DayOfWeek.SUNDAY.name(), "meet with friends");
        }};

        familyTailor.addPet(petTailor);
        motherTailor.setSchedule(scheduleMother);

        System.out.println("--------- Tailor Family ---------");
        System.out.println(familyTailor);

        System.out.println("--------- Tailor Family After adding tasks ---------");
        motherTailor.addTask(DayOfWeek.MONDAY.name(), "go to the gym");
        fatherTailor.addTask(DayOfWeek.MONDAY.name(), "go to work");
        System.out.println(familyTailor);

        try {
            motherTailor.bornChild();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
//        System.out.println("--------- Tailor Family after a child as was born ---------");
//        System.out.println(familyTailor);
    }
}
