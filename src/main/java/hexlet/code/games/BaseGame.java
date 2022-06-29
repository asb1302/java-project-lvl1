package hexlet.code.games;

import hexlet.code.domain.Game;
import hexlet.code.Engine;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseGame {
    protected static final int BASIC_GAME_COUNT = 3;
    private final Engine engine;
    private final List<Game> gamesData;
    private final String gameRule;

    public BaseGame(String rule) {
        this.gameRule = rule;
        this.engine = new Engine();
        this.gamesData = new ArrayList<>();
    }

    /**
     * Add game to data games list.
     *
     * @param game game domain object
     */
    protected void addGame(Game game) {
        this.gamesData.add(game);
    }

    /**
     * Execute game engine.
     */
    protected void execute() {
        engine.execute(this.gamesData, this.gameRule);
    }
}
