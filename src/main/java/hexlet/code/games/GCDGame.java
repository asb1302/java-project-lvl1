package hexlet.code.games;

import hexlet.code.services.RandomNumberGenerator;

public final class GCDGame implements GameInterface {

    private int firstRandomNumber;
    private int secondRandomNumber;

    @Override
    public String getPreviewQuestion() {
        return "Find the greatest common divisor of given numbers.";
    }

    @Override
    public String getGameQuestion() {
        this.firstRandomNumber = new RandomNumberGenerator().getRandomNumber();
        this.secondRandomNumber = new RandomNumberGenerator().getRandomNumber();

        return "Question: " + firstRandomNumber + " " + secondRandomNumber + "\n";
    }

    @Override
    public int getWinConditionCounterLimit() {
        return WIN_CONDITION_COUNTER_LIMIT;
    }

    @Override
    public boolean userAnswerIsCorrect(String userAnswer) {
        int correctAnswer = GCDGame.gcdByEuclidsAlgorithm(this.firstRandomNumber, this.secondRandomNumber);

        return correctAnswer == Integer.parseInt(userAnswer);
    }

    private static int gcdByEuclidsAlgorithm(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }

        return gcdByEuclidsAlgorithm(n2, n1 % n2);
    }
}
