package me.tue.playarea;

import java.util.Arrays;
import java.util.HashMap;

/**
 *  Tracks all info on a room
 *  Stores exits in a Hashmap
 * @author Tue & Philip
 */
public class Room {
    private String description;
    private HashMap<String, Location> exits;
    /**
     * Constructor
     * @param description = The description of the room
     */
    public Room(String description) {
        this.description = description;
        exits = new HashMap<>();
    }

    /**
     * Gets the description of the room
     * @return the description of the room
     */
    public String getDescription() {
        return description;
    }

    public Location getExit(String direction){
        return this.exits.get(direction.toUpperCase());
    }

    /**
     * Sets exits for room
     * @param direction = Which direction the exit is
     * @param loc = Which x,y coordinate the exit leads to
     */
    public void setExits(String direction, Location loc ) {
        exits.put(direction.toUpperCase(), loc);
    }

    @Override
    public String toString() {
        return "{" + Arrays.toString(exits.keySet().toArray()) + "}";
    }
}
