package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

import static java.nio.charset.StandardCharsets.UTF_8;

public final class GCDGame {
    public static void play() {
        String userName = Engine.greet();

        System.out.println("Find the greatest common divisor of given numbers.");

        int correctAnswers = 0;
        while (correctAnswers < Engine.getWinConditionCounterLimit()) {
            int firstRandomNumber = new Random().nextInt(Engine.getMaxRandomNumber()) + 1;
            int secondRandomNumber = new Random().nextInt(Engine.getMaxRandomNumber()) + 1;

            System.out.println("Question: " + firstRandomNumber + " " + secondRandomNumber);
            System.out.print("Your answer: ");
            int userAnswer = Integer.parseInt(new Scanner(System.in, UTF_8.name()).nextLine());
            int correctAnswer = GCDGame.getGcdBySteinsAlgorithm(firstRandomNumber, secondRandomNumber);

            if (correctAnswer == userAnswer) {
                correctAnswers++;
            } else {
                Engine.sayGoodbye(userName, correctAnswers);

                return;
            }
        }

        Engine.sayGoodbye(userName, correctAnswers);
    }

    private static int getGcdBySteinsAlgorithm(int number1, int number2) {
        if (number1 == 0) {
            return number2;
        }

        if (number2 == 0) {
            return number1;
        }

        int n;
        for (n = 0; ((number1 | number2) & 1) == 0; n++) {
            number1 >>= 1;
            number2 >>= 1;
        }

        while ((number1 & 1) == 0) {
            number1 >>= 1;
        }
        do {
            while ((number2 & 1) == 0) {
                number2 >>= 1;
            }
            if (number1 > number2) {
                int temp = number1;
                number1 = number2;
                number2 = temp;
            }
            number2 = (number2 - number1);
        } while (number2 != 0);

        return number1 << n;
    }
}
