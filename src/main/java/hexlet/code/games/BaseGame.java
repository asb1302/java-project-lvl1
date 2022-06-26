package hexlet.code.games;

import hexlet.code.domain.Game;
import hexlet.code.Engine;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseGame {
    protected static final int BASIC_GAME_COUNT = 3;
    private final Engine engine;

    private final List<Game> gamesData;

    public BaseGame() {
        this.engine = new Engine();
        this.gamesData = new ArrayList<>();
    }

    abstract String getRule();

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
    protected List<Game> getGamesData() {
        return gamesData;
    }
}
