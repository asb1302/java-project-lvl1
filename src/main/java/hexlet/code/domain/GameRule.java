package hexlet.code.domain;

@FunctionalInterface
public interface GameRule {
    boolean isWon(String userAnswer, String correctAnswer);
}
