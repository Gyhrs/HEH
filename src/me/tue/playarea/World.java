package me.tue.playarea;

public class World {

    private final String name;
    private final String description;
    private int height;
    private int width;
    private Room[][] worldLayout;

    public World(String name, String description, int w, int h) {
        this.name = name;
        this.description = description;
        this.height = h;
        this.width = w;
        Room[][] worldLayout = new Room[width][height];
    }

    public void setRoom(Room room, int x, int y) {
        worldLayout[x][y] = room;
    }
}
