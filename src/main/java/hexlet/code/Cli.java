package hexlet.code;

import hexlet.code.exceptions.InvalidMenuNumberChoiceException;
import java.util.Scanner;

public class Cli {
    private static final Scanner USER_INPUT_SCANNER = new Scanner(System.in);

    public static String getUserName() {
        String userName = null;

        while (userName == null) {
            System.out.print("May I have your name? ");

            String inputResult = USER_INPUT_SCANNER.nextLine();

            if (inputResult.length() > 0) {
                userName = inputResult;
            }
        }

        return userName;
    }

    public static Integer getUserChoice() throws InvalidMenuNumberChoiceException {
        System.out.print("Your choice: ");

        String inputResult = USER_INPUT_SCANNER.nextLine();

        try {
            Integer result = Integer.parseInt(inputResult);

            System.out.print('\n');
            return result;
        } catch (NumberFormatException e) {
            System.out.println("Enter a valid number!\n");
            throw new InvalidMenuNumberChoiceException();
        }
    }

    public static boolean inputYesNo(String text) {
        System.out.print(text);

        String inputResult = USER_INPUT_SCANNER.nextLine().toLowerCase();
        return inputResult.equals("yes");
    }
}

