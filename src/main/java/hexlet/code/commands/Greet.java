package hexlet.code.commands;

import hexlet.code.Cli;

public final class Greet implements Command {

    @Override
    public void execute() {
        System.out.println("Welcome to the Brain Games!");

        String userName = Cli.getUserName();

        System.out.printf("Hello, %s!\n", userName);
        System.exit(0); //
    }

    @Override
    public int getCommandNumber() {
        return 1;
    }
}
