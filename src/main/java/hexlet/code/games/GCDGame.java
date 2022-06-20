package hexlet.code.games;

import hexlet.code.domain.GameInfo;
import hexlet.code.domain.GameRule;
import hexlet.code.services.RandomNumberGenerator;
import java.util.Objects;

public final class GCDGame extends BaseGame implements GameInterface {
    @Override
    public void play() {
        for (int i = 0; i < BASIC_GAME_COUNT; i++) {
            int firstRandomNumber = new RandomNumberGenerator().getRandomNumber();
            int secondRandomNumber = new RandomNumberGenerator().getRandomNumber();

            String questionParam = firstRandomNumber + " " + secondRandomNumber;

            int correctAnswer = gcdByEuclidsAlgorithm(firstRandomNumber, secondRandomNumber);

            this.getGamesList().add(
                    new GameInfo(
                            this.getPreview(),
                            this.getQuestion(questionParam),
                            Integer.toString(correctAnswer),
                            this.getRule()
                    )
            );
        }

        this.getEngine().execute(this.getGamesList());
    }

    @Override
    public String getPreview() {
        return "Find the greatest common divisor of given numbers.";
    }

    @Override
    public String getQuestion(String param) {
        return "Question: " + param + " " + "\n";
    }

    @Override
    protected GameRule getRule() {
        return Objects::equals;
    }

    private static int gcdByEuclidsAlgorithm(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }

        return gcdByEuclidsAlgorithm(n2, n1 % n2);
    }
}
