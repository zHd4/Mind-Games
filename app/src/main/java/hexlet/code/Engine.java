package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int ATTEMPTS_NUMBER = 3;

    public static final int RANDOM_RANGE = 10;

    public static final String QUESTION = "Question: ";

    private static final String YOUR_ANSWER = "Your answer: ";

    private static final String CORRECT = "Correct!";

    private static final String CONGRATS = "Congratulations, %s!";

    private static final String WRONG_ANSWER = "'%s' is wrong answer ;(. Correct answer was '%s'";

    private static final String TRY_AGAIN = "Let's try again, %s!";

    public static void start(GameData gameData) {
        if (Cli.getUserName() == null) {
            Cli.greet();
        }

        int attempt = 0;

        String[][] questionArgs = gameData.getQuestionsArgs();
        String[] correctAnswers = gameData.getCorrectAnswers();

        while (attempt < ATTEMPTS_NUMBER) {
            String question = QUESTION + String.join(" ", questionArgs[attempt]);
            String correctAnswer = correctAnswers[attempt];

            if (attempt == 0) {
                showUserMessage(gameData.getGameTask());
            }

            showUserMessage(question);

            String userAnswer = getUserAnswer(YOUR_ANSWER);

            if (userAnswer.equals(correctAnswer)) {
                String positiveResult = getPositiveResult(attempt + 1);

                showUserMessage(positiveResult);
                attempt++;
            } else {
                String negativeResult = getNegativeResult(userAnswer, correctAnswer);

                showUserMessage(negativeResult);
                attempt = ATTEMPTS_NUMBER;
            }
        }
    }

    public static String getUserAnswer(String text) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(text);

        return scanner.nextLine();
    }

    private static void showUserMessage(String userMessage) {
        System.out.println(userMessage);
    }

    private static String getPositiveResult(int attempt) {
        String positiveResult = String.format(CONGRATS, Cli.getUserName());

        return (attempt == ATTEMPTS_NUMBER) ? String.format("%s\n%s", CORRECT, positiveResult) : CORRECT;
    }

    private static String getNegativeResult(String userAnswer, String correctAnswer) {
        String wrongAnswer = String.format(WRONG_ANSWER, userAnswer, correctAnswer);
        String goodbye = String.format(TRY_AGAIN, Cli.getUserName());

        return String.format("%s\n%s", wrongAnswer, goodbye);
    }
}
