package hexlet.code;

import hexlet.code.commands.Exit;
import hexlet.code.commands.Greet;
import hexlet.code.exceptions.InvalidMenuNumberChoiceException;

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

            executeGame(Engine.integerInput("Your choice: "));
        }  catch (NullPointerException e) {
            System.out.println("Wrong choice!\n");
        } catch (InvalidMenuNumberChoiceException ignored) {
            // ignored
        }
    }

    private static void executeGame(int chosenGameIndex) {
        switch (chosenGameIndex) {
            case Greet.COMMAND_INDEX:
                Greet.execute();
                break;
            case EvenGame.COMMAND_INDEX:
                EvenGame.startGameLoop();
                break;
            case CalcGame.COMMAND_INDEX:
                CalcGame.startGameLoop();
                break;
            case GCDGame.COMMAND_INDEX:
                GCDGame.startGameLoop();
                break;
            case ProgressionGame.COMMAND_INDEX:
                ProgressionGame.startGameLoop();
                break;
            case PrimeGame.COMMAND_INDEX:
                PrimeGame.startGameLoop();
                break;
            case Exit.COMMAND_INDEX:
                Exit.execute();
                break;
            default:
                throw new NullPointerException();
        }
    }
}
