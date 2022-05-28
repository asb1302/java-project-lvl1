package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int MAX_RANDOM_NUMBER = 10;

    public static final int WIN_CONDITIONS_COUNTER_LIMIT = 3;

    public static Scanner getScanner() {
        return new Scanner(System.in);
    }

    public static String greet() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");

        Scanner scanner = new Scanner(System.in);

        String userName = scanner.nextLine();

        System.out.println("Hello, " + userName + "!");

        return userName;
    }

    public static void sayGoodbye(String userName, int correctAnswers) {
        if (correctAnswers >= WIN_CONDITIONS_COUNTER_LIMIT) {
            System.out.println("Congratulations, " + userName + "!");
        } else {
            System.out.println("Sorry, " + userName + ", you lost ;(");
        }
    }

    public static int getMaxRandomNumber() {
        return MAX_RANDOM_NUMBER;
    }

    public static int getWinConditionCounterLimit() {
        return WIN_CONDITIONS_COUNTER_LIMIT;
    }
}
