package com.colors.student.factsapp;

import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertEquals;

/**
 * Created by Peteris on 18.23.2.
 *
 * There may be a problem(the test will pass, but it wont really check anything) if the device(virtual) has already voted on all of the available facts
 * One run of test upvotes exactly one random fact and downvotes exactly one random fact
 */

@RunWith(AndroidJUnit4.class)
public class applyVotesTest {

    @Rule
    public ActivityTestRule<LoadingActivity> mActivityTestRule = new ActivityTestRule<>(LoadingActivity.class);

    @Before
    public void setUp() throws Exception {
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withId(R.id.skipLogin)).perform(ViewActions.click());
        onView(withId(R.id.politicsBtn)).perform(ViewActions.click());
    }

    @Test
    public void applyVotesTester(){
        int i=0;
        while(true){
            onView(withId(R.id.getFact)).perform(ViewActions.click());
            onView(withId(R.id.voteUpBtn)).perform(ViewActions.click());
            if(FactActivity.toastTestMsg.equals("Applied vote"))break;
            i++;
            if(i>100)return;
        }
        onView(withId(R.id.voteUpBtn)).perform(ViewActions.click());
        assertEquals("You have already voted", FactActivity.toastTestMsg);

        i=0;
        while(true){
            onView(withId(R.id.getFact)).perform(ViewActions.click());
            onView(withId(R.id.voteDownBtn)).perform(ViewActions.click());
            if(FactActivity.toastTestMsg.equals("Applied vote"))break;
            i++;
            if(i>100)return;
        }
        onView(withId(R.id.voteUpBtn)).perform(ViewActions.click());
        assertEquals("You have already voted", FactActivity.toastTestMsg);
    }
}
