package hexlet.code.domain;

public final class GameInfo {
    private final String preview;

    private final String question;

    private final String answer;

    private final GameRule rule;

    public GameInfo(
            String previewStr,
            String questionStr,
            String answerStr,
            GameRule gameRule
    ) {
        this.preview = previewStr;
        this.question = questionStr;
        this.answer = answerStr;
        this.rule = gameRule;
    }

    public String getPreview() {
        return preview;
    }

    public GameRule getRule() {
        return rule;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
