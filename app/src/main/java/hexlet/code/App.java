package hexlet.code;

import hexlet.code.games.EvenGame;
import hexlet.code.games.Game;

import java.util.Map;
import java.util.Scanner;

public class App {
    private static final Map<Integer, Game> GAMES_MAP = Map.of(2, new EvenGame());

    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");

        GAMES_MAP.forEach((number, game) -> System.out.printf("%o - %s\n", number, game));

        System.out.println("0 - Exit");
        System.out.print("Your choice: ");

        try (Scanner scanner = new Scanner(System.in)) {
            int number = scanner.nextInt();

            switch (number) {
                case 1 -> Cli.greeting();
                case 0 -> System.exit(0);
                default -> GAMES_MAP.get(number).run();
            }
        }
    }
}
