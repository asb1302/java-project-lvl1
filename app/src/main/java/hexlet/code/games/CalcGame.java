package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public final class CalcGame extends BaseGame implements GameInterface {
    public static final String MULTIPLICATION_OPERATOR = "*";
    public static final String SUBTRACTION_OPERATOR = "-";
    public static final String ADDITION_OPERATOR = "+";

    @Override
    public void play() {
        this.greet();

        String[] operators = {ADDITION_OPERATOR, SUBTRACTION_OPERATOR, MULTIPLICATION_OPERATOR};

        while (this.getCorrectAnswerCounter() < this.getWinConditionCounterLimit()) {
            String randomOperator = operators[new Random().nextInt(operators.length)];

            int firstRandomNumber = new Random().nextInt(this.getMaxRandomNumber());
            int secondRandomNumber = new Random().nextInt(this.getMaxRandomNumber());
            System.out.println("What is the result of the expression?");

            switch (randomOperator) {
                case ADDITION_OPERATOR -> {
                    System.out.println(
                            "Question: " + firstRandomNumber + " " + ADDITION_OPERATOR + " " + secondRandomNumber
                    );
                    System.out.print("Your answer: ");
                    int userAnswer = Integer.parseInt((new Scanner(System.in)).nextLine());
                    int correctAnswer = firstRandomNumber + secondRandomNumber;
                    if (correctAnswer == userAnswer) {
                        this.increaseCorrectedAnswersCounter();
                    } else {
                        this.sayGoodbye();

                        return;
                    }
                }
                case SUBTRACTION_OPERATOR -> {
                    System.out.println(
                            "Question: " + firstRandomNumber + " " + SUBTRACTION_OPERATOR + " " + secondRandomNumber
                    );
                    System.out.print("Your answer: ");
                    int userAnswer = Integer.parseInt((new Scanner(System.in)).nextLine());
                    int correctAnswer = firstRandomNumber - secondRandomNumber;
                    if (correctAnswer == userAnswer) {
                        this.increaseCorrectedAnswersCounter();
                    } else {
                        this.sayGoodbye();
                        return;
                    }
                }
                case MULTIPLICATION_OPERATOR -> {
                    System.out.println(
                            "Question: " + firstRandomNumber + " " + MULTIPLICATION_OPERATOR + " " + secondRandomNumber
                    );
                    System.out.print("Your answer: ");
                    int userAnswer = Integer.parseInt((new Scanner(System.in)).nextLine());
                    int correctAnswer = firstRandomNumber * secondRandomNumber;
                    if (correctAnswer == userAnswer) {
                        this.increaseCorrectedAnswersCounter();
                    } else {
                        this.sayGoodbye();

                        return;
                    }
                }

                default -> {
                    System.out.println("Incorrect operator!");
                }
            }
        }

        this.sayGoodbye();
    }
}
