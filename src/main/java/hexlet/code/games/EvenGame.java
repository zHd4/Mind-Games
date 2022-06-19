package hexlet.code.games;

import hexlet.code.tools.GamesTools;

import static hexlet.code.tools.MathTools.randomInt;

public final class EvenGame implements Game {
    private static final int RANDOM_MIN = 22;

    private static final int RANDOM_MAX = 3333;

    private static final int MAX_CORRECT_ANSWERS = 3 - 1;

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

            UserAnswer answer = GamesTools.askUser(isEven, correctAnswersCount, MAX_CORRECT_ANSWERS);

            if (answer == UserAnswer.CORRECT) {
                correctAnswersCount++;
            } else if (answer == UserAnswer.WRONG || answer == UserAnswer.DONE) {
                switchGameState();
            }
        }
    }

    private void switchGameState() {
        gameRunning = !gameRunning;
    }
}
