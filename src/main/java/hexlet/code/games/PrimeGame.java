package hexlet.code.games;

import hexlet.code.domain.Game;
import hexlet.code.services.RandomNumberGenerator;

public final class PrimeGame extends BaseGame implements GameInterface {
    public PrimeGame() {
        super("Answer 'yes' if number prime otherwise answer 'no'.");
    }
    @Override
    public void play() {
        for (int i = 0; i < BASIC_GAME_COUNT; i++) {
            Integer randomNumber = new RandomNumberGenerator().getRandomNumber(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);

            this.addGame(
                    new Game(
                            randomNumber.toString(),
                            this.checkNumberIsPrime(randomNumber) ? "yes" : "no"
                    )
            );
        }

        this.execute();
    }

    private boolean checkNumberIsPrime(int number) {
        if (number == 1) {
            return false;
        }

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
