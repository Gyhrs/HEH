package me.tue.playarea;

import java.util.ArrayList;

/**
 *  A class that helps store and control the worlds
 * @author Tue & Philip
 */
public class WorldManager {
    private static WorldManager instance = null;
    private final ArrayList<World> worlds;
    private Location startLocation;

    /**
     * Constructor
     */
    public WorldManager() {
        worlds = new ArrayList<>();
    }

    /**
     * Creates the world "Hell" with all of its rooms
     */
    public World createHell() {
        World hell = new World("Hell", "A world of punishment and suffering", 10, 10);
        // Creates Room 1 and sets locations
        Room r1 = new Room("Starting Room");
        r1.setExits("east", new Location(hell,6,5));
        hell.createRoom(r1, 5,5);
        // Creates Room 2...
        Room r2 = new Room("Test");
        r2.setExits("west", new Location(hell,5,5));
        hell.createRoom(r2,6,5);
        //Creates Room 3...

        //Creates Room 4...

        hell.setStartLocation(5,5);
        return hell;
    }

    /**
     * Creates the world "Earth" with all of its rooms
     */
    public World createEarth() {
        World earth = new World("Earth", "The mortal realm",10,10);

        return earth;
    }

    /**
     * Creates the world "Heaven" with all of its rooms
     */
    public World createHeaven() {
        World heaven = new World("Heaven", "God's realm", 10,10);

        return heaven;
    }

    public void addWorld(World world) {
        worlds.add(world);
    }


    /**
     * Gets a instance of WorldManager such that there will not be multiple instances of the class
     * @return instance of WorldManager
     */
    public static WorldManager getInstance(){
        if(instance == null) instance = new WorldManager();
        return instance;
    }
}
