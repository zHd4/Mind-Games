package hexlet.code.commands;

public final class Exit implements Command {
    @Override
    public void execute() {
        System.exit(0);
    }

    @Override
    public int getCommandNumber() {
        return 0;
    }
}
