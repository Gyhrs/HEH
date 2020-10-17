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
        World hell = new World("Hell", "A world of punishment and suffering", 9, 9);
        Location r1Loc = new Location(hell, 8,0);
        Location r2Loc = new Location(hell, 8,1);
        Location r3Loc = new Location(hell, 8,2);
        Location r4Loc = new Location(hell, 8,3);

        Location r5Loc = new Location(hell, 7,1);
        Location r6Loc = new Location(hell, 7,2);
        Location r7Loc = new Location(hell, 7,3);

        Location r8Loc = new Location(hell, 6,2);
        Location r9Loc = new Location(hell, 6,3);
        Location r10Loc = new Location(hell, 6,4);

        Location r11Loc = new Location(hell, 5,3);
        Location r12Loc = new Location(hell, 5,4);

        // Creates Room 1 and sets locations
        Room r1 = new Room("Starting Room");
        r1.setExits("south", r2Loc);
        hell.createRoom(r1, r1Loc);
        // Creates Room 2...
        Room r2 = new Room("Cell gaurd room");
        r2.setExits("north", r1Loc);
        r2.setExits("south", r3Loc);
        r2.setExits("west", r5Loc);
        hell.createRoom(r2,r2Loc);
        //Creates Room 3...
        Room r3 = new Room("Empty room");
        r3.setExits("north", r2Loc);
        r3.setExits("south", r4Loc);
        hell.createRoom(r3,r3Loc);
        //Creates Room 4...
        Room r4 = new Room("Prisoner storage");
        r4.setExits("north", r3Loc);
        r4.setExits("west", r7Loc);
        hell.createRoom(r4,r4Loc);
        //Creates Room 5...
        Room r5 = new Room("Secret tunnel");
        r5.setExits("south", r6Loc);
        hell.createRoom(r5,r5Loc);
        //Creates Room 6...
        Room r6 = new Room("Kitchen");
        r6.setExits("north", r5Loc);
        r6.setExits("south", r7Loc);
        r6.setExits("west", r8Loc);
        hell.createRoom(r6,r6Loc);
        //Creates Room 7...
        Room r7 = new Room("Canteen");
        r7.setExits("north", r6Loc);
        //r7.setExits("east", r4Loc);
        r7.setExits("west", r9Loc);
        //r7.setExits("west", r6Loc);
        hell.createRoom(r7,r7Loc);
        //Creates Room 8...
        Room r8 = new Room("Cell hall");
        r8.setExits("east", r6Loc);
        r8.setExits("south", r9Loc);
        hell.createRoom(r8,r8Loc);
        //Creates Room 9...
        Room r9 = new Room("Boss warden");
        r9.setExits("west", r11Loc);
        r9.setExits("south", r10Loc);
        hell.createRoom(r9,r9Loc);
        //Creates Room 10...
        Room r10 = new Room("Loot room");
        r10.setExits("north", r9Loc);
        hell.createRoom(r10,r10Loc);
        //Creates Room 11...
        Room r11 = new Room("Reception");
        r11.setExits("east", r9Loc);
        r11.setExits("south", r12Loc);
        hell.createRoom(r11,r11Loc);
        //Creates Room 11...
        Room r12 = new Room("Outside");
        //r12.setExits("tp", r13Loc);
        hell.createRoom(r12,r12Loc);


        hell.setStartLocation(8,0);
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
