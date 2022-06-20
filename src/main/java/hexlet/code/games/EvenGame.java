package hexlet.code.games;

import hexlet.code.domain.GameInfo;
import hexlet.code.services.RandomNumberGenerator;

public final class EvenGame extends BaseGame implements GameInterface {
    @Override
    public void play() {
        for (int i = 0; i < BASIC_GAME_COUNT; i++) {
            String questionParam = new RandomNumberGenerator().getRandomNumber().toString();

            this.getGamesList().add(
                    new GameInfo(
                            this.getPreview(),
                            this.getQuestion(questionParam),
                            Integer.parseInt(questionParam) % 2 == 0 ? "yes" : "no"
                    )
            );
        }

        this.getEngine().execute(this.getGamesList());
    }

    @Override
    protected String getPreview() {
        return "Answer 'yes' if number even otherwise answer 'no'.";
    }
    @Override
    protected String getQuestion(String param) {
        return "Question: " + param + "\n";
    }
}
