package com.basic.hw1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int userNumber,
                randomNumber = new Random().nextInt(101);
//        boolean isRunning = true;
        int[] numbers = {};

        System.out.println(randomNumber);

        System.out.print("Please, enter your name: ");
        String userName = input.nextLine();

        System.out.println("Let the game begin!");

        while (true) {
            System.out.print("Enter a number [0-100]: ");

            if (!input.hasNextInt()) {
                System.out.println("You entered not a number! Please try again.");
                input.next();
                continue;
            }

            userNumber = input.nextInt();

            if (userNumber == randomNumber) {
                if (numbers.length > 0) {
                    arraySortDesc(numbers);
                    System.out.println("You entered such numbers:" + Arrays.toString(numbers));
                }
                System.out.printf("Congratulations, %s!", userName);
                // isRunning = false;
                break;
            } else if (userNumber < randomNumber) {
                System.out.println("Your number is too small. Please, try again.");
            } else {
                System.out.println("Your number is too big. Please, try again.");
            }

            numbers = Arrays.copyOf(numbers, numbers.length + 1);
            numbers[numbers.length - 1] = userNumber;
        }
    }

    static void arraySortDesc(int[] arr) {
        int tmp;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }
}
