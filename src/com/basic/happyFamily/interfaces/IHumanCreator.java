package com.basic.happyFamily.interfaces;

import com.basic.happyFamily.entity.Human;

public interface IHumanCreator {
    String[] boyNames = {"Tom", "John", "Jake", "Mark", "Oliver", "Mike"};
    String[] girlNames = {"Kate", "Marry", "Kris", "Hanna", "Olga", "Bree"};
    Human bornChild() throws Exception;
}
