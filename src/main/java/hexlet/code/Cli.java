package hexlet.code;

import java.util.Scanner;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Cli {
    public static void welcome() {
        System.out.println("Welcome to the Brain Games!");
    }

    public static String getUserName() {
        System.out.print("May I have your name? ");

        Scanner scanner = new Scanner(System.in, UTF_8.name());

        return scanner.nextLine();
    }

    public static void greet(String userName) {
        System.out.println("Hello, " + userName + "!");
    }

    public static void sayGoodbye(String userName, boolean isWon) {
        if (isWon) {
            System.out.println("Congratulations, " + userName + "!");
        } else {
            System.out.println("Let's try again, " + userName + "!");
        }
    }
}
