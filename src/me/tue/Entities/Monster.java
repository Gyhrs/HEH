package me.tue.Entities;

import me.tue.playarea.Location;

public class Monster extends Entity {
    protected float damage;
    protected int hp;

    public Monster(String race, Location location, float damage, int hp) {
        super(race, location, true);
        this.damage = damage;
        this.hp = hp;
    }

    public int getHealth(){
        return hp;
    }

    public float getDamage() {
        return damage;
    }

    public float takeDamage(float damage) {
        hp = (int) Math.floor(hp-damage);
        if(hp <= 0) {
            super.kill();
            hp = 0;
        }
        return hp;
    }

    public void flee() {
        super.kill();
    }
}
