package hexlet.code.tools;

import hexlet.code.Engine;
import hexlet.code.commands.Greet;
import hexlet.code.exceptions.InvalidMenuNumberChoiceException;
import hexlet.code.games.UserAnswer;

public class GamesTools {
    public static UserAnswer askUser(int correctAnswer, int correctAnswersCount, int maxCorrectAnswers) {
        try {
            int answer = Engine.integerInput("Your answer: ");

            if (answer == correctAnswer) {
                System.out.println("Correct!\n");

                if (correctAnswersCount == maxCorrectAnswers) {
                    System.out.printf("Congratulations, %s!\n\n", Greet.getUserName());

                    return UserAnswer.DONE;
                }

                return UserAnswer.CORRECT;
            } else {
                System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.\n",
                        answer, correctAnswer);

                System.out.printf("Let's try again, %s!\n\n", Greet.getUserName());

                return UserAnswer.WRONG;
            }
        } catch (InvalidMenuNumberChoiceException ignored) {
            return UserAnswer.ERROR;
        }
    }

    public static UserAnswer askUser(boolean correctAnswer, int correctAnswersCount, int maxCorrectAnswers) {
        boolean answer = Engine.inputYesNo("Your answer: ");

        if (answer == correctAnswer) {
            System.out.println("Correct!\n");

            if (correctAnswersCount == maxCorrectAnswers) {
                System.out.printf("Congratulations, %s!\n\n", Greet.getUserName());

                return UserAnswer.DONE;
            }

            return UserAnswer.CORRECT;
        } else {
            String userAnswerString = answer ? "yes" : "no";
            String correctAnswerString = correctAnswer ? "yes" : "no";

            System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.\n",
                    userAnswerString, correctAnswerString);

            System.out.printf("Let's try again, %s!\n\n", Greet.getUserName());

            return UserAnswer.WRONG;
        }
    }
}
