package hexlet.code;

import hexlet.code.games.GameInterface;

import java.util.Scanner;

import static java.nio.charset.StandardCharsets.UTF_8;

public final class Engine implements GameEngineInterface {
    @Override
    public void play(GameInterface game) {
        String username = this.greet();

        String previewQuestion = game.getPreviewQuestion();

        if (null == previewQuestion) {
            return;
        }

        System.out.println(previewQuestion);

        int correctAnswers = 0;
        while (correctAnswers < game.getWinConditionCounterLimit()) {
            System.out.print(game.getGameQuestion());
            String userAnswer = this.getScanner().nextLine();

            if (game.userAnswerIsCorrect(userAnswer)) {
                System.out.println("Correct!");

                correctAnswers++;
            } else {
                this.sayGoodbye(username, false);

                return;
            }
        }

        this.sayGoodbye(username, true);
    }

    private Scanner getScanner() {
        return new Scanner(System.in, UTF_8.name());
    }

    private String greet() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");

        Scanner scanner = new Scanner(System.in, UTF_8.name());

        String userName = scanner.nextLine();

        System.out.println("Hello, " + userName + "!");

        return userName;
    }

    private void sayGoodbye(String userName, boolean gameIsWon) {
        if (gameIsWon) {
            System.out.println("Congratulations, " + userName + "!");
        } else {
            System.out.println("Let's try again, " + userName + "!");
        }
    }
}
