package me.tue.commands;

import java.util.Arrays;
import java.util.Scanner;

public class Parser {
    Scanner scanner;

    public Parser(){
         scanner = new Scanner(System.in);
    }

    public Command getCommand() {
        String inputLine;
        System.out.print(">");
        inputLine = scanner.nextLine().toUpperCase();

        String[] playerInput = inputLine.split(" ");
        CommandWords word = CommandWords.valueOf(playerInput[0]);
        if(word != null || word == CommandWords.UNKNOWN) {
            String[] arguments = Arrays.copyOfRange(playerInput, 1, playerInput.length);
            return new Command(word, arguments);
        }
        return new Command(CommandWords.UNKNOWN, null);
        }
    }