package hexlet.code;

import hexlet.code.domain.GameInfo;

import java.util.Objects;
import java.util.Scanner;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public final class Engine implements GameEngineInterface {

    public void execute(List<GameInfo> gameInfoList) {
        String username = this.greet();

        boolean showGoodbye = false;
        for (GameInfo gameInfo : gameInfoList) {
            String preview = gameInfo.getPreview();

            if (null == preview) {
                continue;
            }

            System.out.println(preview);

            System.out.print(gameInfo.getQuestion());
            String userAnswer =  new Scanner(System.in, UTF_8.name()).nextLine();

            if (Objects.equals(userAnswer, gameInfo.getAnswer())) {
                System.out.println("Correct!");
            } else {
                this.sayGoodbye(username, false);

                return;
            }

            showGoodbye = true;
        }

        if (showGoodbye) {
            this.sayGoodbye(username, true);
        }
    }

    private String greet() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");

        Scanner scanner = new Scanner(System.in, UTF_8.name());

        String userName = scanner.nextLine();

        System.out.println("Hello, " + userName + "!");

        return userName;
    }

    private void sayGoodbye(String userName, boolean isWon) {
        if (isWon) {
            System.out.println("Congratulations, " + userName + "!");
        } else {
            System.out.println("Let's try again, " + userName + "!");
        }
    }
}
