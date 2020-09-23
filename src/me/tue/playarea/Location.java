package me.tue.playarea;

/**
 *  A util class that helps store a location
 * @author Tue & Philip
 */
public class Location {
    private int x;
    private int y;
    private World world;

    /**
     * Constructor
     * @param world = The world of the location
     * @param x = The x value
     * @param y = The y value
     */
    public Location(World world, int x, int y){
        this.world = world;
        this.x = x;
        this.y = y;
    }

    /**
     * Get the x value
     * @return The x value of the location
     */
    public int getX() {
        return x;
    }

    /**
     * Get the y value
     * @return The y value of the location
     */
    public int getY() {
        return y;
    }

    /**
     * Get the world
     * @return The world element
     */
    public World getWorld() {
        return world;
    }

    /**
     * Set the x value of the location
     * @param x = The x value of the location
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Set the y value of the location
     * @param y = The y value of the location
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Set the world of the location
     * @param world = World of the location
     */
    public void setWorld(World world) {
        this.world = world;
    }

    /**
     * Generates a string to display the location
     * @return String
     */
    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                ", world=" + world.getName() +
                '}';
    }
}
