package me.tue.commands;

/**
 * A enum class to track command words
 *
 * @author Tue & Philip
 */
public enum CommandWords {
    GO(false),
    ATTACK(false),
    PEEK(false),
    LOOK(false),
    TAKE(false),
    UNKNOWN(false),
    QUIT(false),
    HELP(false),
    INVENTORY(false),
    MAP(false),
    IMAGE(true),
    TP(true);

    boolean isAdmin;

    CommandWords(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    @Override
    public String toString() {
        return this.name();
    }

    public boolean equals(String string) {
        return this.name().equals(string);
    }

    public boolean equalsIgnoreCase(String string) {
        return this.name().equalsIgnoreCase(string);
    }
}
