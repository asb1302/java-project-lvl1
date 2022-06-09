package hexlet.code.DTO;

public final class GameInfo {
    private String preview;

    private String question;

    private String answer;

    private GameRule rule;

    public String getPreview() {
        return preview;
    }

    public void setPreview(String previewStr) {
        this.preview = previewStr;
    }

    public GameRule getRule() {
        return rule;
    }

    public void setRule(GameRule gameRule) {
        this.rule = gameRule;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String questionStr) {
        this.question = questionStr;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answerStr) {
        this.answer = answerStr;
    }
}
