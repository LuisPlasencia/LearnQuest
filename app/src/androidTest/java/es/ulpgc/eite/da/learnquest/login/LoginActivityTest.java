package es.ulpgc.eite.da.learnquest.login;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
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

    Context context =
            InstrumentationRegistry.getInstrumentation().getTargetContext();

    String title = context.getResources().getString(R.string.login_title);
    String title2 = context.getResources().getString(R.string.login_title2);
    String username = context.getResources().getString(R.string.login_username);
    String password = context.getResources().getString(R.string.login_password);

    String level = context.getResources().getString(R.string.level_display);
    String exp_to = context.getResources().getString(R.string.exp_to_display);

    @Test
    public void letsGoButtonPressed() {

        //GIVEN
        ViewInteraction textView4 = onView(withId(R.id.login_title));
        textView4.check(matches(withText(title)));

        ViewInteraction textView5 = onView(withId(R.id.login_title2));
        textView5.check(matches(withText(title2)));

        ViewInteraction button4 = onView(withId(R.id.no_account_button));
        button4.check(matches(isDisplayed()));

        ViewInteraction button5 = onView(withId(R.id.lets_go_button));
        button5.check(matches(isDisplayed()));

        ViewInteraction editText = onView((withId(R.id.username_input)));
        editText.check(matches(withText(username)));

        ViewInteraction editText2 = onView(withId(R.id.password_input));
        editText2.check(matches(withText(password)));

        ViewInteraction imageView6 = onView(withId(R.id.background_shiny));
        imageView6.check(matches(isDisplayed()));

        ViewInteraction imageView7 = onView(withId(R.id.quest_icon));
        imageView7.check(matches(isDisplayed()));

        ViewInteraction imageView8 = onView(withId(R.id.background_mountains));
        imageView8.check(matches(isDisplayed()));

        //WHEN
        ViewInteraction appCompatButton = onView(withId(R.id.lets_go_button));
        appCompatButton.perform(click());

        //THEN
        ViewInteraction button = onView((withId(R.id.go_button)));
        button.check(matches(isDisplayed()));

        ViewInteraction button2 = onView(withId(R.id.create_quest_button));
        button2.check(matches(isDisplayed()));

        ViewInteraction button3 = onView(withId(R.id.log_out_button));
        button3.check(matches(isDisplayed()));

        ViewInteraction imageView = onView(withId(R.id.go_quest_image));
        imageView.check(matches(isDisplayed()));

        ViewInteraction imageView2 = onView(withId(R.id.new_quest_image));
        imageView2.check(matches(isDisplayed()));

        ViewInteraction imageView3 = onView(withId(R.id.log_out_image));
        imageView3.check(matches(isDisplayed()));

        ViewInteraction imageView4 = onView(withId(R.id.profile_photo));
        imageView4.check(matches(isDisplayed()));

        ViewInteraction imageView5 = onView(withId(R.id.achivement_icon));
        imageView5.check(matches(isDisplayed()));

        ViewInteraction textView = onView(withId(R.id.profile_name));
        textView.check(matches(withText(username)));

        ViewInteraction textView2 = onView(withId(R.id.level_display));
        textView2.check(matches(withText(level)));

        ViewInteraction textView3 = onView(withId(R.id.exp_to_display));
        textView3.check(matches(withText(exp_to)));

        ViewInteraction progressBar = onView(withId(R.id.progressBar));
        progressBar.check(matches(isDisplayed()));
    }


}
