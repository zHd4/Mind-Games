package hexlet.code.games;

import hexlet.code.Engine;

import static hexlet.code.MathTools.randomInt;

public final class GCDGame {
    private static int num1;

    private static int num2;

    private static final String[] QUESTION = new String[Engine.ATTEMPTS_NUMBER];

    private static final String[] CORRECT_ANSWER = new String[Engine.ATTEMPTS_NUMBER];

    private static final String GAME_TASK = "Find the greatest common divisor of given numbers.";

    private static final String QUESTION_FORMAT = Engine.QUESTION + "%s";

    public static void play() {
        for (int i = 0; i < Engine.ATTEMPTS_NUMBER; i++) {
            setQuestionData();

            QUESTION[i] = getQuestion();
            CORRECT_ANSWER[i] = getCorrectAnswer();
        }

        Engine.start(GAME_TASK, QUESTION, CORRECT_ANSWER);
    }

    private static void setQuestionData() {
        num1 = randomInt(Engine.RANDOM_RANGE);
        num2 = randomInt(Engine.RANDOM_RANGE);
    }

    private static String getQuestion() {
        return String.format(QUESTION_FORMAT, num1, num2);
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
