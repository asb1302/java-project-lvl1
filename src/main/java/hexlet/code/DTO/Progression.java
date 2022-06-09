package hexlet.code.DTO;

public final class Progression {
    private String progression;

    private Integer missedNumber;

    public String getProgression() {
        return progression;
    }

    public void setProgression(String progressionStr) {
        this.progression = progressionStr;
    }

    public Integer getMissedNumber() {
        return missedNumber;
    }

    public void setMissedNumber(Integer missedNumberInt) {
        this.missedNumber = missedNumberInt;
    }
}
