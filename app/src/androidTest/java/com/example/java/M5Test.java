package com.example.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

@RunWith(AndroidJUnit4.class)
public class M5Test {
    @Rule
    public ActivityTestRule<GameScreen> activityRule2 =
            new ActivityTestRule<>(GameScreen.class);

    public List<Enemy> enemyListSetup() {
        List<Enemy> enemyList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            enemyList.add(new Enemy1());
        }
        enemyList.get(4).setxLoc(750);
        enemyList.get(4).setyLoc(150);
        enemyList.get(3).setxLoc(1050);
        enemyList.get(3).setyLoc(450);
        enemyList.get(2).setxLoc(1200);
        enemyList.get(2).setyLoc(600);
        enemyList.get(1).setxLoc(1350);
        enemyList.get(1).setyLoc(450);
        enemyList.get(0).setxLoc(1650);
        enemyList.get(0).setyLoc(150);
        return enemyList;
    }

    @Test //M5 Test by Ian Westcott
    public void tower1AttackTest() {
        TowerInterface tower = new Tower1(1200, 450);
        List<Enemy> enemyList = enemyListSetup();
        List<Float> attackArray = new ArrayList<>();
        tower.attack(enemyList, attackArray);
        assertEquals(enemyList.get(0).getHealthPercentage(), 1, 0);
        assertNotEquals(enemyList.get(1).getHealthPercentage(), 1);
        assertEquals(enemyList.get(2).getHealthPercentage(), 1, 0);
        assertEquals(enemyList.get(3).getHealthPercentage(), 1, 0);
        assertEquals(enemyList.get(4).getHealthPercentage(), 1, 0);
    }

    @Test //M5 Test by Ian Westcott
    public void tower2AttackTest() {
        TowerInterface tower = new Tower2(1200, 450);
        List<Enemy> enemyList = enemyListSetup();
        List<Float> attackArray = new ArrayList<>();
        tower.attack(enemyList, attackArray);
        assertEquals(enemyList.get(0).getHealthPercentage(), 1, 0);
        assertNotEquals(enemyList.get(1).getHealthPercentage(), 1);
        assertNotEquals(enemyList.get(2).getHealthPercentage(), 1);
        assertNotEquals(enemyList.get(3).getHealthPercentage(), 1);
        assertEquals(enemyList.get(4).getHealthPercentage(), 1, 0);
    }
}
