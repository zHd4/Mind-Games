package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.GameData;

import static hexlet.code.MathTools.randomInt;

public final class EvenGame  {
    private static int randomNumber;

    private static final String GAME_TASK = "Answer 'yes' if number even otherwise answer 'no'.";

    public static void play() {
        GameData gameData = new GameData();

        String[][] questionsArgs = new String[Engine.ATTEMPTS_NUMBER][];
        String[] correctAnswers = new String[Engine.ATTEMPTS_NUMBER];

        for (int i = 0; i < Engine.ATTEMPTS_NUMBER; i++) {
            randomNumber = randomInt(Engine.RANDOM_RANGE);
            questionsArgs[i] = new String[] {String.valueOf(randomNumber)};
            correctAnswers[i] = getCorrectAnswer();
        }

        gameData.setGameTask(GAME_TASK);
        gameData.setQuestionsArgs(questionsArgs);
        gameData.setCorrectAnswers(correctAnswers);

        Engine.start(gameData);
    }

    private static String getCorrectAnswer() {
        return isEven(randomNumber) ? "yes" : "no";
    }

    private  static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
