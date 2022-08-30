package hexlet.code.games;

import hexlet.code.Engine;

import static hexlet.code.MathTools.randomInt;

public final class ProgressionGame {
    private static int[] progression;

    private static int skippedPosition;

    private static final int MIN_LENGTH = 5;

    private static final int MAX_LENGTH = 10;

    private static final String GAME_TASK = "What number is missing in the progression?";

    private static final String[][] GAME_DATA = new String[Engine.ATTEMPTS_NUMBER][];

    public static void play() {
        for (int i = 0; i < Engine.ATTEMPTS_NUMBER; i++) {
            setQuestionData();

            GAME_DATA[i] = new String[] {
                    getQuestion(progression, skippedPosition),
                    getCorrectAnswer()
            };
        }

        Engine.start(GAME_TASK, GAME_DATA);
    }

    private static void setQuestionData() {
        int firstElement = randomInt(Engine.RANDOM_RANGE);
        int progressionStep = randomInt(Engine.RANDOM_RANGE);
        int progressionLength = randomInt(MAX_LENGTH - MIN_LENGTH) + MIN_LENGTH;

        skippedPosition = randomInt(progressionLength);
        progression = getProgression(firstElement, progressionStep, progressionLength);
    }

    private static String getQuestion(final int[] data, final int question) {
        String sequence = getSequence(data, question);

        return String.format(Engine.QUESTION, sequence);
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
