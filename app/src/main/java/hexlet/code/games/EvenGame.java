package hexlet.code.games;

import hexlet.code.Engine;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public final class EvenGame {
    private static final String RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int MAX_NUMBER = 999;

    public static void run() {
        Random random = new Random();
        Map<String, String> rounds = new HashMap<>();

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int number = random.nextInt(MAX_NUMBER) + 1;

            String question = String.valueOf(number);
            String answer = isEven(number) ? "yes" : "no";

            rounds.put(question, answer);
        }

        Engine.start(rounds, RULES);
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
