package hexlet.code.games;

import hexlet.code.DTO.GameInfo;
import hexlet.code.DTO.GameRule;
import hexlet.code.services.RandomNumberGenerator;

public final class CalcGame extends BaseGame implements GameInterface {
    public static final String MULTIPLICATION_OPERATOR = "*";
    public static final String SUBTRACTION_OPERATOR = "-";
    public static final String ADDITION_OPERATOR = "+";

    @Override
    public void play() {
        String[] operators = {ADDITION_OPERATOR, SUBTRACTION_OPERATOR, MULTIPLICATION_OPERATOR};

        for (int i = 0; i < BASIC_GAME_COUNT; i++) {
            GameInfo gameInfoDTO = new GameInfo();
            gameInfoDTO.setPreview(this.getPreview());

            String randomOperator = operators[
                    new RandomNumberGenerator()
                            .setMinRandomNumber(0)
                            .setMaxRandomNumber(operators.length)
                            .getRandomNumber()
                    ];
            int firstRandomNumber = new RandomNumberGenerator().getRandomNumber();
            int secondRandomNumber = new RandomNumberGenerator().getRandomNumber();

            Integer correctAnswer = this.calculateCorrectAnswer(firstRandomNumber, secondRandomNumber, randomOperator);
            gameInfoDTO.setAnswer(correctAnswer.toString());

            String questionParam = firstRandomNumber + " " + randomOperator + " " + secondRandomNumber;
            gameInfoDTO.setQuestion(this.getQuestion(questionParam));

            gameInfoDTO.setRule(this.getRule());

            this.getGamesList().add(gameInfoDTO);
        }

        this.getEngine().execute(this.getGamesList());
    }

    @Override
    protected String getPreview() {
        return "What is the result of the expression?";
    }

    @Override
    protected String getQuestion(String param) {
        return "Question: " + param + "\n" + "Answer: ";
    }

    @Override
    protected GameRule getRule() {
        return (userAnswer, correctAnswer) -> Integer.parseInt(userAnswer) == Integer.parseInt(correctAnswer);
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
