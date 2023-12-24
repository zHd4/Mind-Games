package hexlet.code;

import java.util.List;
import java.util.Scanner;

public final class Engine {
    public static final int ROUNDS_COUNT = 3;

    public static void start(List<Round> rounds, String rules) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to the Brain Games!");
            System.out.print("May I have your name? ");

            String username = scanner.next();

            System.out.printf("Hello, %s!\n", username);
            System.out.println(rules);

            for (Round round : rounds) {
                System.out.println("Question: " + round.question());
                System.out.print("Your answer: ");

                String userAnswer = scanner.next();
                String correctAnswer = round.answer();

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
