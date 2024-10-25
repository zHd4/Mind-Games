package app.mindgames.games;

import app.mindgames.Engine;
import app.mindgames.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class CalculatorGame {
    private static final String RULES = "What is the result of the expression?";
    private static final int MAX_NUMBER = 100;

    public static void run() {
        List<Character> operators = List.of('+', '-', '*');
        List<Map<String, String>> rounds = new ArrayList<>();

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int number1 = Utils.getRandomInt(1, MAX_NUMBER);
            int number2 = Utils.getRandomInt(1, MAX_NUMBER);

            Character operator = operators.get(Utils.getRandomInt(0, operators.size() - 1));

            String question = String.format("%s %s %s", number1, operator, number2);
            int answer = calculate(number1, number2, operator);

            rounds.add(Map.of("question", question, "answer", String.valueOf(answer)));
        }

        Engine.start(rounds, RULES);
    }

    private static int calculate(int number1, int number2, char operator) {
        if (operator == '+') {
            return number1 + number2;
        } else if (operator == '-') {
            return number1 - number2;
        } else if (operator == '*') {
            return number1 * number2;
        } else {
            throw new RuntimeException("Invalid operator");
        }
    }
}
