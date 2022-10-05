package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.GameData;

import static hexlet.code.MathTools.randomInt;

public final class PrimeGame {
    private static int randomNumber;

    private static final String GAME_TASK = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";


    public static void play() {
        String[][] questionsArgs = new String[Engine.ATTEMPTS_NUMBER][];
        String[] correctAnswers = new String[Engine.ATTEMPTS_NUMBER];

        for (int i = 0; i < Engine.ATTEMPTS_NUMBER; i++) {
            randomNumber = randomInt(Engine.RANDOM_RANGE);

            correctAnswers[i] = getCorrectAnswer();
            questionsArgs[i] = new String[] {
                    String.valueOf(randomNumber)
            };
        }

        GameData gameData = new GameData();

        gameData.setGameTask(GAME_TASK);
        gameData.setQuestionsArgs(questionsArgs);
        gameData.setCorrectAnswers(correctAnswers);

        Engine.start(gameData);
    }

    private static String getCorrectAnswer() {
        return isPrime(randomNumber) ? "yes" : "no";
    }

    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
