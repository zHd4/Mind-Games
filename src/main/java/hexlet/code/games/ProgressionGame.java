package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.GameData;

import static hexlet.code.MathTools.randomInt;

public final class ProgressionGame {
    private static int[] progression;

    private static int skippedPosition;

    private static final int MIN_LENGTH = 5;

    private static final int MAX_LENGTH = 10;

    private static final String GAME_TASK = "What number is missing in the progression?";


    public static void play() {
        GameData gameData = new GameData();

        String[][] questionsArgs = new String[Engine.ATTEMPTS_NUMBER][];
        String[] correctAnswers = new String[Engine.ATTEMPTS_NUMBER];

        for (int i = 0; i < Engine.ATTEMPTS_NUMBER; i++) {
            int firstElement = randomInt(Engine.RANDOM_RANGE);
            int progressionStep = randomInt(Engine.RANDOM_RANGE);
            int progressionLength = randomInt(MAX_LENGTH - MIN_LENGTH) + MIN_LENGTH;

            skippedPosition = randomInt(progressionLength);
            progression = getProgression(firstElement, progressionStep, progressionLength);

            questionsArgs[i] = new String[] {getSequence(progression, skippedPosition)};
            correctAnswers[i] = getCorrectAnswer();
        }

        gameData.setGameTask(GAME_TASK);
        gameData.setQuestionsArgs(questionsArgs);
        gameData.setCorrectAnswers(correctAnswers);

        Engine.start(gameData);
    }

    private static String getCorrectAnswer() {
        return String.valueOf(progression[skippedPosition]);
    }


    private static int[] getProgression(int first, int step, int length) {
        int[] sequence = new int[length];
        sequence[0] = first;

        for (int i = 1; i < length; i++) {
            sequence[i] = sequence[i - 1] + step;
        }

        return sequence;
    }

    private static String getSequence(int[] data, int question) {
        StringBuilder sequence = new StringBuilder();
        @SuppressWarnings("UnusedAssignment") String symbol = "";

        for (int i = 0; i < data.length; i++) {
            symbol = (i == question) ? ".." : String.valueOf(data[i]);
            sequence.append(symbol).append(" ");
        }

        return sequence.toString();
    }
}
