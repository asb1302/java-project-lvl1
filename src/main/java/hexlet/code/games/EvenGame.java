package hexlet.code.games;

import hexlet.code.services.RandomNumberGenerator;
import java.util.Objects;

public final class EvenGame implements GameInterface {
    private int randomNumber;

    @Override
    public String getPreviewQuestion() {
        return "Answer 'yes' if number even otherwise answer 'no'.";
    }

    @Override
    public String getGameQuestion() {
        this.randomNumber = new RandomNumberGenerator().getRandomNumber();

        return "Question: " + randomNumber + "\n";
    }

    @Override
    public int getWinConditionCounterLimit() {
        return WIN_CONDITION_COUNTER_LIMIT;
    }

    @Override
    public boolean userAnswerIsCorrect(String userAnswer) {
        return Objects.equals(userAnswer, randomNumber % 2 == 0 ? "yes" : "no");
    }
}
