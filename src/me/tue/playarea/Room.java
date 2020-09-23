package me.tue.playarea;

/**
 *  Tracks all info on a room
 * @author Tue & Philip
 */
public class Room {
    private String description;

    /**
     * Constructor
     * @param description = The description of the room
     */
    public Room(String description) {
        this.description = description;
    }

    /**
     * Gets the description of the room
     * @return the description of the room
     */
    public String getDescription() {
        return description;
    }
}
