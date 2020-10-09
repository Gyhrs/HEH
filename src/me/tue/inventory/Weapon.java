package me.tue.inventory;

public class Weapon extends Item {
    protected float damage;

    public Weapon(String name, float weight, float damage) {
        super(name, weight);
        this.damage = damage;
    }

    public float getDamage() {
        return damage;
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }
}
