package me.tue.inventory;

import java.util.HashMap;
import java.util.Map;

/**
 * Inventory class that can be implemented in other objects
 * @author Tue & Philip
 */
public class Inventory {
    //Item, Amount
    private final Map<Item, Integer> items;
    private int maxWeight;

    /**
     * Constructor of inventory
     * @param maxWeight The max weight of items in the inventory
     */
    public Inventory(int maxWeight){
        this.items = new HashMap<>();
        this.maxWeight = maxWeight;
    }

    /**
     * Calculates the current weight
     * @return the weight of the inventory
     */
    public double calcWeight(){
        double weight = 0D;
        for(Map.Entry<Item, Integer> entry : this.items.entrySet()){
            weight += entry.getKey().getWeight() * entry.getValue();
        }
        return weight;
    }

    /**
     * Sets the max weight of the invntory
     * @param maxWeight = The max weight in the inventory
     */
    public void setMaxWeight(int maxWeight){
        this.maxWeight = maxWeight;
    }

    /**
     * Gets the amount of the given item in the inventory
     * @param item = The item
     * @return The amount of the given item in the inventory
     */
    public int getAmount(Item item){
        return this.items.get(item);
    }

    /**
     * Return whether or not the inventory contains the item
     * @param item = The item
     * @return = whether or not the inventory contains the item
     */
    public boolean containsItem(Item item){
        return this.items.containsKey(item);
    }

    /**
     * Return whether or not the inventory contains the item
     * A certain amount of items is needed here
     * @param item = the item
     * @param amount = the amount needed
     * @return = whether or not the inventory contains an amount of a given item
     */
    public boolean containsItem(Item item, int amount){
        if(!this.containsItem(item)) return false;
        return this.getAmount(item) == amount;
    }

    /**
     * Adds a item to the inventory
     * @param item = the item
     * @param amount = the amount
     * @return Returns the number of items dropped if items exceed the maxWeight
     */
    public int addItem(Item item, int amount){
        int droppedItems = 0;
        if(this.containsItem(item)){
            double currentWeight = this.calcWeight();
            int weightAfter = (int) Math.floor(currentWeight + (item.getWeight()*amount));
            if(weightAfter > this.maxWeight){
                amount = (int) ((weightAfter-currentWeight)/item.getWeight());
            }
            amount += this.getAmount(item);
            this.items.remove(item);
        }
        this.items.put(item, amount);
        return droppedItems;
    }

    /**
     * Sets the amount for a item in the inventory
     * @param item = the item
     * @param amount = the amount
     */
    public void setAmount(Item item, int amount){
        if(this.containsItem(item)){
            this.removeItem(item);
            this.addItem(item, amount);
        }
    }

    /**
     * Removes a item if the inventory contains the item
     * @param item = the item
     */
    public void removeItem(Item item){
        if(this.containsItem(item)) this.items.remove(item);
    }

    /**
     * Removes a given amount of items from the inventory
     * @param item = the item
     * @param amount = the amount
     */
    public void removeItem(Item item, int amount){
        if(this.containsItem(item)){
            if(this.getAmount(item) > amount){
                this.setAmount(item, amount);
            }else{
                this.removeItem(item);
            }
        }
    }
}
