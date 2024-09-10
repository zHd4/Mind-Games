package com.zhd4.mindgames;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public final class Engine {
    public static final int ROUNDS_COUNT = 3;

    public static void start(List<Map<String, String>> rounds, String rules) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to the Brain Games!");
            System.out.print("May I have your name? ");

            String username = scanner.next();

            System.out.printf("Hello, %s!\n", username);
            System.out.println(rules);

            for (Map<String, String> round : rounds) {
                String question = round.get("question");
                String correctAnswer = round.get("answer");

                System.out.println("Question: " + question);
                System.out.print("Your answer: ");

                String userAnswer = scanner.next();

                if (!userAnswer.equals(correctAnswer)) {
                    System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.\n", userAnswer, correctAnswer);
                    System.out.printf("Let's try again, %s!\n", username);

                    return;
                } else {
                    System.out.println("Correct!");
                }
            }

            System.out.printf("Congratulations, %s!\n", username);
        }
    }
}
