package com.zhd4.mindgames;


import com.zhd4.mindgames.games.CalculatorGame;
import com.zhd4.mindgames.games.EvenGame;
import com.zhd4.mindgames.games.GCDGame;
import com.zhd4.mindgames.games.PrimeGame;
import com.zhd4.mindgames.games.ProgressionGame;

import java.util.Scanner;

public final class App {
    public static void main(String[] args) {
        System.out.println("""
                           Please enter the game number and press Enter.
                           1 - Greet
                           2 - Even
                           3 - Calc
                           4 - GCD
                           5 - Progression
                           6 - Prime
                           0 - Exit
                           """);

        System.out.print("Your choice: ");

        try (Scanner scanner = new Scanner(System.in)) {
            switch (scanner.next()) {
                case "1" -> Cli.greeting();
                case "2" -> EvenGame.run();
                case "3" -> CalculatorGame.run();
                case "4" -> GCDGame.run();
                case "5" -> ProgressionGame.run();
                case "6" -> PrimeGame.run();
                case "0" -> System.exit(0);
                default -> System.out.println("Wrong game number! Exit.");
            }
        }
    }
}
