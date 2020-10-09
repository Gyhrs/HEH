package me.tue.inventory;

public class Apparel extends Item {

    private float armorRating;

    public Apparel (String name, float weight, float armorRating) {
        super(name, weight);
        this.armorRating = armorRating;
    }
}
