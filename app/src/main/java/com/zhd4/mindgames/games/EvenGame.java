package com.zhd4.mindgames.games;

import com.zhd4.mindgames.Engine;
import com.zhd4.mindgames.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class EvenGame {
    private static final String RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int MAX_NUMBER = 999;

    public static void run() {
        List<Map<String, String>> rounds = new ArrayList<>();

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int number = Utils.getRandomInt(1, MAX_NUMBER);

            String question = String.valueOf(number);
            String answer = isEven(number) ? "yes" : "no";

            rounds.add(Map.of("question", question, "answer", answer));
        }

        Engine.start(rounds, RULES);
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
