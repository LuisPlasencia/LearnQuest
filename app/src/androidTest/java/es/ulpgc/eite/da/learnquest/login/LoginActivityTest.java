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
import es.ulpgc.eite.da.learnquest.data.QuizRepository;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
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

    QuizRepository repository;

    @Test
    public void letsGoButtonDefaultAccount() {

        //GIVEN
        ViewInteraction textView4 = onView(withId(R.id.login_title));
        textView4.check(matches(withText(title)));

        ViewInteraction textView5 = onView(withId(R.id.login_title2));
        textView5.check(matches(withText(title2)));

        ViewInteraction button4 = onView(withId(R.id.no_account_button));
        button4.check(matches(isDisplayed()));

        ViewInteraction button5 = onView(withId(R.id.lets_go_button));
        button5.check(matches(isDisplayed()));

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

        ViewInteraction progressBar = onView(withId(R.id.progressBar));
        progressBar.check(matches(isDisplayed()));

        ViewInteraction textView2 = onView(withId(R.id.level_display));
        textView2.check(matches(withText("Level: 0")));

        ViewInteraction textView3 = onView(withId(R.id.exp_to_display));
        textView3.check(matches(withText("0 / 100")));
    }

    @Test
    public void letsGoButtonDefaultAccountDifferentUsernameLogoutAndLetsGo() {

        //GIVEN
        ViewInteraction textView4 = onView(withId(R.id.login_title));
        textView4.check(matches(withText(title)));

        ViewInteraction textView5 = onView(withId(R.id.login_title2));
        textView5.check(matches(withText(title2)));

        ViewInteraction editText = onView(withId(R.id.username_input));
        editText.check(matches(withText("")));

        ViewInteraction editText2 = onView(withId(R.id.password_input));
        editText2.check(matches(withText("")));

        ViewInteraction button4 = onView(withId(R.id.no_account_button));
        button4.check(matches(isDisplayed()));

        ViewInteraction button5 = onView(withId(R.id.lets_go_button));
        button5.check(matches(isDisplayed()));

        ViewInteraction imageView1 = onView(withId(R.id.background_shiny));
        imageView1.check(matches(isDisplayed()));

        ViewInteraction imageView2 = onView(withId(R.id.quest_icon));
        imageView2.check(matches(isDisplayed()));

        ViewInteraction imageView3 = onView(withId(R.id.background_mountains));
        imageView3.check(matches(isDisplayed()));

        ViewInteraction appCompatEditText = onView(withId(R.id.username_input));
        appCompatEditText.perform(replaceText("Diferent"), closeSoftKeyboard());

        //WHEN
        ViewInteraction appCompatButton = onView(withId(R.id.lets_go_button));
        appCompatButton.perform(click());

        //THEN & GIVEN
        ViewInteraction button = onView((withId(R.id.go_button)));
        button.check(matches(isDisplayed()));

        ViewInteraction button2 = onView(withId(R.id.create_quest_button));
        button2.check(matches(isDisplayed()));

        ViewInteraction button3 = onView(withId(R.id.log_out_button));
        button3.check(matches(isDisplayed()));

        ViewInteraction imageView = onView(withId(R.id.go_quest_image));
        imageView.check(matches(isDisplayed()));

        ViewInteraction imageView4 = onView(withId(R.id.new_quest_image));
        imageView4.check(matches(isDisplayed()));

        ViewInteraction imageView5 = onView(withId(R.id.log_out_image));
        imageView5.check(matches(isDisplayed()));

        ViewInteraction imageView6 = onView(withId(R.id.profile_photo));
        imageView6.check(matches(isDisplayed()));

        ViewInteraction imageView7 = onView(withId(R.id.achivement_icon));
        imageView7.check(matches(isDisplayed()));

        ViewInteraction textView = onView(withId(R.id.profile_name));
        textView.check(matches(withText("Diferent")));

        ViewInteraction progressBar = onView(withId(R.id.progressBar));
        progressBar.check(matches(isDisplayed()));

        ViewInteraction textView2 = onView(withId(R.id.level_display));
        textView2.check(matches(withText("Level: 0")));

        ViewInteraction textView3 = onView(withId(R.id.exp_to_display));
        textView3.check(matches(withText("0 / 100")));

        //WHEN
        ViewInteraction appCompatButton2 = onView(withId(R.id.log_out_button));
        appCompatButton2.perform(click());

        //THEN & GIVEN
        ViewInteraction textView6 = onView(withId(R.id.login_title));
        textView6.check(matches(withText(title)));

        ViewInteraction textView7 = onView(withId(R.id.login_title2));
        textView7.check(matches(withText(title2)));

        ViewInteraction editText3 = onView(withId(R.id.username_input));
        editText3.check(matches(withText("")));

        ViewInteraction editText4 = onView(withId(R.id.password_input));
        editText4.check(matches(withText("")));

        ViewInteraction button6 = onView(withId(R.id.no_account_button));
        button6.check(matches(isDisplayed()));

        ViewInteraction button7 = onView(withId(R.id.lets_go_button));
        button7.check(matches(isDisplayed()));

        ViewInteraction imageView8 = onView(withId(R.id.background_shiny));
        imageView8.check(matches(isDisplayed()));

        ViewInteraction imageView9 = onView(withId(R.id.quest_icon));
        imageView9.check(matches(isDisplayed()));

        ViewInteraction imageView10 = onView(withId(R.id.background_mountains));
        imageView10.check(matches(isDisplayed()));

        //WHEN
        ViewInteraction appCompatButton3 = onView(withId(R.id.lets_go_button));
        appCompatButton3.perform(click());

        //THEN
        ViewInteraction button8 = onView((withId(R.id.go_button)));
        button8.check(matches(isDisplayed()));

        ViewInteraction button9 = onView(withId(R.id.create_quest_button));
        button9.check(matches(isDisplayed()));

        ViewInteraction button10 = onView(withId(R.id.log_out_button));
        button10.check(matches(isDisplayed()));

        ViewInteraction textView8 = onView(withId(R.id.profile_name));
        textView8.check(matches(withText(username)));

        ViewInteraction textView9 = onView(withId(R.id.level_display));
        textView9.check(matches(withText("Level: 0")));

        ViewInteraction textView10 = onView(withId(R.id.exp_to_display));
        textView10.check(matches(withText("0 / 100")));
    }

    @Test
    public void letsGoButtonLuisAccountLogoutAndGoButton(){
        //GIVEN
        ViewInteraction imageView1 = onView(withId(R.id.quest_icon));
        imageView1.check(matches(isDisplayed()));

        ViewInteraction imageView2 = onView(withId(R.id.background_mountains));
        imageView2.check(matches(isDisplayed()));

        ViewInteraction textView1 = onView(withId(R.id.login_title));
        textView1.check(matches(withText(title)));

        ViewInteraction textView2 = onView(withId(R.id.login_title2));
        textView2.check(matches(withText(title2)));

        ViewInteraction button = onView(withId(R.id.no_account_button));
        button.check(matches(isDisplayed()));

        ViewInteraction button1 = onView(withId(R.id.lets_go_button));
        button1.check(matches(isDisplayed()));

        ViewInteraction appCompatEditText = onView(withId(R.id.username_input));
        appCompatEditText.perform(replaceText("Luis"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(withId(R.id.password_input));
        appCompatEditText2.perform(replaceText("patata"), closeSoftKeyboard());

        //WHEN
        ViewInteraction appCompatButton = onView(withId(R.id.lets_go_button));
        appCompatButton.perform(click());

        //THEN & GIVEN
        ViewInteraction button2 = onView((withId(R.id.go_button)));
        button2.check(matches(isDisplayed()));

        ViewInteraction button3 = onView(withId(R.id.create_quest_button));
        button3.check(matches(isDisplayed()));

        ViewInteraction button4 = onView(withId(R.id.log_out_button));
        button4.check(matches(isDisplayed()));

        ViewInteraction imageView = onView(withId(R.id.go_quest_image));
        imageView.check(matches(isDisplayed()));

        ViewInteraction imageView3 = onView(withId(R.id.new_quest_image));
        imageView3.check(matches(isDisplayed()));

        ViewInteraction imageView4 = onView(withId(R.id.log_out_image));
        imageView4.check(matches(isDisplayed()));

        ViewInteraction imageView5 = onView(withId(R.id.profile_photo));
        imageView5.check(matches(isDisplayed()));

        ViewInteraction textView = onView(withId(R.id.profile_name));
        textView.check(matches(withText("Luis")));

        ViewInteraction textView6 = onView(withId(R.id.level_display));
        textView6.check(matches(withText("Level: 8")));

        ViewInteraction textView3 = onView(withId(R.id.exp_to_display));
        textView3.check(matches(withText("60 / 100")));

        //WHEN
        ViewInteraction appCompatButton2 = onView(withId(R.id.log_out_button));
        appCompatButton2.perform(click());

        //THEN & GIVEN
        ViewInteraction textView10 = onView(withId(R.id.login_title));
        textView10.check(matches(withText(title)));

        ViewInteraction textView7 = onView(withId(R.id.login_title2));
        textView7.check(matches(withText(title2)));

        ViewInteraction editText3 = onView(withId(R.id.username_input));
        editText3.check(matches(withText("")));

        ViewInteraction editText4 = onView(withId(R.id.password_input));
        editText4.check(matches(withText("")));

        ViewInteraction button6 = onView(withId(R.id.no_account_button));
        button6.check(matches(isDisplayed()));

        ViewInteraction button7 = onView(withId(R.id.lets_go_button));
        button7.check(matches(isDisplayed()));

        ViewInteraction imageView8 = onView(withId(R.id.background_shiny));
        imageView8.check(matches(isDisplayed()));

        ViewInteraction imageView9 = onView(withId(R.id.quest_icon));
        imageView9.check(matches(isDisplayed()));

        ViewInteraction imageView10 = onView(withId(R.id.background_mountains));
        imageView10.check(matches(isDisplayed()));

        //WHEN
        ViewInteraction appCompatButton3 = onView(withId(R.id.lets_go_button));
        appCompatButton3.perform(click());

        //THEN
        ViewInteraction button8 = onView((withId(R.id.go_button)));
        button8.check(matches(isDisplayed()));

        ViewInteraction button9 = onView(withId(R.id.create_quest_button));
        button9.check(matches(isDisplayed()));

        ViewInteraction button10 = onView(withId(R.id.log_out_button));
        button10.check(matches(isDisplayed()));

        ViewInteraction textView8 = onView(withId(R.id.profile_name));
        textView8.check(matches(withText(username)));

        ViewInteraction textView9 = onView(withId(R.id.level_display));
        textView9.check(matches(withText("Level: 0")));

        ViewInteraction textView11 = onView(withId(R.id.exp_to_display));
        textView11.check(matches(withText("0 / 100")));

    }


}
