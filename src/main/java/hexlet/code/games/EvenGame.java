package hexlet.code.games;

import hexlet.code.Engine;

import static hexlet.code.MathTools.randomInt;

public final class EvenGame  {
    private static int randomNumber;

    private static final String[][] GAME_DATA = new String[Engine.ATTEMPTS_NUMBER][];

    private static final String GAME_TASK = "Answer 'yes' if number even otherwise answer 'no'.";

    public static void play() {
        for (int i = 0; i < Engine.ATTEMPTS_NUMBER; i++) {
            setQuestionData();
            GAME_DATA[i] = new String[] {getQuestion(), getCorrectAnswer()};
        }

        Engine.start(GAME_TASK, GAME_DATA);
    }

    private static void setQuestionData() {
        randomNumber = randomInt(Engine.RANDOM_RANGE);
    }

    private static String getQuestion() {
        return String.format(Engine.QUESTION, randomNumber);
    }

    private static String getCorrectAnswer() {
        return isEven(randomNumber) ? "yes" : "no";
    }

    private  static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
