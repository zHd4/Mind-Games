package hexlet.code.commands;

import hexlet.code.Cli;

public final class Greet {
    public static final int COMMAND_INDEX = 1;

    private static String userName = null;

    public static String getUserName() {
        return userName;
    }

    public static void execute() {
        greeting();
        System.exit(0);
    }

    public static void greeting() {
        System.out.println("Welcome to the Brain Games!");

        userName = Cli.getUserName();
        System.out.printf("Hello, %s!\n", userName);
    }
}
