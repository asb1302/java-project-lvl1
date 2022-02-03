package hexlet.code.games;

public interface GameInterface {
    int MAX_RANDOM_NUMBER = 10;
    int WIN_CONDITION_COUNTER_LIMIT = 3;

    String LOST_MSG = "You lost!";
    String WIN_MSG = "You won!";

    void play();
}
