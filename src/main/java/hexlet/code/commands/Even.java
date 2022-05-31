package hexlet.code.commands;

import hexlet.code.games.EvenGame;

public final class Even implements Command {
    @Override
    public void execute() {
        if (Greet.getUserName() == null) {
            new Greet().greeting();
        }

        new EvenGame().startGameLoop();
    }

    @Override
    public int getCommandNumber() {
        return 2;
    }
}
