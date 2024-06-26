package com.basic.hw3;

import com.basic.hw3.entity.Family;
import com.basic.hw3.entity.Human;
import com.basic.hw3.entity.Pet;

public class Main {
    public static void main(String[] args) {
        Human motherTailor = new Human("Sara", "Tailor", 1986);
        Human fatherTailor = new Human("John", "Tailor", 1984);
        Family familyTailor = new Family(motherTailor, fatherTailor);

        // Render mother and father
        System.out.println(motherTailor);
        System.out.println(fatherTailor);

        Human childTailor = new Human("James", "Tailor");
        Pet petTailor = new Pet("cat", "Tom");

        familyTailor.setPet(petTailor);

        // Add a child to the family
        familyTailor.addChild(childTailor);

        // Render a family and its count
        System.out.println("--------- New family Tailor ---------");
        System.out.println(familyTailor);
        System.out.printf("Family's count before deleting child: %d\n", familyTailor.countFamily());

        // Remove a child by index
        familyTailor.deleteChild(0);

        // Render family's count after removing a child
        System.out.printf("Family's count after deleting child: %d\n", familyTailor.countFamily());

        // Creating new family with a pet
        Human motherTailorBella = new Human("Bella", "Tailor", 1986, 100, new String[0][0]);
        Human fatherSmith = new Human("James", "Smith");
        Human childSmithFirst = new Human("James", "Smith", 2022);
        Human childSmithSecond = new Human("Kate", "Smith");
        Pet petSmith = new Pet("dog", "Sunny", 3, 49, new String[]{"eat", "play", "kiss"});

        Family familySmith = new Family(motherTailorBella, fatherSmith);

        familySmith.addChild(childSmithFirst);
        familySmith.addChild(childSmithSecond);
        familySmith.setPet(petSmith);

        System.out.println("--------- New family Smith ---------");
        System.out.println(familySmith);

        // All methods of pet
        petSmith.eat();
        petSmith.respond();
        petSmith.foul();
        fatherSmith.describePet();
        fatherSmith.greetPet();
        fatherSmith.feedPet(false);

        // Remove a child as object
        System.out.println("--------- Family Smith: removing Kate ---------");
        System.out.println(familySmith.deleteChild(motherTailor));
        System.out.println(familySmith.deleteChild(childTailor));
        System.out.println(familySmith.deleteChild(childSmithSecond));

        System.out.println("--------- Family Smith after removing Kate ---------");
        System.out.println(familySmith);

        // Comparing objects
        System.out.println("--------- Comparing ---------");
        System.out.println("If motherTailorSara equals motherTailorBella: " + motherTailor.equals(motherTailorBella));

        Human motherTailorSecond = motherTailor;
        System.out.println("If motherTailorSara equals motherTailorSara (the same object): " + motherTailor.equals(motherTailorSecond));
    }
}
