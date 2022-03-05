package com.example.java;

public class Tower1 implements TowerInterface{
    private int damage = 10;
    private int range = 200;
    private int x_loc;
    private int y_loc;
    public Tower1(int x, int y) {
        x_loc = x;
        y_loc = y;
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

    public int getX_loc() {
        return x_loc;
    }

    public void setX_loc(int x_loc) {
        this.x_loc = x_loc;
    }

    public int getY_loc() {
        return y_loc;
    }

    public void setY_loc(int y_loc) {
        this.y_loc = y_loc;
    }
}
