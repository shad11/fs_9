package com.basic.happyFamily;

import com.basic.happyFamily.controller.FamilyController;
import com.basic.happyFamily.utils.Constants;
import com.basic.happyFamily.utils.Menu;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final FamilyController familyController = new FamilyController();

    private static void runMethod(String name) {
//        try {
//            if (name.equals("exit")) {
//                System.exit(0);
//            }
//
//            Method method = familyController.getClass().getMethod(name);
//            method.invoke(familyController);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }

        switch (name) {
            case "exit":
                System.exit(0);
                break;
            case "fillTestData":
                familyController.fillTestData();
                break;
            case "displayAllFamilies":
                familyController.displayAllFamilies();
                break;
            case "getFamiliesBiggerThan":
                familyController.getFamiliesBiggerThan();
                break;
            case "getFamiliesLessThan":
                familyController.getFamiliesLessThan();
                break;
            case "countFamiliesWithMemberNumber":
                familyController.countFamiliesWithMemberNumber();
                break;
            case "createNewFamily":
                familyController.createNewFamily();
                break;
            case "deleteFamilyByIndex":
                familyController.deleteFamilyByIndex();
                break;
            case "editFamily":
                familyController.editFamily();
                break;
            case "deleteAllChildrenOlderThen":
                familyController.deleteAllChildrenOlderThen();
                break;
            default:
                System.out.println("There is no such method");
                break;
        }
    }

    public static void main(String[] args) {
        Map<String, String> menu = Constants.MENU_DEFAULT;

        HashMap<Integer, String> menuNav = Menu.createNumericMenu(menu.keySet().toArray(new String[0]));

        while (true) {
            Menu.showMenu(menuNav);

            int chosenMenuNumber = Menu.chooseNumericItemMenu(menuNav);

            String chosenMenuItem = menuNav.get(chosenMenuNumber);
            String method = menu.get(chosenMenuItem);
            runMethod(method);
        }
    }
}
