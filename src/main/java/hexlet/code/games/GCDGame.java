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
            int correctAnswer = GCDGame.gcdByEuclidsAlgorithm(firstRandomNumber, secondRandomNumber);

            if (correctAnswer == userAnswer) {
                correctAnswers++;
            } else {
                Engine.sayGoodbye(userName, correctAnswers);

                return;
            }
        }

        Engine.sayGoodbye(userName, correctAnswers);
    }

    private static int gcdByEuclidsAlgorithm(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }

        return gcdByEuclidsAlgorithm(n2, n1 % n2);
    }
}
