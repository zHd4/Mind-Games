package hexlet.code.commands;

import hexlet.code.games.GCDGame;

public final class GCD implements Command {
    private static final int COMMAND_NUMBER = 4;

    @Override
    public void execute() {
        if (Greet.getUserName() == null) {
            new Greet().greeting();
        }

        new GCDGame().startGameLoop();
    }

    @Override
    public int getCommandNumber() {
        return COMMAND_NUMBER;
    }
}
