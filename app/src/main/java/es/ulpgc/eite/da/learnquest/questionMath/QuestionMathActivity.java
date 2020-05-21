package es.ulpgc.eite.da.learnquest.questionMath;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import es.ulpgc.eite.da.learnquest.R;
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
      //  super.onBackPressed();

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
    public void resetAnswer(){
        ((TextView) findViewById(R.id.user_answer_math)).setText("");
    }

    @Override
    public void displayData(final QuestionMathViewModel viewModel) {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // deal with the data
                QuizUnitItem quizUnitItem = viewModel.quizUnitItem;

                ((TextView) findViewById(R.id.mathTitle)).
                        setText(quizUnitItem.questionMathItems.get(presenter.getIndex()).getQuestion());

                ((TextView) findViewById(R.id.answer_math)).setText(viewModel.mathAnswerText);
                ((TextView) findViewById(R.id.question_math_number)).setText(viewModel.mathQuestionNumber);

                Log.d("hola", String.valueOf(viewModel.mathHintEnabled));

                findViewById(R.id.math_quiz_hint).setEnabled(viewModel.mathHintEnabled);
                findViewById(R.id.math_quiz_next).setEnabled(viewModel.mathNextEnabled);
                findViewById(R.id.math_quiz_enter).setEnabled(viewModel.mathEnterEnabled);
                findViewById(R.id.math_quiz_clean).setEnabled(viewModel.mathCleanEnabled);
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
        presenter.onNumberClicked();

    }

    public void onCleanButton(View view) {
        presenter.resetHintIndex();
        ((TextView) findViewById(R.id.user_answer_math)).setText("");
        presenter.onCleanClicked();
    }

    @SuppressLint("ResourceAsColor")
    public void onHintButton(View view){
        char solution = presenter.onHintButtonClicked();
        switch (solution){
            case '0':
                ((Button) findViewById(R.id.math_quiz_0)).setBackgroundResource(R.drawable.button_background_profile_red);
                break;
            case '1':
                ((Button) findViewById(R.id.math_quiz_1)).setBackgroundResource(R.drawable.button_background_profile_red);
                break;
            case '2':
                ((Button) findViewById(R.id.math_quiz_2)).setBackgroundResource(R.drawable.button_background_profile_red);
                break;
            case '3':
                ((Button) findViewById(R.id.math_quiz_3)).setBackgroundResource(R.drawable.button_background_profile_red);
                break;
            case '4':
                ((Button) findViewById(R.id.math_quiz_4)).setBackgroundResource(R.drawable.button_background_profile_red);
                break;
            case '5':
                ((Button) findViewById(R.id.math_quiz_5)).setBackgroundResource(R.drawable.button_background_profile_red);
                break;
            case '6':
                ((Button) findViewById(R.id.math_quiz_6)).setBackgroundResource(R.drawable.button_background_profile_red);
                break;
            case '7':
                ((Button) findViewById(R.id.math_quiz_7)).setBackgroundResource(R.drawable.button_background_profile_red);
                break;
            case '8':
                ((Button) findViewById(R.id.math_quiz_8)).setBackgroundResource(R.drawable.button_background_profile_red);
                break;
            case '9':
                ((Button) findViewById(R.id.math_quiz_9)).setBackgroundResource(R.drawable.button_background_profile_red);
                break;
        }

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
        Toast toast;
        Random r = new Random();
        int aleatorio = r.nextInt(3-1 +1) + 1;
        if(aleatorio == 1){
            toast = Toast.makeText(getApplicationContext(),
                    "You are getting smarter!",
                    Toast.LENGTH_SHORT);
        } else if(aleatorio == 2){
            toast = Toast.makeText(getApplicationContext(),
                    "Good one!",
                    Toast.LENGTH_SHORT);
        } else if(aleatorio == 3){
            toast = Toast.makeText(getApplicationContext(),
                    "Nicely done!",
                    Toast.LENGTH_SHORT);
        } else{
            toast = Toast.makeText(getApplicationContext(),
                    "Nicely done!",
                    Toast.LENGTH_SHORT);
        }
        toast.show();
    }

    @Override
    public void displaySolutionIncorrect() {
        Toast toast;
        Random r = new Random();
        int aleatorio = r.nextInt(3-1 +1) + 1;
        if(aleatorio == 1){
            toast = Toast.makeText(getApplicationContext(),
                    "Try harder!",
                    Toast.LENGTH_SHORT);
        } else if(aleatorio == 2){
            toast = Toast.makeText(getApplicationContext(),
                    "Naaah!",
                    Toast.LENGTH_SHORT);
        } else if(aleatorio == 3){
            toast = Toast.makeText(getApplicationContext(),
                    "Wrong!",
                    Toast.LENGTH_SHORT);
        } else{
            toast = Toast.makeText(getApplicationContext(),
                    "Wrong!",
                    Toast.LENGTH_SHORT);
        }
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
        finish();
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

    @Override
    public void alertDialogReturn() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(R.string.message_returnQuizAlert);
        builder.setMessage(R.string.details_returnQuizAlert);
        builder.setPositiveButton(R.string.confirm,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        navigateToQuizUnitScreen();
                    }
                });
        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                return;
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void resetButtons() {
        ((Button) findViewById(R.id.math_quiz_0)).setBackgroundResource(R.drawable.button_selector);
        ((Button) findViewById(R.id.math_quiz_1)).setBackgroundResource(R.drawable.button_selector);
        ((Button) findViewById(R.id.math_quiz_2)).setBackgroundResource(R.drawable.button_selector);
        ((Button) findViewById(R.id.math_quiz_3)).setBackgroundResource(R.drawable.button_selector);
        ((Button) findViewById(R.id.math_quiz_4)).setBackgroundResource(R.drawable.button_selector);
        ((Button) findViewById(R.id.math_quiz_5)).setBackgroundResource(R.drawable.button_selector);
        ((Button) findViewById(R.id.math_quiz_6)).setBackgroundResource(R.drawable.button_selector);
        ((Button) findViewById(R.id.math_quiz_7)).setBackgroundResource(R.drawable.button_selector);
        ((Button) findViewById(R.id.math_quiz_8)).setBackgroundResource(R.drawable.button_selector);
        ((Button) findViewById(R.id.math_quiz_9)).setBackgroundResource(R.drawable.button_selector);
    }

}
