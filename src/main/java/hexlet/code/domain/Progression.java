package hexlet.code.domain;

public final class Progression {
    private final String progression;

    private final Integer missedNumber;

    public Progression(String progressionStr, Integer missedNumberInt) {
        this.progression = progressionStr;
        this.missedNumber = missedNumberInt;
    }

    public String getProgression() {
        return progression;
    }

    public Integer getMissedNumber() {
        return missedNumber;
    }
}
