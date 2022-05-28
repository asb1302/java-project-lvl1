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

    private static int getGcdBySteinsAlgorithm(int n1, int n2) {
        if (n1 == 0) {
            return n2;
        }

        if (n2 == 0) {
            return n1;
        }

        int n;
        for (n = 0; ((n1 | n2) & 1) == 0; n++) {
            n1 >>= 1;
            n2 >>= 1;
        }

        while ((n1 & 1) == 0) {
            n1 >>= 1;
        }

        do {
            while ((n2 & 1) == 0) {
                n2 >>= 1;
            }

            if (n1 > n2) {
                int temp = n1;
                n1 = n2;
                n2 = temp;
            }
            n2 = (n2 - n1);
        } while (n2 != 0);

        return n1 << n;
    }
}
