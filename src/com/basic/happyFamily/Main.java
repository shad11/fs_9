package com.basic.happyFamily;

import com.basic.happyFamily.controller.FamilyController;
import com.basic.happyFamily.entities.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        FamilyController familyController = new FamilyController();

        System.out.println("---- Empty families ----");
        System.out.println(familyController.getAllFamilies());
        System.out.println(familyController.count());
        familyController.displayAllFamilies();
        familyController.getFamiliesBiggerThan(3);
        familyController.getFamiliesLessThan(3);
        familyController.countFamiliesWithMemberNumber(4);

        // adding families
        Woman motherTailor = new Woman("Sara", "Tailor", 1986, 180, new HashMap<>());
        Man fatherTailor = new Man("John", "Tailor", 1984, 150, new HashMap<>());

        familyController.createNewFamily(motherTailor, fatherTailor);

        Woman motherSmith = new Woman("Bella", "Smith", 1989);
        Man fatherSmith = new Man("James", "Smith", 1988);

        familyController.createNewFamily(motherSmith, fatherSmith);

        // getting Tailor family by ID
        Family familyTailor = familyController.getFamilyById(0);

        // Tailors born a child
        familyController.bornChild(familyTailor, "Tom", "Kate");

        Human adoptChild = new Woman("Jess", fatherTailor.getSurname(), 2010);
        familyController.adoptChild(familyTailor, adoptChild);

        System.out.println("---- All families after adding children ----");
        familyController.displayAllFamilies();

        // adding a pet
        Pet dogSmith = new Dog("Tom", 2, 45, new HashSet<>());
        Pet catSmith = new DomesticCat("Molly", 8, 65, new HashSet<>());

        familyController.addPet(1, dogSmith);
        familyController.addPet(1, catSmith);

        System.out.println("---- All families after adding pets ----");
        familyController.displayAllFamilies();

        System.out.println("---- Pets in Smith family ----");
        Set<Pet> pets = familyController.getPets(1);

        pets.forEach(System.out::println);

        System.out.println("---- All families bigger than 1 person ----");
        familyController.getFamiliesBiggerThan(1);

        System.out.println("---- All families less than 3 people ----");
        familyController.getFamiliesLessThan(3);

        System.out.println("---- All families with a certain amount of people ----");
        int countPeople = 4;
        int familiesWithPeople = familyController.countFamiliesWithMemberNumber(countPeople);
        System.out.printf("There are %d families with %d people \n", familiesWithPeople, countPeople);

        // delete all children older then 10
        System.out.println("---- All families after deleting children older then 10 ----");
        familyController.deleteAllChildrenOlderThen(10);
        List<Family> families = familyController.getAllFamilies();

        families.forEach(System.out::println);

        // deleting Tailor family (index = 0)
        familyController.deleteFamilyByIndex(0);

        System.out.println("---- Families count after deleting Tailor family (index = 0) ----");
        System.out.println("Families count: " + familyController.count());
    }
}
