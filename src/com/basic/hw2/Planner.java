package com.basic.hw2;

import java.util.Scanner;

public class Planner {
    public static void main(String[] args) {
        String[][] schedule = new String[7][2];
        Scanner input = new Scanner(System.in);
        String inputText;
        byte dayOfWeek;
        boolean isReschedule;

        fillSchedule(schedule);

        while (true) {
            System.out.print("Please, input the day of the week: ");
            inputText = input.nextLine().toLowerCase().strip();
            isReschedule = inputText.contains("change") || inputText.contains("reschedule");


            if (isReschedule) {
                inputText = inputText.replace("change", "")
                        .replace("reschedule", "")
                        .strip();
            }

            dayOfWeek = getDayOfWeek(inputText);

            if (dayOfWeek < 0) {
                System.out.println("Sorry, I don't understand you, please try again.");
            } else {
                if (isReschedule) {
                    reschedule(dayOfWeek, schedule);
                } else {
                    System.out.printf("Your tasks for %s: %s\n", schedule[dayOfWeek][0], schedule[dayOfWeek][1]);
                }
            }
        }
    }

    static byte getDayOfWeek(String day) {
        byte dayOfWeek = -1;

        switch (day) {
            case "sunday":
                dayOfWeek = 0;
                break;
            case "monday":
                dayOfWeek = 1;
                break;
            case "tuesday":
                dayOfWeek = 2;
                break;
            case "wednesday":
                dayOfWeek = 3;
                break;
            case "thursday":
                dayOfWeek = 4;
                break;
            case "friday":
                dayOfWeek = 5;
                break;
            case "saturday":
                dayOfWeek = 6;
                break;
            case "exit":
                System.exit(0);
            default:
                break;
        }

        return dayOfWeek;
    }

    static void reschedule(byte dayOfWeek, String[][] schedule) {
        Scanner input = new Scanner(System.in);

        System.out.printf("Please, enter a new schedule for %s:\n", schedule[dayOfWeek][0]);
        String tasks = input.nextLine();

        schedule[dayOfWeek][1] = tasks;
    }

    static void fillSchedule(String[][] schedule) {
        schedule[0][0] = "Sunday";
        schedule[0][1] = "do homework from Java courses";
        schedule[1][0] = "Monday";
        schedule[1][1] = "go to courses; read an article";
        schedule[2][0] = "Tuesday";
        schedule[2][1] = "do homework; learn new English words";
        schedule[3][0] = "Wednesday";
        schedule[3][1] = "go to Java and English courses";
        schedule[4][0] = "Thursday";
        schedule[4][1] = "learn new English words; watch youtube video in English";
        schedule[5][0] = "Friday";
        schedule[5][1] = "go to the gym or swimming pool";
        schedule[6][0] = "Saturday";
        schedule[6][1] = "meet with friends; have a rest";
    }
}
