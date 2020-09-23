package me.tue.playarea;

public class World {

    private final String name;
    private final String description;
    private int height;
    private int width;
    private Room[][] worldLayout;
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
    public void setRoom(Room room, int x, int y) {
        worldLayout[x][y] = room;
    }
}
