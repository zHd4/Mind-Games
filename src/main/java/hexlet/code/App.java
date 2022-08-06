package hexlet.code;

import hexlet.code.commands.Exit;
import hexlet.code.commands.Greet;
import hexlet.code.exceptions.InvalidMenuNumberChoiceException;

import hexlet.code.games.EvenGame;
import hexlet.code.games.CalcGame;
import hexlet.code.games.GCDGame;
import hexlet.code.games.ProgressionGame;
import hexlet.code.games.PrimeGame;

import java.util.LinkedHashMap;
import java.util.Map;

public class App {
    private static final LinkedHashMap<Integer, String> GAMES_MAP = new LinkedHashMap<>();

    public static void main(String[] args) {
        load();

        try {
            System.out.println("Please enter the game number and press Enter.");

            for (Map.Entry<Integer, String> entry : GAMES_MAP.entrySet()) {
                Integer gameIndex = entry.getKey();
                String gameName = entry.getValue();

                System.out.printf("%s - %s\n", gameIndex, gameName);
            }

            executeGame(GAMES_MAP.get(Engine.integerInput("Your choice: ")));
        }  catch (NullPointerException e) {
            System.out.println("Wrong choice!\n");
        } catch (InvalidMenuNumberChoiceException ignored) {
            // ignored
        }
    }

    private static void load() {
        GAMES_MAP.put(Greet.COMMAND_INDEX, "Greet"); // 1
        GAMES_MAP.put(EvenGame.COMMAND_INDEX, "Even"); // 2
        GAMES_MAP.put(CalcGame.COMMAND_INDEX, "Calc"); // 3
        GAMES_MAP.put(GCDGame.COMMAND_INDEX, "GCD"); // 4
        GAMES_MAP.put(ProgressionGame.COMMAND_INDEX, "Progression"); // 5
        GAMES_MAP.put(PrimeGame.COMMAND_INDEX, "Prime"); // 6
        GAMES_MAP.put(Exit.COMMAND_INDEX, "Exit"); // 0
    }

    private static void executeGame(String choosenGameName) {
        switch (choosenGameName) {
            case "Greet":
                Greet.execute();
                break;
            case "Even":
                EvenGame.startGameLoop();
                break;
            case "Calc":
                CalcGame.startGameLoop();
                break;
            case "GCD":
                GCDGame.startGameLoop();
                break;
            case "Progression":
                ProgressionGame.startGameLoop();
                break;
            case "Prime":
                PrimeGame.startGameLoop();
                break;
            case "Exit":
                Exit.execute();
                break;
            default:
                throw new NullPointerException();
        }
    }
}
