package es.ulpgc.eite.da.learnquest.quizUnit;

import android.content.Context;
import android.text.style.BackgroundColorSpan;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import es.ulpgc.eite.da.learnquest.R;
import es.ulpgc.eite.da.learnquest.data.Question;
import es.ulpgc.eite.da.learnquest.data.QuizRepository;
import es.ulpgc.eite.da.learnquest.data.RepositoryContract;
import es.ulpgc.eite.da.learnquest.question.QuestionActivity;
import es.ulpgc.eite.da.learnquest.quests.QuestsActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.not;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class QuizUnitInstrumentedTests {

    @Rule
    public ActivityTestRule<QuizUnitActivity> activityTestRule =
            new ActivityTestRule(QuizUnitActivity.class );


    Context context =
            InstrumentationRegistry.getInstrumentation().getTargetContext();
    RepositoryContract repository = QuizRepository.getInstance();



  //  @Test
    //public void whenT1SolveButtonIsClickedAndNotSolved() {
        //Given
        //onView(withId(R.id.math_button)).perform(click());
       // onView(withId(R.id.t1_topic)).check(matches(withText(t1_topic))); }
       // onView(withText(t1_topic)).check(matches((R.id.t1_topic)));
        //onView(withText(endsWith("photo de profil"))).check(matches(isDisplayed()));

       /* onView(withId(R.id.t1_topic_title)).check(matches(withText(t1_topic_title)));
        onView(withId(R.id.t1_description)).check(matches(withText(t1_description)));
        onView(withId(R.id.t1_topic_solve)).check(matches(withText(t1_topic_solve)));
        onView(withId(R.id.t1_topic_practise)).check(matches(withText(t1_topic_practise)));
        onView(withId(R.id.t1_topic_practise)).check(matches(not(isEnabled())));

        onView(withId(R.id.t2_topic)).check(matches(withText(t2_topic)));
        onView(withId(R.id.t2_topic_title)).check(matches(withText(t2_topic_title)));
        onView(withId(R.id.t2_description)).check(matches(withText(t2_description)));
        onView(withId(R.id.t2_topic_solve)).check(matches(withText(t2_topic_solve)));
        onView(withId(R.id.t2_topic_practise)).check(matches(withText(t2_topic_practise)));

        //When
        onView(withId(R.id.t1_topic_solve)).perform(click());

        //Then
        onView(withId(R.id.question_number)).check(matches(withText("Question " + question1.getId())));
        onView(withId(R.id.question_text)).check(matches(withText(question1.getQuestion())));
        onView(withId(R.id.option1_button))
                .check(matches(isEnabled()))
                .check(matches(withText(question1.getOption1())));
        onView(withId(R.id.option2_button))
                .check(matches(isEnabled()))
                .check(matches(withText(question1.getOption2())));
        onView(withId(R.id.option3_button))
                .check(matches(isEnabled()))
                .check(matches(withText(question1.getOption3())));
        onView(withId(R.id.answer_text)).check(matches(withText(empty_answer)));
        onView(withId(R.id.nextButton))
                .check(matches(not(isEnabled())))
                .check(matches(withText(next_button_text)));
        onView(withId(R.id.cheatButton))
                .check(matches(isEnabled()))
                .check(matches(withText(cheat_button_text)));

    }

    @Test
    public void whenT2SolveButtonIsClickedAndNotSolved() {
        //Given
        onView(withId(R.id.t1_topic)).check(matches(withText(t1_topic)));
        onView(withId(R.id.t1_topic_title)).check(matches(withText(t1_topic_title)));
        onView(withId(R.id.t1_description)).check(matches(withText(t1_description)));
        onView(withId(R.id.t1_topic_solve)).check(matches(withText(t1_topic_solve)));
        onView(withId(R.id.t1_topic_practise)).check(matches(withText(t1_topic_practise)));

        onView(withId(R.id.t2_topic)).check(matches(withText(t2_topic)));
        onView(withId(R.id.t2_topic_title)).check(matches(withText(t2_topic_title)));
        onView(withId(R.id.t2_description)).check(matches(withText(t2_description)));
        onView(withId(R.id.t2_topic_solve)).check(matches(withText(t2_topic_solve)));
        onView(withId(R.id.t2_topic_practise)).check(matches(withText(t2_topic_practise)));
        onView(withId(R.id.t2_topic_practise)).check(matches(not(isEnabled())));

        //When
        onView(withId(R.id.t2_topic_solve)).perform(click());

        //Then
        onView(withId(R.id.question_number)).check(matches(withText("Question " + question1.getId())));
        onView(withId(R.id.question_text)).check(matches(withText(question1.getQuestion())));
        onView(withId(R.id.option1_button))
                .check(matches(isEnabled()))
                .check(matches(withText(question1.getOption1())));
        onView(withId(R.id.option2_button))
                .check(matches(isEnabled()))
                .check(matches(withText(question1.getOption2())));
        onView(withId(R.id.option3_button))
                .check(matches(isEnabled()))
                .check(matches(withText(question1.getOption3())));
        onView(withId(R.id.answer_text)).check(matches(withText(empty_answer)));
        onView(withId(R.id.nextButton))
                .check(matches(not(isEnabled())))
                .check(matches(withText(next_button_text)));
        onView(withId(R.id.cheatButton))
                .check(matches(isEnabled()))
                .check(matches(withText(cheat_button_text)));

    }

    @Test
    public void whenT1SolveButtonIsClicked(){
        //Given
        onView(withId(R.id.t1_topic)).check(matches(withText(t1_topic)));
        onView(withId(R.id.t1_topic_title)).check(matches(withText(t1_topic_title)));
        onView(withId(R.id.t1_description)).check(matches(withText(t1_description)));
        onView(withId(R.id.t1_topic_solve)).check(matches(withText(t1_topic_solve)));
        onView(withId(R.id.t1_topic_practise)).check(matches(withText(t1_topic_practise)));


        onView(withId(R.id.t2_topic)).check(matches(withText(t2_topic)));
        onView(withId(R.id.t2_topic_title)).check(matches(withText(t2_topic_title)));
        onView(withId(R.id.t2_description)).check(matches(withText(t2_description)));
        onView(withId(R.id.t2_topic_solve)).check(matches(withText(t2_topic_solve)));
        onView(withId(R.id.t2_topic_practise)).check(matches(withText(t2_topic_practise)));

        //When
        onView(withId(R.id.t1_topic_solve)).perform(click());

        //Then
        onView(withId(R.id.question_number)).check(matches(withText("Question " + question1.getId())));
        onView(withId(R.id.question_text)).check(matches(withText(question1.getQuestion())));
        onView(withId(R.id.option1_button))
                .check(matches(isEnabled()))
                .check(matches(withText(question1.getOption1())));
        onView(withId(R.id.option2_button))
                .check(matches(isEnabled()))
                .check(matches(withText(question1.getOption2())));
        onView(withId(R.id.option3_button))
                .check(matches(isEnabled()))
                .check(matches(withText(question1.getOption3())));
        onView(withId(R.id.answer_text)).check(matches(withText(empty_answer)));
        onView(withId(R.id.nextButton))
                .check(matches(not(isEnabled())))
                .check(matches(withText(next_button_text)));
        onView(withId(R.id.cheatButton))
                .check(matches(isEnabled()))
                .check(matches(withText(cheat_button_text)));

    }

    @Test
    public void whenT2SolveButtonIsClicked(){
        //Given
        onView(withId(R.id.t1_topic)).check(matches(withText(t1_topic)));
        onView(withId(R.id.t1_topic_title)).check(matches(withText(t1_topic_title)));
        onView(withId(R.id.t1_description)).check(matches(withText(t1_description)));
        onView(withId(R.id.t1_topic_solve)).check(matches(withText(t1_topic_solve)));
        onView(withId(R.id.t1_topic_practise)).check(matches(withText(t1_topic_practise)));

        onView(withId(R.id.t2_topic)).check(matches(withText(t2_topic)));
        onView(withId(R.id.t2_topic_title)).check(matches(withText(t2_topic_title)));
        onView(withId(R.id.t2_description)).check(matches(withText(t2_description)));
        onView(withId(R.id.t2_topic_solve)).check(matches(withText(t2_topic_solve)));
        onView(withId(R.id.t2_topic_practise)).check(matches(withText(t2_topic_practise)));

        //When
        onView(withId(R.id.t2_topic_solve)).perform(click());

        //Then
        onView(withId(R.id.question_number)).check(matches(withText("Question " + question1.getId())));
        onView(withId(R.id.question_text)).check(matches(withText(question1.getQuestion())));
        onView(withId(R.id.option1_button))
                .check(matches(isEnabled()))
                .check(matches(withText(question1.getOption1())));
        onView(withId(R.id.option2_button))
                .check(matches(isEnabled()))
                .check(matches(withText(question1.getOption2())));
        onView(withId(R.id.option3_button))
                .check(matches(isEnabled()))
                .check(matches(withText(question1.getOption3())));
        onView(withId(R.id.answer_text)).check(matches(withText(empty_answer)));
        onView(withId(R.id.nextButton))
                .check(matches(not(isEnabled())))
                .check(matches(withText(next_button_text)));
        onView(withId(R.id.cheatButton))
                .check(matches(isEnabled()))
                .check(matches(withText(cheat_button_text)));
    }

    @Test
    public void whenBackButtonIsClickedAndT1IsNotSolved(){
        //Given
        onView(withId(R.id.t1_topic)).check(matches(withText(t1_topic)));
        onView(withId(R.id.t1_topic_title)).check(matches(withText(t1_topic_title)));
        onView(withId(R.id.t1_description)).check(matches(withText(t1_description)));
        onView(withId(R.id.t1_topic_solve)).check(matches(withText(t1_topic_solve)));
        onView(withId(R.id.t1_topic_practise)).check(matches(withText(t1_topic_practise)));
        onView(withId(R.id.t1_topic_practise)).check(matches(not(isEnabled())));

        onView(withId(R.id.t2_topic)).check(matches(withText(t2_topic)));
        onView(withId(R.id.t2_topic_title)).check(matches(withText(t2_topic_title)));
        onView(withId(R.id.t2_description)).check(matches(withText(t2_description)));
        onView(withId(R.id.t2_topic_solve)).check(matches(withText(t2_topic_solve)));
        onView(withId(R.id.t2_topic_practise)).check(matches(withText(t2_topic_practise)));

        //When
        pressBack();

        //Then
        onView(withId(R.id.math_button)).check(matches(withText(maths_button)));
        onView(withId(R.id.english_button)).check(matches(withText(english_button)));
        onView(withId(R.id.geography_button)).check(matches(withText(geography_button)));
        onView(withId(R.id.math_level_id)).check(matches(withText(math_level)));
        math_level_icon.check(matches(isDisplayed()));
        onView(withId(R.id.english_level_id)).check(matches(withText(english_level)));
        english_level_icon.check(matches(isDisplayed()));
        onView(withId(R.id.geography_level_id)).check(matches(withText(geography_level)));
        geography_level_icon.check(matches(isDisplayed()));
    }

    @Test
    public void whenBackButtonIsClickedAndT2IsNotSolved(){
        //Given
        onView(withId(R.id.t1_topic)).check(matches(withText(t1_topic)));
        onView(withId(R.id.t1_topic_title)).check(matches(withText(t1_topic_title)));
        onView(withId(R.id.t1_description)).check(matches(withText(t1_description)));
        onView(withId(R.id.t1_topic_solve)).check(matches(withText(t1_topic_solve)));
        onView(withId(R.id.t1_topic_practise)).check(matches(withText(t1_topic_practise)));


        onView(withId(R.id.t2_topic)).check(matches(withText(t2_topic)));
        onView(withId(R.id.t2_topic_title)).check(matches(withText(t2_topic_title)));
        onView(withId(R.id.t2_description)).check(matches(withText(t2_description)));
        onView(withId(R.id.t2_topic_solve)).check(matches(withText(t2_topic_solve)));
        onView(withId(R.id.t2_topic_practise)).check(matches(withText(t2_topic_practise)));
        onView(withId(R.id.t1_topic_practise)).check(matches(not(isEnabled())));

        //When
        pressBack();

        //Then
        onView(withId(R.id.math_button)).check(matches(withText(maths_button)));
        onView(withId(R.id.english_button)).check(matches(withText(english_button)));
        onView(withId(R.id.geography_button)).check(matches(withText(geography_button)));
       onView(withId(R.id.math_level_id)).check(matches(withText(math_level)));
        math_level_icon.check(matches(isDisplayed()));
        onView(withId(R.id.english_level_id)).check(matches(withText(english_level)));
        english_level_icon.check(matches(isDisplayed()));
        onView(withId(R.id.geography_level_id)).check(matches(withText(geography_level)));
        geography_level_icon.check(matches(isDisplayed()));

    }

    @Test
    public void whenBackButtonIsClickedAndT1IsSolved(){
        //Given
        onView(withId(R.id.t1_topic)).check(matches(withText(t1_topic)));
        onView(withId(R.id.t1_topic_title)).check(matches(withText(t1_topic_title)));
        onView(withId(R.id.t1_description)).check(matches(withText(t1_description)));
        onView(withId(R.id.t1_topic_solve)).check(matches(withText(t1_topic_solve)));
        onView(withId(R.id.t1_topic_practise)).check(matches(withText(t1_topic_practise)));

        onView(withId(R.id.t2_topic)).check(matches(withText(t2_topic)));
        onView(withId(R.id.t2_topic_title)).check(matches(withText(t2_topic_title)));
        onView(withId(R.id.t2_description)).check(matches(withText(t2_description)));
        onView(withId(R.id.t2_topic_solve)).check(matches(withText(t2_topic_solve)));
        onView(withId(R.id.t2_topic_practise)).check(matches(withText(t2_topic_practise)));

        //When
        pressBack();

        //Then
        onView(withId(R.id.math_button)).check(matches(withText(maths_button)));
        onView(withId(R.id.english_button)).check(matches(withText(english_button)));
        onView(withId(R.id.geography_button)).check(matches(withText(geography_button)));
       onView(withId(R.id.math_level_id)).check(matches(withText(math_level)));
        math_level_icon.check(matches(isDisplayed()));
        onView(withId(R.id.english_level_id)).check(matches(withText(english_level)));
        english_level_icon.check(matches(isDisplayed()));
        onView(withId(R.id.geography_level_id)).check(matches(withText(geography_level)));
        geography_level_icon.check(matches(isDisplayed()));
    }

    @Test
    public void whenBackButtonIsClickedAndT2IsSolved(){
        //Given
        onView(withId(R.id.t1_topic)).check(matches(withText(t1_topic)));
        onView(withId(R.id.t1_topic_title)).check(matches(withText(t1_topic_title)));
        onView(withId(R.id.t1_description)).check(matches(withText(t1_description)));
        onView(withId(R.id.t1_topic_solve)).check(matches(withText(t1_topic_solve)));
        onView(withId(R.id.t1_topic_practise)).check(matches(withText(t1_topic_practise)));


        onView(withId(R.id.t2_topic)).check(matches(withText(t2_topic)));
        onView(withId(R.id.t2_topic_title)).check(matches(withText(t2_topic_title)));
        onView(withId(R.id.t2_description)).check(matches(withText(t2_description)));
        onView(withId(R.id.t2_topic_solve)).check(matches(withText(t2_topic_solve)));
        onView(withId(R.id.t2_topic_practise)).check(matches(withText(t2_topic_practise)));

        //When
        pressBack();

        //Then
        onView(withId(R.id.math_button)).check(matches(withText(maths_button)));
        onView(withId(R.id.english_button)).check(matches(withText(english_button)));
        onView(withId(R.id.geography_button)).check(matches(withText(geography_button)));
        onView(withId(R.id.math_level_id)).check(matches(withText(math_level)));
        math_level_icon.check(matches(isDisplayed()));
        onView(withId(R.id.english_level_id)).check(matches(withText(english_level)));
        english_level_icon.check(matches(isDisplayed()));
        onView(withId(R.id.geography_level_id)).check(matches(withText(geography_level)));
        geography_level_icon.check(matches(isDisplayed()));

    }
*/
}
