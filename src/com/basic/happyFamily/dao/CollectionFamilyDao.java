package com.basic.happyFamily.dao;

import com.basic.happyFamily.entities.Family;
import com.basic.happyFamily.entities.Pet;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CollectionFamilyDao implements FamilyDao {
    private final List<Family> familyList;

    {
        familyList = new ArrayList<>();
    }

    @Override
    public List<Family> getAllFamilies() {
        return familyList;
    }

    @Override
    public Family getFamilyByIndex(int index) {
        try {
            return familyList.get(index);
        } catch (Exception e) { // Exception IndexOutOfBoundsException
            return null;
        }

    }

    @Override
    public boolean deleteFamily(int index) {
        try {
            familyList.remove(index);
            return true;
        } catch (Exception e) { // Exception IndexOutOfBoundsException | UnsupportedOperationException
            return false;
        }
    }

    @Override
    public boolean deleteFamily(Family family) {
        return familyList.remove(family);
    }

    @Override
    public void saveFamily(Family family) {
        int index = familyList.indexOf(family);

        if (index != -1) {
            familyList.set(index, family);
        } else {
            familyList.add(family);
        }
    }

    @Override
    public int countFamilies() {
        return familyList.size();
    }

    @Override
    public Set<Pet> getPets(int familyIdx) {
        try {
            return familyList.get(familyIdx).getPets();
        } catch (Exception e) {
            return null;
        }
    }
}
