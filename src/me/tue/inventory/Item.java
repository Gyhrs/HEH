package me.tue.inventory;

public class Item {

    private String displayName;
    private double weight;

    public Item(String displayName, double weight){
        this.displayName = displayName;
        this.weight = weight;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
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
