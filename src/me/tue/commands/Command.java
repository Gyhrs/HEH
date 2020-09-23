package me.tue.commands;

public class Command {
    CommandWords commandType;
    String[] arguments;

    public Command(CommandWords c, String[] arguments) {
        this.commandType = c;
        this.arguments = arguments;
    }

    public CommandWords getCommandType() {
        return commandType;
    }

    public String[] getArguments() {
        return arguments;
    }

    public String getArgument(int index){
        return this.getArguments()[index];
    }

    public boolean isUnknown() {
        return (commandType == CommandWords.UNKNOWN);
    }

    public boolean hasArguments() {
        return ((arguments != null) && (arguments.length > 0));
    }
}
