package com.example.java;

public class Tower3 implements TowerInterface {
    private int damage = 20;
    private int range = 500;
    private float x_loc;
    private float y_loc;
    public Tower3(float x, float y) {
        x_loc = x;
        y_loc = y;
    }

    @Override
    public void attack() {

    }

    public static int initCost(int difficulty){
        switch (difficulty) {
            case 0:
                return 100;
            case 1:
                return 200;
            case 2:
                return 400;
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

    public float getX_loc() {
        return x_loc;
    }

    public void setX_loc(int x_loc) {
        this.x_loc = x_loc;
    }

    public float getY_loc() {
        return y_loc;
    }

    public void setY_loc(int y_loc) {
        this.y_loc = y_loc;
    }
}
