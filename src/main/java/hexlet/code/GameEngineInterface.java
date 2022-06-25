package hexlet.code;

import hexlet.code.domain.Game;

import java.util.List;

public interface GameEngineInterface {
    void execute(List<Game> gameInfoList, String rule);
}
