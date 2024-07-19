package com.basic.happyFamily.service;

import com.basic.happyFamily.dao.CollectionFamilyDao;
import com.basic.happyFamily.dao.FamilyDao;
import com.basic.happyFamily.entities.*;
import com.basic.happyFamily.exceptions.FamilyOverflowException;
import com.basic.happyFamily.utils.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class FamilyService {
    private final FamilyDao familyDao;

    {
        familyDao = new CollectionFamilyDao();
    }

    private void printFamilies(List<Family> families) {
        if (families.isEmpty()) {
            System.out.println("There are no families!");
            return;
        }

        IntStream.range(0, families.size()).forEach(idx -> {
            System.out.printf("%d) ", idx + 1);
            System.out.println(families.get(idx).prettyFormat());
        });
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
        printFamilies(familyDao.getAllFamilies());
    }

    public List<Family> getFamiliesBiggerThan(int peopleCount) {
        List<Family> familiesNew = getAllFamilies()
                .stream()
                .filter(family -> family.countFamily() > peopleCount)
                .toList();

        printFamilies(familiesNew);

        return familiesNew;
    }

    public List<Family> getFamiliesLessThan(int peopleCount) {
        List<Family> familiesNew = getAllFamilies()
                .stream()
                .filter(family -> family.countFamily() < peopleCount)
                .toList();

        printFamilies(familiesNew);

        return familiesNew;
    }

    public int countFamiliesWithMemberNumber(int peopleCount) {
        return (int) getAllFamilies()
                .stream()
                .filter(family -> family.countFamily() == peopleCount)
                .count();
    }

    public Family bornChild(Family family, String boyName, String girlName) throws FamilyOverflowException {
        int familyCount = family.countFamily();

        if (familyCount == Constants.FAMILY_SIZE) {
            throw new FamilyOverflowException("Не може народити, сім'я вже складається з " + familyCount + " людей");
        }

        family.bornChild(boyName, girlName);
        familyDao.saveFamily(family);

        return family;
    }

    public Family adoptChild(Family family, Human child) throws FamilyOverflowException {
        int familyCount = family.countFamily();

        if (familyCount == Constants.FAMILY_SIZE) {
            throw new FamilyOverflowException("Не можна усиновити, сім'я вже складається з " + familyCount + " людей");
        }

        family.addChild(child);
        familyDao.saveFamily(family);

        return family;
    }

    public void deleteAllChildrenOlderThen(int age) {
        familyDao.getAllFamilies().forEach(family -> {
            List<Human> children = family.getChildren();
            List<Human> childrenToRemove = new ArrayList<>();

            children
                    .stream()
                    .filter(child -> child.getAge() > age)
                    .forEach(child -> {
                        child.setFamily(null);
                        childrenToRemove.add(child);
                    });

            if (!childrenToRemove.isEmpty()) {
                children.removeAll(childrenToRemove);
                familyDao.saveFamily(family);
            }
        });

//        for (Family family : families) {
//            List<Human> children = family.getChildren();
//
//            if (children.isEmpty()) {
//                continue;
//            }
//
//            Iterator<Human> childrenItr = children.iterator();
//            boolean isChanged = false;
//
//            while (childrenItr.hasNext()) {
//                Human child = childrenItr.next();
//
//                if (child.getAge() > age) {
//                    child.setFamily(null);
//                    childrenItr.remove();
//                    isChanged = true;
//                }
//            }
//
//            if (isChanged) {
//                familyDao.saveFamily(family);
//            }

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
//        }
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
