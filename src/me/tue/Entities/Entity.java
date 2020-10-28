package me.tue.Entities;

import me.tue.playarea.Location;
import me.tue.utils.ImageUtil;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

public abstract class Entity {
    protected Location location;
    protected boolean alive;
    protected String race;
    protected boolean hostile;
    private String iconPath;

    public Entity(String race, Location location, boolean isHostile) {
        this.location = location;
        this.alive = true;
        this.race = race;
        this.hostile = isHostile;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public String displayName() {
        return race + (hostile? " [Hostile]": "");
    }

    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }

    public boolean isAlive() {
        return alive;
    }
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public String getRace() {
        return this.race;
    }
    public void setRace(String race){ this.race = race;}

    public boolean getHostile(){return hostile;}
    public void setHostile(boolean hostile){this.hostile = hostile;}

    public void kill() {
        setAlive(false);
        setLocation(null);
        ImageUtil.displayImage("images/death.jpg");
    }
}
