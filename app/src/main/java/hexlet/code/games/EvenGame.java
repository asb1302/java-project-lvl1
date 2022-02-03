package hexlet.code.games;

import java.util.Random;

public final class EvenGame extends BaseGame implements GameInterface {
    @Override
    public void play() {
        System.out.println("Answer 'yes' if number even otherwise answer 'no'. ");

        int correctAnswerCounter = 0;

        while (correctAnswerCounter < this.WIN_CONDITION_COUNTER_LIMIT) {
            int randomNumber = new Random().nextInt(this.MAX_RANDOM_NUMBER);
            System.out.println("Question: " + randomNumber);
            String userAnswer = this.getScanner().nextLine();
            String correctAnswer = randomNumber % 2 == 0 ? "yes" : "no";

            if (correctAnswer.equals(userAnswer)) {
                correctAnswerCounter++;
            } else {
                System.out.println(this.LOST_MSG);
                return;
            }
        }

        System.out.println(this.WIN_MSG);
    }
}
