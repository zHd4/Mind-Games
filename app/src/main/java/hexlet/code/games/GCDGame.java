package hexlet.code.games;

import hexlet.code.Engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public final class GCDGame {
    private static final String RULES = "Find the greatest common divisor of given numbers.";
    private static final int MAX_NUMBER = 100;

    private static int getGcd(int number1, int number2) {
        while (number1 != 0 && number2 != 0) {
            if (number1 > number2) {
                number1 = number1 % number2;
            } else {
                number2 = number2 % number1;
            }
        }

        return number1 + number2;
    }

    public static void run() {
        Random random = new Random();
        List<Map<String, String>> rounds = new ArrayList<>();

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int number1 = random.nextInt(MAX_NUMBER) + 1;
            int number2 = random.nextInt(MAX_NUMBER) + 1;

            int answer = getGcd(number1, number2);

            String question = String.format("%s %s", number1, number2);
            rounds.add(Map.of("question", question, "answer", String.valueOf(answer)));
        }

        Engine.start(rounds, RULES);
    }
}
