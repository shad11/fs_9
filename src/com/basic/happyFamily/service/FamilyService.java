package com.basic.happyFamily.service;

import com.basic.happyFamily.dao.CollectionFamilyDao;
import com.basic.happyFamily.dao.FamilyDao;
import com.basic.happyFamily.entities.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class FamilyService {
    private final FamilyDao familyDao;

    {
        familyDao = new CollectionFamilyDao();
    }

    public void createNewFamily(Woman mother, Man father) {
        Family family = new Family(mother, father);
        familyDao.saveFamily(family);
    }

    public Family getFamilyById(int index) {
        return familyDao.getFamilyByIndex(index);
    }

    public List<Family> getAllFamilies() {
        return familyDao.getAllFamilies();
    }

    public boolean deleteFamilyByIndex(int index) {
        return familyDao.deleteFamily(index);
    }

    public int count() {
        return familyDao.countFamilies();
    }

    public void displayAllFamilies() {
        List<Family> families = familyDao.getAllFamilies();

        if (families.isEmpty()) {
            System.out.println("There are no families!");
            return;
        }

        int index = 1;

        for (Family family : families) {
            System.out.printf("Family %d: \n", index++);
            System.out.println(family.toString());
        }
    }

    private List<Family> getFamiliesByComparison(int peopleCount, char operation) {
        List<Family> familiesNew = new ArrayList<>();
        List<Family> families = familyDao.getAllFamilies();

        for (Family family : families) {
            switch (operation) {
                case '>':
                    if (family.countFamily() > peopleCount) {
                        familiesNew.add(family);
                    }
                    break;
                case '<':
                    if (family.countFamily() < peopleCount) {
                        familiesNew.add(family);
                    }
                    break;
                case '=':
                    if (family.countFamily() == peopleCount) {
                        familiesNew.add(family);
                    }
                    break;
            }

        }

        return familiesNew;
    }

    public List<Family> getFamiliesBiggerThan(int peopleCount) {
        List<Family> familiesNew = getFamiliesByComparison(peopleCount, '>');

        if (familiesNew.isEmpty()) {
            System.out.println("There are no families with more than " + peopleCount + " people");
        } else {
            System.out.println("There are families with more than " + peopleCount + " people:");
            familiesNew.forEach(family -> System.out.println(family.toString()));
        }

        return familiesNew;
    }

    public List<Family> getFamiliesLessThan(int peopleCount) {
        List<Family> familiesNew = getFamiliesByComparison(peopleCount, '<');

        if (familiesNew.isEmpty()) {
            System.out.println("There are no families with less than " + peopleCount + " people");
        } else {
            System.out.println("There are families with less than " + peopleCount + " people:");
            familiesNew.forEach(family -> System.out.println(family.toString()));
        }

        return familiesNew;
    }

    public int countFamiliesWithMemberNumber(int peopleCount) {
        List<Family> familiesNew = getFamiliesByComparison(peopleCount, '=');

        return familiesNew.size();
    }

    public Family bornChild(Family family, String boyName, String girlName) {
        family.bornChild(boyName, girlName);
        familyDao.saveFamily(family);

        return family;
    }

    public Family adoptChild(Family family, Human child) {
        family.addChild(child);
        familyDao.saveFamily(family);

        return family;
    }

    public void deleteAllChildrenOlderThen(int age) {
        List<Family> families = familyDao.getAllFamilies();

        for (Family family : families) {
            List<Human> children = family.getChildren();

            if (children.isEmpty()) {
                continue;
            }

            Iterator<Human> childrenItr = children.iterator();
            boolean isChanged = false;

            while (childrenItr.hasNext()) {
                Human child = childrenItr.next();

                if (child.getAge() > age) {
                    child.setFamily(null);
                    childrenItr.remove();
                    isChanged = true;
                }
            }

            if (isChanged) {
                familyDao.saveFamily(family);
            }

//            List<Human> childrenToRemove = new ArrayList<>();
//
//            for (Human child : children) {
//                if (child.getAge() > age) {
//                    childrenToRemove.add(child);
//                }
//            }
//
//            if (!childrenToRemove.isEmpty()) {
//                for (Human child : childrenToRemove) {
//                    family.deleteChild(child);
//                }
//                familyDao.saveFamily(family);
//            }
        };
    }

    public Set<Pet> getPets(int familyIdx) {
        return familyDao.getPets(familyIdx);
    }

    public void addPet(int familyIdx, Pet pet) {
        Family family = familyDao.getFamilyByIndex(familyIdx);

        if (family != null) {
            family.addPet(pet);
            familyDao.saveFamily(family);
        }
    }
}
