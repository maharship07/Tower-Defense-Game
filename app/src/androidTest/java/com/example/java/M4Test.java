package com.example.java;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class M4Test  {
    @Rule
    public ActivityTestRule<ConfigScreen> activityRule2 =
            new ActivityTestRule(GameOverScreen.class);

    @Test // M4 Test made by Manu Gupta
    public void testEnemyLocationSetter() {
        Enemy testEnemy = new Enemy1(); //xLoc should be 37.5 and yLoc should be 337.5;
        testEnemy.setxLoc(100);
        testEnemy.setyLoc(50);
        assertTrue(testEnemy.getxLoc() == 100);
        assertTrue(testEnemy.getyLoc() == 50);
    }

    @Test // M4 Test made by Manu Gupta
    public void testEnemyHealth() {
        Enemy testEnemy = new Enemy2(); //health 20 and damage is 10
        int enemyDamage = testEnemy.getDamage();
        int enemyHealth = testEnemy.getHealth();
        testEnemy.setHealth(enemyHealth - enemyDamage);
        assertTrue(testEnemy.getHealth() == 10);
    }

    @Test // M4 Test by Maharshi Patel
    public void testDamageToMonument() {
        Enemy testEnemy = new Enemy3();
        int enemyDamage = testEnemy.getDamage();
        int monumentHealth = 50;
        int remainingHealth = (monumentHealth - enemyDamage);
        assertTrue(remainingHealth == 35);
    }

    @Test // M4 Test by Maharshi Patel
    public void testRestartButton() {
        Enemy testEnemy = new Enemy3();
        int enemyDamage = testEnemy.getDamage();
        int monumentHealth = 15;
        int remainingHealth = (monumentHealth - enemyDamage);
        boolean flag;

        if (remainingHealth == 0) {
            onView(withId(R.layout.game_over_screen));
            onView(withId(R.id.restartButton)).perform(click());
            flag = true;
        } else {
            flag = false;
        }
        assertTrue(flag);
    }

     @Test  // M4 Test by Vedant Amin
    public void testGameOverScreen() {
        Enemy testEnemy = new Enemy1();
        int enemyDamage = testEnemy.getDamage();
        int monumentHealth = 50;
        for (int i = 0; i < 5; i++) {
            monumentHealth -= enemyDamage;
        }
        if (monumentHealth == 0) {
            onView(withId(R.layout.game_over_screen));
            assertTrue(true);
        }
    }

    @Test  // M4 Test by Vedant Amin
    public void testMonumentHealth() {
        Enemy testEnemy = new Enemy2();
        int enemyDamage = testEnemy.getDamage();
        int monumentHealth = 50;
        for (int i = 0; i < 5; i++) {
            monumentHealth -= enemyDamage;
        }
    }

}

