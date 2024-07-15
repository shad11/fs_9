package com.basic.happyFamily.interfaces;

import com.basic.happyFamily.entities.Human;

public interface IHumanCreator {
    String[] boyNames = {"Tom", "John", "Jake", "Mark", "Oliver", "Mike"};
    String[] girlNames = {"Kate", "Marry", "Kris", "Hanna", "Olga", "Bree"};
    Human bornChild() throws Exception;
    Human bornChild(String boyName, String girlName) throws Exception;
}
