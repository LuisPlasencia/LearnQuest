package es.ulpgc.eite.da.learnquest.intrumentedTests;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.BoundedMatcher;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.filters.LargeTest;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import es.ulpgc.eite.da.learnquest.R;
import es.ulpgc.eite.da.learnquest.data.QuizRepository;
import es.ulpgc.eite.da.learnquest.data.RepositoryContract;
import es.ulpgc.eite.da.learnquest.finalQuiz.FinalQuizActivity;
import es.ulpgc.eite.da.learnquest.login.LoginActivity;

import static android.app.PendingIntent.getActivity;
import static androidx.core.util.Preconditions.checkNotNull;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.instanceOf;
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

    @After
    public void tearDown(){
        repository.resetInstance();
    }

    Context context =
            InstrumentationRegistry.getInstrumentation().getTargetContext();

    String title = context.getResources().getString(R.string.login_title);
    String title2 = context.getResources().getString(R.string.login_title2);
    String username = context.getResources().getString(R.string.login_username);
    String empty_answer = context.getString(R.string.empty_string);
    String correct = context.getString(R.string.correct_text);
    String incorrect = context.getString(R.string.incorrect_text);
    RepositoryContract repository = QuizRepository.getInstance(context);



    ///////////////////////////////////-- LOGIN --///////////////////////////////////
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
        onView(withId(R.id.username_input)).perform(typeText("Cunwang"));
        onView(withId(R.id.password_input)).perform(typeText("lechuga"));
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

        onView(withId(R.id.password_input)).perform(typeText("lechuga"));

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
        onView(withId(R.id.username_input)).perform(typeText("Cunwang"));

        onView(withId(R.id.password_input)).perform(typeText("cc"));

        pressBack();

        ViewInteraction appCompatButton = onView(withId(R.id.lets_go_button));
        appCompatButton.perform(click());

        //THEN
        onView(withText("Wrong password")).inRoot(withDecorView(not(mActivityTestRule.getActivity().getWindow().getDecorView()))).check(matches(isDisplayed()));
    }
        ///////////////////////////////////-- QUESTS --///////////////////////////////////
    public void goToQuest(){
        onView(withId(R.id.username_input)).perform(typeText("test"));
        onView(withId(R.id.password_input)).perform(typeText("test"));
        pressBack();
        ViewInteraction appCompatButton = onView(withId(R.id.lets_go_button));
        appCompatButton.perform(click());
        ViewInteraction appCompatButton2 = onView(withId(R.id.go_button));
        appCompatButton2.perform(click());
    }

    @Test
    public void clickingOnSubjectMaths () {
        goToQuest();

        //GIVEN
        onView(withId(R.id.choose_quest)).check(matches(withText("Choose your Quest!")));

        onView(new RecyclerViewMatcher(R.id.quests_list)
                .atPositionOnView(0, R.id.subjectName))
                .check(matches(withText("Maths")));
        onView(new RecyclerViewMatcher(R.id.quests_list)
                .atPositionOnView(1, R.id.subjectName))
                .check(matches(withText("English")));
        onView(new RecyclerViewMatcher(R.id.quests_list)
                .atPositionOnView(2, R.id.subjectName))
                .check(matches(withText("Geography")));

        //WHEN
        onView(new RecyclerViewMatcher(R.id.quests_list)
                .atPositionOnView(0, R.id.subjectName))
                .perform(click());

        //THEN
        onView(new RecyclerViewMatcher(R.id.quiz_unit_list)
                .atPositionOnView(0, R.id.quizunite_title))
                .check(matches(withText("Triangles")));
        onView(new RecyclerViewMatcher(R.id.quiz_unit_list)
                .atPositionOnView(1, R.id.quizunite_title))
                .check(matches(withText("Equations")));
        onView(new RecyclerViewMatcher(R.id.quiz_unit_list)
                .atPositionOnView(2, R.id.quizunite_title))
                .check(matches(withText("Logarithms")));

        onView(ViewMatchers.withId(R.id.quiz_unit_list)).perform(ViewActions.swipeUp());

        onView(new RecyclerViewMatcher(R.id.quiz_unit_list)
                .atPositionOnView(3, R.id.quizunite_title))
                .check(matches(withText("Math Riddles")));

    }

    @Test
    public void clickingOnSubjectEnglish () {
        goToQuest();

        //GIVEN
        onView(withId(R.id.choose_quest)).check(matches(withText("Choose your Quest!")));

        onView(new RecyclerViewMatcher(R.id.quests_list)
                .atPositionOnView(0, R.id.subjectName))
                .check(matches(withText("Maths")));
        onView(new RecyclerViewMatcher(R.id.quests_list)
                .atPositionOnView(1, R.id.subjectName))
                .check(matches(withText("English")));
        onView(new RecyclerViewMatcher(R.id.quests_list)
                .atPositionOnView(2, R.id.subjectName))
                .check(matches(withText("Geography")));

        //WHEN
        onView(new RecyclerViewMatcher(R.id.quests_list)
                .atPositionOnView(1, R.id.subjectName))
                .perform(click());

        //THEN
        onView(new RecyclerViewMatcher(R.id.quiz_unit_list)
                .atPositionOnView(0, R.id.quizunite_title))
                .check(matches(withText("-ing Form")));
        onView(new RecyclerViewMatcher(R.id.quiz_unit_list)
                .atPositionOnView(1, R.id.quizunite_title))
                .check(matches(withText("Infinitive or -ing")));
        onView(new RecyclerViewMatcher(R.id.quiz_unit_list)
                .atPositionOnView(2, R.id.quizunite_title))
                .check(matches(withText("Can, could, be able to")));

        onView(ViewMatchers.withId(R.id.quiz_unit_list)).perform(ViewActions.swipeUp());

        onView(new RecyclerViewMatcher(R.id.quiz_unit_list)
                .atPositionOnView(3, R.id.quizunite_title))
                .check(matches(withText("Reported Speech")));

    }

    @Test
    public void clickingOnSubjectGeography () {
        goToQuest();

        //GIVEN
        onView(withId(R.id.choose_quest)).check(matches(withText("Choose your Quest!")));

        onView(new RecyclerViewMatcher(R.id.quests_list)
                .atPositionOnView(0, R.id.subjectName))
                .check(matches(withText("Maths")));
        onView(new RecyclerViewMatcher(R.id.quests_list)
                .atPositionOnView(1, R.id.subjectName))
                .check(matches(withText("English")));
        onView(new RecyclerViewMatcher(R.id.quests_list)
                .atPositionOnView(2, R.id.subjectName))
                .check(matches(withText("Geography")));

        //WHEN
        onView(new RecyclerViewMatcher(R.id.quests_list)
                .atPositionOnView(2, R.id.subjectName))
                .perform(click());

        //THEN
        onView(new RecyclerViewMatcher(R.id.quiz_unit_list)
                .atPositionOnView(0, R.id.quizunite_title))
                .check(matches(withText("Autonomous community of Spain")));
        onView(new RecyclerViewMatcher(R.id.quiz_unit_list)
                .atPositionOnView(1, R.id.quizunite_title))
                .check(matches(withText("Provinces of Spain")));
        onView(new RecyclerViewMatcher(R.id.quiz_unit_list)
                .atPositionOnView(2, R.id.quizunite_title))
                .check(matches(withText("Municipalities of Spain")));

        onView(ViewMatchers.withId(R.id.quiz_unit_list)).perform(ViewActions.swipeUp());

        onView(new RecyclerViewMatcher(R.id.quiz_unit_list)
                .atPositionOnView(3, R.id.quizunite_title))
                .check(matches(withText("Culture and events in Spain")));

    }
    /////////////////////////////////////-QUIZ UNIT-////////////////////////////////////

    @Test
    public void clickingOnMathsTriangles(){
        goToQuest();

        onView(new RecyclerViewMatcher(R.id.quests_list)
                .atPositionOnView(0, R.id.subjectName))
                .perform(click());

        //GIVEN
        onView(new RecyclerViewMatcher(R.id.quiz_unit_list)
                .atPositionOnView(0, R.id.quizunite_title))
                .check(matches(withText("Triangles")));
        onView(new RecyclerViewMatcher(R.id.quiz_unit_list)
                .atPositionOnView(1, R.id.quizunite_title))
                .check(matches(withText("Equations")));
        onView(new RecyclerViewMatcher(R.id.quiz_unit_list)
                .atPositionOnView(2, R.id.quizunite_title))
                .check(matches(withText("Logarithms")));

        onView(ViewMatchers.withId(R.id.quiz_unit_list)).perform(ViewActions.swipeUp());

        onView(new RecyclerViewMatcher(R.id.quiz_unit_list)
                .atPositionOnView(3, R.id.quizunite_title))
                .check(matches(withText("Math Riddles")));

        onView(ViewMatchers.withId(R.id.quiz_unit_list)).perform(ViewActions.swipeDown());

        //WHEN
        onView(new RecyclerViewMatcher(R.id.quiz_unit_list)
                .atPositionOnView(0, R.id.quizunit_solve_button))
                .perform(click());
        //THEN
        onView(withId(R.id.question_math_number)).check(matches(withText("Question 1")));
        onView(withId(R.id.mathTitle)).check(matches(withText("If a triangle has two angles whose values are 98º and 45º respectively, which is the value of the last angle?")));
        onView(withId(R.id.user_answer_math)).check(matches(withText("")));
        onView(withId(R.id.answer_math)).check(matches(withText("")));

        onView(withId(R.id.math_quiz_0)).check(matches(withText("0")));
        onView(withId(R.id.math_quiz_1)).check(matches(withText("1")));
        onView(withId(R.id.math_quiz_2)).check(matches(withText("2")));
        onView(withId(R.id.math_quiz_3)).check(matches(withText("3")));
        onView(withId(R.id.math_quiz_4)).check(matches(withText("4")));
        onView(withId(R.id.math_quiz_5)).check(matches(withText("5")));
        onView(withId(R.id.math_quiz_6)).check(matches(withText("6")));
        onView(withId(R.id.math_quiz_7)).check(matches(withText("7")));
        onView(withId(R.id.math_quiz_8)).check(matches(withText("8")));
        onView(withId(R.id.math_quiz_9)).check(matches(withText("9")));
        onView(withId(R.id.math_quiz_next)).check(matches(withText("Next")));
        onView(withId(R.id.math_quiz_clean)).check(matches(withText("Clean")));
        onView(withId(R.id.math_quiz_hint)).check(matches(withText("Hint")));
        onView(withId(R.id.math_quiz_enter)).check(matches(withText("Enter")));

        onView(withId(R.id.math_quiz_0)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_1)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_2)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_3)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_4)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_5)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_6)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_7)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_8)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_9)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_next)).check(matches(not(isEnabled())));
        onView(withId(R.id.math_quiz_hint)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_enter)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_clean)).check(matches(isEnabled()));

    }

    @Test
    public void clickingOnMathsTriangleWrongAnswerFirstQuestion(){
        goToQuest();
        onView(new RecyclerViewMatcher(R.id.quests_list)
                .atPositionOnView(0, R.id.subjectName))
                .perform(click());
        onView(new RecyclerViewMatcher(R.id.quiz_unit_list)
                .atPositionOnView(0, R.id.quizunit_solve_button))
                .perform(click());

        //GIVEN
        onView(withId(R.id.question_math_number)).check(matches(withText("Question 1")));
        onView(withId(R.id.mathTitle)).check(matches(withText("If a triangle has two angles whose values are 98º and 45º respectively, which is the value of the last angle?")));
        onView(withId(R.id.user_answer_math)).check(matches(withText("")));

        onView(withId(R.id.math_quiz_0)).check(matches(withText("0")));
        onView(withId(R.id.math_quiz_1)).check(matches(withText("1")));
        onView(withId(R.id.math_quiz_2)).check(matches(withText("2")));
        onView(withId(R.id.math_quiz_3)).check(matches(withText("3")));
        onView(withId(R.id.math_quiz_4)).check(matches(withText("4")));
        onView(withId(R.id.math_quiz_5)).check(matches(withText("5")));
        onView(withId(R.id.math_quiz_6)).check(matches(withText("6")));
        onView(withId(R.id.math_quiz_7)).check(matches(withText("7")));
        onView(withId(R.id.math_quiz_8)).check(matches(withText("8")));
        onView(withId(R.id.math_quiz_9)).check(matches(withText("9")));
        onView(withId(R.id.math_quiz_next)).check(matches(withText("Next")));
        onView(withId(R.id.math_quiz_clean)).check(matches(withText("Clean")));
        onView(withId(R.id.math_quiz_hint)).check(matches(withText("Hint")));
        onView(withId(R.id.math_quiz_enter)).check(matches(withText("Enter")));

        onView(withId(R.id.math_quiz_0)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_1)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_2)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_3)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_4)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_5)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_6)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_7)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_8)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_9)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_next)).check(matches(not(isEnabled())));
        onView(withId(R.id.math_quiz_hint)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_enter)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_clean)).check(matches(isEnabled()));

        //WHEN
        onView(withId(R.id.math_quiz_1)).perform(click());
        onView(withId(R.id.math_quiz_0)).perform(click());
        onView(withId(R.id.user_answer_math)).check(matches(withText("10")));
        onView(withId(R.id.math_quiz_enter)).perform(click());

        //THEN
        onView(withId(R.id.question_math_number)).check(matches(withText("Question 1")));
        onView(withId(R.id.mathTitle)).check(matches(withText("If a triangle has two angles whose values are 98º and 45º respectively, which is the value of the last angle?")));
        onView(withId(R.id.answer_math)).check(matches(withText("Incorrect")));
        onView(withId(R.id.user_answer_math)).check(matches(withText("")));

        onView(withId(R.id.math_quiz_0)).check(matches(withText("0")));
        onView(withId(R.id.math_quiz_1)).check(matches(withText("1")));
        onView(withId(R.id.math_quiz_2)).check(matches(withText("2")));
        onView(withId(R.id.math_quiz_3)).check(matches(withText("3")));
        onView(withId(R.id.math_quiz_4)).check(matches(withText("4")));
        onView(withId(R.id.math_quiz_5)).check(matches(withText("5")));
        onView(withId(R.id.math_quiz_6)).check(matches(withText("6")));
        onView(withId(R.id.math_quiz_7)).check(matches(withText("7")));
        onView(withId(R.id.math_quiz_8)).check(matches(withText("8")));
        onView(withId(R.id.math_quiz_9)).check(matches(withText("9")));
        onView(withId(R.id.math_quiz_next)).check(matches(withText("Next")));
        onView(withId(R.id.math_quiz_clean)).check(matches(withText("Clean")));
        onView(withId(R.id.math_quiz_hint)).check(matches(withText("Hint")));
        onView(withId(R.id.math_quiz_enter)).check(matches(withText("Enter")));

        onView(withId(R.id.math_quiz_0)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_1)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_2)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_3)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_4)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_5)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_6)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_7)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_8)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_9)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_next)).check(matches(not(isEnabled())));
        onView(withId(R.id.math_quiz_hint)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_enter)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_clean)).check(matches(isEnabled()));
    }

    @Test
    public void clickingOnMathsTriangleCorrectAnswerFirstQuestion(){
        goToQuest();
        onView(new RecyclerViewMatcher(R.id.quests_list)
                .atPositionOnView(0, R.id.subjectName))
                .perform(click());
        onView(new RecyclerViewMatcher(R.id.quiz_unit_list)
                .atPositionOnView(0, R.id.quizunit_solve_button))
                .perform(click());

        //GIVEN
        onView(withId(R.id.question_math_number)).check(matches(withText("Question 1")));
        onView(withId(R.id.mathTitle)).check(matches(withText("If a triangle has two angles whose values are 98º and 45º respectively, which is the value of the last angle?")));
        onView(withId(R.id.user_answer_math)).check(matches(withText("")));

        onView(withId(R.id.math_quiz_0)).check(matches(withText("0")));
        onView(withId(R.id.math_quiz_1)).check(matches(withText("1")));
        onView(withId(R.id.math_quiz_2)).check(matches(withText("2")));
        onView(withId(R.id.math_quiz_3)).check(matches(withText("3")));
        onView(withId(R.id.math_quiz_4)).check(matches(withText("4")));
        onView(withId(R.id.math_quiz_5)).check(matches(withText("5")));
        onView(withId(R.id.math_quiz_6)).check(matches(withText("6")));
        onView(withId(R.id.math_quiz_7)).check(matches(withText("7")));
        onView(withId(R.id.math_quiz_8)).check(matches(withText("8")));
        onView(withId(R.id.math_quiz_9)).check(matches(withText("9")));
        onView(withId(R.id.math_quiz_next)).check(matches(withText("Next")));
        onView(withId(R.id.math_quiz_clean)).check(matches(withText("Clean")));
        onView(withId(R.id.math_quiz_hint)).check(matches(withText("Hint")));
        onView(withId(R.id.math_quiz_enter)).check(matches(withText("Enter")));

        onView(withId(R.id.math_quiz_0)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_1)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_2)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_3)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_4)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_5)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_6)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_7)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_8)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_9)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_next)).check(matches(not(isEnabled())));
        onView(withId(R.id.math_quiz_hint)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_enter)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_clean)).check(matches(isEnabled()));

        //WHEN
        onView(withId(R.id.math_quiz_3)).perform(click());
        onView(withId(R.id.math_quiz_7)).perform(click());
        onView(withId(R.id.user_answer_math)).check(matches(withText("37")));
        onView(withId(R.id.math_quiz_enter)).perform(click());

        //THEN
        onView(withId(R.id.question_math_number)).check(matches(withText("Question 1")));
        onView(withId(R.id.mathTitle)).check(matches(withText("If a triangle has two angles whose values are 98º and 45º respectively, which is the value of the last angle?")));
        onView(withId(R.id.answer_math)).check(matches(withText("Correct")));
        onView(withId(R.id.user_answer_math)).check(matches(withText("")));

        onView(withId(R.id.math_quiz_0)).check(matches(withText("0")));
        onView(withId(R.id.math_quiz_1)).check(matches(withText("1")));
        onView(withId(R.id.math_quiz_2)).check(matches(withText("2")));
        onView(withId(R.id.math_quiz_3)).check(matches(withText("3")));
        onView(withId(R.id.math_quiz_4)).check(matches(withText("4")));
        onView(withId(R.id.math_quiz_5)).check(matches(withText("5")));
        onView(withId(R.id.math_quiz_6)).check(matches(withText("6")));
        onView(withId(R.id.math_quiz_7)).check(matches(withText("7")));
        onView(withId(R.id.math_quiz_8)).check(matches(withText("8")));
        onView(withId(R.id.math_quiz_9)).check(matches(withText("9")));
        onView(withId(R.id.math_quiz_next)).check(matches(withText("Next")));
        onView(withId(R.id.math_quiz_clean)).check(matches(withText("Clean")));
        onView(withId(R.id.math_quiz_hint)).check(matches(withText("Hint")));
        onView(withId(R.id.math_quiz_enter)).check(matches(withText("Enter")));

        onView(withId(R.id.math_quiz_0)).check(matches(not(isEnabled())));
        onView(withId(R.id.math_quiz_1)).check(matches(not(isEnabled())));
        onView(withId(R.id.math_quiz_2)).check(matches(not(isEnabled())));
        onView(withId(R.id.math_quiz_3)).check(matches(not(isEnabled())));
        onView(withId(R.id.math_quiz_4)).check(matches(not(isEnabled())));
        onView(withId(R.id.math_quiz_5)).check(matches(not(isEnabled())));
        onView(withId(R.id.math_quiz_6)).check(matches(not(isEnabled())));
        onView(withId(R.id.math_quiz_7)).check(matches(not(isEnabled())));
        onView(withId(R.id.math_quiz_8)).check(matches(not(isEnabled())));
        onView(withId(R.id.math_quiz_9)).check(matches(not(isEnabled())));
        onView(withId(R.id.math_quiz_next)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_hint)).check(matches(not(isEnabled())));
        onView(withId(R.id.math_quiz_enter)).check(matches(not(isEnabled())));
        onView(withId(R.id.math_quiz_clean)).check(matches(not(isEnabled())));
    }

    @Test
    public void clickingOnMathsTriangleAnswerFirstQuestionCleanButton(){
        goToQuest();
        onView(new RecyclerViewMatcher(R.id.quests_list)
                .atPositionOnView(0, R.id.subjectName))
                .perform(click());
        onView(new RecyclerViewMatcher(R.id.quiz_unit_list)
                .atPositionOnView(0, R.id.quizunit_solve_button))
                .perform(click());

        //GIVEN
        onView(withId(R.id.question_math_number)).check(matches(withText("Question 1")));
        onView(withId(R.id.mathTitle)).check(matches(withText("If a triangle has two angles whose values are 98º and 45º respectively, which is the value of the last angle?")));
        onView(withId(R.id.user_answer_math)).check(matches(withText("")));

        onView(withId(R.id.math_quiz_0)).check(matches(withText("0")));
        onView(withId(R.id.math_quiz_1)).check(matches(withText("1")));
        onView(withId(R.id.math_quiz_2)).check(matches(withText("2")));
        onView(withId(R.id.math_quiz_3)).check(matches(withText("3")));
        onView(withId(R.id.math_quiz_4)).check(matches(withText("4")));
        onView(withId(R.id.math_quiz_5)).check(matches(withText("5")));
        onView(withId(R.id.math_quiz_6)).check(matches(withText("6")));
        onView(withId(R.id.math_quiz_7)).check(matches(withText("7")));
        onView(withId(R.id.math_quiz_8)).check(matches(withText("8")));
        onView(withId(R.id.math_quiz_9)).check(matches(withText("9")));
        onView(withId(R.id.math_quiz_next)).check(matches(withText("Next")));
        onView(withId(R.id.math_quiz_clean)).check(matches(withText("Clean")));
        onView(withId(R.id.math_quiz_hint)).check(matches(withText("Hint")));
        onView(withId(R.id.math_quiz_enter)).check(matches(withText("Enter")));

        onView(withId(R.id.math_quiz_0)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_1)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_2)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_3)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_4)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_5)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_6)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_7)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_8)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_9)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_next)).check(matches(not(isEnabled())));
        onView(withId(R.id.math_quiz_hint)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_enter)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_clean)).check(matches(isEnabled()));

        onView(withId(R.id.math_quiz_3)).perform(click());
        onView(withId(R.id.math_quiz_7)).perform(click());
        onView(withId(R.id.user_answer_math)).check(matches(withText("37")));

        //WHEN
        onView(withId(R.id.math_quiz_clean)).perform(click());

        //THEN
        onView(withId(R.id.question_math_number)).check(matches(withText("Question 1")));
        onView(withId(R.id.mathTitle)).check(matches(withText("If a triangle has two angles whose values are 98º and 45º respectively, which is the value of the last angle?")));
        onView(withId(R.id.user_answer_math)).check(matches(withText("")));

        onView(withId(R.id.math_quiz_0)).check(matches(withText("0")));
        onView(withId(R.id.math_quiz_1)).check(matches(withText("1")));
        onView(withId(R.id.math_quiz_2)).check(matches(withText("2")));
        onView(withId(R.id.math_quiz_3)).check(matches(withText("3")));
        onView(withId(R.id.math_quiz_4)).check(matches(withText("4")));
        onView(withId(R.id.math_quiz_5)).check(matches(withText("5")));
        onView(withId(R.id.math_quiz_6)).check(matches(withText("6")));
        onView(withId(R.id.math_quiz_7)).check(matches(withText("7")));
        onView(withId(R.id.math_quiz_8)).check(matches(withText("8")));
        onView(withId(R.id.math_quiz_9)).check(matches(withText("9")));
        onView(withId(R.id.math_quiz_next)).check(matches(withText("Next")));
        onView(withId(R.id.math_quiz_clean)).check(matches(withText("Clean")));
        onView(withId(R.id.math_quiz_hint)).check(matches(withText("Hint")));
        onView(withId(R.id.math_quiz_enter)).check(matches(withText("Enter")));

        onView(withId(R.id.math_quiz_0)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_1)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_2)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_3)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_4)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_5)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_6)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_7)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_8)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_9)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_next)).check(matches(not(isEnabled())));
        onView(withId(R.id.math_quiz_hint)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_enter)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_clean)).check(matches(isEnabled()));
    }

    @Test
    public void clickingOnMathsTriangleAnswerFirstQuestionHintButton(){
        goToQuest();
        onView(new RecyclerViewMatcher(R.id.quests_list)
                .atPositionOnView(0, R.id.subjectName))
                .perform(click());
        onView(new RecyclerViewMatcher(R.id.quiz_unit_list)
                .atPositionOnView(0, R.id.quizunit_solve_button))
                .perform(click());

        //GIVEN
        onView(withId(R.id.question_math_number)).check(matches(withText("Question 1")));
        onView(withId(R.id.mathTitle)).check(matches(withText("If a triangle has two angles whose values are 98º and 45º respectively, which is the value of the last angle?")));
        onView(withId(R.id.user_answer_math)).check(matches(withText("")));

        onView(withId(R.id.math_quiz_0)).check(matches(withText("0")));
        onView(withId(R.id.math_quiz_1)).check(matches(withText("1")));
        onView(withId(R.id.math_quiz_2)).check(matches(withText("2")));
        onView(withId(R.id.math_quiz_3)).check(matches(withText("3")));
        onView(withId(R.id.math_quiz_4)).check(matches(withText("4")));
        onView(withId(R.id.math_quiz_5)).check(matches(withText("5")));
        onView(withId(R.id.math_quiz_6)).check(matches(withText("6")));
        onView(withId(R.id.math_quiz_7)).check(matches(withText("7")));
        onView(withId(R.id.math_quiz_8)).check(matches(withText("8")));
        onView(withId(R.id.math_quiz_9)).check(matches(withText("9")));
        onView(withId(R.id.math_quiz_next)).check(matches(withText("Next")));
        onView(withId(R.id.math_quiz_clean)).check(matches(withText("Clean")));
        onView(withId(R.id.math_quiz_hint)).check(matches(withText("Hint")));
        onView(withId(R.id.math_quiz_enter)).check(matches(withText("Enter")));

        onView(withId(R.id.math_quiz_0)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_1)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_2)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_3)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_4)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_5)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_6)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_7)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_8)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_9)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_next)).check(matches(not(isEnabled())));
        onView(withId(R.id.math_quiz_hint)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_enter)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_clean)).check(matches(isEnabled()));

        //WHEN
        onView(withId(R.id.math_quiz_hint)).perform(click());
        onView(withId(R.id.math_quiz_hint)).perform(click());

        //THEN
        onView(withId(R.id.question_math_number)).check(matches(withText("Question 1")));
        onView(withId(R.id.mathTitle)).check(matches(withText("If a triangle has two angles whose values are 98º and 45º respectively, which is the value of the last angle?")));
        onView(withId(R.id.user_answer_math)).check(matches(withText("")));

        onView(withId(R.id.math_quiz_0)).check(matches(withText("0")));
        onView(withId(R.id.math_quiz_1)).check(matches(withText("1")));
        onView(withId(R.id.math_quiz_2)).check(matches(withText("2")));
        onView(withId(R.id.math_quiz_3)).check(matches(withText("3")));
        onView(withId(R.id.math_quiz_4)).check(matches(withText("4")));
        onView(withId(R.id.math_quiz_5)).check(matches(withText("5")));
        onView(withId(R.id.math_quiz_6)).check(matches(withText("6")));
        onView(withId(R.id.math_quiz_7)).check(matches(withText("7")));
        onView(withId(R.id.math_quiz_8)).check(matches(withText("8")));
        onView(withId(R.id.math_quiz_9)).check(matches(withText("9")));
        onView(withId(R.id.math_quiz_next)).check(matches(withText("Next")));
        onView(withId(R.id.math_quiz_clean)).check(matches(withText("Clean")));
        onView(withId(R.id.math_quiz_hint)).check(matches(withText("Hint")));
        onView(withId(R.id.math_quiz_enter)).check(matches(withText("Enter")));

        onView(withId(R.id.math_quiz_0)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_1)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_2)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_3)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_4)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_5)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_6)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_7)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_8)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_9)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_next)).check(matches(not(isEnabled())));
        onView(withId(R.id.math_quiz_hint)).check(matches(not(isEnabled())));
        onView(withId(R.id.math_quiz_enter)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_clean)).check(matches(isEnabled()));
    }

    @Test
    public void clickingOnMathsTriangleAnswerFirstQuestionNextButton(){
        goToQuest();
        onView(new RecyclerViewMatcher(R.id.quests_list)
                .atPositionOnView(0, R.id.subjectName))
                .perform(click());


        onView(new RecyclerViewMatcher(R.id.quiz_unit_list)
                .atPositionOnView(0, R.id.quizunit_solve_button))
                .perform(click());

        //GIVEN
        onView(withId(R.id.math_quiz_3)).perform(click());
        onView(withId(R.id.math_quiz_7)).perform(click());
        onView(withId(R.id.user_answer_math)).check(matches(withText("37")));
        onView(withId(R.id.math_quiz_enter)).perform(click());

        onView(withId(R.id.question_math_number)).check(matches(withText("Question 1")));
        onView(withId(R.id.mathTitle)).check(matches(withText("If a triangle has two angles whose values are 98º and 45º respectively, which is the value of the last angle?")));
        onView(withId(R.id.answer_math)).check(matches(withText("Correct")));
        onView(withId(R.id.user_answer_math)).check(matches(withText("")));

        onView(withId(R.id.math_quiz_0)).check(matches(withText("0")));
        onView(withId(R.id.math_quiz_1)).check(matches(withText("1")));
        onView(withId(R.id.math_quiz_2)).check(matches(withText("2")));
        onView(withId(R.id.math_quiz_3)).check(matches(withText("3")));
        onView(withId(R.id.math_quiz_4)).check(matches(withText("4")));
        onView(withId(R.id.math_quiz_5)).check(matches(withText("5")));
        onView(withId(R.id.math_quiz_6)).check(matches(withText("6")));
        onView(withId(R.id.math_quiz_7)).check(matches(withText("7")));
        onView(withId(R.id.math_quiz_8)).check(matches(withText("8")));
        onView(withId(R.id.math_quiz_9)).check(matches(withText("9")));
        onView(withId(R.id.math_quiz_next)).check(matches(withText("Next")));
        onView(withId(R.id.math_quiz_clean)).check(matches(withText("Clean")));
        onView(withId(R.id.math_quiz_hint)).check(matches(withText("Hint")));
        onView(withId(R.id.math_quiz_enter)).check(matches(withText("Enter")));

        onView(withId(R.id.math_quiz_0)).check(matches(not(isEnabled())));
        onView(withId(R.id.math_quiz_1)).check(matches(not(isEnabled())));
        onView(withId(R.id.math_quiz_2)).check(matches(not(isEnabled())));
        onView(withId(R.id.math_quiz_3)).check(matches(not(isEnabled())));
        onView(withId(R.id.math_quiz_4)).check(matches(not(isEnabled())));
        onView(withId(R.id.math_quiz_5)).check(matches(not(isEnabled())));
        onView(withId(R.id.math_quiz_6)).check(matches(not(isEnabled())));
        onView(withId(R.id.math_quiz_7)).check(matches(not(isEnabled())));
        onView(withId(R.id.math_quiz_8)).check(matches(not(isEnabled())));
        onView(withId(R.id.math_quiz_9)).check(matches(not(isEnabled())));
        onView(withId(R.id.math_quiz_next)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_hint)).check(matches(not(isEnabled())));
        onView(withId(R.id.math_quiz_enter)).check(matches(not(isEnabled())));
        onView(withId(R.id.math_quiz_clean)).check(matches(not(isEnabled())));

        //WHEN

        onView(withId(R.id.math_quiz_next)).perform(click());

        //THEN
        onView(withId(R.id.question_math_number)).check(matches(withText("Question 2")));
        onView(withId(R.id.mathTitle)).check(matches(withText("Acute triangle has three angles < x?")));
        onView(withId(R.id.user_answer_math)).check(matches(withText("")));

        onView(withId(R.id.math_quiz_0)).check(matches(withText("0")));
        onView(withId(R.id.math_quiz_1)).check(matches(withText("1")));
        onView(withId(R.id.math_quiz_2)).check(matches(withText("2")));
        onView(withId(R.id.math_quiz_3)).check(matches(withText("3")));
        onView(withId(R.id.math_quiz_4)).check(matches(withText("4")));
        onView(withId(R.id.math_quiz_5)).check(matches(withText("5")));
        onView(withId(R.id.math_quiz_6)).check(matches(withText("6")));
        onView(withId(R.id.math_quiz_7)).check(matches(withText("7")));
        onView(withId(R.id.math_quiz_8)).check(matches(withText("8")));
        onView(withId(R.id.math_quiz_9)).check(matches(withText("9")));
        onView(withId(R.id.math_quiz_next)).check(matches(withText("Next")));
        onView(withId(R.id.math_quiz_clean)).check(matches(withText("Clean")));
        onView(withId(R.id.math_quiz_hint)).check(matches(withText("Hint")));
        onView(withId(R.id.math_quiz_enter)).check(matches(withText("Enter")));

        onView(withId(R.id.math_quiz_0)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_1)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_2)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_3)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_4)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_5)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_6)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_7)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_8)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_9)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_next)).check(matches(not(isEnabled())));
        onView(withId(R.id.math_quiz_hint)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_enter)).check(matches(isEnabled()));
        onView(withId(R.id.math_quiz_clean)).check(matches(isEnabled()));
    }


    @Test
    public void englishQuizTimeout() {
        goToQuest();

        //GIVEN
        onView(new RecyclerViewMatcher(R.id.quests_list)
                .atPositionOnView(0, R.id.quest_level_id))
                .check(matches(withText("0%")));

        onView(new RecyclerViewMatcher(R.id.quests_list)
                .atPositionOnView(1, R.id.quest_level_id))
                .check(matches(withText("0%")));

        onView(new RecyclerViewMatcher(R.id.quests_list)
                .atPositionOnView(2, R.id.quest_level_id))
                .check(matches(withText("0%")));


        //WHEN
        onView(new RecyclerViewMatcher(R.id.quests_list)
                .atPositionOnView(1, R.id.subjectName))
                .perform(click());


        //THEN & GIVEN
        onView(new RecyclerViewMatcher(R.id.quiz_unit_list)
                .atPositionOnView(0, R.id.mark))
                .check(matches(withText("0%")));

        onView(new RecyclerViewMatcher(R.id.quiz_unit_list)
                .atPositionOnView(1, R.id.mark))
                .check(matches(withText("0%")));

        onView(new RecyclerViewMatcher(R.id.quiz_unit_list)
                .atPositionOnView(0, R.id.quizunit_practica_button))
                .check(matches(not(isEnabled())));

        onView(new RecyclerViewMatcher(R.id.quiz_unit_list)
                .atPositionOnView(0, R.id.quizunit_solve_button))
                .check(matches(isEnabled()));

        onView(ViewMatchers.withId(R.id.quiz_unit_list)).perform(ViewActions.swipeUp());


        onView(new RecyclerViewMatcher(R.id.quiz_unit_list)
                .atPositionOnView(2, R.id.mark))
                .check(matches(withText("0%")));

        onView(new RecyclerViewMatcher(R.id.quiz_unit_list)
                .atPositionOnView(3, R.id.mark))
                .check(matches(withText("0%")));

        onView(ViewMatchers.withId(R.id.quiz_unit_list)).perform(ViewActions.swipeDown());


        //WHEN
        onView(new RecyclerViewMatcher(R.id.quiz_unit_list)
                .atPositionOnView(0, R.id.quizunit_solve_button))
                .perform(click());


        //THEN & GIVEN
        onView(withId(R.id.question_number)).check(matches(withText("1")));
        onView(withId(R.id.question_text)).check(matches(withText("I dislike ______ to the movies by myself")));
        onView(withId(R.id.option1_button)).check(matches(withText("going")));
        onView(withId(R.id.option2_button)).check(matches(withText("to go")));
        onView(withId(R.id.option3_button)).check(matches(withText("going/to go")));
        onView(withId(R.id.answer_text)).check(matches(withText(empty_answer)));
        onView(withId(R.id.nextButton))
                .check(matches(not(isEnabled())));
        onView(withId(R.id.cheatButton))
                .check(matches(isEnabled()));

        //WHEN (Se acaba el timer)
        try {
            Thread.sleep(21000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //THEN & GIVEN
        onView(withId(R.id.option1_button)).check(matches(not(isEnabled())));
        onView(withId(R.id.option2_button)).check(matches(not(isEnabled())));
        onView(withId(R.id.option3_button)).check(matches(not(isEnabled())));
        onView(withId(R.id.cheatButton))
                .check(matches(not(isEnabled())));
        onView(withId(R.id.nextButton))
                .check(matches(isEnabled()));
        onView(withId(R.id.answer_text)).check(matches(withText("Timeout!")));
    }


    @Test
    public void englishQuizAllCorrectAndReturn() {
        goToQuest();

        //GIVEN
        onView(new RecyclerViewMatcher(R.id.quests_list)
                .atPositionOnView(0, R.id.quest_level_id))
                .check(matches(withText("0%")));

        onView(new RecyclerViewMatcher(R.id.quests_list)
                .atPositionOnView(1, R.id.quest_level_id))
                .check(matches(withText("0%")));

        onView(new RecyclerViewMatcher(R.id.quests_list)
                .atPositionOnView(2, R.id.quest_level_id))
                .check(matches(withText("0%")));


        //WHEN
        onView(new RecyclerViewMatcher(R.id.quests_list)
                .atPositionOnView(1, R.id.subjectName))
                .perform(click());


        //THEN & GIVEN
        onView(new RecyclerViewMatcher(R.id.quiz_unit_list)
                .atPositionOnView(0, R.id.mark))
                .check(matches(withText("0%")));

        onView(new RecyclerViewMatcher(R.id.quiz_unit_list)
                .atPositionOnView(1, R.id.mark))
                .check(matches(withText("0%")));

        onView(new RecyclerViewMatcher(R.id.quiz_unit_list)
                .atPositionOnView(0, R.id.quizunit_practica_button))
                .check(matches(not(isEnabled())));

        onView(new RecyclerViewMatcher(R.id.quiz_unit_list)
                .atPositionOnView(0, R.id.quizunit_solve_button))
                .check(matches(isEnabled()));

        onView(ViewMatchers.withId(R.id.quiz_unit_list)).perform(ViewActions.swipeUp());


        onView(new RecyclerViewMatcher(R.id.quiz_unit_list)
                .atPositionOnView(2, R.id.mark))
                .check(matches(withText("0%")));

        onView(new RecyclerViewMatcher(R.id.quiz_unit_list)
                .atPositionOnView(3, R.id.mark))
                .check(matches(withText("0%")));

        onView(ViewMatchers.withId(R.id.quiz_unit_list)).perform(ViewActions.swipeDown());


        //WHEN
        onView(new RecyclerViewMatcher(R.id.quiz_unit_list)
                .atPositionOnView(0, R.id.quizunit_solve_button))
                .perform(click());


        //THEN & GIVEN
        onView(withId(R.id.question_number)).check(matches(withText("1")));
        onView(withId(R.id.question_text)).check(matches(withText("I dislike ______ to the movies by myself")));
        onView(withId(R.id.option1_button)).check(matches(withText("going")));
        onView(withId(R.id.option2_button)).check(matches(withText("to go")));
        onView(withId(R.id.option3_button)).check(matches(withText("going/to go")));
        onView(withId(R.id.answer_text)).check(matches(withText(empty_answer)));
        onView(withId(R.id.nextButton))
                .check(matches(not(isEnabled())));
        onView(withId(R.id.cheatButton))
                .check(matches(isEnabled()));

        //WHEN
        onView(withId(R.id.option1_button)).perform(click());


        //THEN & GIVEN
        onView(withId(R.id.option1_button)).check(matches(not(isEnabled())));
        onView(withId(R.id.option2_button)).check(matches(not(isEnabled())));
        onView(withId(R.id.option3_button)).check(matches(not(isEnabled())));
        onView(withId(R.id.cheatButton))
                .check(matches(not(isEnabled())));
        onView(withId(R.id.nextButton))
                .check(matches(isEnabled()));
        onView(withId(R.id.answer_text)).check(matches(withText(correct)));


        //WHEN
        ViewInteraction appCompatButton3 = onView(withId(R.id.nextButton));
        appCompatButton3.perform(click());


        //THEN & GIVEN
        onView(withId(R.id.question_number)).check(matches(withText("2")));
        onView(withId(R.id.question_text)).check(matches(withText("We started ______ dinner without you")));
        onView(withId(R.id.option1_button)).check(matches(withText("eating")));
        onView(withId(R.id.option2_button)).check(matches(withText("to eat")));
        onView(withId(R.id.option3_button)).check(matches(withText("eating/to eat")));
        onView(withId(R.id.answer_text)).check(matches(withText(empty_answer)));
        onView(withId(R.id.nextButton))
                .check(matches(not(isEnabled())));
        onView(withId(R.id.cheatButton))
                .check(matches(isEnabled()));

        //WHEN
        onView(withId(R.id.option3_button)).perform(click());

        //THEN & GIVEN
        onView(withId(R.id.option1_button)).check(matches(not(isEnabled())));
        onView(withId(R.id.option2_button)).check(matches(not(isEnabled())));
        onView(withId(R.id.option3_button)).check(matches(not(isEnabled())));
        onView(withId(R.id.cheatButton))
                .check(matches(not(isEnabled())));
        onView(withId(R.id.nextButton))
                .check(matches(isEnabled()));
        onView(withId(R.id.answer_text)).check(matches(withText(correct)));

        //WHEN
        ViewInteraction appCompatButton4 = onView(withId(R.id.nextButton));
        appCompatButton4.perform(click());


        //THEN & GIVEN
        onView(withId(R.id.question_number)).check(matches(withText("3")));
        onView(withId(R.id.question_text)).check(matches(withText("I can't imagine ______ my own house")));
        onView(withId(R.id.option1_button)).check(matches(withText("buying")));
        onView(withId(R.id.option2_button)).check(matches(withText("to buy")));
        onView(withId(R.id.option3_button)).check(matches(withText("buying/to buy")));
        onView(withId(R.id.answer_text)).check(matches(withText(empty_answer)));
        onView(withId(R.id.nextButton))
                .check(matches(not(isEnabled())));
        onView(withId(R.id.cheatButton))
                .check(matches(isEnabled()));

        //WHEN
        onView(withId(R.id.option1_button)).perform(click());


        //THEN & GIVEN
        onView(withId(R.id.option1_button)).check(matches(not(isEnabled())));
        onView(withId(R.id.option2_button)).check(matches(not(isEnabled())));
        onView(withId(R.id.option3_button)).check(matches(not(isEnabled())));
        onView(withId(R.id.cheatButton))
                .check(matches(not(isEnabled())));
        onView(withId(R.id.nextButton))
                .check(matches(isEnabled()));
        onView(withId(R.id.answer_text)).check(matches(withText(correct)));


        //WHEN
        ViewInteraction appCompatButton5 = onView(withId(R.id.nextButton));
        appCompatButton5.perform(click());


        //THEN & GIVEN
        onView(withId(R.id.question_number)).check(matches(withText("4")));
        onView(withId(R.id.question_text)).check(matches(withText("I used ______ that television show all the time")));
        onView(withId(R.id.option1_button)).check(matches(withText("watching")));
        onView(withId(R.id.option2_button)).check(matches(withText("to watch")));
        onView(withId(R.id.option3_button)).check(matches(withText("watching/to watch")));
        onView(withId(R.id.answer_text)).check(matches(withText(empty_answer)));
        onView(withId(R.id.nextButton))
                .check(matches(not(isEnabled())));
        onView(withId(R.id.cheatButton))
                .check(matches(isEnabled()));


        //WHEN
        onView(withId(R.id.option2_button)).perform(click());


        //THEN & GIVEN
        onView(withId(R.id.option1_button)).check(matches(not(isEnabled())));
        onView(withId(R.id.option2_button)).check(matches(not(isEnabled())));
        onView(withId(R.id.option3_button)).check(matches(not(isEnabled())));
        onView(withId(R.id.cheatButton))
                .check(matches(not(isEnabled())));
        onView(withId(R.id.nextButton))
                .check(matches(isEnabled()));
        onView(withId(R.id.answer_text)).check(matches(withText(correct)));


        //WHEN
        ViewInteraction appCompatButton6 = onView(withId(R.id.nextButton));
        appCompatButton6.perform(click());



        //THEN % GIVEN
        ViewInteraction imageView = onView(withId(R.id.medal));
        imageView.check(matches(isDisplayed()));

        ViewInteraction textView = onView(withId(R.id.earned));
        textView.check(matches(withText("You earned 100xp!")));

        ViewInteraction textView6 = onView(withId(R.id.exp_to_nextlevel));
        textView6.check(matches(withText("You need 100xp to reach level 2")));

        ViewInteraction textView11 = onView(withId(R.id.level_display));
        textView11.check(matches(withText("Level: 1")));

        ViewInteraction textView7 = onView(withId(R.id.quiz_number));
        textView7.check(matches(withText("Quiz number 1")));

        ViewInteraction textView10 = onView(withId(R.id.subject));
        textView10.check(matches(withText("Subject: English")));

        ViewInteraction progressBar = onView(withId(R.id.progressBar2));
        progressBar.check(matches(isDisplayed()));


        //WHEN
        ViewInteraction appCompatButton7 = onView(withId(R.id.return_button));
        appCompatButton7.perform(click());

        ViewInteraction appCompatButton2 = onView(withId(R.id.go_button));
        appCompatButton2.perform(click());



        //THEN & GIVEN
        onView(new RecyclerViewMatcher(R.id.quests_list)
                .atPositionOnView(0, R.id.quest_level_id))
                .check(matches(withText("0%")));

        onView(new RecyclerViewMatcher(R.id.quests_list)
                .atPositionOnView(1, R.id.quest_level_id))
                .check(matches(withText("25%")));

        onView(new RecyclerViewMatcher(R.id.quests_list)
                .atPositionOnView(2, R.id.quest_level_id))
                .check(matches(withText("0%")));


        //WHEN
        onView(new RecyclerViewMatcher(R.id.quests_list)
                .atPositionOnView(1, R.id.subjectName))
                .perform(click());



        //THEN
        onView(new RecyclerViewMatcher(R.id.quiz_unit_list)
                .atPositionOnView(0, R.id.mark))
                .check(matches(withText("100%")));

        onView(new RecyclerViewMatcher(R.id.quiz_unit_list)
                .atPositionOnView(0, R.id.quizunit_practica_button))
                .check(matches(isEnabled()));

        onView(new RecyclerViewMatcher(R.id.quiz_unit_list)
                .atPositionOnView(0, R.id.quizunit_practica_button))
                .check(matches(isEnabled()));

        onView(new RecyclerViewMatcher(R.id.quiz_unit_list)
                .atPositionOnView(0, R.id.quizunit_solve_button))
                .check(matches(not(isEnabled())));

        onView(new RecyclerViewMatcher(R.id.quiz_unit_list)
                .atPositionOnView(1, R.id.mark))
                .check(matches(withText("0%")));

        onView(ViewMatchers.withId(R.id.quiz_unit_list)).perform(ViewActions.swipeUp());

        onView(new RecyclerViewMatcher(R.id.quiz_unit_list)
                .atPositionOnView(2, R.id.mark))
                .check(matches(withText("0%")));

        onView(new RecyclerViewMatcher(R.id.quiz_unit_list)
                .atPositionOnView(3, R.id.mark))
                .check(matches(withText("0%")));

    }


    @Test
    public void eliminateUserAndTryToLogIn() {

        //GIVEN
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


        //WHEN
        onView(withId(R.id.username_input)).perform(typeText("test"));
        onView(withId(R.id.password_input)).perform(typeText("test"));
        pressBack();
        ViewInteraction appCompatButton = onView(withId(R.id.lets_go_button));
        appCompatButton.perform(click());


        //THEN & GIVEN
        ViewInteraction button = onView((withId(R.id.go_button)));
        button.check(matches(isDisplayed()));

        ViewInteraction button2 = onView(withId(R.id.removeUser_button));
        button2.check(matches(isDisplayed()));

        ViewInteraction button3 = onView(withId(R.id.log_out_button));
        button3.check(matches(isDisplayed()));

        ViewInteraction imageView = onView(withId(R.id.go_quest_image));
        imageView.check(matches(isDisplayed()));

        ViewInteraction imageView6 = onView(withId(R.id.new_quest_image));
        imageView6.check(matches(isDisplayed()));

        ViewInteraction imageView7 = onView(withId(R.id.log_out_image));
        imageView7.check(matches(isDisplayed()));


        //WHEN
        ViewInteraction appCompatButton2 = onView(withId(R.id.removeUser_button));
        appCompatButton2.perform(click());
        onView(withText("Eliminate it!"))
                .inRoot(withDecorView(not(is(mActivityTestRule.getActivity().getWindow().getDecorView()))))
                .perform(click());


        //THEN & GIVEN
        button4.check(matches(isDisplayed()));
        button5.check(matches(isDisplayed()));
        imageView1.check(matches(isDisplayed()));
        imageView2.check(matches(isDisplayed()));
        imageView3.check(matches(isDisplayed()));


        //WHEN
        onView(withId(R.id.username_input)).perform(typeText("test"));
        onView(withId(R.id.password_input)).perform(typeText("test"));
        pressBack();
        appCompatButton.perform(click());


        //THEN
        onView(withText("Invalid username")).inRoot(withDecorView(not(mActivityTestRule.getActivity().getWindow().getDecorView()))).check(matches(isDisplayed()));



    }


    @Test
    public void createUserAndLogInAndStatistics() throws InterruptedException {
        //GIVEN
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


        //WHEN
        ViewInteraction appCompatButton = onView(withId(R.id.no_account_button));
        appCompatButton.perform(click());


        //THEN & GIVEN
        ViewInteraction button = onView((withId(R.id.registro_signup_button)));
        button.check(matches(isDisplayed()));

        ViewInteraction imageView = onView(withId(R.id.imagenDePerfil));
        imageView.check(matches(isDisplayed()));

        ViewInteraction textView10 = onView(withId(R.id.ImagenDePerfilDescripcion));
        textView10.check(matches(withText("Profile Image Preview")));


        //WHEN
        onView(withId(R.id.registro_username)).perform(typeText("prueba"));
        onView(withId(R.id.registro_email)).perform(typeText("prueba"));
        onView(withId(R.id.registro_password)).perform(typeText("prueba"));

        onView(withId(R.id.image_selection)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("Rabano"))).perform(click());
        onView(withId(R.id.image_selection)).check(matches(withSpinnerText(containsString("Rabano"))));
        pressBack();

        ViewInteraction appCompatButton2 = onView(withId(R.id.registro_signup_button));
        appCompatButton2.perform(click());


        //THEN & GIVEN
        button4.check(matches(isDisplayed()));
        button5.check(matches(isDisplayed()));
        imageView1.check(matches(isDisplayed()));
        imageView2.check(matches(isDisplayed()));
        imageView3.check(matches(isDisplayed()));


        //WHEN
        onView(withId(R.id.username_input)).perform(typeText("prueba"));
        onView(withId(R.id.password_input)).perform(typeText("prueba"));
        pressBack();
        ViewInteraction appCompatButton3 = onView(withId(R.id.lets_go_button));
        appCompatButton3.perform(click());


        //THEN & GIVEN
        ViewInteraction button9 = onView((withId(R.id.go_button)));
        button9.check(matches(isDisplayed()));

        ViewInteraction button2 = onView(withId(R.id.removeUser_button));
        button2.check(matches(isDisplayed()));

        ViewInteraction button3 = onView(withId(R.id.log_out_button));
        button3.check(matches(isDisplayed()));

        ViewInteraction imageView8 = onView(withId(R.id.go_quest_image));
        imageView8.check(matches(isDisplayed()));

        ViewInteraction imageView6 = onView(withId(R.id.new_quest_image));
        imageView6.check(matches(isDisplayed()));

        ViewInteraction imageView7 = onView(withId(R.id.log_out_image));
        imageView7.check(matches(isDisplayed()));

        ViewInteraction textView11 = onView(withId(R.id.profile_name));
        textView11.check(matches(withText("prueba")));

        ViewInteraction textView12 = onView(withId(R.id.level_display));
        textView12.check(matches(withText("Level: 0")));

        ViewInteraction textView13 = onView(withId(R.id.exp_to_display));
        textView13.check(matches(withText("0 / 100")));


        //WHEN
        ViewInteraction appCompatButton4 = onView(withId(R.id.statistics_button));
        appCompatButton4.perform(click());


        //THEN & GIVEN
        onView(new RecyclerViewMatcher(R.id.statistics_list)
                .atPositionOnView(0, R.id.user_name))
                .check(matches(withText("Username")));

        onView(new RecyclerViewMatcher(R.id.statistics_list)
                .atPositionOnView(1, R.id.user_name))
                .check(matches(withText("Luis")));


        //WHEN
        onView(ViewMatchers.withId(R.id.statistics_list)).perform(ViewActions.swipeUp());
        Thread.sleep(2000);


        //THEN
        onView(new RecyclerViewMatcher(R.id.statistics_list)
                .atPositionOnView(4, R.id.user_name))
                .check(matches(withText("test")));


        onView(new RecyclerViewMatcher(R.id.statistics_list)
                .atPositionOnView(5, R.id.user_name))
                .check(matches(withText("prueba")));


    }




}


