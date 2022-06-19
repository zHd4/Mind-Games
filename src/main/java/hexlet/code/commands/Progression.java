package hexlet.code.commands;

import hexlet.code.games.ProgressionGame;

public final class Progression implements Command {
    private static final int COMMAND_NUMBER = 5;

    @Override
    public void execute() {
        if (Greet.getUserName() == null) {
            new Greet().greeting();
        }

        new ProgressionGame().startGameLoop();
    }

    @Override
    public int getCommandNumber() {
        return COMMAND_NUMBER;
    }
}
