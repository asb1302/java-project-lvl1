package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public final class EvenGame {
    public static void play() {
        String userName = Engine.greet();

        System.out.println("Answer 'yes' if number even otherwise answer 'no'. ");

        int correctAnswers = 0;
        while (correctAnswers < Engine.getWinConditionCounterLimit()) {
            int randomNumber = new Random().nextInt(Engine.getMaxRandomNumber()) + 1;
            System.out.println("Question: " + randomNumber);
            String userAnswer = Engine.getScanner().nextLine();
            String correctAnswer = randomNumber % 2 == 0 ? "yes" : "no";

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
}
