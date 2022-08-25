package hexlet.code;

import hexlet.code.games.EvenGame;
import hexlet.code.games.CalcGame;
import hexlet.code.games.GCDGame;
import hexlet.code.games.ProgressionGame;
import hexlet.code.games.PrimeGame;

public class App {

    public static void main(String[] args) {
        try {
            System.out.println("Please enter the game number and press Enter.");

            System.out.println("1 - Greet");
            System.out.println("2 - Even");
            System.out.println("3 - Calc");
            System.out.println("4 - GCD");
            System.out.println("5 - Progression");
            System.out.println("6 - Prime");
            System.out.println("0 - Exit");

            executeGame(Engine.getUserAnswer("Your choice: "));
        }  catch (NullPointerException e) {
            System.out.println("Wrong choice!\n");
        }
    }

    private static void executeGame(String chosenGame) {
        switch (chosenGame) {
            case "1":
                Engine.meetUser();
                break;
            case "2":
                EvenGame.play();
                break;
            case "3":
                CalcGame.play();
                break;
            case "4":
                GCDGame.play();
                break;
            case "5":
                ProgressionGame.play();
                break;
            case "6":
                PrimeGame.play();
                break;
            case "0":
                System.exit(0);
                break;
            default:
                throw new NullPointerException();
        }
    }
}
