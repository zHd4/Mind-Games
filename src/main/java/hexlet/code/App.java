package hexlet.code;

import hexlet.code.commands.Command;
import hexlet.code.commands.Greet;
import hexlet.code.commands.Even;
import hexlet.code.commands.Calc;
import hexlet.code.commands.GCD;
import hexlet.code.commands.Progression;
import hexlet.code.commands.Prime;
import hexlet.code.commands.Exit;

import hexlet.code.exceptions.InvalidMenuNumberChoiceException;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.HashMap;
import java.util.Comparator;
import java.util.Objects;

import static java.util.stream.Collectors.toMap;

public class App {
    private static LinkedHashMap<String, Command> commandsMap = new LinkedHashMap<>();

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
        Map<String, Command> source = new HashMap<>();

        source.put("Greet", new Greet()); // 1
        source.put("Even", new Even()); // 2
        source.put("Calc", new Calc()); // 3
        source.put("GCD", new GCD()); // 4
        source.put("Progression", new Progression()); // 5
        source.put("Prime", new Prime()); // 6
        source.put("Exit", new Exit()); // 0

        commandsMap = source.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparing(Command::getCommandNumber)))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (s1, s2) -> s1, LinkedHashMap::new));
    }

    private static Command getUserMenuChoice() throws InvalidMenuNumberChoiceException {
        final Map<Integer, String> commandsNumbers = new HashMap<>();

        System.out.println("Please enter the game number and press Enter.");

        for (Map.Entry<String, Command> entry : commandsMap.entrySet()) {
            String commandName = entry.getKey();
            Integer commandNumber = entry.getValue().getCommandNumber();

            commandsNumbers.put(commandNumber, commandName);

            if (commandNumber == 0) {
                continue;
            }

            System.out.printf("%s - %s\n", commandNumber, commandName);
        }

        System.out.println("0 - Exit");
        String commandName = commandsNumbers.get(Cli.integerInput("Your choice: "));

        return commandsMap.get(commandName);
    }
}
