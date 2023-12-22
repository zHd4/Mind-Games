package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");

        System.out.println("1 - Greet");
        System.out.println("0 - Exit");

        System.out.print("Your choice: ");

        try (Scanner scanner = new Scanner(System.in)) {
            int number = scanner.nextInt();

            switch (number) {
                case 1 -> {
                    System.out.println("Welcome to the Brain Games!");
                    Cli.greeting();
                }

                case 0 -> System.exit(0);
            }
        }
    }
}
