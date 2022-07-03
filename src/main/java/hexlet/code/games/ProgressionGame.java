package hexlet.code.games;

import hexlet.code.domain.Game;
import hexlet.code.services.RandomNumberGenerator;

public final class ProgressionGame extends BaseGame implements GameInterface {
    public ProgressionGame() {
        super("What number is missing in this progression?");
    }
    private static final int MIN_PROGRESSION_SIZE = 5;
    private static final int MAX_PROGRESSION_SIZE = 10;

    @Override
    public void play() {
        for (int i = 0; i < BASIC_GAME_COUNT; i++) {
            int size = new RandomNumberGenerator()
                    .getRandomNumber(MIN_PROGRESSION_SIZE, MAX_PROGRESSION_SIZE);
            int randomMissedPosition = new RandomNumberGenerator()
                    .getRandomNumber(0, size);

            int[] progressionArray = this.createProgressionArray(size);

            this.addGame(
                    new Game(
                            this.createProgressionStr(progressionArray, randomMissedPosition),
                            Integer.toString(progressionArray[randomMissedPosition])
                    )
            );
        }

        this.execute();
    }

    private int[] createProgressionArray(int size) {
        int step = new RandomNumberGenerator().getRandomNumber(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
        int number = new RandomNumberGenerator().getRandomNumber(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);

        int[] progressionArray = new int[size];

        for (int i = 0; i < size; i++) {
            progressionArray[i] = number;

            number += step;
        }

        return progressionArray;
    }

    private String createProgressionStr(int[] progressionArray, int randomMissedPosition) {
        StringBuilder progressionStr = new StringBuilder();

        for (int i = 0; i < progressionArray.length; i++) {
            if (i == randomMissedPosition) {
                progressionStr.append(".." + " ");
            } else {
                progressionStr.append(progressionArray[i]).append(" ");
            }
        }

        return progressionStr.toString();
    }
}
