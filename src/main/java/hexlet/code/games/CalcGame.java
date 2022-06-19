package hexlet.code.games;

import hexlet.code.tools.GamesTools;
import static hexlet.code.tools.MathTools.randomInt;

public final class CalcGame implements Game {
    private static final int RANDOM_MIN = 22;

    private static final int RANDOM_MAX = 3333;

    private static final int MAX_CORRECT_ANSWERS = 3 - 1;

    private static final char[] MATH_OPERATIONS = new char[] {'+', '-', '*'};

    private boolean gameRunning = false;

    @Override
    public void startGameLoop() {
        int correctAnswersCount = 0;

        switchGameState();
        System.out.println("What is the result of the expression?");

        while (gameRunning) {
            int firstOperator = randomInt(RANDOM_MIN, RANDOM_MAX);
            int secondOperator = randomInt(RANDOM_MIN, RANDOM_MAX);

            char operation = MATH_OPERATIONS[randomInt(0, MATH_OPERATIONS.length - 1)];

            int result = calculate(firstOperator, secondOperator, operation);

            System.out.printf("Question: %s %s %s\n", firstOperator, operation, secondOperator);

            UserAnswer answer = GamesTools.askUser(result, correctAnswersCount, MAX_CORRECT_ANSWERS);

            if (answer == UserAnswer.CORRECT) {
                correctAnswersCount++;
            } else if (answer == UserAnswer.WRONG || answer == UserAnswer.DONE) {
                switchGameState();
            }
        }
    }

    private int calculate(int firstOperator, int secondOperator, char operation) {
        int result = 0;

        switch (operation) {
            case '+':
                result = firstOperator + secondOperator;
                break;

            case '-':
                result = firstOperator - secondOperator;
                break;

            case '*':
                result = firstOperator * secondOperator;
                break;

            default:
                break;
        }

        return result;
    }

    private void switchGameState() {
        gameRunning = !gameRunning;
    }
}
