package me.tue.playarea;

import java.util.ArrayList;

public class WorldManager {
    private static WorldManager instance = null;
    private ArrayList<World> worlds;

    public WorldManager() {
        worlds = new ArrayList<>();
    }

    public void createHell() {
        World hell = new World("Hell", "A world of punishment and suffering", 10, 10);
        hell.setRoom(new Room("Starting Room"),5,5);

        worlds.add(hell);
    }

    public void createEarth() {
        World earth = new World("Earth", "The mortal realm",10,10);

        worlds.add(earth);
    }

    public void createHeaven() {
        World heaven = new World("Heaven", "God's realm", 10,10);

        worlds.add(heaven);
    }

    public static WorldManager getInstance(){
        if(instance == null) instance = new WorldManager();
        return instance;
    }
}
