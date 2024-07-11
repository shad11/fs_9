package com.basic.happyFamily;

import com.basic.happyFamily.entities.Human;
import com.basic.happyFamily.entities.Family;
import com.basic.happyFamily.entities.Man;
import com.basic.happyFamily.entities.Woman;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FamilyTest {
    private Family family;
    private List<Human> children;
    private Woman mother;
    private Man father;

    {
        mother = new Woman("Sara", "Tailor", 1986);
        father = new Man("John", "Tailor", 1984);
        children = Arrays.asList(new Human("Kate", "Tailor"), new Human("Tom", "Tailor"));
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
        int childrenSizeBefore = family.getChildren().size();
        Human childToAdd = new Human("James", "Tailor");

        family.addChild(childToAdd);

        List<Human> childrenNew = family.getChildren();

        assertEquals(childrenSizeBefore + 1, childrenNew.size());
        assertEquals(childrenNew.get(children.size()), childToAdd);
    }

    @Test
    public void testDeleteChildByHumanExist() {
        Human childToDelete = new Human("James", "Tailor");

        family.addChild(childToDelete);

        boolean expected = true;
        boolean actual = family.deleteChild(childToDelete);

        assertEquals(expected, actual);
        assertArrayEquals(children.toArray(), family.getChildren().toArray());
    }

    @Test
    public void testDeleteChildByHumanNotExist() {
        Human childToDelete = new Human("James", "Tailor");

        assertFalse(family.deleteChild(childToDelete));
        assertArrayEquals(children.toArray(), family.getChildren().toArray());
    }

    @Test
    public void testDeleteChildByWrongObject() {
        Integer number = Integer.valueOf(10);

        assertFalse(family.deleteChild(number));
        assertArrayEquals(children.toArray(), family.getChildren().toArray());
    }

    @Test
    public void testDeleteChildByIdExist() {
        Human childToDelete = new Human("James", "Tailor");

        family.addChild(childToDelete);

        int deleteIndex = family.getChildren().size() - 1;

        assertTrue(family.deleteChild(deleteIndex));
        assertArrayEquals(children.toArray(), family.getChildren().toArray());
    }

    @Test
    public void testDeleteChildByIdOutOfBound() {
        int deleteIndex = family.getChildren().size() + 3;

        assertFalse(family.deleteChild(deleteIndex));
    }

    @Test
    public void testCountFamily() {
        int expected = 4;
        int actual = family.countFamily();

        assertEquals(expected, actual);
    }
}
