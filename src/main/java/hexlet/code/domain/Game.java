package hexlet.code.domain;

public final class Game {
    private final String question;

    private final String answer;

    public Game(
            String questionStr,
            String answerStr
    ) {
        this.question = questionStr;
        this.answer = answerStr;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
