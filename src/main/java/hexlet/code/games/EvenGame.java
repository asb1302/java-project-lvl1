package hexlet.code.games;

import hexlet.code.DTO.GameInfo;
import hexlet.code.DTO.GameRule;
import hexlet.code.services.RandomNumberGenerator;

import java.util.Objects;

public final class EvenGame extends BaseGame implements GameInterface {
    @Override
    public void play() {
        for (int i = 0; i < BASIC_GAME_COUNT; i++) {
            GameInfo gameInfoDTO = new GameInfo();
            gameInfoDTO.setPreview(this.getPreview());

            String questionParam = new RandomNumberGenerator().getRandomNumber().toString();
            gameInfoDTO.setQuestion(this.getQuestion(questionParam));

            String correctAnswer = Integer.parseInt(questionParam) % 2 == 0 ? "yes" : "no";

            gameInfoDTO.setAnswer(correctAnswer);
            gameInfoDTO.setRule(this.getRule());

            this.getGamesList().add(gameInfoDTO);
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

    @Override
    protected GameRule getRule() {
        return Objects::equals;
    }
}
