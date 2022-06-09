package hexlet.code.games;

import hexlet.code.DTO.GameInfo;
import hexlet.code.DTO.GameRule;

public final class GreetGame extends BaseGame implements GameInterface {
    @Override
    public void play() {
        GameInfo gameInfoDTO = new GameInfo();
        this.getGamesList().add(gameInfoDTO);

        this.getEngine().execute(this.getGamesList());
    }

    @Override
    protected String getPreview() {
        return null;
    }
    @Override
    protected String getQuestion(String param) {
        return null;
    }

    @Override
    protected GameRule getRule() {
        return null;
    }
}
