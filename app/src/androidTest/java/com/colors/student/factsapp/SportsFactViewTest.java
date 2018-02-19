package com.colors.student.factsapp;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Helena on 19/02/18.
 */
@RunWith(AndroidJUnit4.class)
public class SportsFactViewTest {
    public ActivityTestRule mActivityRule = new ActivityTestRule(FactActivity.class, false, false);

    @Before
    public void init() {
        Intent intent = new Intent();
        intent.putExtra("category", "Sports");
        mActivityRule.launchActivity(intent);
    }

    @Test
    public void LaunchFactView(){
        onView(withId(R.id.category)).check(matches(withText("Sports")));
    }
}
