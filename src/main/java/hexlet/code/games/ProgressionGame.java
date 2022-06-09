package hexlet.code.games;

import hexlet.code.DTO.GameInfoDTO;
import hexlet.code.DTO.GameRule;
import hexlet.code.DTO.Progression;
import hexlet.code.services.RandomNumberGenerator;

import java.util.Objects;

public final class ProgressionGame extends BaseGame implements GameInterface {
    private static final int MIN_PROGRESSION_SIZE = 5;
    private static final int MAX_PROGRESSION_SIZE = 10;

    @Override
    public void play() {
        for (int i = 0; i < this.BASIC_GAME_COUNT; i++) {
            GameInfoDTO gameInfoDTO = new GameInfoDTO();
            gameInfoDTO.setPreview(this.getPreview());

            int size = new RandomNumberGenerator()
                    .setMinRandomNumber(MIN_PROGRESSION_SIZE)
                    .setMaxRandomNumber(MAX_PROGRESSION_SIZE)
                    .getRandomNumber();
            int randomMissedPosition = new RandomNumberGenerator()
                    .setMinRandomNumber(0)
                    .setMaxRandomNumber(size)
                    .getRandomNumber();
            int step = new RandomNumberGenerator().getRandomNumber();
            int number = new RandomNumberGenerator().getRandomNumber();

            Progression progression = this.printProgression(size, step, number, randomMissedPosition);
            gameInfoDTO.setQuestion(this.getQuestion(progression.getProgression()));

            gameInfoDTO.setAnswer(progression.getMissedNumber().toString());

            gameInfoDTO.setRule(this.getRule());

            this.getGamesList().add(gameInfoDTO);
        }

        this.getEngine().execute(this.getGamesList());
    }

    @Override
    public String getPreview() {
        return "What number is missing in this progression?";
    }

    @Override
    public String getQuestion(String param) {
        return "Question: " + param + "\n" + "Your answer: ";
    }

    @Override
    protected GameRule getRule() {
        return Objects::equals;
    }

    private Progression printProgression(int size, int step, int number, int randomMissedPosition) {
        StringBuilder progressionStr = new StringBuilder();

        Progression progression = new Progression();

        for (int i = 0; i < size; i++) {
            if (i == randomMissedPosition) {
                progressionStr.append(".." + " ");
                progression.setMissedNumber(number);
            } else {
                progressionStr.append(number).append(" ");
            }

            number += step;
        }

        progression.setProgression(progressionStr.toString());

        return progression;
    }
}
