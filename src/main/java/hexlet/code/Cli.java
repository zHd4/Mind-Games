package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static String getUserName() {
        String userName = null;

        while (userName == null) {
            System.out.println("May I have your name? ");

            Scanner userInputScanner = new Scanner(System.in);
            String inputResult = userInputScanner.nextLine();

            if (inputResult.length() > 0) {
                userName = inputResult;
            }
        }

        return userName;
    }
}
