package hexlet.code.games;

public final class GreetGame extends BaseGame implements GameInterface {
    @Override
    public void play() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String name = this.getScanner().nextLine();
        System.out.println("Hello, " + name + "!");
    }
}
