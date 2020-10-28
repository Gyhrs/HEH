package me.tue.player;

import me.tue.inventory.Inventory;
import me.tue.inventory.Item;
import me.tue.inventory.Weapon;
import me.tue.playarea.Location;
import me.tue.playarea.WorldManager;

/**
 *  A class that tracks the player
 * @author Tue & Philip
 */
public class Player {
    private Location location;
    private final Inventory inventory;
    private int hp = 100;
    private final int baseDamage = 1;

    public Player() {
        this.location = new Location(null, 0, 0);
        this.inventory = new Inventory("Inventory",30);
        this.addTestItems();
    }

    private void addTestItems(){
        Weapon sword = new Weapon("Sword", 10, 5);
        Item stick = new Item("Stick", 0.5F);
        this.getInventory().addItem(sword, 1);
        this.getInventory().addItem(sword, 3);
        this.getInventory().addItem(stick, 3);

    }

    private Weapon getWeapon(){
        return (Weapon) this.getInventory().getItems().keySet().stream()
                .filter(e -> e instanceof Weapon)
                .findFirst()
                .orElse(null);
    }

    public void giveItem(Item item, int amount){
        Weapon currentWeapon = this.getWeapon();
        if(currentWeapon != null){
            this.getInventory().removeItem(currentWeapon);
            WorldManager.getInstance().getRoomFromLocation(this.location).dropItem(currentWeapon);
        }
        this.getInventory().addItem(item, amount);

    }

    public int getHealth(){
        return hp;
    }

    public float getDamage() {
        Weapon currentWeapon = this.getWeapon();
        if(currentWeapon != null){
            return baseDamage + currentWeapon.getDamage();
        }
        return baseDamage;
    }

    public float takeDamage(float damage) {
        hp = (int) Math.floor(hp-damage);
        if(hp <= 0) {
            this.die();
            hp = 0;
        }
        return hp;
    }

    private void die(){

    }


    /**
     * Sets location of player
     * @param location = The location of the player
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * Gets location of player
     * @return The location of the player
     */
    public Location getLocation() {
        return location;
    }


    /**
     * Gets the players inventory
     * @return The players inventory
     */
    public Inventory getInventory() {
        return inventory;
    }
}
