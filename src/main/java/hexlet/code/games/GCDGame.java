package hexlet.code.games;

import hexlet.code.commands.Greet;
import hexlet.code.tools.GamesTools;
import static hexlet.code.tools.MathTools.randomInt;

public final class GCDGame {
    public static final int COMMAND_INDEX = 4;

    private static final int RANDOM_MIN = 22;

    private static final int RANDOM_MAX = 3333;

    private static final int MAX_CORRECT_ANSWERS = 3 - 1;

    private static boolean gameRunning = false;

    public static void startGameLoop() {
        if (Greet.getUserName() == null) {
            Greet.greeting();
        }

        int correctAnswersCount = 0;

        switchGameState();
        System.out.println("Find the greatest common divisor of given numbers.");

        while (gameRunning) {
            int a = randomInt(RANDOM_MIN, RANDOM_MAX);
            int b = randomInt(RANDOM_MIN, RANDOM_MAX);

            int gcd = getGcd(a, b);

            System.out.printf("Question: %s %s\n", a, b);

            UserAnswer answer = GamesTools.askUser(gcd, correctAnswersCount, MAX_CORRECT_ANSWERS);

            if (answer == UserAnswer.CORRECT) {
                correctAnswersCount++;
            } else if (answer == UserAnswer.WRONG || answer == UserAnswer.DONE) {
                switchGameState();
            }
        }
    }

    private static int getGcd(final int a, final int b) {
        int gcd = 1;

        for (int i = 1; i <= a && i <= b; i++) {
            if (a % i == 0 && b % i == 0) {
                gcd = i;
            }
        }

        return gcd;
    }

    private static void switchGameState() {
        gameRunning = !gameRunning;
    }
}
