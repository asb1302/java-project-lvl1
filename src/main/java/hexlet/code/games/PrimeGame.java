package hexlet.code.games;

import hexlet.code.DTO.GameInfoDTO;
import hexlet.code.DTO.GameRule;
import hexlet.code.services.RandomNumberGenerator;

import java.util.Objects;

public final class PrimeGame extends BaseGame implements GameInterface {
    @Override
    public void play() {
        for (int i = 0; i < this.BASIC_GAME_COUNT; i++) {
            GameInfoDTO gameInfoDTO = new GameInfoDTO();
            gameInfoDTO.setPreview(this.getPreview());

            Integer randomNumber = new RandomNumberGenerator().getRandomNumber();
            gameInfoDTO.setQuestion(this.getQuestion(randomNumber.toString()));

            String correctAnswer = this.checkNumberIsPrime(randomNumber) ? "yes" : "no";

            gameInfoDTO.setAnswer(correctAnswer);
            gameInfoDTO.setRule(this.getRule());

            this.getGamesList().add(gameInfoDTO);
        }

        this.getEngine().execute(this.getGamesList());
    }

    @Override
    public String getPreview() {
        return "Answer 'yes' if number prime otherwise answer 'no'.";
    }

    @Override
    public String getQuestion(String param) {
        return "Question: " + param + "\n";
    }
    @Override
    protected GameRule getRule() {
        return Objects::equals;
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
