package hexlet.code.games;

import hexlet.code.commands.Greet;
import hexlet.code.tools.GamesTools;

import static hexlet.code.tools.MathTools.randomInt;

public final class PrimeGame {
    public static final int COMMAND_INDEX = 6;

    private static final int RANDOM_MIN = 1;

    private static final int RANDOM_MAX = 100;

    private static final int MAX_CORRECT_ANSWERS = 3 - 1;

    private static boolean gameRunning = false;

    public static void startGameLoop() {
        if (Greet.getUserName() == null) {
            Greet.greeting();
        }

        int correctAnswersCount = 0;

        switchGameState();
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        while (gameRunning) {
            int question = randomInt(RANDOM_MIN, RANDOM_MAX);
            boolean isPrime = checkPrime(question);

            System.out.printf("Question: %s\n", question);

            UserAnswer answer = GamesTools.askUser(isPrime, correctAnswersCount, MAX_CORRECT_ANSWERS);

            if (answer == UserAnswer.WRONG || answer == UserAnswer.DONE) {
                switchGameState();
                break;
            }

            correctAnswersCount++;
        }
    }

    private static boolean checkPrime(int number) {
        if (number == 0 || number == 1) {
            return false;
        }

        int m = number / 2;

        for (int i = 2; i <= m; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    private static void switchGameState() {
        gameRunning = !gameRunning;
    }
}
