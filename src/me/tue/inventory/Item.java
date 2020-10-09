package me.tue.inventory;

public class Item {

    protected String displayName;
    protected float weight;

    public Item(String displayName, float weight){
        this.displayName = displayName;
        this.weight = weight;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Item{" +
                "displayName='" + displayName + '\'' +
                ", weight=" + weight +
                '}';
    }
}
