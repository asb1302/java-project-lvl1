package hexlet.code;

import hexlet.code.domain.Game;

import java.util.Objects;
import java.util.Scanner;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public final class Engine implements GameEngineInterface {

    @Override
    public void execute(List<Game> gamesData, String rule) {
        Cli.welcome();
        String userName = Cli.getUserName();
        Cli.greet(userName);

        System.out.println(rule);

        for (Game game : gamesData) {
            System.out.println("Question: " + game.getQuestion());
            System.out.print("Answer: ");
            String userAnswer =  new Scanner(System.in, UTF_8.name()).nextLine();

            if (Objects.equals(userAnswer, game.getAnswer())) {
                System.out.println("Correct!");
            } else {
                Cli.sayGoodbye(userName, false);

                return;
            }
        }

        Cli.sayGoodbye(userName, true);
    }
}
