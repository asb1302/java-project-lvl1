package hexlet.code.games;

import hexlet.code.domain.Game;
import hexlet.code.domain.Progression;
import hexlet.code.services.RandomNumberGenerator;

public final class ProgressionGame extends BaseGame implements GameInterface {
    private static final int MIN_PROGRESSION_SIZE = 5;
    private static final int MAX_PROGRESSION_SIZE = 10;

    @Override
    public void play() {
        for (int i = 0; i < BASIC_GAME_COUNT; i++) {
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

            this.getGamesData().add(
                    new Game(
                            progression.getProgression(),
                            progression.getMissedNumber().toString()
                    )
            );
        }

        this.getEngine().execute(this.getGamesData(), this.getRule());
    }

    @Override
    public String getRule() {
        return "What number is missing in this progression?";
    }

    private Progression printProgression(int size, int step, int number, int randomMissedPosition) {
        StringBuilder progressionStr = new StringBuilder();

        int missedNumber = 0;

        for (int i = 0; i < size; i++) {
            if (i == randomMissedPosition) {
                progressionStr.append(".." + " ");
                missedNumber = number;
            } else {
                progressionStr.append(number).append(" ");
            }

            number += step;
        }

        return new Progression(progressionStr.toString(), missedNumber);
    }
}
