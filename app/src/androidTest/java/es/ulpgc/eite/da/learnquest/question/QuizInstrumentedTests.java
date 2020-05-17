package es.ulpgc.eite.da.learnquest.question;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

import es.ulpgc.eite.da.learnquest.R;
//import es.ulpgc.eite.da.learnquest.data.Question;
import es.ulpgc.eite.da.learnquest.data.QuizRepository;
import es.ulpgc.eite.da.learnquest.data.RepositoryContract;
import es.ulpgc.eite.da.learnquest.question.QuestionActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;
//
//@LargeTest
//@RunWith(AndroidJUnit4.class)
//public class QuizInstrumentedTests {
//
//    @Rule
//    public ActivityTestRule<QuestionActivity> activityTestRule =
//            new ActivityTestRule(QuestionActivity.class);
//
//
//    Context context =
//            InstrumentationRegistry.getInstrumentation().getTargetContext();
//    RepositoryContract repository = QuizRepository.getInstance();
//
//    //Esto se puede ir modificando
//    ArrayList<Question> question_array = repository.getQuestions();
//    Question question1 = question_array.get(0);
//    Question question2 = question_array.get(1);
//    Question question3 = question_array.get(2);
//    String correct = context.getString(R.string.correct_text);
//    String incorrect = context.getString(R.string.incorrect_text);
//    String empty_answer = context.getString(R.string.empty_string);
//    String next_button_text = context.getString(R.string.next_button_text);
//    String cheat_button_text = context.getString(R.string.hint_button_text);
//
//    String confirmation_text = context.getString(R.string.confirmation_cheat);
//    String confirmation_info_text = context.getString(R.string.confirmation_info_cheat);
//
//    String returnToProfileTextFinalQuiz = context.getString(R.string.return_home_button);
//
//
//    private void rotate() {
//
//        Context context = ApplicationProvider.getApplicationContext();
//        int orientation = context.getResources().getConfiguration().orientation;
//        Activity activity = activityTestRule.getActivity();
//
//        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
//            activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//        } else {
//            activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//        }
//    }
//
//
//    @Test
//    public void incorrectAnswerChosenTest() {
//        //GIVEN
//        onView(withId(R.id.question_number)).check(matches(withText("Question " + question1.getId())));
//        onView(withId(R.id.question_text)).check(matches(withText(question1.getQuestion())));
//        onView(withId(R.id.option1_button))
//                .check(matches(isEnabled()))
//                .check(matches(withText(question1.getOption1())));
//        onView(withId(R.id.option2_button))
//                .check(matches(isEnabled()))
//                .check(matches(withText(question1.getOption2())));
//        onView(withId(R.id.option3_button))
//                .check(matches(isEnabled()))
//                .check(matches(withText(question1.getOption3())));
//        onView(withId(R.id.answer_text)).check(matches(withText(empty_answer)));
//        onView(withId(R.id.nextButton))
//                .check(matches(not(isEnabled())))
//                .check(matches(withText(next_button_text)));
//        onView(withId(R.id.cheatButton))
//                .check(matches(isEnabled()))
//                .check(matches(withText(cheat_button_text)));
//
//        //WHEN
//        onView(withId(R.id.option3_button)).perform(click());
//
//        //THEN
//        onView(withId(R.id.option1_button))
//                .check(matches(not(isEnabled())))
//                .check(matches(withText(question1.getOption1())));
//        onView(withId(R.id.option2_button))
//                .check(matches(not(isEnabled())))
//                .check(matches(withText(question1.getOption2())));
//        onView(withId(R.id.option3_button))
//                .check(matches(not(isEnabled())))
//                .check(matches(withText(question1.getOption3())));
//        onView(withId(R.id.cheatButton))
//                .check(matches(not(isEnabled())))
//                .check(matches(withText(cheat_button_text)));
//        onView(withId(R.id.nextButton))
//                .check(matches((isEnabled())))
//                .check(matches(withText(next_button_text)));
//        onView(withId(R.id.question_number)).check(matches(withText("Question " + question1.getId())));
//        onView(withId(R.id.question_text)).check(matches(withText(question1.getQuestion())));
//        onView(withId(R.id.answer_text)).check(matches(withText(incorrect)));
//    }
//
//    @Test
//    public void correctAnswerChosenTest() {
//        //GIVEN
//        onView(withId(R.id.question_number)).check(matches(withText("Question " + question1.getId())));
//        onView(withId(R.id.question_text)).check(matches(withText(question1.getQuestion())));
//        onView(withId(R.id.option1_button))
//                .check(matches(isEnabled()))
//                .check(matches(withText(question1.getOption1())));
//        onView(withId(R.id.option2_button))
//                .check(matches(isEnabled()))
//                .check(matches(withText(question1.getOption2())));
//        onView(withId(R.id.option3_button))
//                .check(matches(isEnabled()))
//                .check(matches(withText(question1.getOption3())));
//        onView(withId(R.id.answer_text)).check(matches(withText(empty_answer)));
//        onView(withId(R.id.nextButton))
//                .check(matches(not(isEnabled())))
//                .check(matches(withText(next_button_text)));
//        onView(withId(R.id.cheatButton))
//                .check(matches(isEnabled()))
//                .check(matches(withText(cheat_button_text)));
//
//        //WHEN
//        onView(withId(R.id.option1_button)).perform(click());
//
//        //THEN
//        onView(withId(R.id.option1_button))
//                .check(matches(not(isEnabled())))
//                .check(matches(withText(question1.getOption1())));
//        onView(withId(R.id.option2_button))
//                .check(matches(not(isEnabled())))
//                .check(matches(withText(question1.getOption2())));
//        onView(withId(R.id.option3_button))
//                .check(matches(not(isEnabled())))
//                .check(matches(withText(question1.getOption3())));
//        onView(withId(R.id.cheatButton))
//                .check(matches(not(isEnabled())))
//                .check(matches(withText(cheat_button_text)));
//        onView(withId(R.id.nextButton))
//                .check(matches((isEnabled())))
//                .check(matches(withText(next_button_text)));
//        onView(withId(R.id.question_number)).check(matches(withText("Question " + question1.getId())));
//        onView(withId(R.id.question_text)).check(matches(withText(question1.getQuestion())));
//        onView(withId(R.id.answer_text)).check(matches(withText(correct)));
//    }
//
//    @Test
//    public void nextButtonClickedAfterWrongAnswerTest() {
//        //GIVEN
//        onView(withId(R.id.question_number)).check(matches(withText("Question " + question1.getId())));
//        onView(withId(R.id.question_text)).check(matches(withText(question1.getQuestion())));
//        onView(withId(R.id.option1_button)).check(matches(withText(question1.getOption1())));
//        onView(withId(R.id.option2_button)).check(matches(withText(question1.getOption2())));
//        onView(withId(R.id.option3_button)).check(matches(withText(question1.getOption3())));
//        onView(withId(R.id.answer_text)).check(matches(withText(empty_answer)));
//        onView(withId(R.id.nextButton))
//                .check(matches(not(isEnabled())))
//                .check(matches(withText(next_button_text)));
//        onView(withId(R.id.cheatButton))
//                .check(matches(isEnabled()))
//                .check(matches(withText(cheat_button_text)));
//
//        onView(withId(R.id.option3_button)).perform(click());
//
//        onView(withId(R.id.option1_button)).check(matches(not(isEnabled())));
//        onView(withId(R.id.option2_button)).check(matches(not(isEnabled())));
//        onView(withId(R.id.option3_button)).check(matches(not(isEnabled())));
//        onView(withId(R.id.cheatButton))
//                .check(matches(not(isEnabled())))
//                .check(matches(withText(cheat_button_text)));
//        onView(withId(R.id.nextButton))
//                .check(matches(isEnabled()))
//                .check(matches(withText(next_button_text)));
//        onView(withId(R.id.answer_text)).check(matches(withText(incorrect)));
//
//        //WHEN
//        onView(withId(R.id.nextButton)).perform(click());
//
//        //THEN
//        onView(withId(R.id.question_number)).check(matches(withText("Question " + question2.getId())));
//        onView(withId(R.id.question_text)).check(matches(withText(question2.getQuestion())));
//        onView(withId(R.id.option1_button))
//                .check(matches(isEnabled()))
//                .check(matches(withText(question2.getOption1())));
//        onView(withId(R.id.option2_button))
//                .check(matches(isEnabled()))
//                .check(matches(withText(question2.getOption2())));
//        onView(withId(R.id.option3_button))
//                .check(matches(isEnabled()))
//                .check(matches(withText(question2.getOption3())));
//        onView(withId(R.id.answer_text)).check(matches(withText(empty_answer)));
//        onView(withId(R.id.nextButton))
//                .check(matches(not(isEnabled())))
//                .check(matches(withText(next_button_text)));
//        onView(withId(R.id.cheatButton))
//                .check(matches(isEnabled()))
//                .check(matches(withText(cheat_button_text)));
//    }
//
//    @Test
//    public void nextButtonClickedAfterRightAnswerChosen() {
//        //GIVEN
//        onView(withId(R.id.question_number)).check(matches(withText("Question " + question1.getId())));
//        onView(withId(R.id.question_text)).check(matches(withText(question1.getQuestion())));
//        onView(withId(R.id.option1_button)).check(matches(withText(question1.getOption1())));
//        onView(withId(R.id.option2_button)).check(matches(withText(question1.getOption2())));
//        onView(withId(R.id.option3_button)).check(matches(withText(question1.getOption3())));
//        onView(withId(R.id.answer_text)).check(matches(withText(empty_answer)));
//        onView(withId(R.id.nextButton))
//                .check(matches(not(isEnabled())))
//                .check(matches(withText(next_button_text)));
//        onView(withId(R.id.cheatButton))
//                .check(matches(isEnabled()))
//                .check(matches(withText(cheat_button_text)));
//
//        onView(withId(R.id.option1_button)).perform(click());
//
//        onView(withId(R.id.option1_button)).check(matches(not(isEnabled())));
//        onView(withId(R.id.option2_button)).check(matches(not(isEnabled())));
//        onView(withId(R.id.option3_button)).check(matches(not(isEnabled())));
//        onView(withId(R.id.cheatButton))
//                .check(matches(not(isEnabled())))
//                .check(matches(withText(cheat_button_text)));
//        onView(withId(R.id.nextButton))
//                .check(matches(isEnabled()))
//                .check(matches(withText(next_button_text)));
//        onView(withId(R.id.answer_text)).check(matches(withText(correct)));
//
//        //WHEN
//        onView(withId(R.id.nextButton)).perform(click());
//
//        //THEN
//        onView(withId(R.id.question_number)).check(matches(withText("Question " + question2.getId())));
//        onView(withId(R.id.question_text)).check(matches(withText(question2.getQuestion())));
//        onView(withId(R.id.option1_button))
//                .check(matches(isEnabled()))
//                .check(matches(withText(question2.getOption1())));
//        onView(withId(R.id.option2_button))
//                .check(matches(isEnabled()))
//                .check(matches(withText(question2.getOption2())));
//        onView(withId(R.id.option3_button))
//                .check(matches(isEnabled()))
//                .check(matches(withText(question2.getOption3())));
//        onView(withId(R.id.answer_text)).check(matches(withText(empty_answer)));
//        onView(withId(R.id.nextButton))
//                .check(matches(not(isEnabled())))
//                .check(matches(withText(next_button_text)));
//        onView(withId(R.id.cheatButton))
//                .check(matches(isEnabled()))
//                .check(matches(withText(cheat_button_text)));
//    }
//
//    @Test
//    public void startHintActivityAfterHintButtonPressed() {
//        //GIVEN
//        onView(withId(R.id.question_number)).check(matches(withText("Question " + question1.getId())));
//        onView(withId(R.id.question_text)).check(matches(withText(question1.getQuestion())));
//        onView(withId(R.id.option1_button)).check(matches(withText(question1.getOption1())));
//        onView(withId(R.id.option2_button)).check(matches(withText(question1.getOption2())));
//        onView(withId(R.id.option3_button)).check(matches(withText(question1.getOption3())));
//        onView(withId(R.id.answer_text)).check(matches(withText(empty_answer)));
//        onView(withId(R.id.nextButton))
//                .check(matches(not(isEnabled())))
//                .check(matches(withText(next_button_text)));
//        onView(withId(R.id.cheatButton))
//                .check(matches(isEnabled()))
//                .check(matches(withText(cheat_button_text)));
//
//        //WHEN
//        onView(withId(R.id.cheatButton)).perform(click());
//
//        //THEN
//        onView(withId(R.id.confirmation_text)).check(matches(withText(confirmation_text)));
//        onView(withId(R.id.confirmation_info_text)).check(matches(withText(confirmation_info_text)));
//        onView(withId(R.id.answer_text)).check(matches(withText(empty_answer)));
//    }
//
//    @Test
//    public void pressNoToReturnToQuestionInHintActivity() {
//        //GIVEN
//        onView(withId(R.id.cheatButton)).perform(click());
//        onView(withId(R.id.confirmation_text)).check(matches(withText(confirmation_text)));
//        onView(withId(R.id.confirmation_info_text)).check(matches(withText(confirmation_info_text)));
//        onView(withId(R.id.answer_text)).check(matches(withText(empty_answer)));
//
//        //WHEN
//        onView(withId(R.id.noButton)).perform(click());
//
//        //THEN
//        onView(withId(R.id.question_number)).check(matches(withText("Question " + question1.getId())));
//        onView(withId(R.id.question_text)).check(matches(withText(question1.getQuestion())));
//        onView(withId(R.id.option1_button))
//                .check(matches(isEnabled()))
//                .check(matches(withText(question1.getOption1())));
//        onView(withId(R.id.option2_button))
//                .check(matches(isEnabled()))
//                .check(matches(withText(question1.getOption2())));
//        onView(withId(R.id.option3_button))
//                .check(matches(isEnabled()))
//                .check(matches(withText(question1.getOption3())));
//        onView(withId(R.id.answer_text)).check(matches(withText(empty_answer)));
//        onView(withId(R.id.nextButton))
//                .check(matches(not(isEnabled())))
//                .check(matches(withText(next_button_text)));
//        onView(withId(R.id.cheatButton))
//                .check(matches(isEnabled()))
//                .check(matches(withText(cheat_button_text)));
//    }
//
//    @Test
//    public void pressYesInHintActivity() {
//        //GIVEN
//        onView(withId(R.id.cheatButton)).perform(click());
//        onView(withId(R.id.confirmation_text)).check(matches(withText(confirmation_text)));
//        onView(withId(R.id.confirmation_info_text)).check(matches(withText(confirmation_info_text)));
//        onView(withId(R.id.answer_text)).check(matches(withText(empty_answer)));
//
//        //WHEN
//        onView(withId(R.id.yesButton)).perform(click());
//
//        //THEN
//        onView(withId(R.id.confirmation_text)).check(matches(withText(confirmation_text)));
//        onView(withId(R.id.confirmation_info_text)).check(matches(withText(confirmation_info_text)));
//        onView(withId(R.id.answer_text)).check(matches(withText(question1.getHint())));
//    }
//
//    @Test
//    public void pressYesInHintActivityAndReturnToQuestion() {
//        //GIVEN
//        onView(withId(R.id.cheatButton)).perform(click());
//        onView(withId(R.id.confirmation_text)).check(matches(withText(confirmation_text)));
//        onView(withId(R.id.confirmation_info_text)).check(matches(withText(confirmation_info_text)));
//        onView(withId(R.id.answer_text)).check(matches(withText(empty_answer)));
//
//        onView(withId(R.id.yesButton)).perform(click());
//        onView(withId(R.id.confirmation_text)).check(matches(withText(confirmation_text)));
//        onView(withId(R.id.confirmation_info_text)).check(matches(withText(confirmation_info_text)));
//        onView(withId(R.id.answer_text)).check(matches(withText(question1.getHint())));
//
//        //WHEN
//        onView(withId(R.id.returnButton)).perform(click());
//
//        //THEN
//        onView(withId(R.id.question_number)).check(matches(withText("Question " + question1.getId())));
//        onView(withId(R.id.question_text)).check(matches(withText(question1.getQuestion())));
//        onView(withId(R.id.option1_button))
//                .check(matches(isEnabled()))
//                .check(matches(withText(question1.getOption1())));
//        onView(withId(R.id.option2_button))
//                .check(matches(isEnabled()))
//                .check(matches(withText(question1.getOption2())));
//        onView(withId(R.id.option3_button))
//                .check(matches(isEnabled()))
//                .check(matches(withText(question1.getOption3())));
//        onView(withId(R.id.answer_text)).check(matches(withText(empty_answer)));
//        onView(withId(R.id.nextButton))
//                .check(matches(not(isEnabled())))
//                .check(matches(withText(next_button_text)));
//        onView(withId(R.id.cheatButton))
//                .check(matches(not(isEnabled())))
//                .check(matches(withText(cheat_button_text)));
//
//    }
//
//    @Test
//    public void pressNextButtonAtLastQuestion() {
//        //GIVEN
//        repository.setUserActual(repository.getUser("Ruben", "rabano"));
//        onView(withId(R.id.option2_button)).perform(click());
//        onView(withId(R.id.nextButton)).perform(click());
//        onView(withId(R.id.option2_button)).perform(click());
//        onView(withId(R.id.nextButton)).perform(click());
//        onView(withId(R.id.option2_button)).perform(click());
//
//        //WHEN
//        onView(withId(R.id.nextButton)).perform(click());
//
//        //THEN
//        ViewInteraction appCompatButton = onView(withId(R.id.return_button));
//        appCompatButton.check(matches(withText(returnToProfileTextFinalQuiz)));
//    }
//}
