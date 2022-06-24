package hexlet.code.commands;

import hexlet.code.games.PrimeGame;

public final class Prime implements Command {
    private static final int COMMAND_NUMBER = 6;

    @Override
    public void execute() {
        if (Greet.getUserName() == null) {
            new Greet().greeting();
        }

        new PrimeGame().startGameLoop();
    }

    @Override
    public int getCommandNumber() {
        return COMMAND_NUMBER;
    }
}
