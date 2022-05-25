package hexlet.code.games;

import java.util.Random;

public final class PrimeGame extends BaseGame implements GameInterface {
    @Override
    public void play() {
        this.greet();

        System.out.println("Answer 'yes' if number prime otherwise answer 'no'. ");

        while (this.getCorrectAnswerCounter() < this.getWinConditionCounterLimit()) {
            int randomNumber = new Random().nextInt(this.getMaxRandomNumber()) + 1;
            System.out.println("Question: " + randomNumber);
            String userAnswer = this.getScanner().nextLine();
            String correctAnswer = this.checkNumberIsPrime(randomNumber) ? "yes" : "no";

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

    private boolean checkNumberIsPrime(int number) {
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
