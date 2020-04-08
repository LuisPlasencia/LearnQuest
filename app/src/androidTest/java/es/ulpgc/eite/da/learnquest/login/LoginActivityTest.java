package es.ulpgc.eite.da.learnquest.login;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import es.ulpgc.eite.da.learnquest.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityTestRule = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void letsGoButtonPressed() {

        //GIVEN
        ViewInteraction textView = onView(withId(R.id.login_title));
        textView.check(matches(withText("LearnQuest")));

        ViewInteraction textView2 = onView(withId(R.id.login_title2));
        textView2.check(matches(withText("Have fun learning!")));

        ViewInteraction button = onView(withId(R.id.no_account_button));
        button.check(matches(isDisplayed()));

        //WHEN
        ViewInteraction appCompatButton = onView(withId(R.id.lets_go_button));
        appCompatButton.perform(click());

        //THEN
        ViewInteraction button2 = onView(withId(R.id.go_button));
        button2.check(matches(isDisplayed()));

        ViewInteraction button3 = onView(withId(R.id.create_quest_button));
        button3.check(matches(isDisplayed()));

        ViewInteraction button4 = onView(withId(R.id.log_out_button));
        button4.check(matches(isDisplayed()));

        ViewInteraction button5 = onView(withId(R.id.achievements_button));
        button5.check(matches(isDisplayed()));
    }


}
