//package es.ulpgc.eite.da.learnquest.finalQuiz;
//
//
//import android.content.Context;
//import android.content.pm.ActivityInfo;
//import android.view.View;
//import android.view.ViewGroup;
//import android.view.ViewParent;
//
//import androidx.test.espresso.ViewInteraction;
//import androidx.test.filters.LargeTest;
//import androidx.test.platform.app.InstrumentationRegistry;
//import androidx.test.rule.ActivityTestRule;
//import androidx.test.runner.AndroidJUnit4;
//
//import org.hamcrest.Description;
//import org.hamcrest.Matcher;
//import org.hamcrest.TypeSafeMatcher;
//import org.hamcrest.core.IsInstanceOf;
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//
//import es.ulpgc.eite.da.learnquest.R;
//
//import static androidx.test.espresso.Espresso.onView;
//import static androidx.test.espresso.action.ViewActions.click;
//import static androidx.test.espresso.assertion.ViewAssertions.matches;
//import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
//import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
//import static androidx.test.espresso.Espresso.pressBack;
//import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
//import static androidx.test.espresso.matcher.ViewMatchers.withId;
//import static androidx.test.espresso.matcher.ViewMatchers.withText;
//import static org.hamcrest.Matchers.allOf;
//import static org.hamcrest.Matchers.is;
//
//@LargeTest
//@RunWith(AndroidJUnit4.class)
//public class FinalQuizActivityTest {
//
//    @Rule
//    public ActivityTestRule<FinalQuizActivity> mActivityTestRule = new ActivityTestRule<>(FinalQuizActivity.class);
//
//    Context context =
//            InstrumentationRegistry.getInstrumentation().getTargetContext();
//
//    String amount_earned = context.getResources().getString(R.string.earned_display);
//    String exp_needed = context.getResources().getString(R.string.exp_to_display);
//    String t1_topic = context.getResources().getString(R.string.T1_Topic);
//    String t2_topic = context.getResources().getString(R.string.T2_Topic);
//    String level = context.getResources().getString(R.string.level_display_final_quiz);
//
//    @Test
//    public void returnToHomeButtonPressed() {
//        //GIVEN
//        ViewInteraction imageView = onView(withId(R.id.medal));
//        imageView.check(matches(isDisplayed()));
//
//        ViewInteraction textView = onView(withId(R.id.earned));
//        textView.check(matches(withText("You earned no xp")));
//
//        ViewInteraction textView2 = onView(withId(R.id.exp_to_nextlevel));
//        textView2.check(matches(withText("You need 100xp to reach level 1")));
//
//        ViewInteraction textView3 = onView(withId(R.id.level_display));
//        textView3.check(matches(withText("Level: 0")));
//
//        ViewInteraction progressBar = onView(withId(R.id.progressBar2));
//        progressBar.check(matches(isDisplayed()));
//
//        //WHEN
//        ViewInteraction appCompatButton = onView(withId(R.id.return_button));
//        appCompatButton.perform(click());
//
//        //THEN
//        ViewInteraction button2 = onView(withId(R.id.go_button));
//        button2.check(matches(isDisplayed()));
//
//        ViewInteraction button3 = onView(withId(R.id.create_quest_button));
//        button3.check(matches(isDisplayed()));
//
//        ViewInteraction button4 = onView(withId(R.id.log_out_button));
//        button4.check(matches(isDisplayed()));
//
//        ViewInteraction button5 = onView(withId(R.id.achievements_button));
//        button5.check(matches(isDisplayed()));
//    }
//
//    @Test
//    public void BackPressed() {
//        //GIVEN
//        ViewInteraction imageView = onView(withId(R.id.medal));
//        imageView.check(matches(isDisplayed()));
//
//        ViewInteraction textView = onView(withId(R.id.earned));
//        textView.check(matches(withText("You earned no xp")));
//
//        ViewInteraction textView2 = onView(withId(R.id.exp_to_nextlevel));
//        textView2.check(matches(withText("You need 100xp to reach level 1")));
//
//        ViewInteraction textView3 = onView(withId(R.id.level_display));
//        textView3.check(matches(withText("Level: 0")));
//
//        ViewInteraction progressBar = onView(withId(R.id.progressBar2));
//        progressBar.check(matches(isDisplayed()));
//
//
//        //WHEN
//        pressBack();
//
//        //THEN
//        ViewInteraction button2 = onView(withId(R.id.go_button));
//        button2.check(matches(isDisplayed()));
//
//        ViewInteraction button3 = onView(withId(R.id.create_quest_button));
//        button3.check(matches(isDisplayed()));
//
//        ViewInteraction button4 = onView(withId(R.id.log_out_button));
//        button4.check(matches(isDisplayed()));
//
//        ViewInteraction button5 = onView(withId(R.id.achievements_button));
//        button5.check(matches(isDisplayed()));
//
//    }
//
//    @Test
//    public void landscapeFinalQuizTest(){
//        //GIVEN
//        ViewInteraction imageView = onView(withId(R.id.medal));
//        imageView.check(matches(isDisplayed()));
//
//        ViewInteraction textView = onView(withId(R.id.earned));
//        textView.check(matches(withText("You earned no xp")));
//
//        ViewInteraction textView2 = onView(withId(R.id.exp_to_nextlevel));
//        textView2.check(matches(withText("You need 100xp to reach level 1")));
//
//        ViewInteraction textView3 = onView(withId(R.id.level_display));
//        textView3.check(matches(withText("Level: 0")));
//
//        ViewInteraction progressBar = onView(withId(R.id.progressBar2));
//        progressBar.check(matches(isDisplayed()));
//
//
//        //WHEN
//        mActivityTestRule.getActivity()
//                .setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//
//        //THEN
//        ViewInteraction imageView4 = onView(withId(R.id.medal));
//        imageView4.check(matches(isDisplayed()));
//
//        ViewInteraction textView5 = onView(withId(R.id.earned));
//        textView5.check(matches(withText("You earned no xp")));
//
//        ViewInteraction textView6 = onView(withId(R.id.exp_to_nextlevel));
//        textView6.check(matches(withText("You need 100xp to reach level 1")));
//
//        ViewInteraction textView7 = onView(withId(R.id.level_display));
//        textView7.check(matches(withText("Level: 0")));
//
//        ViewInteraction progressBar2 = onView(withId(R.id.progressBar2));
//        progressBar2.check(matches(isDisplayed()));
//    }
//
//
//
//
//}
