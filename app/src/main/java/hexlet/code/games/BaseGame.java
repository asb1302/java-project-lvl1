package hexlet.code.games;

import java.util.Scanner;

public abstract class BaseGame {
    public static final int MAX_RANDOM_NUMBER = 10;

    public static final int WIN_CONDITIONS_COUNTER_LIMIT = 3;

    private String userName;

    private int correctAnswerCounter;
    private final Scanner scanner;

    BaseGame() {
        this.scanner = new Scanner(System.in);
        this.correctAnswerCounter = 0;
        this.userName = "Dear friend";
    }

    public final Scanner getScanner() {
        return this.scanner;
    }

    /**
     * Displays a welcome message.
     */
    protected void greet() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");

        this.userName = this.getScanner().nextLine();

        System.out.println("Hello, " + this.getUserName() + "!");
    }

    /**
     * Displays farewell message.
     */
    protected void sayGoodbye() {
        if (this.correctAnswerCounter >= this.getWinConditionCounterLimit()) {
            System.out.println("Congratulations, " + this.getUserName() + "!");
        } else {
            System.out.println("Sorry, " + this.getUserName() + ", you lost ;(");
        }
    }

    /**
     * Returns the largest possible random number.
     *
     * @return max random number
     */
    protected int getMaxRandomNumber() {
        return MAX_RANDOM_NUMBER;
    }

    /**
     * Returns the number of attempts required to win.
     *
     * @return win condition counter limit
     */
    protected int getWinConditionCounterLimit() {
        return WIN_CONDITIONS_COUNTER_LIMIT;
    }

    /**
     * Returns the username.
     *
     * @return username
     */
    protected String getUserName() {
        return this.userName;
    }

    /**
     * Returns the number of valid attempts.
     *
     * @return corrected answer counter
     */
    protected int getCorrectAnswerCounter() {
        return this.correctAnswerCounter;
    }

    /**
     * Increase the number of valid attempts.
     */
    protected void increaseCorrectedAnswersCounter() {
        this.correctAnswerCounter++;
    }
}
