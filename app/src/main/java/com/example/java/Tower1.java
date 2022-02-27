package com.example.java;

public class Tower1 implements TowerInterface{
    private int damage = 10;
    private int range = 200;
    private int cost;
    public Tower1(int difficulty) {
        switch (difficulty) {
            case 0:
                cost = 25;
            case 1:
                cost = 50;
            case 2:
                cost = 100;
            default:
                break;
        }
    }

    @Override
    public void attack() {

    }
}
