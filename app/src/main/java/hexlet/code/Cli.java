package hexlet.code;

import java.util.Scanner;

public final class Cli {
    public static void greeting() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to the Brain Games!");
            System.out.print("May I have your name? ");

            String username = scanner.next();
            System.out.printf("Hello, %s!\n", username);
        }
    }
}
