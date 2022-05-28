package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public final class CalcGame {
    public static final String MULTIPLICATION_OPERATOR = "*";
    public static final String SUBTRACTION_OPERATOR = "-";
    public static final String ADDITION_OPERATOR = "+";

    public static void play() {
        String userName = Engine.greet();

        String[] operators = {ADDITION_OPERATOR, SUBTRACTION_OPERATOR, MULTIPLICATION_OPERATOR};

        int correctAnswers = 0;
        while (correctAnswers < Engine.getWinConditionCounterLimit()) {
            String randomOperator = operators[new Random().nextInt(operators.length)];

            int firstRandomNumber = new Random().nextInt(Engine.getMaxRandomNumber());
            int secondRandomNumber = new Random().nextInt(Engine.getMaxRandomNumber());
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
                        correctAnswers++;
                    } else {
                        Engine.sayGoodbye(userName, correctAnswers);

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
                        correctAnswers++;
                    } else {
                        Engine.sayGoodbye(userName, correctAnswers);
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
                        correctAnswers++;
                    } else {
                        Engine.sayGoodbye(userName, correctAnswers);

                        return;
                    }
                }

                default -> System.out.println("Incorrect operator!");
            }
        }

        Engine.sayGoodbye(userName, correctAnswers);
    }
}
