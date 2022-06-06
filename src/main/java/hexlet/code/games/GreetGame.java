package hexlet.code.games;

public final class GreetGame implements GameInterface {
    @Override
    public String getPreviewQuestion() {
        return null;
    }

    @Override
    public String getGameQuestion() {
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
