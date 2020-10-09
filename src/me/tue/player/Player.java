package me.tue.player;

import me.tue.inventory.Inventory;
import me.tue.inventory.Item;
import me.tue.playarea.Location;

/**
 *  A class that tracks the player
 * @author Tue & Philip
 */
public class Player {
    private Location location;
    private final Inventory inventory;

    public Player() {
        this.location = new Location(null, 0, 0);
        this.inventory = new Inventory("Inventory",30);
        this.addTestItems();
    }

    private void addTestItems(){
        Item sword = new Item("Sword", 10);
        Item stick = new Item("Stick", 0.5F);
        System.out.println("DROP1: " + this.getInventory().addItem(sword, 1));
        System.out.println("DROP2: " + this.getInventory().addItem(sword, 3));
        System.out.println("DROP3: " + this.getInventory().addItem(stick, 3));

    }

    /**
     * Sets location of player
     * @param location = The location of the player
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * Gets location of player
     * @return The location of the player
     */
    public Location getLocation() {
        return location;
    }


    /**
     * Gets the players inventory
     * @return The players inventory
     */
    public Inventory getInventory() {
        return inventory;
    }
}
