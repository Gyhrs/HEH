package me.tue.playarea;

import java.util.ArrayList;

/**
 *  A class that helps store and control the worlds
 * @author Tue & Philip
 */
public class WorldManager {
    private static WorldManager instance = null;
    private ArrayList<World> worlds;

    /**
     * Constructor
     */
    public WorldManager() {
        worlds = new ArrayList<>();
    }

    /**
     * Creates the world "Hell" with all of its rooms
     */
    public void createHell() {
        World hell = new World("Hell", "A world of punishment and suffering", 10, 10);
        hell.setRoom(new Room("Starting Room"),5,5);
        worlds.add(hell);
    }

    /**
     * Creates the world "Earth" with all of its rooms
     */
    public void createEarth() {
        World earth = new World("Earth", "The mortal realm",10,10);

        worlds.add(earth);
    }

    /**
     * Creates the world "Heaven" with all of its rooms
     */
    public void createHeaven() {
        World heaven = new World("Heaven", "God's realm", 10,10);

        worlds.add(heaven);
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
