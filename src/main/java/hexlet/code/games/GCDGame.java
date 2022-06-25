package hexlet.code.games;

import hexlet.code.domain.Game;
import hexlet.code.services.RandomNumberGenerator;

public final class GCDGame extends BaseGame implements GameInterface {
    @Override
    public void play() {
        for (int i = 0; i < BASIC_GAME_COUNT; i++) {
            int firstRandomNumber = new RandomNumberGenerator().getRandomNumber();
            int secondRandomNumber = new RandomNumberGenerator().getRandomNumber();

            String questionParam = firstRandomNumber + " " + secondRandomNumber;

            int correctAnswer = gcdByEuclidsAlgorithm(firstRandomNumber, secondRandomNumber);

            this.getGamesData().add(
                    new Game(
                            this.getQuestion(questionParam),
                            Integer.toString(correctAnswer)
                    )
            );
        }

        this.getEngine().execute(this.getGamesData(), this.getRule());
    }

    @Override
    public String getRule() {
        return "Find the greatest common divisor of given numbers.";
    }

    @Override
    public String getQuestion(String param) {
        return "Question: " + param + " " + "\n";
    }

    private static int gcdByEuclidsAlgorithm(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }

        return gcdByEuclidsAlgorithm(n2, n1 % n2);
    }
}
