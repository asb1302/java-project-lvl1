package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public final class GCDGame extends BaseGame implements GameInterface {
    @Override
    public void play() {
        this.greet();

        System.out.println("Find the greatest common divisor of given numbers.");

        while (this.getCorrectAnswerCounter() < this.getWinConditionCounterLimit()) {
            int firstRandomNumber = new Random().nextInt(this.getMaxRandomNumber());
            int secondRandomNumber = new Random().nextInt(this.getMaxRandomNumber());

            System.out.println("Question: " + firstRandomNumber + " " + secondRandomNumber);
            System.out.print("Your answer: ");
            int userAnswer = Integer.parseInt((new Scanner(System.in)).nextLine());
            int correctAnswer = this.getGcdBySteinsAlgorithm(firstRandomNumber, secondRandomNumber);

            if (correctAnswer == userAnswer) {
                this.increaseCorrectedAnswersCounter();
            } else {
                this.sayGoodbye();

                return;
            }
        }

        this.sayGoodbye();
    }

    private int getGcdBySteinsAlgorithm(int n1, int n2) {
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
