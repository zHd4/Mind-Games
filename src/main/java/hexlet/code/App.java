package hexlet.code;

import hexlet.code.commands.Command;
import hexlet.code.commands.Even;
import hexlet.code.commands.Exit;
import hexlet.code.commands.Greet;
import hexlet.code.exceptions.InvalidMenuNumberChoiceException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class App {
    private static final Map<String, Command> COMMANDS_MAP = new HashMap<>();

    public static void main(String[] args) {
        load();

        //noinspection InfiniteLoopStatement
        while (true) {
            try {
                Objects.requireNonNull(getUserMenuChoice()).execute();
            } catch (NullPointerException e) {
                System.out.println("Wrong choice!\n");
            } catch (InvalidMenuNumberChoiceException e) {
                //noinspection UnnecessaryContinue
                continue;
            }
        }
    }

    private static void load() {
        COMMANDS_MAP.put("Greet", new Greet()); // 1
        COMMANDS_MAP.put("Even", new Even()); // 2
        COMMANDS_MAP.put("Exit", new Exit()); // 0
    }

    private static Command getUserMenuChoice() throws InvalidMenuNumberChoiceException {
        final Map<Integer, String> commandsNumbers = new HashMap<>();

        System.out.println("Please enter the game number and press Enter.");

        for (Map.Entry<String, Command> entry : COMMANDS_MAP.entrySet()) {
            String commandName = entry.getKey();
            Integer commandNumber = entry.getValue().getCommandNumber();

            System.out.printf("%s - %s\n", commandNumber, commandName);

            commandsNumbers.put(commandNumber, commandName);
        }

        String commandName = commandsNumbers.get(Cli.getUserChoice());

        return COMMANDS_MAP.get(commandName);
    }
}
