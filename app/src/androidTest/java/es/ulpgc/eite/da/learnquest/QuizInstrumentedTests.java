package es.ulpgc.eite.da.learnquest;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import es.ulpgc.eite.da.learnquest.question.QuestionActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class QuizInstrumentedTests {

    @Rule
    public ActivityTestRule<QuestionActivity> activityTestRule =
            new ActivityTestRule(QuestionActivity.class );


    Context context =
            InstrumentationRegistry.getInstrumentation().getTargetContext();

    //Esto se puede ir modificando
    String[] question_array = context.getResources().getStringArray(R.array.question_array);
    String question_number = question_array[0];
    String question_text = question_array[1];
    String option1_text = question_array[2];
    String option2_text = question_array[3];
    String option3_text = question_array[4];
    String correct = context.getString(R.string.correct_text);
    String incorrect = context.getString(R.string.incorrect_text);
    String empty_reply = context.getString(R.string.empty_string);
    String warning = context.getString(R.string.confirmation_cheat);
    String empty_answer = context.getString(R.string.empty_string);
    String warningInfo = context.getString(R.string.confirmation_info_cheat);
    String next_button_text = context.getString(R.string.next_button_text);
    String cheat_button_text = context.getString(R.string.cheat_button_text);

    String confirmation_text = context.getString(R.string.confirmation_cheat);
    String confirmation_info_text = context.getString(R.string.confirmation_info_cheat);


    private void rotate() {

        Context context = ApplicationProvider.getApplicationContext();
        int orientation = context.getResources().getConfiguration().orientation;
        Activity activity = activityTestRule.getActivity();

        if(orientation  == Configuration.ORIENTATION_PORTRAIT) {
            activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        } else {
            activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }


    @Test
    public void incorrectAnswerChosenTest() {
        //GIVEN
        onView(withId(R.id.question_number)).check(matches(withText(question_array[0])));
        onView(withId(R.id.question_text)).check(matches(withText(question_array[1])));
        onView(withId(R.id.option1_button))
                .check(matches(isEnabled()))
                .check(matches(withText(question_array[2])));
        onView(withId(R.id.option2_button))
                .check(matches(isEnabled()))
                .check(matches(withText(question_array[3])));
        onView(withId(R.id.option3_button))
                .check(matches(isEnabled()))
                .check(matches(withText(question_array[4])));
        onView(withId(R.id.answer_text)).check(matches(withText(empty_answer)));
        onView(withId(R.id.nextButton))
                .check(matches(not(isEnabled())))
                .check(matches(withText(next_button_text)));
        onView(withId(R.id.cheatButton))
                .check(matches(isEnabled()))
                .check(matches(withText(cheat_button_text)));

        //WHEN
        onView(withId(R.id.option1_button)).perform(click());

        //THEN
        onView(withId(R.id.option1_button))
                .check(matches(not(isEnabled())))
                .check(matches(withText(question_array[2])));
        onView(withId(R.id.option2_button))
                .check(matches(not(isEnabled())))
                .check(matches(withText(question_array[3])));
        onView(withId(R.id.option3_button))
                .check(matches(not(isEnabled())))
                .check(matches(withText(question_array[4])));
        onView(withId(R.id.cheatButton))
                .check(matches(not(isEnabled())))
                .check(matches(withText(cheat_button_text)));
        onView(withId(R.id.nextButton))
                .check(matches(not(isEnabled())))
                .check(matches(withText(next_button_text)));
        onView(withId(R.id.question_number)).check(matches(withText(question_array[0])));
        onView(withId(R.id.question_text)).check(matches(withText(question_array[1])));
        onView(withId(R.id.answer_text)).check(matches(withText(incorrect)));
    }

    @Test
    public void correctAnswerChosenTest() {
        //GIVEN
        onView(withId(R.id.question_number)).check(matches(withText(question_array[0])));
        onView(withId(R.id.question_text)).check(matches(withText(question_array[1])));
        onView(withId(R.id.option1_button))
                .check(matches(isEnabled()))
                .check(matches(withText(question_array[2])));
        onView(withId(R.id.option2_button))
                .check(matches(isEnabled()))
                .check(matches(withText(question_array[3])));
        onView(withId(R.id.option3_button))
                .check(matches(isEnabled()))
                .check(matches(withText(question_array[4])));
        onView(withId(R.id.answer_text)).check(matches(withText(empty_answer)));
        onView(withId(R.id.nextButton))
                .check(matches(not(isEnabled())))
                .check(matches(withText(next_button_text)));
        onView(withId(R.id.cheatButton))
                .check(matches(isEnabled()))
                .check(matches(withText(cheat_button_text)));

        //WHEN
        onView(withId(R.id.option2_button)).perform(click());

        //THEN
        onView(withId(R.id.option1_button))
                .check(matches(not(isEnabled())))
                .check(matches(withText(question_array[2])));
        onView(withId(R.id.option2_button))
                .check(matches(not(isEnabled())))
                .check(matches(withText(question_array[3])));
        onView(withId(R.id.option3_button))
                .check(matches(not(isEnabled())))
                .check(matches(withText(question_array[4])));
        onView(withId(R.id.cheatButton))
                .check(matches(not(isEnabled())))
                .check(matches(withText(cheat_button_text)));
        onView(withId(R.id.nextButton))
                .check(matches(not(isEnabled())))
                .check(matches(withText(next_button_text)));
        onView(withId(R.id.question_number)).check(matches(withText(question_array[0])));
        onView(withId(R.id.question_text)).check(matches(withText(question_array[1])));
        onView(withId(R.id.answer_text)).check(matches(withText(incorrect)));
    }

    @Test
    public void nextButtonClickedAfterWrongAnswerTest() {
        //GIVEN
        onView(withId(R.id.question_number)).check(matches(withText(question_array[0])));
        onView(withId(R.id.question_text)).check(matches(withText(question_array[1])));
        onView(withId(R.id.option1_button)).check(matches(withText(question_array[2])));
        onView(withId(R.id.option2_button)).check(matches(withText(question_array[3])));
        onView(withId(R.id.option3_button)).check(matches(withText(question_array[4])));
        onView(withId(R.id.answer_text)).check(matches(withText(empty_answer)));
        onView(withId(R.id.nextButton))
                .check(matches(not(isEnabled())))
                .check(matches(withText(next_button_text)));
        onView(withId(R.id.cheatButton))
                .check(matches(isEnabled()))
                .check(matches(withText(cheat_button_text)));

        onView(withId(R.id.option1_button)).perform(click());
        onView(withId(R.id.option1_button)).check(matches(not(isEnabled())));
        onView(withId(R.id.option2_button)).check(matches(not(isEnabled())));
        onView(withId(R.id.option3_button)).check(matches(not(isEnabled())));
        onView(withId(R.id.cheatButton))
                .check(matches(not(isEnabled())))
                .check(matches(withText(cheat_button_text)));
        onView(withId(R.id.nextButton))
                .check(matches(isEnabled()))
                .check(matches(withText(next_button_text)));
        onView(withId(R.id.question_number)).check(matches(withText(question_array[0])));
        onView(withId(R.id.question_text)).check(matches(withText(question_array[1])));
        onView(withId(R.id.answer_text)).check(matches(withText(incorrect)));

        //WHEN
        onView(withId(R.id.nextButton)).perform(click());

        //THEN
        onView(withId(R.id.question_number)).check(matches(withText(question_array[5])));
        onView(withId(R.id.question_text)).check(matches(withText(question_array[6])));
        onView(withId(R.id.option1_button))
                .check(matches(isEnabled()))
                .check(matches(withText(question_array[7])));
        onView(withId(R.id.option2_button))
                .check(matches(isEnabled()))
                .check(matches(withText(question_array[8])));
        onView(withId(R.id.option3_button))
                .check(matches(isEnabled()))
                .check(matches(withText(question_array[9])));
        onView(withId(R.id.answer_text)).check(matches(withText(empty_answer)));
        onView(withId(R.id.nextButton))
                .check(matches(not(isEnabled())))
                .check(matches(withText(next_button_text)));
        onView(withId(R.id.cheatButton))
                .check(matches(isEnabled()))
                .check(matches(withText(cheat_button_text)));
    }

    @Test
    public void nextButtonClickedAfterRightAnswerChosen() {
        //GIVEN
        onView(withId(R.id.question_number)).check(matches(withText(question_array[0])));
        onView(withId(R.id.question_text)).check(matches(withText(question_array[1])));
        onView(withId(R.id.option1_button)).check(matches(withText(question_array[2])));
        onView(withId(R.id.option2_button)).check(matches(withText(question_array[3])));
        onView(withId(R.id.option3_button)).check(matches(withText(question_array[4])));
        onView(withId(R.id.answer_text)).check(matches(withText(empty_answer)));
        onView(withId(R.id.nextButton))
                .check(matches(not(isEnabled())))
                .check(matches(withText(next_button_text)));
        onView(withId(R.id.cheatButton))
                .check(matches(isEnabled()))
                .check(matches(withText(cheat_button_text)));

        onView(withId(R.id.option2_button)).perform(click());

        onView(withId(R.id.option1_button)).check(matches(not(isEnabled())));
        onView(withId(R.id.option2_button)).check(matches(not(isEnabled())));
        onView(withId(R.id.option3_button)).check(matches(not(isEnabled())));
        onView(withId(R.id.cheatButton))
                .check(matches(not(isEnabled())))
                .check(matches(withText(cheat_button_text)));
        onView(withId(R.id.nextButton))
                .check(matches(isEnabled()))
                .check(matches(withText(next_button_text)));
        onView(withId(R.id.question_number)).check(matches(withText(question_array[0])));
        onView(withId(R.id.question_text)).check(matches(withText(question_array[1])));
        onView(withId(R.id.answer_text)).check(matches(withText(incorrect)));

        //WHEN
        onView(withId(R.id.nextButton)).perform(click());

        //THEN
        onView(withId(R.id.question_number)).check(matches(withText(question_array[5])));
        onView(withId(R.id.question_text)).check(matches(withText(question_array[6])));
        onView(withId(R.id.option1_button))
                .check(matches(isEnabled()))
                .check(matches(withText(question_array[7])));
        onView(withId(R.id.option2_button))
                .check(matches(isEnabled()))
                .check(matches(withText(question_array[8])));
        onView(withId(R.id.option3_button))
                .check(matches(isEnabled()))
                .check(matches(withText(question_array[9])));
        onView(withId(R.id.answer_text)).check(matches(withText(empty_answer)));
        onView(withId(R.id.nextButton))
                .check(matches(not(isEnabled())))
                .check(matches(withText(next_button_text)));
        onView(withId(R.id.cheatButton))
                .check(matches(isEnabled()))
                .check(matches(withText(cheat_button_text)));
    }

    @Test
    public void startHintActivityAfterHintButtonPressed() {
        //GIVEN
        onView(withId(R.id.question_number)).check(matches(withText(question_array[0])));
        onView(withId(R.id.question_text)).check(matches(withText(question_array[1])));
        onView(withId(R.id.option1_button)).check(matches(withText(question_array[2])));
        onView(withId(R.id.option2_button)).check(matches(withText(question_array[3])));
        onView(withId(R.id.option3_button)).check(matches(withText(question_array[4])));
        onView(withId(R.id.answer_text)).check(matches(withText(empty_answer)));
        onView(withId(R.id.nextButton))
                .check(matches(not(isEnabled())))
                .check(matches(withText(next_button_text)));
        onView(withId(R.id.cheatButton))
                .check(matches(isEnabled()))
                .check(matches(withText(cheat_button_text)));

        //WHEN
        onView(withId(R.id.cheatButton)).perform(click());

        //THEN
        onView(withId(R.id.confirmation_text)).check(matches(withText(confirmation_text)));
        onView(withId(R.id.confirmation_info_text)).check(matches(withText(confirmation_info_text)));
        onView(withId(R.id.answer_text)).check(matches(withText(empty_answer)));
    }

   @Test
   public void pressNoToReturnToQuestionInHintActiivty() {
        //GIVEN
       onView(withId(R.id.cheatButton)).perform(click());
       onView(withId(R.id.confirmation_text)).check(matches(withText(confirmation_text)));
       onView(withId(R.id.confirmation_info_text)).check(matches(withText(confirmation_info_text)));
       onView(withId(R.id.answer_text)).check(matches(withText(empty_answer)));

       //WHEN
       onView(withId(R.id.noButton)).perform(click());

       //THEN
       onView(withId(R.id.question_number)).check(matches(withText(question_array[0])));
       onView(withId(R.id.question_text)).check(matches(withText(question_array[1])));
       onView(withId(R.id.option1_button))
               .check(matches(isEnabled()))
               .check(matches(withText(question_array[2])));
       onView(withId(R.id.option2_button))
               .check(matches(isEnabled()))
               .check(matches(withText(question_array[3])));
       onView(withId(R.id.option3_button))
               .check(matches(isEnabled()))
               .check(matches(withText(question_array[4])));
       onView(withId(R.id.answer_text)).check(matches(withText(empty_answer)));
       onView(withId(R.id.nextButton))
               .check(matches(not(isEnabled())))
               .check(matches(withText(next_button_text)));
       onView(withId(R.id.cheatButton))
               .check(matches(isEnabled()))
               .check(matches(withText(cheat_button_text)));
   }

   @Test
   public void pressYesInHintActivity() {
       //GIVEN
       onView(withId(R.id.cheatButton)).perform(click());
       onView(withId(R.id.confirmation_text)).check(matches(withText(confirmation_text)));
       onView(withId(R.id.confirmation_info_text)).check(matches(withText(confirmation_info_text)));
       onView(withId(R.id.answer_text)).check(matches(withText(empty_answer)));

       //WHEN
       onView(withId(R.id.yesButton)).perform(click());

       //THEN
       onView(withId(R.id.confirmation_text)).check(matches(withText(confirmation_text)));
       onView(withId(R.id.confirmation_info_text)).check(matches(withText(confirmation_info_text)));
       onView(withId(R.id.answer_text)).check(matches(withText(question_array[3])));
   }

   @Test
    public void pressYesInHintActivityAndReturnToQuestion() {
       //GIVEN
       onView(withId(R.id.cheatButton)).perform(click());
       onView(withId(R.id.confirmation_text)).check(matches(withText(confirmation_text)));
       onView(withId(R.id.confirmation_info_text)).check(matches(withText(confirmation_info_text)));
       onView(withId(R.id.answer_text)).check(matches(withText(empty_answer)));
       onView(withId(R.id.yesButton)).perform(click());

       //WHEN
       onView(withId(R.id.yesButton)).perform(click());

       //THEN
       onView(withId(R.id.question_number)).check(matches(withText(question_array[5])));
       onView(withId(R.id.question_text)).check(matches(withText(question_array[6])));
       onView(withId(R.id.option1_button))
               .check(matches(isEnabled()))
               .check(matches(withText(question_array[7])));
       onView(withId(R.id.option2_button))
               .check(matches(isEnabled()))
               .check(matches(withText(question_array[8])));
       onView(withId(R.id.option3_button))
               .check(matches(isEnabled()))
               .check(matches(withText(question_array[9])));
       onView(withId(R.id.answer_text)).check(matches(withText(empty_answer)));
       onView(withId(R.id.nextButton))
               .check(matches(not(isEnabled())))
               .check(matches(withText(next_button_text)));
       onView(withId(R.id.cheatButton))
               .check(matches(isEnabled()))
               .check(matches(withText(cheat_button_text)));

   }

   @Test
   public void pressNextButtonAtLastQuestion() {
        //GIVEN
       onView(withId(R.id.option2_button)).perform(click());
       onView(withId(R.id.nextButton)).perform(click());
       onView(withId(R.id.option2_button)).perform(click());
       onView(withId(R.id.nextButton)).perform(click());
       onView(withId(R.id.option2_button)).perform(click());

       //WHEN
       onView(withId(R.id.nextButton)).perform(click());

       //THEN
       onView(withId(R.id.earned)).check(matches(withText(context.getString(R.string.earned_display))));
   }
}
