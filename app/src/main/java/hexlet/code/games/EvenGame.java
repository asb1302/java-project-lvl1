package hexlet.code.games;

import java.util.Random;

public final class EvenGame extends BaseGame implements GameInterface {
    @Override
    public void play() {
        this.greet();

        System.out.println("Answer 'yes' if number even otherwise answer 'no'. ");

        while (this.getCorrectAnswerCounter() < this.getWinConditionCounterLimit()) {
            int randomNumber = new Random().nextInt(this.getMaxRandomNumber());
            System.out.println("Question: " + randomNumber);
            String userAnswer = this.getScanner().nextLine();
            String correctAnswer = randomNumber % 2 == 0 ? "yes" : "no";

            if (correctAnswer.equals(userAnswer)) {
                System.out.println("Correct!");
                this.increaseCorrectedAnswersCounter();
            } else {
                this.sayGoodbye();

                return;
            }
        }

        this.sayGoodbye();
    }
}
