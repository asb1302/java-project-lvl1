package hexlet.code.games;

import hexlet.code.domain.Game;
import hexlet.code.services.RandomNumberGenerator;

public final class EvenGame extends BaseGame implements GameInterface {
    @Override
    public void play() {
        for (int i = 0; i < BASIC_GAME_COUNT; i++) {
            String question = new RandomNumberGenerator().getRandomNumber().toString();

            this.getGamesData().add(
                    new Game(
                            question,
                            Integer.parseInt(question) % 2 == 0 ? "yes" : "no"
                    )
            );
        }

        this.getEngine().execute(this.getGamesData(), this.getRule());
    }

    @Override
    protected String getRule() {
        return "Answer 'yes' if number even otherwise answer 'no'.";
    }
}
