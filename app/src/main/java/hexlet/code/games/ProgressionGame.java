package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public final class ProgressionGame extends BaseGame implements GameInterface {
    public static final int MIN_PROGRESSION_SIZE = 5;
    public static final int MAX_PROGRESSION_SIZE = 10;

    private int missedNumber;
    @Override
    public void play() {
        this.greet();

        System.out.println("What number is missing in this progression?");

        while (this.getCorrectAnswerCounter() < this.getWinConditionCounterLimit()) {
            this.printProgression();
            int userAnswer = Integer.parseInt((new Scanner(System.in)).nextLine());
            int correctAnswer = this.missedNumber;

            if (correctAnswer == userAnswer) {
                System.out.println("Correct!");

                this.increaseCorrectedAnswersCounter();
            } else {
                this.sayGoodbye();

                return;
            }
        }

        this.sayGoodbye();
    }

    private void printProgression() {
        int size =
                (int) Math.floor(Math.random()
                        * (MAX_PROGRESSION_SIZE - MIN_PROGRESSION_SIZE + 1) + MIN_PROGRESSION_SIZE + 1) + 1;
        int randomMissedPosition = (int) Math.floor(Math.random()
                * (size - MIN_PROGRESSION_SIZE + 1) + MIN_PROGRESSION_SIZE + 1) - 1;

        int step = new Random().nextInt(this.getMaxRandomNumber()) + 1;

        int number = new Random().nextInt(this.getMaxRandomNumber());

        for (int i = 0; i < size; i++) {
            if (i == randomMissedPosition) {
                System.out.print(".." + " ");
                this.missedNumber = number;
            } else {
                System.out.print(number + " ");
            }

            number += step;
        }

        System.out.println();
    }
}
