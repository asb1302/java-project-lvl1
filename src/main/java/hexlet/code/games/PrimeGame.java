package hexlet.code.games;

import hexlet.code.domain.GameInfo;
import hexlet.code.services.RandomNumberGenerator;

public final class PrimeGame extends BaseGame implements GameInterface {
    @Override
    public void play() {
        for (int i = 0; i < BASIC_GAME_COUNT; i++) {
            Integer randomNumber = new RandomNumberGenerator().getRandomNumber();

            this.getGamesList().add(
                    new GameInfo(
                            this.getPreview(),
                            this.getQuestion(randomNumber.toString()),
                            this.checkNumberIsPrime(randomNumber) ? "yes" : "no"
                    )
            );
        }

        this.getEngine().execute(this.getGamesList());
    }

    @Override
    public String getPreview() {
        return "Answer 'yes' if number prime otherwise answer 'no'.";
    }

    @Override
    public String getQuestion(String param) {
        return "Question: " + param + "\n";
    }

    private boolean checkNumberIsPrime(int number) {
        if (number == 1) {
            return false;
        }

        boolean check = true;

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                check = false;

                break;
            }
        }

        return check;
    }
}
