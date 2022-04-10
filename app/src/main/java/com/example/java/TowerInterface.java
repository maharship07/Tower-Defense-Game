package com.example.java;

import java.util.List;

public interface TowerInterface {
    //define other shared methods

    int getxLoc();
    int getyLoc();
    int damage = 0;
    int range = 1;

    default List<Enemy> attack(List<Enemy> enemyArray) {
        for (int i = 0; i < enemyArray.size(); i++) {
            if (Math.abs(enemyArray.get(i).getxLoc() - getxLoc() - 37.5) < (150*range) &&
                    Math.abs(enemyArray.get(i).getyLoc() - getyLoc() - 37.5) < (150*range) &&
                    enemyArray.get(i).getHealth() != 0) {
                enemyArray.get(i).setHealth(enemyArray.get(i).getHealth()-damage);
                break;
            }
        }
        return enemyArray;
    }

}
