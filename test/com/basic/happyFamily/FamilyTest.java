package com.basic.happyFamily;

import com.basic.happyFamily.entity.Human;
import com.basic.happyFamily.entity.Family;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FamilyTest {
    private Family family;
    private Human[] children;
    private Human mother;
    private Human father;

    {
        mother = new Human("Sara", "Tailor", 1986);
        father = new Human("John", "Tailor", 1984);
        children = new Human[] {new Human("Kate", "Tailor"), new Human("Tom", "Tailor")};
    }

    @BeforeEach
    public void setUp() {
        family = new Family(mother, father);

        for (Human child : children) {
            family.addChild(child);
        }
    }

    @Test
    public void testAddChild() {
        Human[] children = family.getChildren();
        Human childToAdd = new Human("James", "Tailor");

        family.addChild(childToAdd);

        Human[] childrenNew = family.getChildren();

        assertEquals(children.length + 1, childrenNew.length);
        assertEquals(childrenNew[childrenNew.length - 1], childToAdd);
    }

    @Test
    public void testDeleteChildByHumanExist() {
        Human childToDelete = new Human("James", "Tailor");

        family.addChild(childToDelete);

        boolean expected = true;
        boolean actual = family.deleteChild(childToDelete);

        assertEquals(expected, actual);
        assertArrayEquals(children, family.getChildren());
    }

    @Test
    public void testDeleteChildByHumanNotExist() {
        Human childToDelete = new Human("James", "Tailor");

        assertFalse(family.deleteChild(childToDelete));
        assertArrayEquals(children, family.getChildren());
    }

    @Test
    public void testDeleteChildByWrongObject() {
        Integer number = Integer.valueOf(10);

        assertFalse(family.deleteChild(number));
        assertArrayEquals(children, family.getChildren());
    }

    @Test
    public void testDeleteChildByIdExist() {
        Human childToDelete = new Human("James", "Tailor");

        family.addChild(childToDelete);

        int deleteIndex = family.getChildren().length - 1;

        assertTrue(family.deleteChild(deleteIndex));
        assertArrayEquals(children, family.getChildren());
    }

    @Test
    public void testDeleteChildByIdOutOfBound() {
        int deleteIndex = family.getChildren().length + 3;

        assertFalse(family.deleteChild(deleteIndex));
        assertArrayEquals(children, family.getChildren());
    }

    @Test
    public void testCountFamily() {
        int expected = 4;
        int actual = family.countFamily();

        assertEquals(expected, actual);
    }
}
