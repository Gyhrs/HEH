package me.tue.playarea;

import me.tue.Entities.Entity;
import me.tue.Entities.Monster;
import me.tue.inventory.Item;

import java.util.*;

/**
 *  Tracks all info on a room
 *  Stores exits in a Hashmap
 * @author Tue & Philip
 */
public class Room {
    private final String description;
    private final HashMap<String, Location> exits;
    private final List<Entity> entities;
    private final List<Item> itemsOnFloor;

    /**
     * Constructor
     * @param description = The description of the room
     */
    public Room(String description) {
        this.description = description;
        exits = new HashMap<>();
        entities = new ArrayList<>();
        itemsOnFloor = new ArrayList<>();
    }

    public List<Item> getItemsOnFloor() {
        return itemsOnFloor;
    }
    public void dropItem(Item item){
        this.getItemsOnFloor().add(item);
    }

    public void removeItem(Item item){
        this.getItemsOnFloor().remove(item);
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public boolean containsHostileMonsters(){
        if(this.getEntities() == null || this.getEntities().isEmpty()) return false;
        for(Entity e : this.getEntities()){
            if(e instanceof Monster && e.getHostile()) return true;
        }
        return false;
    }

    public boolean hasEntities(){
        return this.getEntities() != null && !this.getEntities().isEmpty();
    }

    public void addEntities(Entity entity){
        this.getEntities().add(entity);
    }

    public void displayEntities(){
        this.displayEntities(false);
    }

    public void displayEntities(boolean hostileOnly) {
        System.out.println("Entities in the room: ");
        int id = 0;
        for(int i=0; i<entities.size(); i++) {
            Entity entity = entities.get(i);
            if(hostileOnly && !(entity instanceof Monster && entity.getHostile())) continue;
            id++;
            String hp = (entity instanceof Monster ? (((Monster) entity).getHealth() + " hp") : "");
            String message = "["+id+"] - " + entity.displayName() + " " + hp;
            System.out.println(message);
        }
    }

    /**
     * Gets the description of the room
     * @return the description of the room
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the exit locations
     * @param direction
     * @return
     */
    public Location getExit(String direction){
        return this.exits.get(direction.toUpperCase());
    }

    public Collection<Location> getExits(){
        return exits.values();
    }

    /**
     * Sets exits for room
     * @param direction = Which direction the exit is
     * @param loc = Which x,y coordinate the exit leads to
     */
    public void setExits(String direction, Location loc ) {
        exits.put(direction.toUpperCase(), loc);
    }

    public String getExitString(){
        return "{" + Arrays.toString(exits.keySet().toArray()) + "}";
    }

    @Override
    public String toString() {
        return "Room{" +
                "description='" + description + '\'' +
                ", exits=" + exits +
                ", entities=" + entities +
                ", itemsOnFloor=" + itemsOnFloor +
                '}';
    }
}
