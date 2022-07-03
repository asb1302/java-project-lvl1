package hexlet.code;

import java.util.Scanner;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Cli {
    public static void greet() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");

        Scanner scanner = new Scanner(System.in, UTF_8.name());

        System.out.println("Hello, " + scanner.nextLine() + "!");
    }
}
