package com.basic.hw3.entity;

import java.util.Arrays;
import java.util.Objects;

public class Family {
    private Human mother;
    private Human father;
    private Human[] children;
    private Pet pet;

    static {
        System.out.println("Class Family is loaded");
    }

    {
        children = new Human[0];
        System.out.println("Instance " + this.getClass() + " is loaded");
    }

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;

        mother.setFamily(this);
        father.setFamily(this);
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Human[] getChildren() {
        return children;
    }

    public void setChildren(Human[] children) {
        this.children = children;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Family family = (Family) obj;

        return mother.equals(family.mother) && father.equals(family.father);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mother, father);
    }

    @Override
    public String toString() {
        return "Mother: %s,\nFather: %s,\nTheir children:%s,\nPet: %s".formatted(
                mother.toString(),
                father.toString(),
                Arrays.toString(children),
                pet == null ? "No pet" : pet.toString()
        );
    }

    public void addChild(Human child) {
        int  childrenCnt = children.length;

        children = Arrays.copyOf(children, childrenCnt + 1);
        children[childrenCnt] = child;
        child.setFamily(this);
    }

    public boolean deleteChild(int index) {
        if (index < 0 || index >= children.length) {
            return false;
        }

        Human[] childrenNew = new Human[children.length - 1];

        for (int i = 0; i < children.length; i++) {
            if (i == index) {
                children[i].setFamily(null);
                continue;
            }
            childrenNew[i] = children[i];
        }

        children = childrenNew;
        return true;
    }

    public boolean deleteChild(Human childDeleted) {
        int ind = 0;

        for (Human child : children) {
            if (child.equals(childDeleted)) {
                return deleteChild(ind);
            }

            ind++;
        }

        return false;
    }

    public int countFamily() {
        return 2 + children.length;
    }
}
