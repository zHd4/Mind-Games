package hexlet.code.games;

import hexlet.code.Engine;

import static hexlet.code.MathTools.randomInt;

public final class ProgressionGame {
    private static final int MIN_LENGTH = 5;

    private static final int MAX_LENGTH = 10;

    private static final String GAME_TASK = "What number is missing in the progression?";

    private static final String[] QUESTION = new String[Engine.ATTEMPTS_NUMBER];

    private static final String[] CORRECT_ANSWER = new String[Engine.ATTEMPTS_NUMBER];

    private static int progressionLength;

    private static int skippedPosition;

    private static int[] progression;


    public static void play() {
        for (int i = 0; i < Engine.ATTEMPTS_NUMBER; i++) {
            setQuestionData();

            QUESTION[i] = getQuestion();
            CORRECT_ANSWER[i] = getCorrectAnswer();
        }

        Engine.start(GAME_TASK, QUESTION, CORRECT_ANSWER);
    }

    private static void setQuestionData() {
        int firstElement = randomInt(Engine.RANDOM_RANGE);
        int progressionStep = randomInt(Engine.RANDOM_RANGE);

        progressionLength = randomInt(MAX_LENGTH - MIN_LENGTH) + MIN_LENGTH;
        skippedPosition = randomInt(progressionLength);
        progression = getProgression(firstElement, progressionStep);
    }

    private static String getQuestion() {
        String sequence = getSequence();

        return String.format(Engine.QUESTION, sequence);
    }

    private static String getCorrectAnswer() {
        return String.valueOf(progression[skippedPosition]);
    }


    private static int[] getProgression(int first, int step) {
        int[] sequence = new int[progressionLength];
        sequence[0] = first;

        for (int i = 1; i < progressionLength; i++) {
            sequence[i] = sequence[i - 1] + step;
        }

        return sequence;
    }

    private static String getSequence() {
        StringBuilder sequence = new StringBuilder();
        @SuppressWarnings("UnusedAssignment") String symbol = "";

        for (int i = 0; i < progressionLength; i++) {
            symbol = (i == skippedPosition) ? ".." : String.valueOf(progression[i]);
            sequence.append(symbol).append(" ");
        }

        return sequence.toString();
    }
}
