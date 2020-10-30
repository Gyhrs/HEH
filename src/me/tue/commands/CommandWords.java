package me.tue.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A enum class to track command words
 *
 * @author Tue & Philip
 */
public enum CommandWords {
    GO(false, "g"),
    ATTACK(false, "a"),
    PEEK(false, "p"),
    LOOK(false, "l"),
    TAKE(false, "t"),
    UNKNOWN(false),
    QUIT(false),
    HELP(false, "h"),
    INVENTORY(false, "inv"),
    MAP(false, "m"),
    IMAGE(true),
    TP(true);

    boolean isAdmin;
    String[] aliases;

    CommandWords(boolean isAdmin) {
        this(isAdmin, new String[]{});
    }

    CommandWords(boolean isAdmin, String alias){
        this(isAdmin, new String[]{alias});
    }

    CommandWords(boolean isAdmin, String[] aliases) {
        this.isAdmin = isAdmin;
        this.aliases = aliases;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public String[] getAliases() {
        return aliases;
    }
    public boolean containsAlias(String alias, boolean ignoreCase){
        return Arrays.stream(this.getAliases()).anyMatch(s -> (ignoreCase ? s.equalsIgnoreCase(alias) : s.equals(alias)));
    }

    public boolean hasAliases(){
        return aliases != null && aliases.length != 0;
    }


    @Override
    public String toString() {
        return this.name();
    }

    public boolean equals(String string) {
        return this.name().equals(string) || (this.hasAliases() && this.containsAlias(string, false));
    }

    public boolean equalsIgnoreCase(String string) {

        return this.name().equalsIgnoreCase(string) || (this.hasAliases() && this.containsAlias(string, true));
    }
}
