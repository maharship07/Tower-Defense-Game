package com.example.java;

public class Tower3 implements TowerInterface {
    private int damage = 20;
    private int range = 500;
    private int cost;
    public Tower3(int difficulty) {
        switch (difficulty) {
            case 0:
                cost = 100;
            case 1:
                cost = 200;
            case 2:
                cost = 400;
            default:
                break;
        }
    }

    @Override
    public void attack() {

    }
}
