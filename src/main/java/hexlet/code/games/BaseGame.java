package hexlet.code.games;

import hexlet.code.DTO.GameInfoDTO;
import hexlet.code.DTO.GameRule;
import hexlet.code.Engine;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseGame {
    protected static final int BASIC_GAME_COUNT = 3;
    private final Engine engine;

    private final List<GameInfoDTO> gamesList;

    public BaseGame() {
        this.engine = new Engine();
        this.gamesList = new ArrayList<>();
    }

    abstract String getPreview();
    abstract String getQuestion(String param);
    abstract GameRule getRule();

    /**
     * Gel game engine.
     *
     * @return engine
     */
    protected Engine getEngine() {
        return engine;
    }

    /**
     *
     * Gel list of games.
     *
     * @return game list
     */
    protected List<GameInfoDTO> getGamesList() {
        return gamesList;
    }
}
