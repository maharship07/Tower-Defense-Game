package com.example.java;

import static org.junit.Assert.assertEquals;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

@RunWith(AndroidJUnit4.class)
public class M6Test {
    @Rule
    public ActivityTestRule<GameScreen> activityRule2 =
            new ActivityTestRule<>(GameScreen.class);


    @Test //M6 Test by Manu Gupta
    public void upgradeDamageTest() {
        TowerInterface tower = new Tower1(1200, 450);
        assertEquals(tower.getDamage(), 5);
        Upgrade upgrade = new UpgradeDamage();
        upgrade.upgrade(tower);
        assertEquals(tower.getDamage(), 10);
        upgrade.upgrade(tower);
        assertEquals(tower.getDamage(), 10);
    }

    @Test //M6 Test made by Manu Gupta
    public void upgradeRangeTest() {
        TowerInterface tower = new Tower2(1200, 450);
        assertEquals(tower.getRange(), 1);
        Upgrade upgrade = new UpgradeRange();
        upgrade.upgrade(tower);
        assertEquals(tower.getRange(), 2);
        upgrade.upgrade(tower);
        assertEquals(tower.getRange(), 2);
    }

    @Test
    public void enemiesKilledTest() {
        GameScreen gameScreen = activityRule2.getActivity();
        List<Enemy> enemyList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            enemyList.add(new Enemy1());
        }
        enemyList.get(2).setHealth(0);
        enemyList.get(3).setHealth(0);
        gameScreen.setEnemyArray(enemyList);
        gameScreen.removeDeadEnemies();
        assertEquals(gameScreen.getNumEnemiesKilled(), 2);
    }

    @Test
    public void TotalDamageTakenTest() {
        GameScreen gameScreen = activityRule2.getActivity();
        Enemy1 enemy1 = new Enemy1();
        Enemy2 enemy2 = new Enemy2();
        Enemy3 enemy3 = new Enemy3();
        gameScreen.attack(enemy1);
        gameScreen.attack(enemy2);
        gameScreen.attack(enemy3);
        assertEquals(gameScreen.getTotalDamageTaken(), (enemy1.getDamage() + enemy2.getDamage()
                + enemy3.getDamage()));
    }
}
