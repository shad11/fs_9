package com.basic.happyFamily.controller;

import com.basic.happyFamily.entities.*;
import com.basic.happyFamily.service.FamilyService;

import java.util.List;
import java.util.Set;

public class FamilyController {
    private final FamilyService familyService;

    {
        familyService = new FamilyService();
    }

    public List<Family> getAllFamilies() {
        return familyService.getAllFamilies();
    }

    public void displayAllFamilies() {
        familyService.displayAllFamilies();
    }

    public void getFamiliesBiggerThan(int peopleCount) {
        familyService.getFamiliesBiggerThan(peopleCount);
    }

    public void getFamiliesLessThan(int peopleCount) {
        familyService.getFamiliesLessThan(peopleCount);
    }

    public int countFamiliesWithMemberNumber(int peopleCount) {
        return familyService.countFamiliesWithMemberNumber(peopleCount);
    }

    public void createNewFamily(Woman mother, Man father) {
        familyService.createNewFamily(mother, father);
    }

    public boolean deleteFamilyByIndex(int index) {
        return familyService.deleteFamilyByIndex(index);
    }

    public Family bornChild(Family family, String boyName, String girlName) {
        return familyService.bornChild(family, boyName, girlName);
    }

    public Family adoptChild(Family family, Human child) {
        return familyService.adoptChild(family, child);
    }

    public void deleteAllChildrenOlderThen(int age) {
        familyService.deleteAllChildrenOlderThen(age);
    }

    public int count() {
        return familyService.count();
    }

    public Family getFamilyById(int index) {
        return familyService.getFamilyById(index);
    }

    public Set<Pet> getPets(int familyIdx) {
        return familyService.getPets(familyIdx);
    }

    public void addPet(int familyIdx, Pet pet) {
        familyService.addPet(familyIdx, pet);
    }
}
