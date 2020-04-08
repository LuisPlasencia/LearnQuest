package es.ulpgc.eite.da.learnquest;


import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import es.ulpgc.eite.da.learnquest.question.QuestionActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class QuestionInstrumentedTests {

    @Rule
    public ActivityTestRule<QuestionActivity> activityTestRule =
            new ActivityTestRule(QuestionActivity.class );


    Context context =
            InstrumentationRegistry.getInstrumentation().getTargetContext();

    String english_button = "English";
    String maths_button = "Maths";
    String geography_button = "Geography";

    String math_level = context.getResources().getString(R.string.math_level);
    String english_level = context.getResources().getString(R.string.english_level);
    String geography_level = context.getResources().getString(R.string.geography_level);


    @Test
    public void whenMathButtonIsClicked(){
        //Given
        onView(withId(R.id.math_Button)).check(matches(withText(maths_button)));
        onView(withId(R.id.math_Button)).check(matches(withText(maths_button)));
        onView(withId(R.id.math_Button)).check(matches(withText(maths_button)));
        onView(withId(R.id.math_level_id)).check(matches(withText(math_level)));

        //Then
        onView(withId(R.id.math_Button)).perform(click());
    }
}
