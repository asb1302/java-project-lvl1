package hexlet.code.games;

import java.util.Scanner;

public abstract class BaseGame {
    private final Scanner scanner;

    BaseGame() {
        this.scanner = new Scanner(System.in);
    }

    public final Scanner getScanner() {
        return this.scanner;
    }
}
