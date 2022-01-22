package hexlet.code;

import java.util.Scanner;

public class App {
    public static final int MAX_RANDOM_NUMBER = 100;
    public static final int WIN_CONDITION_COUNTER_LIMIT = 3;

    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        try {
            int choice = Integer.parseInt(input);

            switch (choice) {
                case 1 -> {
                    System.out.println("Welcome to the Brain Games!");
                    System.out.print("May I have your name? ");
                    String name = scanner.nextLine();
                    System.out.println("Hello, " + name + "!");
                }
                case 2 -> {
                    System.out.println("Answer 'yes' if number even otherwise answer 'no'. ");

                    int correctAnswerCounter = 0;

                    while (correctAnswerCounter < App.WIN_CONDITION_COUNTER_LIMIT) {
                        int randomNumber = App.getRandomNumber(1, App.MAX_RANDOM_NUMBER);
                        System.out.println("Question:" + randomNumber);
                        String userAnswer = scanner.nextLine();
                        String correctAnswer = randomNumber % 2 == 0 ? "yes" : "no";

                        if (correctAnswer.equals(userAnswer)) {
                            correctAnswerCounter++;
                        } else {
                            System.out.println("You lost!");
                            return;
                        }
                    }

                    System.out.println("Congratulations, Sam!");
                }
                case 0 -> {
                    System.out.println("Bye!");
                }
                default -> {
                    System.out.println("Incorrect input!");
                }
            }
        } catch (NumberFormatException ex) {
            System.out.println("Incorrect input!");
        }
    }

    private static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
