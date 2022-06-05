package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.commands.Greet;

import static hexlet.code.MathTools.randomInt;

public final class EvenGame implements Game {
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
            int question = randomInt(RANDOM_MIN, RANDOM_MAX);
            boolean isEven = question % 2 == 0;

            System.out.printf("Question: %s\n", question);

            boolean answer = Cli.inputYesNo("Your answer: ");

            if (answer == isEven) {
                correctAnswersCount++;

                System.out.println("Correct!\n");

                if (correctAnswersCount == MAX_CORRECT_ANSWERS) {
                    System.out.printf("Congratulations, %s!\n\n", Greet.getUserName());
                    switchGameState();
                }
            } else {
                String userAnswerString = answer ? "yes" : "no";
                String correctAnswerString = isEven ? "yes" : "no";

                System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.\n",
                        userAnswerString, correctAnswerString);

                System.out.printf("Let's try again, %s!\n\n", Greet.getUserName());
                switchGameState();
            }
        }
    }

    private void switchGameState() {
        gameRunning = !gameRunning;
    }
}
