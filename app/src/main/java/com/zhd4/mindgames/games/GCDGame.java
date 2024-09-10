package com.zhd4.mindgames.games;

import com.zhd4.mindgames.Engine;
import com.zhd4.mindgames.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        List<Map<String, String>> rounds = new ArrayList<>();

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int number1 = Utils.getRandomInt(1, MAX_NUMBER);
            int number2 = Utils.getRandomInt(1, MAX_NUMBER);

            int answer = getGcd(number1, number2);

            String question = String.format("%s %s", number1, number2);
            rounds.add(Map.of("question", question, "answer", String.valueOf(answer)));
        }

        Engine.start(rounds, RULES);
    }
}
