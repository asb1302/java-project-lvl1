package hexlet.code.games;

import hexlet.code.domain.Game;
import hexlet.code.services.RandomNumberGenerator;

public final class EvenGame extends BaseGame implements GameInterface {
    public EvenGame() {
        super("Answer 'yes' if number even otherwise answer 'no'.");
    }

    @Override
    public void play() {
        for (int i = 0; i < BASIC_GAME_COUNT; i++) {
            String question = new RandomNumberGenerator()
                    .getRandomNumber(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER).toString();

            this.addGame(
                    new Game(
                            question,
                            Integer.parseInt(question) % 2 == 0 ? "yes" : "no"
                    )
            );
        }

        this.execute();
    }
}
