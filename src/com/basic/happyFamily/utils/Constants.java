package com.basic.happyFamily.utils;

import java.util.LinkedHashMap;
import java.util.Map;

public class Constants {
    public static final int FAMILY_SIZE = 5;

    public static final Map<String, String> MENU_DEFAULT = new LinkedHashMap<>(){{
        put("Вихід", "exit");
        put("Зберегти дані у файл", "saveDataToFile");
        put("Завантажити дані з файлу", "loadDataFromFile");
        put("Відобразити весь список сімей", "displayAllFamilies");
        put("Відобразити список сімей, де кількість людей більша за задану", "getFamiliesBiggerThan");
        put("Відобразити список сімей, де кількість людей менша за задану", "getFamiliesLessThan");
        put("Підрахувати кількість сімей, де кількість членів дорівнює", "countFamiliesWithMemberNumber");
        put("Створити нову родину", "createNewFamily");
        put("Видалити сім'ю за індексом сім'ї у загальному списку", "deleteFamilyByIndex");
        put("Редагувати сім'ю за індексом сім'ї у загальному списку", "editFamily");
        put("Видалити всіх дітей старше віку (у всіх сім'ях видаляються діти старше зазначеного віку - вважатимемо, що вони виросли)", "deleteAllChildrenOlderThen");
    }};
}
