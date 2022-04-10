package com.example.java;

import java.util.List;

public interface TowerInterface {
    //define other shared methods
    List<Enemy> attack(List<Enemy> enemyArray);
    int getxLoc();
    int getyLoc();
}
