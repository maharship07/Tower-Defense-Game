package com.example.java;

import java.util.List;
//Regular Projectile Tower
public class Tower1 implements TowerInterface {
    private int damage = 5;
    private int range = 3;
    private int xLoc;
    private int yLoc;
    public Tower1(int x, int y) {
        xLoc = x;
        yLoc = y;
    }

    @Override
    public List<Enemy> attack(List<Enemy> enemyArray) {
        for (int i = 0; i < enemyArray.size(); i++) {
            if (Math.abs(enemyArray.get(i).getxLoc() - xLoc - 37.5) < (150*range) &&
                    Math.abs(enemyArray.get(i).getyLoc() - yLoc - 37.5) < (150*range) &&
                            enemyArray.get(i).getHealth() != 0) {
                enemyArray.get(i).setHealth(enemyArray.get(i).getHealth()-damage);
                break;
            }
        }
        return enemyArray;
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
