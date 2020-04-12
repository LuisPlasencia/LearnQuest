package es.ulpgc.eite.da.learnquest.quests;


import android.content.Context;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import es.ulpgc.eite.da.learnquest.R;
import es.ulpgc.eite.da.learnquest.data.QuizRepository;
import es.ulpgc.eite.da.learnquest.data.RepositoryContract;
import es.ulpgc.eite.da.learnquest.data.User;
import es.ulpgc.eite.da.learnquest.question.QuestionActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.not;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class QuestsInstrumentedTests {

    @Rule
    public ActivityTestRule<QuestsActivity> activityTestRule =
            new ActivityTestRule(QuestsActivity.class);


    Context context =
            InstrumentationRegistry.getInstrumentation().getTargetContext();
    RepositoryContract repository = QuizRepository.getInstance();
    //Quests
    String english_button = "English";
    String maths_button = "Maths";
    String geography_button = "Geography";

    ViewInteraction math_level_icon = onView(ViewMatchers.withId(R.id.math_level_icon));
    ViewInteraction english_level_icon = onView(withId(R.id.english_level_icon));
    ViewInteraction geography_level_icon = onView(withId(R.id.geography_level_icon));

    String math_level = repository.getSubjectPercentage(1).toString();
    String english_level = repository.getSubjectPercentage(2).toString();
    String geography_level = repository.getSubjectPercentage(3).toString();

    //Quiz units (falta la nota +A)

    String t1_topic = repository.getQuizUnit("Maths").getT1Topic();
    String t1_topic_title = repository.getQuizUnit("Maths").getT1SubTopic();
    String t1_description = repository.getQuizUnit("Maths").getT1Description();
    String t1_topic_solve = context.getResources().getString(R.string.T1_Topic_solve_button);
    String t1_topic_practise = context.getResources().getString(R.string.T1_Topic_practise_button);


    String t2_topic = repository.getQuizUnit("Maths").getT2Topic();
    String t2_topic_title = repository.getQuizUnit("Maths").getT2SubTopic();
    String t2_description = repository.getQuizUnit("Maths").getT2Description();
    String t2_topic_solve = context.getResources().getString(R.string.T2_Topic_solve_button);
    String t2_topic_practise = context.getResources().getString(R.string.T2_Topic_practise_button);

    //Profile
    String usern2ame = context.getResources().getString(R.string.login_username);
    String username = repository.getUsername();
    int level = repository.getLevel();
    //String exp_to = repository.get


    String title = context.getResources().getString(R.string.login_title);
    String title2 = context.getResources().getString(R.string.login_title2);
    String password = context.getResources().getString(R.string.login_password);



    @Test
    public void whenMathButtonIsClicked() {

        //Given
        onView(withId(R.id.math_button)).check(matches(withText(maths_button)));
        onView(withId(R.id.english_button)).check(matches(withText(english_button)));
        onView(withId(R.id.geography_button)).check(matches(withText(geography_button)));
        onView(withId(R.id.math_level_id)).check(matches(withText(math_level+"%")));
        math_level_icon.check(matches(isDisplayed()));
        onView(withId(R.id.english_level_id)).check(matches(withText(english_level+"%")));
        english_level_icon.check(matches(isDisplayed()));
        onView(withId(R.id.geography_level_id)).check(matches(withText(geography_level+"%")));
        geography_level_icon.check(matches(isDisplayed()));

       //When
        onView(withId(R.id.math_button)).perform(click());

        //Then
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
    }



    @Test
    public void whenEnglishButtonIsClicked() {
        //Given
        onView(withId(R.id.math_button)).check(matches(withText(maths_button)));
        onView(withId(R.id.english_button)).check(matches(withText(english_button)));
        onView(withId(R.id.geography_button)).check(matches(withText(geography_button)));
        onView(withId(R.id.math_level_id)).check(matches(withText(math_level+"%")));
        math_level_icon.check(matches(isDisplayed()));
        onView(withId(R.id.english_level_id)).check(matches(withText(english_level+"%")));
        english_level_icon.check(matches(isDisplayed()));
        onView(withId(R.id.geography_level_id)).check(matches(withText(geography_level+"%")));
        geography_level_icon.check(matches(isDisplayed()));

        //When
        onView(withId(R.id.english_button)).perform(click());

        //Then
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

    }

    @Test
    public void whenGeographyButtonIsClicked() {
        //Given
        onView(withId(R.id.math_button)).check(matches(withText(maths_button)));
        onView(withId(R.id.english_button)).check(matches(withText(english_button)));
        onView(withId(R.id.geography_button)).check(matches(withText(geography_button)));
        onView(withId(R.id.math_level_id)).check(matches(withText(math_level+"%")));
        math_level_icon.check(matches(isDisplayed()));
        onView(withId(R.id.english_level_id)).check(matches(withText(english_level+"%")));
        english_level_icon.check(matches(isDisplayed()));
        onView(withId(R.id.geography_level_id)).check(matches(withText(geography_level+"%")));
        geography_level_icon.check(matches(isDisplayed()));

        //When
        onView(withId(R.id.geography_button)).perform(click());

        //Then
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

    }

    @Test
    public void whenBackButtonIsClicked() {
        //Given
        onView(withId(R.id.math_button)).check(matches(withText(maths_button)));
        onView(withId(R.id.english_button)).check(matches(withText(english_button)));
        onView(withId(R.id.geography_button)).check(matches(withText(geography_button)));
        onView(withId(R.id.math_level_id)).check(matches(withText(math_level+"%")));
        math_level_icon.check(matches(isDisplayed()));
        onView(withId(R.id.english_level_id)).check(matches(withText(english_level+"%")));
        english_level_icon.check(matches(isDisplayed()));
        onView(withId(R.id.geography_level_id)).check(matches(withText(geography_level+"%")));
        geography_level_icon.check(matches(isDisplayed()));

        //When
       // pressBack();

        //Then
       //onView(withId(R.))

    }
}
