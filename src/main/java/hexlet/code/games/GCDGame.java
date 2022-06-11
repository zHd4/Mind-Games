package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.commands.Greet;
import hexlet.code.exceptions.InvalidMenuNumberChoiceException;

import static hexlet.code.MathTools.randomInt;

public final class GCDGame implements Game {
    private static final int RANDOM_MIN = 22;

    private static final int RANDOM_MAX = 3333;

    private static final int MAX_CORRECT_ANSWERS = 3;

    private boolean gameRunning = false;

    @Override
    public void startGameLoop() {
        int correctAnswersCount = 0;

        switchGameState();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        while (gameRunning) {
            int a = randomInt(RANDOM_MIN, RANDOM_MAX);
            int b = randomInt(RANDOM_MIN, RANDOM_MAX);

            int gcd = getGcd(a, b);

            System.out.printf("Question: %s %s\n", a, b);

            try {
                int answer = Cli.integerInput("Your answer: ");

                if (answer == gcd) {
                    correctAnswersCount++;

                    System.out.println("Correct!\n");

                    if (correctAnswersCount == MAX_CORRECT_ANSWERS) {
                        System.out.printf("Congratulations, %s!\n\n", Greet.getUserName());
                        switchGameState();
                    }
                } else {
                    System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.\n",
                            answer, gcd);

                    System.out.printf("Let's try again, %s!\n\n", Greet.getUserName());
                    switchGameState();
                }
            } catch (InvalidMenuNumberChoiceException ignored) {
                // ignored
            }
        }
    }

    private int getGcd(final int a, final int b) {
        int gcd = 1;

        for (int i = 1; i <= a && i <= b; i++) {
            if (a % i == 0 && b % i == 0) {
                gcd = i;
            }
        }

        return gcd;
    }

    private void switchGameState() {
        gameRunning = !gameRunning;
    }
}
