package hexlet.code;

import hexlet.code.exceptions.InvalidMenuNumberChoiceException;
import java.util.Scanner;

public class Cli {
    public static String getUserName() {
        String userName = null;

        while (userName == null) {
            System.out.print("May I have your name? ");

            Scanner userInputScanner = new Scanner(System.in);
            String inputResult = userInputScanner.nextLine();

            if (inputResult.length() > 0) {
                userName = inputResult;
            }
        }

        return userName;
    }

    public static Integer getUserChoice() throws InvalidMenuNumberChoiceException {
        System.out.print("Your choice: ");

        Scanner userInputScanner = new Scanner(System.in);
        String inputResult = userInputScanner.nextLine();

        try {
            Integer result = Integer.parseInt(inputResult);

            System.out.print('\n');

            return result;
        } catch (NumberFormatException e) {
            System.out.println("Enter a valid number!\n");
            throw new InvalidMenuNumberChoiceException();
        }
    }
}

