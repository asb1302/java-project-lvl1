package hexlet.code.games;

import hexlet.code.domain.Game;
import hexlet.code.services.RandomNumberGenerator;

public final class ProgressionGame extends BaseGame implements GameInterface {
    private static final int MIN_PROGRESSION_SIZE = 5;
    private static final int MAX_PROGRESSION_SIZE = 10;

    @Override
    public void play() {
        for (int i = 0; i < BASIC_GAME_COUNT; i++) {
            int size = new RandomNumberGenerator()
                    .getRandomNumber(MIN_PROGRESSION_SIZE, MAX_PROGRESSION_SIZE);
            int randomMissedPosition = new RandomNumberGenerator()
                    .getRandomNumber(0, size);
            int step = new RandomNumberGenerator().getRandomNumber(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            int number = new RandomNumberGenerator().getRandomNumber(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);

            this.getGamesData().add(
                    new Game(
                            this.createProgression(size, step, number, randomMissedPosition),
                            this.calculateMissedNumber(step, randomMissedPosition, number)
                    )
            );
        }

        this.getEngine().execute(this.getGamesData(), this.getRule());
    }

    @Override
    public String getRule() {
        return "What number is missing in this progression?";
    }

    private String createProgression(int size, int step, int number, int randomMissedPosition) {
        StringBuilder progressionStr = new StringBuilder();

        for (int i = 0; i < size; i++) {
            if (i == randomMissedPosition) {
                progressionStr.append(".." + " ");
            } else {
                progressionStr.append(number).append(" ");
            }

            number += step;
        }

        return progressionStr.toString();
    }

    private String calculateMissedNumber(int step, int randomMissedPosition, int number) {
        return Integer.toString(number + (step * randomMissedPosition));
    }
}
