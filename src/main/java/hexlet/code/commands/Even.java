package hexlet.code.commands;

import hexlet.code.games.EvenGame;

public final class Even implements Command {
    private static final int COMMAND_NUMBER = 2;

    @Override
    public void execute() {
        if (Greet.getUserName() == null) {
            new Greet().greeting();
        }

        new EvenGame().startGameLoop();
    }

    @Override
    public int getCommandNumber() {
        return COMMAND_NUMBER;
    }
}
