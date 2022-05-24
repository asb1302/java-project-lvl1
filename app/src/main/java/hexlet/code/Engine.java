package hexlet.code;

import hexlet.code.games.ProgressionGame;
import hexlet.code.games.GreetGame;
import hexlet.code.games.GameInterface;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GCDGame;
import hexlet.code.games.CalcGame;
import hexlet.code.games.PrimeGame;

import java.util.Scanner;

public class Engine {
    private final GameInterface greetGame;
    private final GameInterface calcGame;
    private final GameInterface evenGame;
    private final GameInterface gcdGame;
    private final GameInterface progressionGame;
    private final GameInterface primeGame;

    public static final int GREET_GAME_NUM = 1;
    public static final int EVEN_GAME_NUM = 2;
    public static final int CALC_GAME_NUM = 3;

    public static final int GCD_GAME_NUM = 4;
    public static final int PROGRESSION_GAME_NUM = 5;
    public static final int PRIME_GAME_NUM = 6;
    public static final int EXIT_NUM = 0;

    public Engine() {
        this.greetGame = new GreetGame();
        this.calcGame = new CalcGame();
        this.evenGame = new EvenGame();
        this.gcdGame = new GCDGame();
        this.progressionGame = new ProgressionGame();
        this.primeGame = new PrimeGame();
    }

    public final void execute() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println(GREET_GAME_NUM  + " - Greet");
        System.out.println(EVEN_GAME_NUM + " - Even");
        System.out.println(CALC_GAME_NUM + " - Calc");
        System.out.println(GCD_GAME_NUM + " - GDC");
        System.out.println(PROGRESSION_GAME_NUM + " - Progression");
        System.out.println(PRIME_GAME_NUM + " - Prime");
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
                case GCD_GAME_NUM -> {
                    this.gcdGame.play();
                }
                case PROGRESSION_GAME_NUM -> {
                    this.progressionGame.play();
                }
                case PRIME_GAME_NUM -> {
                    this.primeGame.play();
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
