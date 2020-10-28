package me.tue.Entities;

import me.tue.playarea.Location;

public class Spider extends Monster {

    public Spider(Location location) {
        super("Spider",location, 1, 10);
        super.setIconPath("images/spider.jpeg");
    }


}
