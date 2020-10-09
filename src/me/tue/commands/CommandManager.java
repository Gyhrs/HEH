package me.tue.commands;

import me.tue.Main;
import me.tue.playarea.Location;
import me.tue.playarea.Room;

import java.util.Arrays;

public class CommandManager {

    private final Main main;

    public CommandManager(){
        this.main = Main.getInstance();
    }

    public void run(Command command) {
        switch (command.getCommandType()) {
            case UNKNOWN:
                System.out.println("Invalid Command");
                break;

            case HELP:
                System.out.println("Here are your commands");
                System.out.println(Arrays.toString(CommandWords.values()));
                break;

            case GO:
                Location currentLoc = this.main.getPlayer().getLocation();
                Room currentRoom = currentLoc.getWorld().getRoom(currentLoc.getX(), currentLoc.getY());
                if(!command.hasArguments()){
                    System.out.println("Go where?");
                    System.out.println(currentRoom.toString());
                    return;
                }
                String direction = command.getArgument(0);
                Location nextLocation = currentRoom.getExit(direction);
                if(nextLocation == null){
                    System.out.println("You can't go that way.");
                    return;
                }
                Room nextRoom = nextLocation.getWorld().getRoom(nextLocation.getX(), nextLocation.getY());
                if(nextRoom == null){
                    System.out.println("There isn't anything there");
                    return;
                }
                main.getPlayer().setLocation(nextLocation);
                System.out.println("You enter a new room... " + nextRoom.getDescription());
                System.out.println(nextRoom.toString());
                break;
            case INVENTORY:
                main.getPlayer().getInventory().display();
                break;
            case QUIT:
                System.out.println("Thank you for playing");
                main.setRunning(false);
                break;


        }
    }

}
