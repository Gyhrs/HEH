package me.tue.commands;

import me.tue.Main;
import me.tue.playarea.Location;
import me.tue.playarea.Room;
import me.tue.utils.ImageUtil;

import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.List;

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
            case MAP:
                Location loc = main.getPlayer().getLocation();
                boolean betaMap = false;
                if(command.hasArguments()){
                    betaMap = Boolean.parseBoolean(command.getArgument(0));
                }
                List<String> map = loc.getWorld().generateMap(loc, betaMap);
                System.out.println("------ MAP of " + loc.getWorld().getName() +"  ------");
                for(String s : map){
                    System.out.println(s);
                }
                System.out.println("------------------------");
                break;
            case IMAGE:
                String imagePath = "magicmike.jpeg";
                if(command.hasArguments()){
                    imagePath = command.getArgument(0);
                }
                BufferedImage image = ImageUtil.getImage("images/" + imagePath);
                List<String> lines = ImageUtil.convertImage(image);
                for(String s : lines){
                    System.out.println(s);
                }
                break;
            case QUIT:
                System.out.println("Thank you for playing");
                main.setRunning(false);
                break;


        }
    }

}
