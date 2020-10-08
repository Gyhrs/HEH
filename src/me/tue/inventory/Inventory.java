package me.tue.inventory;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

/**
 * Inventory class that can be implemented in other objects
 * @author Tue & Philip
 */
public class Inventory {
    //Item, Amount
    private final Map<Item, Integer> items;
    private int maxWeight;
    private String displayName;

    /**
     * Constructor of inventory
     * @param maxWeight The max weight of items in the inventory
     */
    public Inventory(String displayName, int maxWeight){
        this.displayName = displayName;
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
     * @return whether or not the item was added
     */
    public boolean addItem(Item item, int amount){
        if(canAddItem(item, amount)){
            if(this.containsItem(item)){
                amount += this.getAmount(item);
            }
            this.setItem(item, amount);
            return true;
        }
        return false;

    }

    public boolean canAddItem(Item item, int amount){
        return (this.calcWeight() + item.getWeight()*amount) < this.maxWeight;
    }

    public void setItem(Item item, int amount){
        if(this.containsItem(item)){
            this.removeItem(item);
        }
        this.getItems().put(item, amount);
    }

    /**
     * Sets the amount for a item in the inventory
     * @param item = the item
     * @param amount = the amount
     */
    public void setAmount(Item item, int amount){
        if(this.containsItem(item)){
            this.removeItem(item);
            this.getItems().put(item, amount);
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

    public Map<Item, Integer> getItems() {
        return items;
    }

    public void display(){
        String weight = " Weight: " + this.calcWeight() + " ";
        int difference = (this.getDisplayName().length()-weight.length())/2;

        difference += 7; //6 (------) +1
        String s = String.join("", Collections.nCopies(difference, "-"));
        weight = s + weight + s;
        System.out.println("------ " + this.getDisplayName() + " -------");
        int size = this.getItems().size();
        if(this.getItems().isEmpty()){
            System.out.println("| NO ITEMS IN THE INVENTORY |");
        }else{
            int rows = size/9;
            for(int i = 0; i<rows+1; i++){
                int j = 0;
                StringJoiner sj = new StringJoiner(", ", "| ", " |");
                for(Map.Entry<Item, Integer> entry : this.getItems().entrySet()){
                    if(j < (i*9) || j >= ((i+1)*9)) continue;
                    sj.add(entry.getKey().getDisplayName() + "x" + entry.getValue());
                }
                System.out.println(sj.toString());
            }
        }

        System.out.println(weight);

    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
