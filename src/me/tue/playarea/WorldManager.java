package me.tue.playarea;

import me.tue.Entities.Goblin;
import me.tue.Entities.Spider;

import java.math.RoundingMode;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;
import java.util.List;

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

        Location r13Loc = new Location(hell, 7,5);
        Location r14Loc = new Location(hell, 7,6);
        Location r15Loc = new Location(hell, 7,7);
        Location r16Loc = new Location(hell, 6,7);
        Location r17Loc = new Location(hell, 5,7);
        Location r18Loc = new Location(hell,5,8);

        Location r19Loc = new Location(hell, 2,1);
        Location r20Loc = new Location(hell, 3,1);
        Location r21Loc = new Location(hell, 3,0);
        Location r22Loc = new Location(hell, 4,0);
        Location r23Loc = new Location(hell, 5,0);
        Location r24Loc = new Location(hell, 5,1);
        Location r25Loc = new Location(hell, 4,1);
        Location r26Loc = new Location(hell, 4,2);


        Location r27Loc = new Location(hell, 3,4);
        Location r28Loc = new Location(hell, 2,4);
        Location r29Loc = new Location(hell, 1,4);

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
        r5.addEntities(new Spider(r6Loc));
        r5.addEntities(new Spider(r6Loc));
        r5.addEntities(new Goblin(r6Loc));
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
        hell.createRoom(r12, r12Loc);
        //Creates Room 13...
        Room r13 = new Room("North of The Old Hut (TP2)");
        r13.setExits("south", r14Loc);
        r13.setExits("north", r19Loc);
        hell.createRoom(r13, r13Loc);
        //Creates Room 14...
        Room r14 = new Room("Old Man's Hut");
        r14.setExits("south", r15Loc);
        r14.setExits("west", r27Loc);
        r14.setExits("north", r13Loc);
        hell.createRoom(r14, r14Loc);
        //Creates Room 15...
        Room r15 = new Room("Entrance to satanic church");
        r15.setExits("west", r16Loc);
        hell.createRoom(r15, r15Loc);
        //Creates Room 16...
        Room r16 = new Room("Great fight in the church");
        r16.setExits("west", r17Loc);
        hell.createRoom(r16, r16Loc);
        //Creates Room 17...
        Room r17 = new Room("Big boss at the altar");
        r17.setExits("south", r18Loc);
        hell.createRoom(r17, r17Loc);
        //Creates Room r18...
        Room r18 = new Room("Loot room Swamp");
        r18.setExits("north", r17Loc);
        r18.setExits("east", r14Loc);
        hell.createRoom(r18, r18Loc);
        //Creates Room 19...
        Room r19 = new Room("Outside Lucifer's castle Gate");
        r19.setExits("east", r20Loc);
        r19.setExits("south", r13Loc);
        hell.createRoom(r19, r19Loc);
        //Creates Room 20...
        Room r20 = new Room("Inside hallway");
        r20.setExits("north", r21Loc);
        r20.setExits("east", r19Loc);
        hell.createRoom(r20, r20Loc);
        //Creates Room 21...
        Room r21 = new Room("Left wing");
        r21.setExits("east", r22Loc);
        hell.createRoom(r21, r21Loc);
        //Creates Room 22...
        Room r22 = new Room("Left wing pt 2");
        r22.setExits("west", r23Loc);
        hell.createRoom(r22, r22Loc);
        //Creates Room 23...
        Room r23 = new Room("Left wing pt 3");
        r23.setExits("south", r24Loc);
        hell.createRoom(r23, r23Loc);
        //Creates Room 24...
        Room r24 = new Room("Behind Throne Room");
        r24.setExits("west", r25Loc);
        hell.createRoom(r24, r24Loc);
        //Creates Room 25...
        Room r25 = new Room("Lucifer's Throne Room");
        r25.setExits("west", r20Loc);
        r25.setExits("south", r26Loc);
        hell.createRoom(r25, r25Loc);
        //Creates Room 26...
        Room r26 = new Room("Lucifer's Loot");
        r26.setExits("north", r5Loc);
        hell.createRoom(r26, r26Loc);
        //Creates Room 27...
        Room r27 = new Room("Gateway Entrance");
        r27.setExits("west", r28Loc);
        hell.createRoom(r27, r27Loc);
        //Creates Room 28...
        Room r28 = new Room("Gate Guardian");
        r28.setExits("west", r29Loc);
        hell.createRoom(r28, r28Loc);
        //Creates Room 29...
        Room r29 = new Room("Gate to Earth");
        hell.createRoom(r29, r29Loc);
        /*r29.setExits("up", e1Loc);
        */
        hell.setStartLocation(8,0);
        return hell;
    }
    /**
     * Creates the world "Earth" with all of its rooms
     */
    public World createEarth() {
        World earth = new World("Earth", "The mortal realm",10,10);

        Location e1Loc = new Location(earth, 0,0);
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

    public List<World> getWorlds() {
        return worlds;
    }

    public Room getRoomFromLocation(Location location){
        World world = this.getWorlds().stream().filter(w -> w.equals(location.getWorld())).findFirst().orElse(null);
        if(world == null) return null;
        return world.getRoom(location.getX(), location.getY());
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
