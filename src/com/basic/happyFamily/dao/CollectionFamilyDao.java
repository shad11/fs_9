package com.basic.happyFamily.dao;

import com.basic.happyFamily.entities.Family;
import com.basic.happyFamily.entities.Pet;
import com.basic.happyFamily.utils.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CollectionFamilyDao implements FamilyDao {
    private final List<Family> familyList;
    private final String familiesFile = "files/happyFamily/families.ser";

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
            Logger.error(e.getMessage());
            return null;
        }

    }

    @Override
    public boolean deleteFamily(int index) {
        try {
            Family family = familyList.remove(index);
            Logger.info("Deleting " + family.prettyFormat());
            return true;
        } catch (Exception e) { // Exception IndexOutOfBoundsException | UnsupportedOperationException
            Logger.error(e.getMessage());
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

            Logger.info("Updating " + family.prettyFormat());
        } else {
            familyList.add(family);

            Logger.info("Adding a new " + family.prettyFormat());
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
            Logger.error(e.getMessage());
            return null;
        }
    }

    @Override
    public void loadData(List<Family> families) throws RuntimeException {
        try (
            FileOutputStream fos = new FileOutputStream(familiesFile);
            ObjectOutputStream writer = new ObjectOutputStream(fos)
        ) {
//            for (Family family : families) {
//                writer.writeObject(family);
//            }
            writer.writeObject(families);
        } catch (IOException e) {
            Logger.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void loadData() throws RuntimeException {
        try (
            FileInputStream fis = new FileInputStream(familiesFile);
            ObjectInputStream reader = new ObjectInputStream(fis)
        ) {
            List<Family> families = (List<Family>) reader.readObject();

            families.forEach(familyList::add);
//            while (true) {
//                Family family = (Family) reader.readObject();
//
//                familyList.add(family);
//            }
//        } catch (EOFException e) {
//            System.out.println(familiesFile + " was read.");
        } catch (IOException | ClassNotFoundException e) {
            Logger.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
