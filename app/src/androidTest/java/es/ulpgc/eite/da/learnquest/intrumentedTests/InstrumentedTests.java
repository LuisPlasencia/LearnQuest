package es.ulpgc.eite.da.learnquest.intrumentedTests;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.BoundedMatcher;
import androidx.test.filters.LargeTest;
import androidx.test.platform.app.InstrumentationRegistry;
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
import es.ulpgc.eite.da.learnquest.finalQuiz.FinalQuizActivity;
import es.ulpgc.eite.da.learnquest.login.LoginActivity;

import static android.app.PendingIntent.getActivity;
import static androidx.core.util.Preconditions.checkNotNull;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import es.ulpgc.eite.da.learnquest.intrumentedTests.RecyclerViewMatcher;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class InstrumentedTests {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityTestRule = new ActivityTestRule<>(LoginActivity.class);

    Context context =
            InstrumentationRegistry.getInstrumentation().getTargetContext();



    @Test
    public void letsGoButton() {
        //GIVEN
        onView(withId(R.id.login_title)).check(matches(withText("LearnQuest")));
        onView(withId(R.id.login_title2)).check(matches(withText("Have fun learning!")));
        ViewInteraction editText = onView(withId(R.id.username_input));
        editText.check(matches(withText("")));
        ViewInteraction editText2 = onView(withId(R.id.password_input));
        editText2.check(matches(withText("")));

        //WHEN
        onView(withId(R.id.username_input)).perform(typeText("c"));
        onView(withId(R.id.password_input)).perform(typeText("c"));
        pressBack();
        ViewInteraction appCompatButton = onView(withId(R.id.lets_go_button));
        appCompatButton.perform(click());
        //THEN
        ViewInteraction button = onView((withId(R.id.go_button)));
        button.check(matches(isDisplayed()));
    }

    @Test
    public void letsGoButtonWrongUserName() {
        //GIVEN
        onView(withId(R.id.login_title)).check(matches(withText("LearnQuest")));

        onView(withId(R.id.login_title2)).check(matches(withText("Have fun learning!")));

        ViewInteraction editText = onView(withId(R.id.username_input));
        editText.check(matches(withText("")));

        ViewInteraction editText2 = onView(withId(R.id.password_input));
        editText2.check(matches(withText("")));

        //WHEN
        onView(withId(R.id.username_input)).perform(typeText("cc"));

        onView(withId(R.id.password_input)).perform(typeText("c"));

        pressBack();

        ViewInteraction appCompatButton = onView(withId(R.id.lets_go_button));
        appCompatButton.perform(click());

        //THEN
        onView(withText("Invalid username")).inRoot(withDecorView(not(mActivityTestRule.getActivity().getWindow().getDecorView()))).check(matches(isDisplayed()));
    }

    @Test
    public void letsGoButtonWrongPassWord() {
        //GIVEN
        onView(withId(R.id.login_title)).check(matches(withText("LearnQuest")));

        onView(withId(R.id.login_title2)).check(matches(withText("Have fun learning!")));

        ViewInteraction editText = onView(withId(R.id.username_input));
        editText.check(matches(withText("")));

        ViewInteraction editText2 = onView(withId(R.id.password_input));
        editText2.check(matches(withText("")));

        //WHEN
        onView(withId(R.id.username_input)).perform(typeText("c"));

        onView(withId(R.id.password_input)).perform(typeText("cc"));

        pressBack();

        ViewInteraction appCompatButton = onView(withId(R.id.lets_go_button));
        appCompatButton.perform(click());

        //THEN
        onView(withText("Wrong password")).inRoot(withDecorView(not(mActivityTestRule.getActivity().getWindow().getDecorView()))).check(matches(isDisplayed()));
    }

    @Test
    public void rr () {
        onView(withId(R.id.username_input)).perform(typeText("c"));
        onView(withId(R.id.password_input)).perform(typeText("c"));
        pressBack();
        ViewInteraction appCompatButton = onView(withId(R.id.lets_go_button));
        appCompatButton.perform(click());

        ViewInteraction appCompatButton2 = onView(withId(R.id.go_button));
        appCompatButton2.perform(click());

        onView(new RecyclerViewMatcher(R.id.quests_list)
                .atPositionOnView(1, R.id.subjectName))
                .check(matches(withText("English")));
    }



}