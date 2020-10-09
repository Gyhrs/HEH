package me.tue.Entities;

import me.tue.playarea.Location;

public class Monster extends Entity {
    protected float damage;
    protected int hp;

    public Monster(String race, Location location, float damage, int hp) {
        super(race, location);
        this.damage = damage;
        this.hp = hp;
    }

    public float dealDamage() {
        return damage;
    }

    public void flee() {

    }
}
