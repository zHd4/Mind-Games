package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.commands.Greet;
import hexlet.code.exceptions.InvalidMenuNumberChoiceException;

import static hexlet.code.MathTools.randomInt;

public final class CalcGame implements Game {
    private static final int RANDOM_MIN = 22;

    private static final int RANDOM_MAX = 3333;

    private static final int MAX_CORRECT_ANSWERS = 3;

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

            try {
                int answer = Cli.integerInput("Your answer: ");

                if (answer == result) {
                    correctAnswersCount++;

                    System.out.println("Correct!\n");

                    if (correctAnswersCount == MAX_CORRECT_ANSWERS) {
                        System.out.printf("Congratulations, %s!\n\n", Greet.getUserName());
                        switchGameState();
                    }
                } else {
                    System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.\n",
                            answer, result);

                    System.out.printf("Let's try again, %s!\n\n", Greet.getUserName());
                    switchGameState();
                }
            } catch (InvalidMenuNumberChoiceException ignored) {
                // ignored
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
