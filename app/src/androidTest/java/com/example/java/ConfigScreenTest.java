package com.example.java;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import android.app.Activity;
import android.content.Context;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ConfigScreenTest  {
    private Activity mActivity;

    @Rule
    public ActivityScenarioRule<ConfigScreen> activityRule =
            new ActivityScenarioRule<ConfigScreen>(ConfigScreen.class);

    @Test
    public void testNormalName() {
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.playerName)).perform(typeText("Yay"));
        onView(withId(R.id.normalButton)).perform(click());
        onView(withId(R.id.healthCounter)).check(matches(isDisplayed()));
    }

    @Test
    public void testBlankName() {
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.playerName)).perform(typeText(""));
        onView(withId(R.id.normalButton)).perform(click());
        onView(withId(R.id.normalButton)).check(matches(isDisplayed()));
    }

    @Test
    public void testWhiteSpaceName() {
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.playerName)).perform(typeText("   "));
        onView(withId(R.id.normalButton)).perform(click());
        onView(withId(R.id.normalButton)).check(matches(isDisplayed()));
    }

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.java", appContext.getPackageName());
    }


}


