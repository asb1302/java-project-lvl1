package hexlet.code;

import hexlet.code.domain.Game;

import java.util.Objects;
import java.util.Scanner;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public final class Engine implements GameEngineInterface {

    @Override
    public void execute(List<Game> gamesData, String rule) {
        this.welcome();
        String userName = this.getUserName();
        this.greet(userName);

        System.out.println(rule);

        for (Game game : gamesData) {
            System.out.println("Question: " + game.getQuestion());
            System.out.print("Answer: ");
            String userAnswer =  new Scanner(System.in, UTF_8.name()).nextLine();

            if (Objects.equals(userAnswer, game.getAnswer())) {
                System.out.println("Correct!");
            } else {
                this.sayGoodbye(userName, false);

                return;
            }
        }

        this.sayGoodbye(userName, true);
    }

    private void welcome() {
        System.out.println("Welcome to the Brain Games!");
    }

    private String getUserName() {
        System.out.print("May I have your name? ");

        Scanner scanner = new Scanner(System.in, UTF_8.name());

        return scanner.nextLine();
    }

    private void greet(String userName) {
        System.out.println("Hello, " + userName + "!");
    }

    private void sayGoodbye(String userName, boolean isWon) {
        if (isWon) {
            System.out.println("Congratulations, " + userName + "!");
        } else {
            System.out.println("Let's try again, " + userName + "!");
        }
    }
}
