package hexlet.code.games;

public final class GreetGame implements GameInterface {
    @Override
    public String getPreview() {
        return null;
    }

    @Override
    public String getQuestion() {
        return null;
    }

    @Override
    public int getWinConditionCounterLimit() {
        return 0;
    }

    @Override
    public boolean userAnswerIsCorrect(String userAnswer) {
        return false;
    }
}
