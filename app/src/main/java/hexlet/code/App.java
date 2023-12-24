package hexlet.code;

import hexlet.code.games.*;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class App {
    private static final Map<Integer, Game> GAMES_MAP = Map.of(
            2, new EvenGame(),
            3, new CalculatorGame(),
            4, new GCDGame(),
            5, new ProgressionGame(),
            6, new PrimeGame());

    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");

        new TreeMap<>(GAMES_MAP).forEach((number, game) -> System.out.printf("%s - %s\n", number, game));

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
