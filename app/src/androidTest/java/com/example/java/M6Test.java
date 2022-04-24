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


}
