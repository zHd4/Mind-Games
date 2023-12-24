package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Round;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CalculatorGame implements Game {
    private static final String RULES = "What is the result of the expression?";
    private static final int MAX_NUMBER = 100;

    @Override
    public void run() {
        Random random = new Random();

        List<Character> operators = List.of('+', '-', '*');
        List<Round> rounds = new ArrayList<>();

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int number1 = random.nextInt(MAX_NUMBER) + 1;
            int number2 = random.nextInt(MAX_NUMBER) + 1;

            Character operator = operators.get(random.nextInt(operators.size()));
            String question = String.format("%s %s %s", number1, operator, number2);

            int answer = 0;

            switch (operator) {
                case '+' -> answer = number1 + number2;
                case '-' -> answer = number1 - number2;
                case '*' -> answer = number1 * number2;
            }

            rounds.add(new Round(question, String.valueOf(answer)));
        }

        Engine.start(rounds, RULES);
    }

    @Override
    public String toString() {
        return "Calc";
    }
}
