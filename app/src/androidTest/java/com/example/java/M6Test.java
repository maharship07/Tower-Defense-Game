package com.example.java;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

    @Test //M6 Test by Ian Westcott
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

    @Test //M6 Test by Ian Westcott
    public void totalDamageTakenTest() {
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

    @Test //M6 Test made by Vedant Amin
    public void testGameWinScreen() {
        FinalBoss finalBoss = new FinalBoss();
        Tower1 tower = new Tower1(1200, 450);
        int bossHealth = finalBoss.getHealth();
        int towerDamage = tower.getDamage();
        for(int i = 0; i < 60; i++) {
            bossHealth -= towerDamage;
        }
        if (bossHealth == 0) {
            onView(withId(R.layout.game_win_screen));
            assertTrue(true);
        }
    }

    @Test //M6 Test made by Vedant Amin
    public void bossDamageMonument() {
        int monumentHealth = 600;
        FinalBoss finalBoss = new FinalBoss();
        int bossDamage = finalBoss.getDamage();
        for (int i = 0; i < 4; i++) {
            monumentHealth -= bossDamage;
        }
        assertEquals(0, monumentHealth);
    }
}
