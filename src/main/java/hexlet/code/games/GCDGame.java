package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.GameData;

import static hexlet.code.MathTools.randomInt;

public final class GCDGame {
    private static int num1;

    private static int num2;

    private static final String GAME_TASK = "Find the greatest common divisor of given numbers.";

    public static void play() {
        GameData gameData = new GameData();

        String[][] questionsArgs = new String[Engine.ATTEMPTS_NUMBER][];
        String[] correctAnswers = new String[Engine.ATTEMPTS_NUMBER];

        for (int i = 0; i < Engine.ATTEMPTS_NUMBER; i++) {
            num1 = randomInt(Engine.RANDOM_RANGE);
            num2 = randomInt(Engine.RANDOM_RANGE);

            String[] args = new String[] {String.valueOf(num1), String.valueOf(num2)};

            questionsArgs[i] = args;
            correctAnswers[i] = getCorrectAnswer();
        }

        gameData.setGameTask(GAME_TASK);
        gameData.setQuestionsArgs(questionsArgs);
        gameData.setCorrectAnswers(correctAnswers);

        Engine.start(gameData);
    }

    private static String getCorrectAnswer() {
        int result = getGCD(num1, num2);

        return String.valueOf(result);
    }


    private static int getGCD(int p, int q) {
        if (q == 0) {
            return p;
        }

        return getGCD(q, p % q);
    }
}
