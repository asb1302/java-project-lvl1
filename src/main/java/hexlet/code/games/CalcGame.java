package hexlet.code.games;

import hexlet.code.services.RandomNumberGenerator;

public final class CalcGame implements GameInterface {
    public static final String MULTIPLICATION_OPERATOR = "*";
    public static final String SUBTRACTION_OPERATOR = "-";
    public static final String ADDITION_OPERATOR = "+";
    private int firstRandomNumber;
    private int secondRandomNumber;
    private String randomOperator;

    @Override
    public String getPreview() {
        return "What is the result of the expression?";
    }

    @Override
    public String getQuestion() {
        String[] operators = {ADDITION_OPERATOR, SUBTRACTION_OPERATOR, MULTIPLICATION_OPERATOR};

        this.randomOperator = operators[
            new RandomNumberGenerator()
                    .setMinRandomNumber(0)
                    .setMaxRandomNumber(operators.length)
                    .getRandomNumber()
            ];
        this.firstRandomNumber = new RandomNumberGenerator().getRandomNumber();
        this.secondRandomNumber = new RandomNumberGenerator().getRandomNumber();

        return "Question: " + firstRandomNumber + " " + randomOperator + " " + secondRandomNumber + "\n" + "Answer: ";
    }

    @Override
    public int getWinConditionCounterLimit() {
        return WIN_CONDITION_COUNTER_LIMIT;
    }

    @Override
    public boolean userAnswerIsCorrect(String userAnswer) {
        switch (this.randomOperator) {
            case ADDITION_OPERATOR -> {
                return firstRandomNumber + secondRandomNumber == Integer.parseInt(userAnswer);
            }
            case SUBTRACTION_OPERATOR -> {
                return firstRandomNumber - secondRandomNumber == Integer.parseInt(userAnswer);
            }
            case MULTIPLICATION_OPERATOR -> {
                return firstRandomNumber * secondRandomNumber == Integer.parseInt(userAnswer);
            }

            default -> {
                return false;
            }
        }
    }
}
