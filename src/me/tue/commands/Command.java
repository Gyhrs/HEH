package me.tue.commands;

/**
 *  A util class that control the commands
 * @author Tue & Philip
 */
public class Command {
    CommandWords commandType;
    String[] arguments;

    /**
     * Constructor
     * @param c = The command type
     * @param arguments = The arguments of the command
     */
    public Command(CommandWords c, String[] arguments) {
        this.commandType = c;
        this.arguments = arguments;
    }

    /**
     * Gets the command type of the command
     * @return CommandWords
     */
    public CommandWords getCommandType() {
        return commandType;
    }

    /**
     * Gets the arguements of the command
     * @return Array of Strings
     */
    public String[] getArguments() {
        return arguments;
    }

    /**
     * Gets a specific arguement
     * @param index = The index of the arguement needed
     * @return String
     */
    public String getArgument(int index){
        return this.getArguments()[index];
    }

    /**
     * Check if a command is unknown
     * @return CommandWords
     */
    public boolean isUnknown() {
        return (commandType == CommandWords.UNKNOWN);
    }

    /**
     * Check if a command has arguments
     * @return boolean
     */
    public boolean hasArguments() {
        return ((arguments != null) && (arguments.length > 0));
    }
}
