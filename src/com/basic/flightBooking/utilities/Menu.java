package com.basic.flightBooking.utilities;

import com.basic.flightBooking.exception.MenuException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    public static Map<String, String> MENU_DEFAULT = new HashMap<>(){{
        put("Онайн-табло", "onlineSchedule");
        put("Подивитися інформацію про рейс", "flightInfo");
//        put("Пошук та бронювання рейсу", "findFlight");
//        put("Скасувати бронювання", "deleteBooking");
//        put("Мої рейси", "myBookings");
        put("Вихід", "exit");
    }};

    public static int chooseNumericMenu(List<String> menu) throws MenuException {
        if (menu.isEmpty()) {
            throw new MenuException("Меню не може бути пустим!");
        }

        Scanner input = new Scanner(System.in);
        int num = 1;

        for (String item : menu) {
            System.out.println(num + ") " + item);
            num++;
        }

        System.out.print("Виберіть пункт меню: ");
        num = Integer.parseInt(input.nextLine());

        if (num < 1 || num > menu.size()) {
            throw new MenuException("Ви вибрали невірний пункт меню! Спробуйте ще.");
        } else {
            return num;
        }
    }
}
