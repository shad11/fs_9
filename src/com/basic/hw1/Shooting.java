package com.basic.hw1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Shooting {
    public static void main(String[] args) {
        int size = 5;
        int shootCellsCnt = 3;
        int shootSuccessCnt = 0;
        boolean isRunning = true;
        char[][] gameField = new char[size][size];
        char[][] gameShootField = new char[size][size];

        fillFieldByChar(gameField, '-');
        fillGameShootField(gameShootField, size, shootCellsCnt);
//        printGameField(gameShootField);

        while (isRunning) {
            boolean isSuccessShoot = makeShoot(gameField, gameShootField);

            if (isSuccessShoot) {
                shootSuccessCnt++;

                if (shootSuccessCnt == shootCellsCnt) {
                    System.out.println("--------------\nYou have won!");
                    isRunning = false;
                }
            }

            printGameField(gameField);
        }
    }

    static boolean makeShoot(char[][] gameField, char[][] shootField) {
        int row = getValue("Enter row [1-5]: ");
        int column = getValue("Enter column [1-5]: ");

        if (shootField[row][column] == 'X') {
            if (gameField[row][column] == 'X') {
                return false;
            }
            gameField[row][column] = 'X';
            return true;
        } else {
            gameField[row][column] = '*';
            return false;
        }
    }

    static int getValue(String msg) {
        Scanner input = new Scanner(System.in);
        int number;

        while (true) {
            System.out.print(msg);

            if (!input.hasNextInt()) {
                System.out.println("You entered not a number. Please, try again!");
                input.next();
                continue;
            }

            number = input.nextInt();

            if (number < 1 || number > 5) {
                System.out.println("You entered not valid number. Please, try again!");
                continue;
            }

            break;
        }
        return --number;
    }

    static void fillFieldByChar(char[][] gameField, char charDefault) {
        for (char[] row : gameField) {
            Arrays.fill(row, charDefault);
        }
    }

    static void fillGameShootField(char[][] shootField, int size, int shootCellsCnt) {
        Random random = new Random();
        boolean verticalDirection = random.nextInt(2) != 0;
        int directionNumber = random.nextInt(size);
        int randomNumber = random.nextInt(size - shootCellsCnt);
        int row, column;

        for (int i = 0; i < shootCellsCnt; i++) {
            row = verticalDirection ? randomNumber + i : directionNumber;
            column = verticalDirection ? directionNumber : randomNumber + i;

            shootField[row][column] = 'X';
        }
    }

    static void printGameField(char[][] field) {
        System.out.print("0 | ");

        for (int i = 1; i <= field[0].length; i++) {
            System.out.printf("%d | ", i);
        }

        for (int i = 0; i < field.length; i++) {
            System.out.printf("\n%d |", i + 1);

            for (int j = 0; j < field[i].length; j++) {
                System.out.printf(" %c |", field[i][j]);
            }
        }

        System.out.println();
    }
}
