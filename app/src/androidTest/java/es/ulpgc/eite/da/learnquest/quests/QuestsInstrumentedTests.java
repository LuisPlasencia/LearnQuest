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

import java.util.ArrayList;

import es.ulpgc.eite.da.learnquest.R;
import es.ulpgc.eite.da.learnquest.data.Question;
import es.ulpgc.eite.da.learnquest.data.QuizRepository;
import es.ulpgc.eite.da.learnquest.data.RepositoryContract;
import es.ulpgc.eite.da.learnquest.data.User;
import es.ulpgc.eite.da.learnquest.question.QuestionActivity;
import es.ulpgc.eite.da.learnquest.quizUnit.QuizUnitActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
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

    String username = context.getResources().getString(R.string.login_username);
    String level = context.getResources().getString(R.string.level_display);
    String exp_to = context.getResources().getString(R.string.exp_to_display);


    String title = context.getResources().getString(R.string.login_title);
    String title2 = context.getResources().getString(R.string.login_title2);
    String password = context.getResources().getString(R.string.login_password);
    /////////////////////////////////////

    //Quiz
    ArrayList<Question> question_array = repository.getQuestions();
    Question question1 = question_array.get(0);
    Question question2 = question_array.get(1);
    Question question3 = question_array.get(2);
    String correct = context.getString(R.string.correct_text);
    String incorrect = context.getString(R.string.incorrect_text);
    String empty_answer = context.getString(R.string.empty_string);
    String next_button_text = context.getString(R.string.next_button_text);
    String cheat_button_text = context.getString(R.string.hint_button_text);
    String confirmation_text = context.getString(R.string.confirmation_cheat);
    String confirmation_info_text = context.getString(R.string.confirmation_info_cheat);
    String returnToProfileTextFinalQuiz = context.getString(R.string.return_home_button);

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
        onView(withId(R.id.t1_topic_solve)).check(matches((isEnabled())));
        onView(withId(R.id.t1_topic_practise)).check(matches(withText(t1_topic_practise)));
        onView(withId(R.id.t1_topic_practise)).check(matches(not(isEnabled())));

        onView(withId(R.id.t2_topic)).check(matches(withText(t2_topic)));
        onView(withId(R.id.t2_topic_title)).check(matches(withText(t2_topic_title)));
        onView(withId(R.id.t2_description)).check(matches(withText(t2_description)));
        onView(withId(R.id.t2_topic_solve)).check(matches(withText(t2_topic_solve)));
        onView(withId(R.id.t2_topic_solve)).check(matches((isEnabled())));
        onView(withId(R.id.t2_topic_practise)).check(matches(withText(t2_topic_practise)));
        onView(withId(R.id.t2_topic_practise)).check(matches(not(isEnabled())));
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
        onView(withId(R.id.t1_topic_solve)).check(matches((isEnabled())));
        onView(withId(R.id.t1_topic_practise)).check(matches(withText(t1_topic_practise)));
        onView(withId(R.id.t1_topic_practise)).check(matches(not(isEnabled())));

        onView(withId(R.id.t2_topic)).check(matches(withText(t2_topic)));
        onView(withId(R.id.t2_topic_title)).check(matches(withText(t2_topic_title)));
        onView(withId(R.id.t2_description)).check(matches(withText(t2_description)));
        onView(withId(R.id.t2_topic_solve)).check(matches(withText(t2_topic_solve)));
        onView(withId(R.id.t2_topic_solve)).check(matches((isEnabled())));
        onView(withId(R.id.t2_topic_practise)).check(matches(withText(t2_topic_practise)));
        onView(withId(R.id.t2_topic_practise)).check(matches(not(isEnabled())));

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
        onView(withId(R.id.t1_topic_solve)).check(matches((isEnabled())));
        onView(withId(R.id.t1_topic_practise)).check(matches(withText(t1_topic_practise)));
        onView(withId(R.id.t1_topic_practise)).check(matches(not(isEnabled())));

        onView(withId(R.id.t2_topic)).check(matches(withText(t2_topic)));
        onView(withId(R.id.t2_topic_title)).check(matches(withText(t2_topic_title)));
        onView(withId(R.id.t2_description)).check(matches(withText(t2_description)));
        onView(withId(R.id.t2_topic_solve)).check(matches(withText(t2_topic_solve)));
        onView(withId(R.id.t2_topic_solve)).check(matches((isEnabled())));
        onView(withId(R.id.t2_topic_practise)).check(matches(withText(t2_topic_practise)));
        onView(withId(R.id.t2_topic_practise)).check(matches(not(isEnabled())));

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
        /*pressBack();

        //Then
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
        textView.check(matches(withText("")));

        ViewInteraction progressBar = onView(withId(R.id.progressBar));
        progressBar.check(matches(isDisplayed()));

        ViewInteraction textView2 = onView(withId(R.id.level_display));
        textView2.check(matches(withText("Level: 0")));

        ViewInteraction textView3 = onView(withId(R.id.exp_to_display));
        textView3.check(matches(withText("0 / 100")));
*/
    }

    ////////////////////////////////////////////////////// TESTS DE QUIZUNIT //////////////////////////////////////////////////////////////
    @Test
    public void whenT1MathSolveButtonIsClickedAndNotSolved() {
        onView(withId(R.id.math_button)).perform(click());

        //GIVEN
        onView(withId(R.id.t1_topic)).check(matches(withText(t1_topic)));
        onView(withId(R.id.t1_topic_title)).check(matches(withText(t1_topic_title)));
        onView(withId(R.id.t1_description)).check(matches(withText(t1_description)));
        onView(withId(R.id.t1_topic_solve)).check(matches(withText(t1_topic_solve)));
        onView(withId(R.id.t1_topic_solve)).check(matches((isEnabled())));
        onView(withId(R.id.t1_topic_practise)).check(matches(withText(t1_topic_practise)));
        onView(withId(R.id.t1_topic_practise)).check(matches(not(isEnabled())));

        onView(withId(R.id.t2_topic)).check(matches(withText(t2_topic)));
        onView(withId(R.id.t2_topic_title)).check(matches(withText(t2_topic_title)));
        onView(withId(R.id.t2_description)).check(matches(withText(t2_description)));
        onView(withId(R.id.t2_topic_solve)).check(matches(withText(t2_topic_solve)));
        onView(withId(R.id.t2_topic_solve)).check(matches((isEnabled())));
        onView(withId(R.id.t2_topic_practise)).check(matches(withText(t2_topic_practise)));
        onView(withId(R.id.t2_topic_practise)).check(matches(not(isEnabled())));

        //WHEN
        onView(withId(R.id.t1_topic_solve)).perform(click());

        //THEN
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
    public void whenT2MathSolveButtonIsClickedAndNotSolved() {
        onView(withId(R.id.math_button)).perform(click());

        //GIVEN
        onView(withId(R.id.t1_topic)).check(matches(withText(t1_topic)));
        onView(withId(R.id.t1_topic_title)).check(matches(withText(t1_topic_title)));
        onView(withId(R.id.t1_description)).check(matches(withText(t1_description)));
        onView(withId(R.id.t1_topic_solve)).check(matches(withText(t1_topic_solve)));
        onView(withId(R.id.t1_topic_solve)).check(matches((isEnabled())));
        onView(withId(R.id.t1_topic_practise)).check(matches(withText(t1_topic_practise)));
        onView(withId(R.id.t1_topic_practise)).check(matches(not(isEnabled())));

        onView(withId(R.id.t2_topic)).check(matches(withText(t2_topic)));
        onView(withId(R.id.t2_topic_title)).check(matches(withText(t2_topic_title)));
        onView(withId(R.id.t2_description)).check(matches(withText(t2_description)));
        onView(withId(R.id.t2_topic_solve)).check(matches(withText(t2_topic_solve)));
        onView(withId(R.id.t2_topic_solve)).check(matches((isEnabled())));
        onView(withId(R.id.t2_topic_practise)).check(matches(withText(t2_topic_practise)));
        onView(withId(R.id.t2_topic_practise)).check(matches(not(isEnabled())));

        //WHEN
        onView(withId(R.id.t2_topic_solve)).perform(click());

        //THEN
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
    public void whenBackButtonIsClickedAndT1AndT2IsNotSolved(){
        onView(withId(R.id.math_button)).perform(click());

        //GIVEN
        onView(withId(R.id.t1_topic)).check(matches(withText(t1_topic)));
        onView(withId(R.id.t1_topic_title)).check(matches(withText(t1_topic_title)));
        onView(withId(R.id.t1_description)).check(matches(withText(t1_description)));
        onView(withId(R.id.t1_topic_solve)).check(matches(withText(t1_topic_solve)));
        onView(withId(R.id.t1_topic_solve)).check(matches((isEnabled())));
        onView(withId(R.id.t1_topic_practise)).check(matches(withText(t1_topic_practise)));
        onView(withId(R.id.t1_topic_practise)).check(matches(not(isEnabled())));

        onView(withId(R.id.t2_topic)).check(matches(withText(t2_topic)));
        onView(withId(R.id.t2_topic_title)).check(matches(withText(t2_topic_title)));
        onView(withId(R.id.t2_description)).check(matches(withText(t2_description)));
        onView(withId(R.id.t2_topic_solve)).check(matches(withText(t2_topic_solve)));
        onView(withId(R.id.t2_topic_solve)).check(matches((isEnabled())));
        onView(withId(R.id.t2_topic_practise)).check(matches(withText(t2_topic_practise)));
        onView(withId(R.id.t2_topic_practise)).check(matches(not(isEnabled())));

        //When
        pressBack();

        //Then
        onView(withId(R.id.math_button)).check(matches(withText(maths_button)));
        onView(withId(R.id.english_button)).check(matches(withText(english_button)));
        onView(withId(R.id.geography_button)).check(matches(withText(geography_button)));
        onView(withId(R.id.math_level_id)).check(matches(withText(math_level+"%")));
        math_level_icon.check(matches(isDisplayed()));
        onView(withId(R.id.english_level_id)).check(matches(withText(english_level+"%")));
        english_level_icon.check(matches(isDisplayed()));
        onView(withId(R.id.geography_level_id)).check(matches(withText(geography_level+"%")));
        geography_level_icon.check(matches(isDisplayed()));
    }

}
