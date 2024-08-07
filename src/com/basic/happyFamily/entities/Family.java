package com.basic.happyFamily.entities;

import java.time.Year;
import java.util.*;
import java.util.stream.Collectors;
import java.io.Serializable;

public class Family implements Serializable {
    private static final long serialVersionUID = 1L;

    private Woman mother;
    private Man father;
    private List<Human> children;
    private Set<Pet> pets;

//    static {
//        System.out.println("Class Family is loaded");
//    }

    {
        children = new ArrayList<>();
        pets = new HashSet<>();
//        System.out.println("Instance " + this.getClass() + " is loaded");
    }

    public Family(Woman mother, Man father) {
        this.mother = mother;
        this.father = father;

        mother.setFamily(this);
        father.setFamily(this);
    }

    public Woman getMother() {
        return mother;
    }

    public void setMother(Woman mother) {
        this.mother = mother;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public Man getFather() {
        return father;
    }

    public void setFather(Man father) {
        this.father = father;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())  // instanceof
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
                children.toString(),
                pets == null ? "No pet" : pets.toString()
        );
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Family object is deleted: " + this);
    }

    public void addChild(Human child) {
        children.add(child);
        child.setFamily(this);
    }

    public boolean deleteChild(int index) {
        if (index < 0 || index >= children.size()) {
            return false;
        }

        children.remove(index);
        return true;
    }

    public boolean deleteChild(Human childDeleted) {
        return children.remove(childDeleted);
    }

    public boolean addPet(Pet pet) {
        return pets.add(pet);
    }

    public int countFamily() {
        return 2 + children.size();
    }

    public void bornChild(String boyName, String girlName) {
        try {
            mother.bornChild(boyName, girlName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String prettyFormat() {
        String childrenStr = "[]";
        String petsStr = "[]";

        List<Human> children = getChildren();
        Set<Pet> pets = getPets();

        if (!children.isEmpty()) {
            childrenStr = "\n\t\t" +
                    getChildren().stream()
                            .map(child -> (child instanceof Man ? "boy: " : "girl: ") + child.prettyFormat())
                            .collect(Collectors.joining(",\n\t\t"));
        }

        if (!pets.isEmpty()) {
            petsStr = "\n\t\t" +
                    pets.stream()
                            .map(Pet::prettyFormat)
                            .collect(Collectors.joining(",\n\t\t"));
        }

        return "family:\n\tmother: %s;\n\tfather: %s;\n\tchildren: %s;\n\tpets: %s".formatted(
                mother.prettyFormat(),
                father.prettyFormat(),
                childrenStr,
                petsStr
        );
    }
}
