package hexlet.code.games;

public interface GameInterface {
    int WIN_CONDITION_COUNTER_LIMIT = 3;

    String getPreviewQuestion();

    String getGameQuestion();

    int getWinConditionCounterLimit();

    boolean userAnswerIsCorrect(String userAnswer);
}
