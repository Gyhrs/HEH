package me.tue.player;

import me.tue.playarea.Location;

/**
 *  A class that tracks the player
 * @author Tue & Philip
 */
public class Player {
    private Location location;

    public Player() {
        this.location = new Location(null, 0, 0);
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
}
