package me.tue.commands;

public enum CommandWords {
    GO, ATTACK, PEEK, LOOK, TAKE, UNKNOWN;

    @Override
    public String toString() {
        return super.toString();
    }

    public boolean equals(String string){
        return this.name().equals(string);
    }

    public boolean equalsIgnoreCase(String string){
        return this.name().equalsIgnoreCase(string);
    }
}
