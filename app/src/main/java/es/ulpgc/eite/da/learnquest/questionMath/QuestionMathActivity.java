package es.ulpgc.eite.da.learnquest.questionMath;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import es.ulpgc.eite.da.learnquest.R;
import es.ulpgc.eite.da.learnquest.data.QuestItem;
import es.ulpgc.eite.da.learnquest.data.QuestionMathItem;
import es.ulpgc.eite.da.learnquest.data.QuizUnitItem;
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
        super.onBackPressed();

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

        // deal with the data
        QuizUnitItem quizUnit = viewModel.quizUnitItem;

        if(quizUnit != null) {

            ((TextView) findViewById(R.id.question_math_text)).
                    setText(quizUnit.mathTitle);
        }

        findViewById(R.id.math_quiz_enter).setEnabled(viewModel.mathEnterEnabled);
        findViewById(R.id.math_quiz_next).setEnabled(viewModel.mathNextEnabled);
        findViewById(R.id.math_quiz_hint).setEnabled(viewModel.mathHintEnabled);

        // deal with the data

       /* ((TextView) findViewById(R.id.question_math_number)).setText(viewModel.mathQuestionNumber);
        ((TextView) findViewById(R.id.question_math_text)).setText(viewModel.mathQuestionText);


        findViewById(R.id.math_quiz_enter).setEnabled(viewModel.mathEnterEnabled);
        findViewById(R.id.math_quiz_next).setEnabled(viewModel.mathNextEnabled);
        findViewById(R.id.math_quiz_hint).setEnabled(viewModel.mathHintEnabled);*/

    }

    public void onNextButtonClicked(View view) {
        //presenter.onNextButtonClicked();
    }

    public void onNumberClicked(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();
        ((TextView) findViewById(R.id.answer_math)).append(buttonText);

    }

    public void onCleanButton(View view) {
        ((TextView) findViewById(R.id.answer_math)).setText("");
    }

    @Override
    public void updateReply(boolean isCorrect) {
        if (isCorrect) {
            ((TextView) findViewById(R.id.answer_math)).setText(R.string.correct_text);
        } else {
            ((TextView) findViewById(R.id.answer_math)).setText(R.string.incorrect_text);
        }
    }


    @Override
    public void navigateToNextScreen() {
        Intent intent = new Intent(this, QuestionMathActivity.class);
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
