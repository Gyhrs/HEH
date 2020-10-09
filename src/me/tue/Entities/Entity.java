package me.tue.Entities;

import me.tue.playarea.Location;

public class Entity {
    protected String race;
    protected Location location;
    protected boolean alive;

    public Entity(String race, Location location) {
        this.race = race;
        this.location = location;
        this.alive = true;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}
