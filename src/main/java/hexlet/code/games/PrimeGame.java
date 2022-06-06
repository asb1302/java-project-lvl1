package hexlet.code.games;

import hexlet.code.services.RandomNumberGenerator;
import java.util.Objects;

public final class PrimeGame implements GameInterface {

    private int randomNumber;

    @Override
    public String getPreview() {
        return "Answer 'yes' if number prime otherwise answer 'no'.";
    }

    @Override
    public String getQuestion() {
        this.randomNumber = new RandomNumberGenerator().getRandomNumber();

        return "Question: " + randomNumber + "\n";
    }

    @Override
    public int getWinConditionCounterLimit() {
        return WIN_CONDITION_COUNTER_LIMIT;
    }

    @Override
    public boolean userAnswerIsCorrect(String userAnswer) {
        return Objects.equals(userAnswer, this.checkNumberIsPrime(randomNumber) ? "yes" : "no");
    }

    private boolean checkNumberIsPrime(int number) {
        if (number == 1) {
            return false;
        }

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
