package com.basic.happyFamily.utils;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Menu {
    public static<T> HashMap<Integer, String> createNumericMenu(T[] list) {
        HashMap<Integer, String> menu = new HashMap<>();
        int number = 1;

        for (T item : list) {
            menu.put(number, item.toString());
            number++;
        }

        return menu;
    }

    public static<K, V> void showMenu(HashMap<K, V> menu) {
        System.out.println("----------------------------");

        for (Object key : menu.keySet()) {
            System.out.println(key + ". " + menu.get(key));
        }

        System.out.println("----------------------------");
    }

    public static int chooseNumericItemMenu(HashMap<Integer, String> menu) {
        int number;
        Set<Integer> numbers = menu.keySet();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print("Введіть номер пункту меню: ");
            number = Integer.parseInt(input.nextLine());

            if (!numbers.contains(number)) {
                Logger.error("Wrong entered number: " + number);
                System.out.println("Ви ввели невірне число. Спробуйте ще.");
                continue;
            }

            return number;
        }
    }
}
