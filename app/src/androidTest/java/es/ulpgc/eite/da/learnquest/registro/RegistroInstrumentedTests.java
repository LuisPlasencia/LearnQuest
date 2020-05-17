package es.ulpgc.eite.da.learnquest.registro;

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

import java.util.ArrayList;

import es.ulpgc.eite.da.learnquest.R;
//import es.ulpgc.eite.da.learnquest.data.Question;
import es.ulpgc.eite.da.learnquest.data.QuizRepository;
import es.ulpgc.eite.da.learnquest.data.RepositoryContract;
import es.ulpgc.eite.da.learnquest.question.QuestionActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;
//
//@LargeTest
//@RunWith(AndroidJUnit4.class)
//public class RegistroInstrumentedTests {
//
//    @Rule
//    public ActivityTestRule<RegistroActivity> activityTestRule =
//            new ActivityTestRule(RegistroActivity.class );
//
//
//    Context context =
//            InstrumentationRegistry.getInstrumentation().getTargetContext();
//
//    String usernameHint = context.getResources().getString(R.string.registro_username_text);
//    String emailHint = context.getResources().getString(R.string.registro_correo_text);
//    String passwordHint = context.getResources().getString(R.string.registro_password_text);
//
//    String exampleUser = "UsernameEjemplo";
//    String exampleEmail = "EmailEjemplo";
//    String examplePassword = "passwordEjemplo";
//
//
//    private void rotate() {
//
//        Context context = ApplicationProvider.getApplicationContext();
//        int orientation = context.getResources().getConfiguration().orientation;
//        Activity activity = activityTestRule.getActivity();
//
//        if(orientation  == Configuration.ORIENTATION_PORTRAIT) {
//            activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//        } else {
//            activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//        }
//    }
//
//
//    @Test
//    public void emptyFieldsSignUpTest() {
//        //GIVEN
//        onView(withId(R.id.registro_username)).check(matches(withHint(usernameHint)));
//        onView(withId(R.id.registro_email)).check(matches(withHint(emailHint)));
//        onView(withId(R.id.registro_password)).check(matches(withHint(passwordHint)));
//        onView(withId(R.id.registro_signup_button)).check(matches(isEnabled()));
//
//        //WHEN
//        onView(withId(R.id.registro_signup_button)).perform(click());
//
//        //THEN (Se permanece en la misma pantalla)
//        onView(withId(R.id.registro_username)).check(matches(withHint(usernameHint)));
//        onView(withId(R.id.registro_email)).check(matches(withHint(emailHint)));
//        onView(withId(R.id.registro_password)).check(matches(withHint(passwordHint)));
//        onView(withId(R.id.registro_signup_button)).check(matches(isEnabled()));
//    }
//
//    //No se puede realizar porque al hacer finish, la activity de logIn no ha sido creada
//    /*
//    @Test
//    public void correctSignUpTest() {
//        //GIVEN
//        onView(withId(R.id.registro_username)).check(matches(withHint(usernameHint)));
//        onView(withId(R.id.registro_email)).check(matches(withHint(emailHint)));
//        onView(withId(R.id.registro_password)).check(matches(withHint(passwordHint)));
//        onView(withId(R.id.registro_signup_button)).check(matches(isEnabled()));
//
//        //WHEN
//        onView(withId(R.id.registro_username)).perform(typeText(exampleUser));
//        onView(withId(R.id.registro_email)).perform(typeText(exampleEmail));
//        onView(withId(R.id.registro_password)).perform(typeText(examplePassword));
//        onView(withId(R.id.registro_signup_button)).perform(click());
//
//        //THEN (Se pasa a pantalla de login)
//        onView(withId(R.id.lets_go_button)).check(matches(isEnabled()));
//        onView(withId(R.id.no_account_button)).check(matches(isEnabled()));
//    } */
//}
