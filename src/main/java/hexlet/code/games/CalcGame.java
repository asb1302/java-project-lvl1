package hexlet.code.games;

import hexlet.code.domain.Game;
import hexlet.code.services.RandomNumberGenerator;

public final class CalcGame extends BaseGame implements GameInterface {
    public static final String MULTIPLICATION_OPERATOR = "*";
    public static final String SUBTRACTION_OPERATOR = "-";
    public static final String ADDITION_OPERATOR = "+";

    public CalcGame() {
        super("What is the result of the expression?");
    }

    @Override
    public void play() {
        String[] operators = {ADDITION_OPERATOR, SUBTRACTION_OPERATOR, MULTIPLICATION_OPERATOR};

        for (int i = 0; i < BASIC_GAME_COUNT; i++) {
            String randomOperator = operators[
                    new RandomNumberGenerator()
                            .getRandomNumber(0, operators.length)
                    ];
            int firstRandomNumber = new RandomNumberGenerator().getRandomNumber(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            int secondRandomNumber = new RandomNumberGenerator().getRandomNumber(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);

            Integer correctAnswer = this.calculateCorrectAnswer(firstRandomNumber, secondRandomNumber, randomOperator);

            String question = firstRandomNumber + " " + randomOperator + " " + secondRandomNumber;

            this.addGame(
                    new Game(
                            question,
                            correctAnswer.toString()
                    )
            );
        }

        this.execute();
    }

    private Integer calculateCorrectAnswer(int firstRandomNumber, int secondRandomNumber, String randomOperator) {
        switch (randomOperator) {
            case ADDITION_OPERATOR -> {
                return firstRandomNumber + secondRandomNumber;
            }
            case SUBTRACTION_OPERATOR -> {
                return firstRandomNumber - secondRandomNumber;
            }
            case MULTIPLICATION_OPERATOR -> {
                return firstRandomNumber * secondRandomNumber;
            }

            default -> {
                System.out.println("Внутренняя ошибка. Передан неккотетный оператор!");

                return 0;
            }
        }
    }
}
