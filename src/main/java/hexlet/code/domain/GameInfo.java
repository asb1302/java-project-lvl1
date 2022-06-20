package hexlet.code.domain;

public final class GameInfo {
    private final String preview;

    private final String question;

    private final String answer;

    public GameInfo(
            String previewStr,
            String questionStr,
            String answerStr
    ) {
        this.preview = previewStr;
        this.question = questionStr;
        this.answer = answerStr;
    }

    public String getPreview() {
        return preview;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
