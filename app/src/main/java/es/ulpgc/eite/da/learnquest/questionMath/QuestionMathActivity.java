package es.ulpgc.eite.da.learnquest.questionMath;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import es.ulpgc.eite.da.learnquest.R;
import es.ulpgc.eite.da.learnquest.data.QuestItem;
import es.ulpgc.eite.da.learnquest.data.QuestionMathItem;
import es.ulpgc.eite.da.learnquest.data.QuizUnitItem;
import es.ulpgc.eite.da.learnquest.finalQuiz.FinalQuizActivity;
import es.ulpgc.eite.da.learnquest.quizUnit.QuizUnitActivity;

public class QuestionMathActivity
        extends AppCompatActivity implements QuestionMathContract.View {

    public static String TAG = QuestionMathActivity.class.getSimpleName();

    private QuestionMathContract.Presenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_math);
        setupToolbar();

        // do the setup
        QuestionMathScreen.configure(this);

        presenter.fetchQuestionMathData();

        if (savedInstanceState == null) {

            presenter.onStart();

        } else {
            presenter.onRestart();
        }
    }


    @Override
    protected void onResume() {
        super.onResume();

        // load the data
        presenter.onResume();
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();

        presenter.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();

        presenter.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        presenter.onDestroy();
    }

   private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.question_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            String questionTitle = getResources().getString(R.string.quiz_screen_title);
            actionBar.setTitle(questionTitle);
        }
    }

    @Override
    public void resetReply() {
        ((TextView) findViewById(R.id.answer_math)).setText(R.string.empty_string);

    }

    @Override
    public void displayData(final QuestionMathViewModel viewModel) {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // deal with the data
                QuizUnitItem quizUnitItem = viewModel.quizUnitItem;

                ((TextView) findViewById(R.id.mathTitle)).
                        setText(quizUnitItem.questionMathItems.get(presenter.getIndex()).mathTitle);

                ((TextView) findViewById(R.id.answer_math)).setText(viewModel.mathAnswerText);
                ((TextView) findViewById(R.id.question_math_number)).setText(viewModel.mathQuestionNumber);

                findViewById(R.id.math_quiz_hint).setEnabled(viewModel.mathHintEnabled);
                findViewById(R.id.math_quiz_next).setEnabled(viewModel.mathNextEnabled);
                findViewById(R.id.math_quiz_enter).setEnabled(viewModel.mathEnterEnabled);
                findViewById(R.id.math_quiz_1).setEnabled(viewModel.mathNumbersEnabled);
                findViewById(R.id.math_quiz_2).setEnabled(viewModel.mathNumbersEnabled);
                findViewById(R.id.math_quiz_3).setEnabled(viewModel.mathNumbersEnabled);
                findViewById(R.id.math_quiz_4).setEnabled(viewModel.mathNumbersEnabled);
                findViewById(R.id.math_quiz_5).setEnabled(viewModel.mathNumbersEnabled);
                findViewById(R.id.math_quiz_6).setEnabled(viewModel.mathNumbersEnabled);
                findViewById(R.id.math_quiz_7).setEnabled(viewModel.mathNumbersEnabled);
                findViewById(R.id.math_quiz_8).setEnabled(viewModel.mathNumbersEnabled);
                findViewById(R.id.math_quiz_9).setEnabled(viewModel.mathNumbersEnabled);
                findViewById(R.id.math_quiz_0).setEnabled(viewModel.mathNumbersEnabled);

            }
        });
    }

    public void onNextButtonClickedMath(View view) {
        //int index = presenter.getIndex();
        //((TextView) findViewById(R.id.answer_math)).setText(String.valueOf(index));
        presenter.onNextButtonClicked();
    }

    public void onNumberClicked(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();
        ((TextView) findViewById(R.id.user_answer_math)).append(buttonText);

    }

    public void onCleanButton(View view) {
        presenter.resetHintIndex();
        ((TextView) findViewById(R.id.user_answer_math)).setText("");
    }

    public void onHintButton(View view){
        ((TextView) findViewById(R.id.user_answer_math)).append(presenter.onHintButtonClicked());

    }


    @Override
    public String getSolution(final QuestionMathViewModel viewModel) {
        QuizUnitItem quizUnitItem = viewModel.quizUnitItem;
        return quizUnitItem.questionMathItems.get(presenter.getIndex()).mathSolution;
    }

    @Override
    public String getUserSolution() {
        TextView textView = findViewById(R.id.user_answer_math);
        String userSolution = textView.getText().toString();
        return userSolution;
    }

    @Override
    public void displaySolutionCorrect() {
        Toast toast = Toast.makeText(getApplicationContext(),
                "Naisuuuuuuuuuuuuuuuuuuuuuuuuu",
                Toast.LENGTH_SHORT);

        toast.show();
    }

    @Override
    public void displaySolutionIncorrect() {
        Toast toast = Toast.makeText(getApplicationContext(),
                "Try again",
                Toast.LENGTH_SHORT);

        toast.show();
    }

    public void onEnterButtonClickedMath(View view) {
        presenter.onEnterButtonClicked();
        ((TextView) findViewById(R.id.user_answer_math)).setText("");
    }

    @Override
    public void navigateToNextScreen() {
        Intent intent = new Intent(this, QuestionMathActivity.class);
        startActivity(intent);
    }

    @Override
    public void navigateToQuizUnitScreen() {
        Intent intent = new Intent(this, QuizUnitActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }

    @Override
    public void navigateToFinalQuizScreen() {
        Intent intent = new Intent(this, FinalQuizActivity.class);
        startActivity(intent);
    }

    @Override
    public void injectPresenter(QuestionMathContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            navigateUpTo(new Intent(this, QuizUnitActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
