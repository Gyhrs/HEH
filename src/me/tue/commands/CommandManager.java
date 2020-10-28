package me.tue.commands;

import me.tue.Entities.Entity;
import me.tue.Entities.Monster;
import me.tue.Main;
import me.tue.playarea.Location;
import me.tue.playarea.Room;
import me.tue.playarea.World;
import me.tue.utils.ImageUtil;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandManager {

    private final Main main;

    public CommandManager(){
        this.main = Main.getInstance();
    }

    private void moveTo(Location location) {
        Room nextRoom = location.getWorld().getRoom(location.getX(), location.getY());
        if(nextRoom == null){
            System.out.println("There isn't anything there");
            return;
        }
        main.getPlayer().setLocation(location);
        System.out.println("You enter a new room... " + nextRoom.getDescription());
        if(nextRoom.hasEntities()) nextRoom.displayEntities();

        System.out.println(nextRoom.toString());
    }

    public void run(Command command) {
        if(command == null || command.getCommandType() == null) return;
        if(!main.isAdminMode() && command.getCommandType().isAdmin()) return;

        Location currentLoc = this.main.getPlayer().getLocation();
        Room currentRoom = currentLoc.getWorld().getRoom(currentLoc.getX(), currentLoc.getY());
        switch (command.getCommandType()) {
            case PEEK:
                break;
            case LOOK:
                break;
            case TAKE:
                break;
            case UNKNOWN:
                System.out.println("Invalid Command");
                break;

            case HELP:
                System.out.println("Here are your commands");
                System.out.println(Arrays.toString(CommandWords.values()));
                break;

            case GO:
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
                moveTo(nextLocation);
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
            case ATTACK:
                if(!currentRoom.hasEntities()){
                    System.out.println("Congratz! You hit the air!");
                    return;
                }
                List<Monster> list = new ArrayList<>();
                for (Entity entity : currentRoom.getEntities()) {
                    if (entity.getHostile() && entity instanceof Monster) {
                        list.add((Monster) entity);
                    }
                }
                Monster[] monsters = list.toArray(new Monster[]{});
                if(monsters.length == 0){
                    System.out.println("Those entities are not monsters!");
                    return;
                }
                Monster monster = null;
                if(monsters.length > 1){
                    if(!command.hasArguments()){
                        System.out.println("Multiple monsters to attack. Use ATTACK (id) to choose a monster to attack");
                        currentRoom.displayEntities(true);
                        return;
                    }else{
                        try{
                            int id = Integer.parseInt(command.getArgument(0))-1;
                            monster = monsters[id];
                        }catch (Exception e){
                            System.out.println(command.getArgument(0) + " is not a valid number");
                            currentRoom.displayEntities(true);
                            return;
                        }
                    }
                }else{
                    monster = monsters[0];
                }
                if(monster == null){
                    System.out.println("Failed attack");
                    return;
                }

                float damageDealt = main.getPlayer().getDamage();
                monster.takeDamage(damageDealt);
                float damageTaken = 0;
                String race = monster.getRace();
                if(monster.isAlive()){
                    damageTaken = monster.getDamage();
                    main.getPlayer().takeDamage(damageTaken);
                }else{
                    System.out.println(race + " has been slayed");
                    currentRoom.getEntities().remove(monster);
                    if(monsters.length > 1){
                        currentRoom.displayEntities(true);
                    }
                    return;
                }
                if(monster.getIconPath() != null && damageTaken > 0){
                    ImageUtil.displayImage(monster.getIconPath());
                }
                System.out.println("Attacked " + race + " and dealt " + damageDealt + " damage. " + race + " has " + monster.getHealth() + " hp left.");
                if(damageTaken > 0){
                    System.out.println("The " + race + " attacked back and dealt " +  damageTaken + " damage. You have " + main.getPlayer().getHealth() + " hp left.");
                }
                if(monsters.length > 1){
                    currentRoom.displayEntities(true);
                }
                break;
            case IMAGE:
                String imagePath = "magicmike.jpeg";
                if(command.hasArguments()){
                    imagePath = command.getArgument(0);
                }
                try{
                    ImageUtil.displayImage("images/" + imagePath);
                }catch (NullPointerException e){
                    System.out.println("Failed to get image");
                }
                break;
            case TP:
                if(!command.hasArguments() && command.getArguments().length < 4){
                    System.out.println("Input room location, with proper coordinates you retard");
                    return;
                }
                String worldName = command.getArgument(0);
                World world = main.getWorldManager().getWorlds().stream()
                        .filter(w -> w.getName().equalsIgnoreCase(worldName))
                        .findFirst()
                        .orElse(null);
                if(world == null) {
                    System.out.println("World does not exist");
                    return;
                }
                int x = 0;
                int y = 0;
                try {
                    x = (int) Integer.parseInt(command.getArgument(1));
                    y = (int) Integer.parseInt(command.getArgument(2));
                } catch (NumberFormatException e) {
                    System.out.println("Not a integer");
                    return;
                }
               main.getPlayer().setLocation(new Location(world,x,y));
                System.out.println("Magic TP");
                moveTo(new Location(world,x,y));
                break;
            case QUIT:
                System.out.println("Thank you for playing");
                main.setRunning(false);
                break;


            default:
                throw new IllegalStateException("Unexpected value: " + command.getCommandType());
        }
    }

}
