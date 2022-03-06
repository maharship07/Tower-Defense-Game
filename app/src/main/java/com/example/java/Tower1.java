package com.example.java;

public class Tower1 implements TowerInterface {
    private int damage = 10;
    private int range = 200;
    private int xLoc;
    private int yLoc;
    public Tower1(int x, int y) {
        xLoc = x;
        yLoc = y;
    }

    @Override
    public void attack() {

    }

    public static int initCost(int difficulty) {
        switch (difficulty) {
        case 0:
            return 25;
        case 1:
            return 50;
        case 2:
            return 100;
        default:
            break;
        }
        return 0;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getxLoc() {
        return xLoc;
    }

    public void setxLoc(int xLoc) {
        this.xLoc = xLoc;
    }

    public int getyLoc() {
        return yLoc;
    }

    public void setyLoc(int yLoc) {
        this.yLoc = yLoc;
    }
}
