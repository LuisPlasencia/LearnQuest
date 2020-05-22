package es.ulpgc.eite.da.learnquest.question;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import es.ulpgc.eite.da.learnquest.R;
import es.ulpgc.eite.da.learnquest.app.AppMediator;
import es.ulpgc.eite.da.learnquest.finalQuiz.FinalQuizActivity;
import es.ulpgc.eite.da.learnquest.hint.HintActivity;
import es.ulpgc.eite.da.learnquest.quizUnit.QuizUnitActivity;

public class QuestionActivity
        extends AppCompatActivity implements QuestionContract.View {

    public static String TAG = QuestionActivity.class.getSimpleName();

    private QuestionContract.Presenter presenter;
    private ProgressBar mProgressBar;
    private int progress;
    private CountDownTimer mCountDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        setupToolbar();

        //if(savedInstanceState == null ) AppMediator.resetInstance();

        // do the setup
        QuestionScreen.configure(this);

        presenter.fetchQuestionEnglishData();

        Button hintButton = findViewById(R.id.cheatButton);
        hintButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onHintButtonClicked();
            }
        });

        if(savedInstanceState == null) {
            presenter.onStart();
        } else {
            presenter.onRestart();
        }
    }

    @Override
    public void initTimer() {
        progress = 0;
        mProgressBar = (ProgressBar)findViewById(R.id.progressbar);
        mProgressBar.setProgress(progress);
        mCountDownTimer = new CountDownTimer(20000, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                //Log.d(TAG, "Tick of Progress"+ progress + millisUntilFinished);
                progress++;
                mProgressBar.setProgress((int) progress*100/(20000/100));
            }

            @Override
            public void onFinish() {
                Log.d(TAG, "onTimerFinish()");
                presenter.onTimerFinish();
                progress++;
                mProgressBar.setProgress(100);
            }
        };
        startTimer();
    }

    @Override
    public void startTimer() {
        mCountDownTimer.start();
    }

    @Override
    public void stopTimer() {
        mCountDownTimer.cancel();
    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.question_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            String questionTitle = getResources().getString(R.string.english_quiz_title);
            actionBar.setTitle(questionTitle);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        // load the data
        presenter.onResume();
    }

    @Override
    public void resetReply() {
        ((TextView) findViewById(R.id.answer_text)).setText(R.string.empty_string);
    }

    @Override
    public void displayData(final QuestionViewModel viewModel) {
        Log.e(TAG, "displayData()");

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // deal with the data
                ((TextView) findViewById(R.id.question_number)).setText(String.valueOf(viewModel.questionNumber+1));
                ((TextView) findViewById(R.id.question_text)).setText(viewModel.questionText);
                ((Button) findViewById(R.id.option1_button)).setText(viewModel.option1);
                ((Button) findViewById(R.id.option2_button)).setText(viewModel.option2);
                ((Button) findViewById(R.id.option3_button)).setText(viewModel.option3);
                ((TextView) findViewById(R.id.question_text)).setText(viewModel.questionText);

                findViewById(R.id.option1_button).setEnabled(viewModel.optionEnabled);
                findViewById(R.id.option2_button).setEnabled(viewModel.optionEnabled);
                findViewById(R.id.option3_button).setEnabled(viewModel.optionEnabled);
                findViewById(R.id.nextButton).setEnabled(viewModel.nextEnabled);
                findViewById(R.id.cheatButton).setEnabled(viewModel.hintEnabled);
            }
        });
    }

    public void onNextButtonClicked(View view) {
        presenter.onNextButtonClicked();
    }


    public void onOptionButtonClicked(View view) {
        int option = Integer.valueOf((String) view.getTag());
        presenter.onOptionButtonClicked(option);
    }

    @Override
    public void updateReply(boolean isCorrect) {
        if(isCorrect){
            ((TextView) findViewById(R.id.answer_text)).setText(R.string.correct_text);
        } else {
            ((TextView) findViewById(R.id.answer_text)).setText(R.string.incorrect_text);
        }
    }

    @Override
    public void updateReplyTimeFinished() {
        ((TextView) findViewById(R.id.answer_text)).setText(R.string.question_timer_finished_text);
    }

    @Override
    public void resetOptionColor() {
        findViewById(R.id.option1_button).getBackground().clearColorFilter();
        findViewById(R.id.option2_button).getBackground().clearColorFilter();
        findViewById(R.id.option3_button).getBackground().clearColorFilter();
    }

    @Override
    public void setOptionColorCorrect(int option) {
        Button optionSelected = null;
        switch (option) {
            case 1:
                optionSelected = findViewById(R.id.option1_button);
                break;
            case 2:
                optionSelected = findViewById(R.id.option2_button);
                break;
            case 3:
                optionSelected = findViewById(R.id.option3_button);
                break;
        }
        if(optionSelected != null) {
            optionSelected.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.MULTIPLY);
        }
    }

    @Override
    public void setOptionColorIncorrect(int option) {
        Button optionSelected = null;
        switch (option) {
            case 1:
                optionSelected = findViewById(R.id.option1_button);
                break;
            case 2:
                optionSelected = findViewById(R.id.option2_button);
                break;
            case 3:
                optionSelected = findViewById(R.id.option3_button);
                break;
        }
        if(optionSelected != null) {
            optionSelected.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
        }
    }

    @Override
    public void injectPresenter(QuestionContract.Presenter presenter) {
        this.presenter = presenter;
    }

    public void navigateToFinalQuizScreen() {
        Intent intent = new Intent(this, FinalQuizActivity.class);
        startActivity(intent);
    }

    @Override
    public void navigateToQuizUnitScreen() {
        Intent intent = new Intent(this, QuizUnitActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
        finish();
    }

    public void navigateToHintScreen() {
        Intent intent = new Intent(this, HintActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed(){
   //     super.onBackPressed();
        presenter.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
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


}
