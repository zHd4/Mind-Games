package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Round;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class CalculatorGame {
    private static final String RULES = "What is the result of the expression?";
    private static final int MAX_NUMBER = 100;

    public static void run() {
        Random random = new Random();

        List<Character> operators = List.of('+', '-', '*');
        List<Round> rounds = new ArrayList<>();

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int number1 = random.nextInt(MAX_NUMBER) + 1;
            int number2 = random.nextInt(MAX_NUMBER) + 1;

            Character operator = operators.get(random.nextInt(operators.size()));

            String question = String.format("%s %s %s", number1, operator, number2);
            int answer = calculate(number1, number2, operator);

            rounds.add(new Round(question, String.valueOf(answer)));
        }

        Engine.start(rounds, RULES);
    }

    private static int calculate(int number1, int number2, char operator) {
        int result;

        if (operator == '+') {
            result = number1 + number2;
        } else if (operator == '-') {
            result = number1 - number2;
        } else if (operator == '*') {
            result = number1 * number2;
        } else {
            throw new RuntimeException("Invalid operator");
        }

        return result;
    }
}
