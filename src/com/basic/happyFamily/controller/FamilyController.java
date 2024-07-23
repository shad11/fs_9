package com.basic.happyFamily.controller;

import com.basic.happyFamily.entities.*;
import com.basic.happyFamily.exceptions.FamilyOverflowException;
import com.basic.happyFamily.service.FamilyService;
import com.basic.happyFamily.utils.Logger;
import com.basic.happyFamily.utils.Menu;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class FamilyController {
    private final FamilyService familyService;
    private final Scanner input;

    {
        familyService = new FamilyService();
        input = new Scanner(System.in);
    }

    private int inputInteger(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                System.out.println("Ви ввели не число. Спробуйте ще.");
            }
        }
    }

    private Human createHumanByEnterData(boolean isWoman, boolean isParent) {
        String gender = isWoman ?
                (isParent ? "матері" : "дівчинки") :
                (isParent ? "батька" : "хлопчика");
        LocalDate birthDate;
        DateTimeFormatter birthDateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.printf("Введіть ім'я %s: ", gender);
        String name = input.nextLine();

        System.out.printf("Введіть прізвище %s: ", gender);
        String surname = input.nextLine();

        while (true) {
            try {
                int birthYear = inputInteger("Введіть рік народження " + gender + ": ");

                int birthMonth = inputInteger("Введіть місяць народження " + gender + ": ");

                int birthDay = inputInteger("Введіть день народження " + gender + ": ");

                birthDate = LocalDate.of(birthYear, birthMonth, birthDay);

                break;
            } catch (Exception e) {
                System.out.println("Ви ввели неправильні дані для дати. Спробуйте ще.");
            }
        }

        int iq = inputInteger("Введіть iq " + gender + ": ");

        return isWoman
                ? new Woman(name, surname, birthDate.format(birthDateFormatter), iq)
                : new Man(name, surname, birthDate.format(birthDateFormatter), iq);
    }

    private int getFamilyIndex() {
        int index;
        int familiesCount = familyService.count();

        familyService.displayAllFamilies();

        index = inputInteger("Введіть номер сім'ї: ");

        if (index < 1 || index > familiesCount) {
            Logger.error("Wrong family number: " + index);
            System.out.println("Ви ввели невірний номер сім'ї!");
            return -1;
        } else {
            return index - 1;
        }
    }

    public List<Family> getAllFamilies() {
        return familyService.getAllFamilies();
    }

    public void displayAllFamilies() {
        familyService.displayAllFamilies();
    }

    public void getFamiliesBiggerThan() {
        int peopleCount = inputInteger("Сім'ї, котрі мають кількість людей більше за це число, не виводяться. Введіть число: ");

        familyService.getFamiliesBiggerThan(peopleCount);
    }

    public void getFamiliesLessThan() {
        int peopleCount = inputInteger("Сім'ї, котрі мають кількість людей менше за це число, не виводяться. Введіть число: ");

        familyService.getFamiliesLessThan(peopleCount);
    }

    public void countFamiliesWithMemberNumber() {
        int peopleCount = inputInteger("Виведуться сім'ї, де кількість членів дорівнює введенему числу. Введіть число: ");
        int familiesCount = familyService.countFamiliesWithMemberNumber(peopleCount);

        System.out.println("Кількість сімей: " + familiesCount);
    }

    public void createNewFamily(Woman mother, Man father) {
        familyService.createNewFamily(mother, father);
    }

    public void createNewFamily() {
        Woman mother = (Woman) createHumanByEnterData(true, true);
        Man father = (Man) createHumanByEnterData(false, true);

        familyService.createNewFamily(mother, father);
    }

    public void deleteFamilyByIndex() {
        int index = getFamilyIndex();

        if (index == -1) {
            return;
        }

        boolean isDeleted = familyService.deleteFamilyByIndex(index);
        System.out.println(isDeleted ? "Сім'я була видалена" : "Сім'я не видалена (неправильний номер)");
    }

    public Family bornChild(Family family) {
        System.out.print("Введіть їм'я хлопчика: ");
        String boyName = input.nextLine();
        System.out.print("Введіть їм'я дівчинки: ");
        String girlName = input.nextLine();

        try {
            return familyService.bornChild(family, boyName, girlName);
        } catch (FamilyOverflowException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Family adoptChild(Family family) {
        boolean isWoman = false;

        System.out.print("Це дівчинка [1] чи хлопчик [2]? ");
        String number = input.nextLine();

        switch (number) {
            case "1":
                isWoman = true;
                break;
            case "2":
                break;
            default:
                System.out.println("Ви ввели невірне число.");
                return null;
        }

        Human child = createHumanByEnterData(isWoman, false);

        try {
            return familyService.adoptChild(family, child);
        } catch (FamilyOverflowException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void deleteAllChildrenOlderThen() {
        int age = inputInteger("Введіть вік, старше якого треба видалити дітей: ");

        familyService.deleteAllChildrenOlderThen(age);
    }

    public int count() {
        return familyService.count();
    }

    public Family getFamilyById(int index) {
        return familyService.getFamilyById(index);
    }

    public Set<Pet> getPets(int familyIdx) {
        return familyService.getPets(familyIdx);
    }

    public void addPet(int familyIdx, Pet pet) {
        familyService.addPet(familyIdx, pet);
    }

    public void editFamily() {
        int index;
        Family family;

        HashMap<Integer, String> menu = new HashMap<>(){{
            put(1, "Народити дитину");
            put(2, "Усиновити дитину");
            put(3, "Повернутися до головного меню");
        }};

        while (true) {
            Menu.showMenu(menu);
            int menuNumber = Menu.chooseNumericItemMenu(menu);

            switch (menuNumber) {
                case 1:
                    index = getFamilyIndex();

                    if (index != -1) {
                        family = familyService.getFamilyById(index);
                        bornChild(family);
                    }

                    break;
                case 2:
                    index = getFamilyIndex();

                    if (index != -1) {
                        family = familyService.getFamilyById(index);
                        adoptChild(family);
                    }

                    break;
                case 3:
                    return;
                default:
                    break;
            }
        }
    }

    public void saveDataToFile() {
        List<Family> families = familyService.getAllFamilies();

        if (families.isEmpty()) {
            System.out.println("Список сімей пустий. Нічого зберігати.");
            return;
        }

        try {
            familyService.loadData(families);
            System.out.println("Дані збережені у файл.");
        } catch (RuntimeException e) {
            System.out.println("Помилка при зберіганні даних у файл:");
            System.out.println(e.getMessage());
        }

    }

    public void loadDataFromFile() {
        try {
            familyService.loadData();
            System.out.println("Дані завантажені з файлу.");
        } catch (RuntimeException e) {
            System.out.println("Помилка при завантаженні даних з файлу:");
            System.out.println(e.getMessage());
        }
    }
}
