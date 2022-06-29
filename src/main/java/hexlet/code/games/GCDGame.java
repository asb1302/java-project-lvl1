package hexlet.code.games;

import hexlet.code.domain.Game;
import hexlet.code.services.RandomNumberGenerator;

public final class GCDGame extends BaseGame implements GameInterface {
    public GCDGame() {
        super("Find the greatest common divisor of given numbers.");
    }
    @Override
    public void play() {
        for (int i = 0; i < BASIC_GAME_COUNT; i++) {
            int firstRandomNumber = new RandomNumberGenerator().getRandomNumber(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            int secondRandomNumber = new RandomNumberGenerator().getRandomNumber(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);

            String question = firstRandomNumber + " " + secondRandomNumber;

            int correctAnswer = gcdByEuclidsAlgorithm(firstRandomNumber, secondRandomNumber);

            this.addGame(
                    new Game(
                            question,
                            Integer.toString(correctAnswer)
                    )
            );
        }

        this.execute();
    }

    private static int gcdByEuclidsAlgorithm(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }

        return gcdByEuclidsAlgorithm(n2, n1 % n2);
    }
}
