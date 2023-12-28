package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class ProgressionGame {
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

    public static void run() {
        List<Map<String, String>> rounds = new ArrayList<>();

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int start = Utils.getRandomInt(1, MAX_START);
            int step = Utils.getRandomInt(1, MAX_STEP);

            int length = Utils.getRandomInt(MIN_LENGTH, MAX_LENGTH);
            int questionIndex = Utils.getRandomInt(1, length - 1);

            List<Integer> progression = getProgression(start, step, length);

            String question = progressionToString(progression, questionIndex);
            String answer = progression.get(questionIndex).toString();

            rounds.add(Map.of("question", question, "answer", answer));
        }

        Engine.start(rounds, RULES);
    }
}
