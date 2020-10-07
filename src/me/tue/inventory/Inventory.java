package me.tue.inventory;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Inventory {
    //Item, Amount
    private Map<Item, Integer> items;
    private int maxWeight;

    public Inventory(int maxWeight){
        this.items = new HashMap<>();
        this.maxWeight = maxWeight;
    }
    public int getAmount(Item item){
        return this.items.get(item);
    }

    public boolean containsItem(Item item){
        return this.items.containsKey(item);
    }

    public boolean containsItem(Item item, int amount){
        if(!this.containsItem(item)) return false;
        return this.getAmount(item) == amount;
    }

    public void addItem(Item item, int amount){
        if(this.containsItem(item)){
            amount += this.getAmount(item);
            this.items.remove(item);
        }
        this.items.put(item, amount);
    }

    public void removeItem(Item item){

    }
    public void removeItem(Item item, int amount){

    }
}
