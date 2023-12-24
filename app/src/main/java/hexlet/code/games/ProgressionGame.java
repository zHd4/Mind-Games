package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Round;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public final class ProgressionGame implements Game {
    private static final String RULES = "What number is missing in the progression?";
    public static final int MAX_START = 40;
    public static final int MAX_STEP = 5;
    public static final int MIN_LENGTH = 5;
    public static final int MAX_LENGTH = 10;

    private static List<Integer> getProgression(int start, int step, int length) {
        List<Integer> progression = new ArrayList<>();

        int current = start;

        for (int i = 0; i < length; i++) {
            current += step;
            progression.add(current);
        }

        return progression;
    }

    private static String progressionToString(List<Integer> progression, int questionIndex) {
        return progression.stream()
                .map(number -> progression.indexOf(number) == questionIndex ? ".." : String.valueOf(number))
                .collect(Collectors.joining(" "));
    }

    @Override
    public void run() {
        Random random = new Random();
        List<Round> rounds = new ArrayList<>();

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int start = random.nextInt(1, MAX_START) + 1;
            int step = random.nextInt(1, MAX_STEP) + 1;

            int length = random.nextInt(MIN_LENGTH, MAX_LENGTH) + 1;
            int questionIndex = random.nextInt(1, length);

            List<Integer> progression = getProgression(start, step, length);

            String question = progressionToString(progression, questionIndex);
            String answer = progression.get(questionIndex).toString();

            rounds.add(new Round(question, answer));
        }

        Engine.start(rounds, RULES);
    }

    @Override
    public String toString() {
        return "Progression";
    }
}
