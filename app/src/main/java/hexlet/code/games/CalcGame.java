package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.GameData;

import static hexlet.code.MathTools.randomInt;

public final class CalcGame {
    private static int operand1;

    private static int operand2;

    private static String operator;

    private static final int OPERATORS_RANDOM_RANGE = 2;

    private static final String GAME_TASK = "What is the result of the expression?";

    public static void play() {
        GameData gameData = new GameData();

        String[][] questionsArgs = new String[Engine.ATTEMPTS_NUMBER][];
        String[] correctAnswers = new String[Engine.ATTEMPTS_NUMBER];

        for (int i = 0; i < Engine.ATTEMPTS_NUMBER; i++) {
            operand1 = randomInt(Engine.RANDOM_RANGE);
            operand2 = randomInt(Engine.RANDOM_RANGE);

            operator = getOperator();

            String[] args = new String[] {String.valueOf(operand1), operator, String.valueOf(operand2)};

            questionsArgs[i] = args;
            correctAnswers[i] = getCorrectAnswer();
        }

        gameData.setGameTask(GAME_TASK);
        gameData.setQuestionsArgs(questionsArgs);
        gameData.setCorrectAnswers(correctAnswers);

        Engine.start(gameData);
    }

    private static String getCorrectAnswer() {
        switch (operator) {
            case "+":
                return String.valueOf(operand1 + operand2);
            case "-":
                return String.valueOf(operand1 - operand2);
            case "*":
                return String.valueOf(operand1 * operand2);
            default:
                throw new IllegalArgumentException("Unsupported operator: " + operator);
        }
    }

    private static String getOperator() {
        int random = randomInt(OPERATORS_RANDOM_RANGE);

        switch (random) {
            case 0:
                return "*";
            case 1:
                return "+";
            case 2:
                return "-";
            default:
                throw new IllegalArgumentException("Operator selection error: " + random);
        }
    }
}
