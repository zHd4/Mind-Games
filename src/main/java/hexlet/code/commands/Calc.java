package hexlet.code.commands;

import hexlet.code.games.CalcGame;

public final class Calc implements Command {
    private static final int COMMAND_NUMBER = 3;

    @Override
    public void execute() {
        if (Greet.getUserName() == null) {
            new Greet().greeting();
        }

        new CalcGame().startGameLoop();
    }

    @Override
    public int getCommandNumber() {
        return COMMAND_NUMBER;
    }
}
