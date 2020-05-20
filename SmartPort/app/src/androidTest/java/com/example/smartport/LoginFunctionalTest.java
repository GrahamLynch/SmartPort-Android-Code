package com.example.smartport;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class LoginFunctionalTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityTestRule = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void loginUITest() {
        ViewInteraction appCompatEditText = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.email),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withClassName(Matchers.is("android.widget.LinearLayout")),
                                        1),
                                2),
                        ViewMatchers.isDisplayed()));
        appCompatEditText.perform(ViewActions.click());

        ViewInteraction appCompatEditText2 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.email),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withClassName(Matchers.is("android.widget.LinearLayout")),
                                        1),
                                2),
                        ViewMatchers.isDisplayed()));
        appCompatEditText2.perform(ViewActions.replaceText("grahamlynch20@hotmail.com"), ViewActions.closeSoftKeyboard());

        ViewInteraction appCompatEditText3 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.password),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withClassName(Matchers.is("android.widget.LinearLayout")),
                                        1),
                                3),
                        ViewMatchers.isDisplayed()));
        appCompatEditText3.perform(ViewActions.replaceText("nationalcollegeofireland"), ViewActions.closeSoftKeyboard());

        ViewInteraction appCompatButton = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.loginBtn), ViewMatchers.withText("Login"),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withClassName(Matchers.is("android.widget.LinearLayout")),
                                        1),
                                4),
                        ViewMatchers.isDisplayed()));
        appCompatButton.perform(ViewActions.click());
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
