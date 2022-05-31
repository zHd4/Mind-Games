package hexlet.code.commands;

public interface Command {
    void execute();

    int getCommandNumber();
}
