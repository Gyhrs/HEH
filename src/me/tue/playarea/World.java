package me.tue.playarea;

import java.util.*;

public class World {

    private final String name;
    private final String description;
    private final int height;
    private final int width;
    private final Room[][] worldLayout;
    private int startX = -1;
    private int startY = -1;

    /**
     * Constructor
     * @param name = The name of the world
     * @param description = The description of the world
     * @param w = The width of the world
     * @param h = The height of the world
     */
    public World(String name, String description, int w, int h) {
        this.name = name;
        this.description = description;
        this.height = h;
        this.width = w;
        worldLayout = new Room[width][height];
    }

    public String getName() {
        return name;
    }

    public Room[][] getRooms(){
        return this.worldLayout;
    }

    @Override
    public String toString(){
        return "{Name: " + this.name + ", width: " + this.width + ", height: " + this.height + ", rooms: " + Arrays.toString(worldLayout) + "}";
    }

    public String getDescription() {
        return description;
    }

    /**
     * Sets the location the player starts on.
     * @param x = The x value of the starting room
     * @param y = The y value of the starting room
     */
    public void setStartLocation(int x, int y){
        this.startX = x;
        this.startY = y;
    }

    /**
     * Gets the starting room
     * @return the starting room
     */
    public Room getStartRoom(){
        if(this.startX < 0 || this.startY < 0) return null;
        return this.getRoom(this.startX, this.startY);
    }

    /**
     * Gets a room from the worldLayout
     * @param x = The x value of the room
     * @param y = The y value of the room
     * @return the room at the given location
     */
    public Room getRoom(int x, int y){
        return this.worldLayout[x][y];
    }

    /**
     * Sets a room at a given location
     * @param room = The room that needs to be set
     * @param x = The x value of the location of the room
     * @param y = The y value of the location of the room
     */
    public void createRoom(Room room, int x, int y) {
        worldLayout[x][y] = room;
    }

    public void createRoom(Room room, Location loc) {
        this.createRoom(room, loc.getX(), loc.getY());
    }

    /**
     * Return the start location
     * @return = Returns the start location
     */
    public Location getStartLocation() {
        return new Location(this,startX,startY);
    }

    private Room[][] switchCords(Room[][] rooms){
        Room[][] switched = new Room[height][width];
        for (int x = 0; x < rooms.length; x++){
            Room[] xRooms = rooms[x];
            for(int y = 0; y < xRooms.length; y++){
                Room room = xRooms[y];
                switched[y][x] = room;
            }
        }
        return switched;
    }

    public List<String> generateMap(Location currentLoc, boolean betaMap){
        if(betaMap){
            Location clonedLoc = currentLoc.clone();
            boolean hasExists = true;
            int minX = -1;
            int maxX = -1;
            int minY = -1;
            int maxY = -1;
            Room currentRoom = this.getRoom(clonedLoc.getX(), clonedLoc.getY());
            List<Location> foundLocation = new ArrayList<>();
            System.out.println(foundLocation.stream().toString());
            while (hasExists){
                hasExists = false;
                for(Location loc : currentRoom.getExits()){
                    if(foundLocation.contains(loc)) continue;
                    int x = loc.getX();
                    int y = loc.getY();
                    if(minX > x || minX == -1) minX = x;
                    if(maxX < x || maxX == -1) maxX = x;
                    if(minY > y || minY == -1) minY = y;
                    if(maxY < y || maxY == -1) maxY = y;
                    foundLocation.add(loc);
                    currentRoom = this.getRoom(loc.getX(), loc.getY());
                    hasExists = true;
                }
            }
            if(minX  < 0 || minY < 0 || maxX < 0 || maxY < 0) return this.generateMap(currentLoc);
            int mapHeight = (maxY-minY)+1;
            int mapWidth = (maxX-minX)+1;
            System.out.println("Height: " + mapHeight + " / Width: " + mapWidth);
            Room[][] rooms = new Room[mapHeight][mapWidth];


            /*Min: 5x
            Max: 7x
            Diff: 2x

            6-5

             */
            for(Location loc : foundLocation){
                Room room = this.getRoom(loc.getX(), loc.getY());
                if(room == null) continue;
                int y = loc.getY()-minY;
                int x = loc.getX()-minX;
                System.out.println("x: " + x + " / y: " + y);
                rooms[y][x] = room;
            }
            clonedLoc.setX(clonedLoc.getX()-minX);
            clonedLoc.setY(clonedLoc.getY()-minY);
            return this.generateMap(rooms, clonedLoc);
        }
        return this.generateMap(currentLoc);
    }

    public List<String> generateMap(Location currentLoc){

        Room[][] switchedCords = this.switchCords(this.getRooms());
        return this.generateMap(switchedCords, currentLoc);
    }

    public List<String> generateMap(Room[][] rooms, Location currentLoc){
        List<String> mapList = new ArrayList<>();

        for (int y = 0; y < rooms.length; y++){
            Room[] yRooms = rooms[y];
            StringJoiner sj = new StringJoiner(".", "[", "]");
            for(int x = 0; x < yRooms.length; x++){
                Room room = yRooms[x];
                if(room == null) {
                    sj.add(" ");
                    continue;
                }
                if(currentLoc != null && currentLoc.getWorld().name.equals(this.getName())){
                    if(currentLoc.getX() == x && currentLoc.getY() == y){
                        sj.add("P");
                        continue;
                    }
                }
                if(this.startX == x && this.startY == y){
                    sj.add("S");
                    continue;
                }

                sj.add("R");
            }
            mapList.add(sj.toString());
        }
        return mapList;
    }
}
