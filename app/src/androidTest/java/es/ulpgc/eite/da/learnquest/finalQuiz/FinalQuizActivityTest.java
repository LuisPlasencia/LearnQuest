package es.ulpgc.eite.da.learnquest.finalQuiz;


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
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class FinalQuizActivityTest {

    @Rule
    public ActivityTestRule<FinalQuizActivity> mActivityTestRule = new ActivityTestRule<>(FinalQuizActivity.class);

    @Test
    public void returnToHomeButtonPressed() {
        //GIVEN
        ViewInteraction imageView = onView(withId(R.id.gold_medal));
        imageView.check(matches(isDisplayed()));

        ViewInteraction textView = onView(withId(R.id.earned));
        textView.check(matches(withText("You earned 400 xp!")));

        ViewInteraction textView2 = onView(withId(R.id.exp_to_nextlevel));
        textView2.check(matches(withText("You need 1300xp to reach level 3!")));

        ViewInteraction progressBar = onView(withId(R.id.progressBar2));
        progressBar.check(matches(isDisplayed()));

        ViewInteraction imageButton = onView(withContentDescription("Navigate up"));
        imageButton.check(matches(isDisplayed()));

        //WHEN
        ViewInteraction appCompatButton = onView(withId(R.id.return_button));
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

    @Test
    public void BackPressed() {
        //GIVEN
        ViewInteraction imageView = onView(withId(R.id.gold_medal));
        imageView.check(matches(isDisplayed()));

        ViewInteraction textView = onView(withId(R.id.earned));
        textView.check(matches(withText("You earned 400 xp!")));

        ViewInteraction textView2 = onView(withId(R.id.exp_to_nextlevel));
        textView2.check(matches(withText("You need 1300xp to reach level 3!")));

        ViewInteraction progressBar = onView(withId(R.id.progressBar2));
        progressBar.check(matches(isDisplayed()));

        //WHEN
        pressBack();

        //THEN
        ViewInteraction viewGroup = onView(withId(R.id.linearLayout));
        viewGroup.check(matches(isDisplayed()));

        ViewInteraction viewGroup2 = onView(withId(R.id.linearLayout));
        viewGroup2.check(matches(isDisplayed()));

        ViewInteraction textView3 = onView(withId(R.id.linearLayout));
        textView3.check(matches(withText("T1. Topic")));

        ViewInteraction textView4 = onView(withId(R.id.t2_topic));
        textView4.check(matches(withText("T2. Topic")));

        ViewInteraction textView5 = onView(withId(R.id.t1_topic));
        textView3.check(matches(isDisplayed()));

        ViewInteraction textView6 = onView(withId(R.id.t2_topic));
        textView6.check(matches(isDisplayed()));

        ViewInteraction button = onView(withId(R.id.t1_topic_solve));
        button.check(matches(isDisplayed()));

        ViewInteraction button2 = onView(withId(R.id.t1_topic_practise));
        button2.check(matches(isDisplayed()));

        ViewInteraction imageView2 = onView(withId(R.id.grade));
        imageView2.check(matches(isDisplayed()));

    }

    @Test
    public void returnIconPressed() {
        //GIVEN
        ViewInteraction imageView = onView(withId(R.id.gold_medal));
        imageView.check(matches(isDisplayed()));

        ViewInteraction textView = onView(withId(R.id.earned));
        textView.check(matches(withText("You earned 400 xp!")));

        ViewInteraction textView2 = onView(withId(R.id.exp_to_nextlevel));
        textView2.check(matches(withText("You need 1300xp to reach level 3!")));

        ViewInteraction progressBar = onView(withId(R.id.progressBar2));
        progressBar.check(matches(isDisplayed()));

        //WHEN
        ViewInteraction appCompatImageButton = onView(withContentDescription("Navigate up"));
        appCompatImageButton.perform(click());

        //THEN
        ViewInteraction viewGroup = onView(withId(R.id.linearLayout));
        viewGroup.check(matches(isDisplayed()));

        ViewInteraction viewGroup2 = onView(withId(R.id.linearLayout));
        viewGroup2.check(matches(isDisplayed()));

        ViewInteraction textView3 = onView(withId(R.id.linearLayout));
        textView3.check(matches(withText("T1. Topic")));

        ViewInteraction textView4 = onView(withId(R.id.t2_topic));
        textView4.check(matches(withText("T2. Topic")));

        ViewInteraction textView5 = onView(withId(R.id.t1_topic));
        textView3.check(matches(isDisplayed()));

        ViewInteraction textView6 = onView(withId(R.id.t2_topic));
        textView6.check(matches(isDisplayed()));

        ViewInteraction button = onView(withId(R.id.t1_topic_solve));
        button.check(matches(isDisplayed()));

        ViewInteraction button2 = onView(withId(R.id.t1_topic_practise));
        button2.check(matches(isDisplayed()));

        ViewInteraction imageView2 = onView(withId(R.id.grade));
        imageView2.check(matches(isDisplayed()));


    }


}
