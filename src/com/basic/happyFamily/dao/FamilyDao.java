package com.basic.happyFamily.dao;

import com.basic.happyFamily.entities.Family;
import com.basic.happyFamily.entities.Pet;

import java.util.List;
import java.util.Set;

public interface FamilyDao {
    List<Family> getAllFamilies();
    Family getFamilyByIndex(int index);
    boolean deleteFamily(int index);
    boolean deleteFamily(Family family);
    void saveFamily(Family family);
    int countFamilies();
    Set<Pet> getPets(int index);
}
