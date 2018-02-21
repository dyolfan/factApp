package com.colors.student.factsapp;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainMenuButtonTest {

    @Rule
    public ActivityTestRule<LoadingActivity> mActivityTestRule = new ActivityTestRule<>(LoadingActivity.class);

    @Test
    public void mainMenuButtonTest() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatTextView = onView(
                allOf(withId(R.id.skipLogin), withText("Skip"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        2),
                                0),
                        isDisplayed()));
        appCompatTextView.perform(click());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.topfactsBtn), withText("Top facts"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.mainMenu),
                                        0),
                                0),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatImageButton = onView(
                allOf(withId(R.id.toMainMenuBtn),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.toolbar3),
                                        0),
                                1),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.sportsBtn), withText("Sports"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.mainMenu),
                                        0),
                                1),
                        isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction appCompatImageButton2 = onView(
                allOf(withId(R.id.backBtn),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.toolbar3),
                                        0),
                                2),
                        isDisplayed()));
        appCompatImageButton2.perform(click());

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.animalsBtn), withText("Animals"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.mainMenu),
                                        0),
                                2),
                        isDisplayed()));
        appCompatButton3.perform(click());

        ViewInteraction appCompatImageButton3 = onView(
                allOf(withId(R.id.backBtn),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.toolbar3),
                                        0),
                                2),
                        isDisplayed()));
        appCompatImageButton3.perform(click());

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.historyBtn), withText("History"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.mainMenu),
                                        0),
                                3),
                        isDisplayed()));
        appCompatButton4.perform(click());

        ViewInteraction appCompatImageButton4 = onView(
                allOf(withId(R.id.backBtn),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.toolbar3),
                                        0),
                                2),
                        isDisplayed()));
        appCompatImageButton4.perform(click());

        ViewInteraction appCompatButton5 = onView(
                allOf(withId(R.id.itBtn), withText("IT"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.mainMenu),
                                        0),
                                4),
                        isDisplayed()));
        appCompatButton5.perform(click());

        ViewInteraction appCompatImageButton5 = onView(
                allOf(withId(R.id.backBtn),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.toolbar3),
                                        0),
                                2),
                        isDisplayed()));
        appCompatImageButton5.perform(click());

        ViewInteraction appCompatButton6 = onView(
                allOf(withId(R.id.politicsBtn), withText("Politics"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.mainMenu),
                                        0),
                                5),
                        isDisplayed()));
        appCompatButton6.perform(click());


        ViewInteraction appCompatImageButton6 = onView(
                allOf(withId(R.id.backBtn),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.toolbar3),
                                        0),
                                2),
                        isDisplayed()));
        appCompatImageButton6.perform(click());

        ViewInteraction appCompatButton7 = onView(
                allOf(withId(R.id.myFavBtn), withText("My favourites"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.mainMenu),
                                        0),
                                6),
                        isDisplayed()));
        appCompatButton7.perform(click());

        ViewInteraction appCompatImageButton7 = onView(
                allOf(withId(R.id.toMainMenu),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.toolbar),
                                        0),
                                1),
                        isDisplayed()));
        appCompatImageButton7.perform(click());

        ViewInteraction appCompatButton8 = onView(
                allOf(withId(R.id.addFactBtn), withText("Add new fact"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.mainMenu),
                                        0),
                                7),
                        isDisplayed()));
        appCompatButton8.perform(click());

        ViewInteraction appCompatImageButton8 = onView(
                allOf(withId(R.id.toMainMenu),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.toolbar3),
                                        0),
                                1),
                        isDisplayed()));
        appCompatImageButton8.perform(click());

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
