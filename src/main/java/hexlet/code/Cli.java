package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static String getUserName() {
        String userName = null;
        Scanner userInputScanner = new Scanner(System.in);

        while (userName == null) {
            System.out.print("May I have your name? ");

            String inputResult = userInputScanner.nextLine();

            if (inputResult.length() > 0) {
                userName = inputResult;
            }
        }

        return userName;
    }
}

