package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Map;
import java.util.HashMap;
import java.util.Random;


public final class PrimeGame {
    private static final String RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int MAX_NUMBER = 999;

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void run() {
        Random random = new Random();
        Map<String, String> rounds = new HashMap<>();

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int number = random.nextInt(MAX_NUMBER) + 1;

            String question = String.valueOf(number);
            String answer = isPrime(number) ? "yes" : "no";

            rounds.put(question, answer);
        }

        Engine.start(rounds, RULES);
    }
}
