package me.tue.commands;
/**
 *  A enum class to track command words
 * @author Tue & Philip
 */
public enum CommandWords {
    GO, ATTACK, PEEK, LOOK, TAKE, UNKNOWN, QUIT, HELP, INVENTORY;

    @Override
    public String toString() {
        return this.name();
    }

    public boolean equals(String string){
        return this.name().equals(string);
    }

    public boolean equalsIgnoreCase(String string){
        return this.name().equalsIgnoreCase(string);
    }
}
