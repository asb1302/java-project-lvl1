package hexlet.code;

import hexlet.code.games.CalcGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GameInterface;
import hexlet.code.games.GreetGame;

import java.util.Scanner;

public class Engine {
    private final GameInterface greetGame;
    private final GameInterface calcGame;
    private final GameInterface evenGame;

    public static final int GREET_GAME_NUM = 1;
    public static final int EVEN_GAME_NUM = 2;
    public static final int CALC_GAME_NUM = 3;
    public static final int EXIT_NUM = 0;

    public Engine() {
        this.greetGame = new GreetGame();
        this.calcGame = new CalcGame();
        this.evenGame = new EvenGame();
    }

    public final void execute() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println(GREET_GAME_NUM  + " - Greet");
        System.out.println(EVEN_GAME_NUM + " - Even");
        System.out.println(CALC_GAME_NUM + " - Calc");
        System.out.println(EXIT_NUM + " - Exit");
        System.out.print("Your choice: ");

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        try {
            int choice = Integer.parseInt(input);

            switch (choice) {
                case GREET_GAME_NUM -> {
                    this.greetGame.play();
                }
                case EVEN_GAME_NUM -> {
                    this.evenGame.play();
                }
                case CALC_GAME_NUM -> {
                    this.calcGame.play();
                }
                case EXIT_NUM -> {
                    System.out.println("Bye!");
                }
                default -> {
                    System.out.println("Incorrect input!");
                }
            }
        } catch (NumberFormatException ex) {
            System.out.println("Incorrect input!");
        }
    }
}
