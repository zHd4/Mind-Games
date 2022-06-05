package hexlet.code.commands;

public final class Exit implements Command {
    private static final int COMMAND_NUMBER = 0;

    @Override
    public void execute() {
        System.exit(0);
    }

    @Override
    public int getCommandNumber() {
        return COMMAND_NUMBER;
    }
}
