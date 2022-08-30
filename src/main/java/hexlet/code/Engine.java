package hexlet.code;

import java.util.Scanner;

public class Engine {
    private static final Scanner USER_INPUT_SCANNER = new Scanner(System.in);

    public static final int ATTEMPTS_NUMBER = 3;

    public static final int RANDOM_RANGE = 10;

    public static final String QUESTION = "Question: %s ";

    private static final String YOUR_ANSWER = "Your answer: ";

    private static final String CORRECT = "Correct!";

    private static final String CONGRATS = "Congratulations, %s!";

    private static final String WRONG_ANSWER = "'%s' is wrong answer ;(. Correct answer was '%s'";

    private static final String TRY_AGAIN = "Let's try again, %s!";

    private static final String WELCOME = "Welcome to the Brain Games!";

    private static String userName = null;

    public static void start(String gameTask, String[][] gameData) {
        meetUser();

        int attempt = 0;

        while (attempt < ATTEMPTS_NUMBER) {
            String question = gameData[attempt][0];
            String correctAnswer = gameData[attempt][1];

            if (attempt == 0) {
                showUserMessage(gameTask);
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

    public static void meetUser() {
        System.out.println(WELCOME);

        userName = Cli.getUserName();
        System.out.printf("Hello, %s!\n", userName);
    }

    public static String getUserAnswer(String text) {
        System.out.print(text);

        return USER_INPUT_SCANNER.nextLine();
    }

    private static void showUserMessage(String userMessage) {
        System.out.println(userMessage);
    }

    private static String getPositiveResult(int attempt) {
        String positiveResult = String.format(CONGRATS, userName);

        return (attempt == ATTEMPTS_NUMBER) ? String.format("%s\n%s", CORRECT, positiveResult) : CORRECT;
    }

    private static String getNegativeResult(String userAnswer, String correctAnswer) {
        String wrongAnswer = String.format(WRONG_ANSWER, userAnswer, correctAnswer);
        String goodbye = String.format(TRY_AGAIN, userName);

        return String.format("%s\n%s", wrongAnswer, goodbye);
    }
}
