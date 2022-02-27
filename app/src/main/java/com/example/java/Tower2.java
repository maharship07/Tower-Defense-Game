package com.example.java;

public class Tower2 implements TowerInterface{
    private int damage = 50;
    private int range = 100;
    private int cost;
    public Tower2(int difficulty) {
        switch (difficulty) {
            case 0:
                cost = 50;
            case 1:
                cost = 100;
            case 2:
                cost = 200;
            default:
                break;
        }
    }

    @Override
    public void attack() {

    }
}
