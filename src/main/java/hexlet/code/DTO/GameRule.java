package hexlet.code.DTO;

public interface GameRule {
    boolean isWon(String userAnswer, String correctAnswer);
}
