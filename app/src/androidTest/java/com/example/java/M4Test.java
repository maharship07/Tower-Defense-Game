package com.example.java;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class M4Test  {
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


}

