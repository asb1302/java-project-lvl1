package hexlet.code;

import hexlet.code.games.ProgressionGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GCDGame;
import hexlet.code.games.CalcGame;
import hexlet.code.games.PrimeGame;
import hexlet.code.games.GameInterface;

import java.util.Scanner;

import static java.nio.charset.StandardCharsets.UTF_8;

public class App {
    public static final String GREET_GAME_NUM = "1";
    public static final String EVEN_GAME_NUM = "2";
    public static final String CALC_GAME_NUM = "3";
    public static final String GCD_GAME_NUM = "4";
    public static final String PROGRESSION_GAME_NUM = "5";
    public static final String PRIME_GAME_NUM = "6";
    public static final String EXIT_NUM = "0";

    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println(GREET_GAME_NUM  + " - Greet");
        System.out.println(EVEN_GAME_NUM + " - Even");
        System.out.println(CALC_GAME_NUM + " - Calc");
        System.out.println(GCD_GAME_NUM + " - GDC");
        System.out.println(PROGRESSION_GAME_NUM + " - Progression");
        System.out.println(PRIME_GAME_NUM + " - Prime");
        System.out.println(EXIT_NUM + " - Exit");
        System.out.print("Your choice: ");

        Scanner scanner = new Scanner(System.in, UTF_8.name());

        String input = scanner.nextLine();

        try {
            switch (input) {
                case GREET_GAME_NUM -> {
                    Cli.welcome();
                    String userName = Cli.getUserName();
                    Cli.greet(userName);
                }
                case EVEN_GAME_NUM -> {
                    GameInterface game = new EvenGame();

                    game.play();
                }
                case CALC_GAME_NUM -> {
                    GameInterface game = new CalcGame();

                    game.play();
                }

                case GCD_GAME_NUM -> {
                    GameInterface game = new GCDGame();

                    game.play();
                }

                case PROGRESSION_GAME_NUM -> {
                    GameInterface game = new ProgressionGame();

                    game.play();
                }
                case PRIME_GAME_NUM -> {
                    GameInterface game = new PrimeGame();

                    game.play();
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
