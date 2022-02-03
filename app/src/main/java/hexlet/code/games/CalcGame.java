package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public final class CalcGame extends BaseGame implements GameInterface {
    public static final String MULTIPLICATION_OPERATOR = "*";
    public static final String SUBTRACTION_OPERATOR = "-";
    public static final String ADDITION_OPERATOR = "+";

    @Override
    public void play() {
        String[] operators = {ADDITION_OPERATOR, SUBTRACTION_OPERATOR, MULTIPLICATION_OPERATOR};

        int correctAnswerCounter = 0;

        while (correctAnswerCounter < this.WIN_CONDITION_COUNTER_LIMIT) {
            String randomOperator = operators[new Random().nextInt(operators.length)];

            int firstRandomNumber = new Random().nextInt(this.MAX_RANDOM_NUMBER);
            int secondRandomNumber = new Random().nextInt(this.MAX_RANDOM_NUMBER);
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
                        correctAnswerCounter++;
                    } else {
                        System.out.println(this.LOST_MSG);
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
                        correctAnswerCounter++;
                    } else {
                        System.out.println(this.LOST_MSG);
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
                        correctAnswerCounter++;
                    } else {
                        System.out.println(this.LOST_MSG);
                        return;
                    }
                }

                default -> {
                    System.out.println("Incorrect operator!");
                }
            }
        }

        System.out.println(this.WIN_MSG);
    }
}
