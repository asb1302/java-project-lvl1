package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public final class PrimeGame {
    public static void play() {
        String userName = Engine.greet();

        System.out.println("Answer 'yes' if number prime otherwise answer 'no'. ");

        int correctAnswers = 0;
        while (correctAnswers < Engine.getWinConditionCounterLimit()) {
            int randomNumber = new Random().nextInt(Engine.getMaxRandomNumber()) + 1;
            System.out.println("Question: " + randomNumber);
            String userAnswer = Engine.getScanner().nextLine();
            String correctAnswer = PrimeGame.checkNumberIsPrime(randomNumber) ? "yes" : "no";

            if (correctAnswer.equals(userAnswer)) {
                System.out.println("Correct!");
                correctAnswers++;
            } else {
                Engine.sayGoodbye(userName, correctAnswers);

                return;
            }
        }

        Engine.sayGoodbye(userName, correctAnswers);
    }

    private static boolean checkNumberIsPrime(int number) {
        boolean check = true;

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                check = false;

                break;
            }
        }

        return check;
    }
}
