package com.basic.flightBooking.menu;

import com.basic.flightBooking.controller.FlightController;
import com.basic.flightBooking.exception.MenuException;

import java.util.List;

import static com.basic.flightBooking.utilities.Menu.MENU_DEFAULT;
import static com.basic.flightBooking.utilities.Menu.chooseNumericMenu;

public class Menu {
    private static FlightController flightController = new FlightController();

    private static void makeAction(String action) {
        switch (action) {
            case "exit":
                flightController.saveDataToFile();
                System.exit(0);
            case "onlineSchedule":
                flightController.onlineSchedule();
                break;
            case "flightInfo":
                flightController.flightInfo();
                break;
            default:
                break;
        }
    }

    public static void start() {
        List<String> menuList = MENU_DEFAULT.keySet().stream().toList();
        int menuNumber;

        flightController.readDataFromFile();

        while (true) {
            try {
                System.out.println("------------------------------------");
                menuNumber = chooseNumericMenu(menuList);
            } catch (MenuException e) {
                System.out.println(e.getMessage());
                continue;
            }

            String menuKey = menuList.get(menuNumber - 1);
            String action = MENU_DEFAULT.get(menuKey);

            System.out.println("------------------------------------");
            System.out.println(menuKey);

            makeAction(action);
        }
    }
}
