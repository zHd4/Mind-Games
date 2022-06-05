package hexlet.code.commands;

import hexlet.code.Cli;

public final class Greet implements Command {
    private static final int COMMAND_NUMBER = 1;

    private static String userName = null;

    public static String getUserName() {
        return userName;
    }

    @Override
    public void execute() {
        greeting();
        System.exit(0);
    }

    @Override
    public int getCommandNumber() {
        return COMMAND_NUMBER;
    }

    public void greeting() {
        System.out.println("Welcome to the Brain Games!");

        userName = Cli.getUserName();
        System.out.printf("Hello, %s!\n", userName);
    }
}
