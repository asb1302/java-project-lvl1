package hexlet.code.games;

import hexlet.code.services.RandomNumberGenerator;

public final class ProgressionGame implements GameInterface {
    private static final int MIN_PROGRESSION_SIZE = 5;
    private static final int MAX_PROGRESSION_SIZE = 10;
    private int missedNumber;

    @Override
    public String getPreview() {
        return "What number is missing in this progression?";
    }

    @Override
    public String getQuestion() {
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

        return "Question: " + this.printProgression(size, step, number, randomMissedPosition) + "\n" + "Your answer: ";
    }

    @Override
    public int getWinConditionCounterLimit() {
        return WIN_CONDITION_COUNTER_LIMIT;
    }

    @Override
    public boolean userAnswerIsCorrect(String userAnswer) {
        return this.missedNumber == Integer.parseInt(userAnswer);
    }

    private String printProgression(int size, int step, int number, int randomMissedPosition) {
        StringBuilder progressionStr = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (i == randomMissedPosition) {
                progressionStr.append(".." + " ");
                this.missedNumber = number;
            } else {
                progressionStr.append(number).append(" ");
            }

            number += step;
        }

        return progressionStr.toString();
    }
}
