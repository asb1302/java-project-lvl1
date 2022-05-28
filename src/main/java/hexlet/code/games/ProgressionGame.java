package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public final class ProgressionGame {
    private static final int MIN_PROGRESSION_SIZE = 5;
    private static final int MAX_PROGRESSION_SIZE = 10;

    private int missedNumber;
    public static void play() {
        String userName = Engine.greet();

        System.out.println("What number is missing in this progression?");

        int correctAnswers = 0;
        while (correctAnswers < Engine.getWinConditionCounterLimit()) {
            int correctAnswer = ProgressionGame.printProgression();
            int userAnswer = Integer.parseInt((new Scanner(System.in)).nextLine());

            if (correctAnswer == userAnswer) {
                System.out.println("Correct!");

                correctAnswers++;
            } else {
                Engine.sayGoodbye(userName, correctAnswers);

                return;
            }
        }

        Engine.sayGoodbye(userName, correctAnswers);
    }

    private static int printProgression() {
        int size = MIN_PROGRESSION_SIZE + (int) (Math.random() * MAX_PROGRESSION_SIZE);
        int randomMissedPosition = (int) (Math.random() * (size));

        int step = new Random().nextInt(Engine.getMaxRandomNumber()) + 1;

        int number = new Random().nextInt(Engine.getMaxRandomNumber());

        int missedNumber = 0;
        for (int i = 0; i < size; i++) {
            if (i == randomMissedPosition) {
                System.out.print(".." + " ");
                missedNumber = number;
            } else {
                System.out.print(number + " ");
            }

            number += step;
        }

        System.out.println();

        return missedNumber;
    }
}
