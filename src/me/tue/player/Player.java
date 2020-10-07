package me.tue.player;

import me.tue.inventory.Inventory;
import me.tue.playarea.Location;

/**
 *  A class that tracks the player
 * @author Tue & Philip
 */
public class Player {
    private Location location;
    private Inventory inventory;

    public Player() {
        this.location = new Location(null, 0, 0);
        this.inventory = new Inventory(30);
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
