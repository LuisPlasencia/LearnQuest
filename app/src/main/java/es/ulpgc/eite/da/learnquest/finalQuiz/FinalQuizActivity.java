package es.ulpgc.eite.da.learnquest.finalQuiz;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import es.ulpgc.eite.da.learnquest.R;
import es.ulpgc.eite.da.learnquest.app.AppMediator;
import es.ulpgc.eite.da.learnquest.data.User;
import es.ulpgc.eite.da.learnquest.profile.ProfileActivity;
import es.ulpgc.eite.da.learnquest.quizUnit.QuizUnitActivity;
import es.ulpgc.eite.da.learnquest.registro.RegistroActivity;

public class FinalQuizActivity
        extends AppCompatActivity implements FinalQuizContract.View {

    public static String TAG = FinalQuizActivity.class.getSimpleName();

    private FinalQuizContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_quiz);
        getSupportActionBar().setTitle(getResources().getString(R.string.final_quiz_activity_title));

//        if(savedInstanceState == null) AppMediator.resetInstance();

        // do the setup
        FinalQuizScreen.configure(this);

        if (savedInstanceState == null) {
            presenter.onStart();

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
    public void displayFinalQuizData(FinalQuizViewModel viewModel) {
        if (viewModel.experience_earned == 0) {
            ((TextView) findViewById(R.id.earned)).setText(String.valueOf("You earned no xp"));
            ((ImageView) findViewById(R.id.medal)).setImageResource(R.drawable.no_exp_gained);
        } else {
            ((TextView) findViewById(R.id.earned)).setText(String.valueOf("You earned " + viewModel.experience_earned + "xp!"));
            int photo = presenter.getMedalPhoto();
            ((ImageView) findViewById(R.id.medal)).setImageResource(photo);
        }
        ((TextView) findViewById(R.id.exp_to_nextlevel)).setText(String.valueOf("You need " + viewModel.experience_needed + "xp to reach level " + (viewModel.level + 1)));
        ((TextView) findViewById(R.id.level_display)).setText(String.valueOf("Level: " + viewModel.level));
        ((TextView) findViewById(R.id.sublevel_display)).setText(String.valueOf(viewModel.sublevel + "/100"));
        if (viewModel.subjectId == 1) {
            ((TextView) findViewById(R.id.subject)).setText("Subject: Maths");
        } else if (viewModel.subjectId == 2) {
            ((TextView) findViewById(R.id.subject)).setText("Subject: English");
        } else if (viewModel.subjectId == 3) {
            ((TextView) findViewById(R.id.subject)).setText("Subject: Geography");
        } else {
            ((TextView) findViewById(R.id.subject)).setText("Unregistered subject");
        }
        ((TextView) findViewById(R.id.quiz_number)).setText(String.valueOf("Quiz number " + String.valueOf(viewModel.quizId)));
        displayprogressBar(viewModel.sublevel);
    }

    @Override
    public void finishView() {
        finish();
    }

    private void displayprogressBar(int sublevel) {
        final ProgressBar mProgressBar;
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar2);
        final int actualExperience = sublevel;
        final int[] mProgressStatus = {0};
        final Handler mHandler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mProgressStatus[0] < actualExperience) {
                    mProgressStatus[0]++;
                    android.os.SystemClock.sleep(25);
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            mProgressBar.setProgress(mProgressStatus[0]);
                        }
                    });
                }
            }
        }).start();
    }

    @Override
    public void injectPresenter(FinalQuizContract.Presenter presenter) {
        this.presenter = presenter;
    }

    public void onReturnClicked(View view) {
        presenter.onReturnClicked();
    }


    @Override
    public void navigateToQuizUnitsScreen(){
        Intent intent = new Intent(this, QuizUnitActivity.class);
        startActivity(intent);
    }

    @Override
    public void navigateToProfileScreen() {
        Intent intent = new Intent(this, ProfileActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }

    public void onShareClicked(View view) {
        presenter.sendEmail();
    }

    @Override
    public void sendEmail(User usuario, int quizId, int subjectId, int score) {
        String subject = "";
        if (subjectId == 1) {
            subject = getString(R.string.subject_maths);
        } else if (subjectId == 2) {
            subject = getString(R.string.subject_english);
        } else if (subjectId == 3) {
            subject = getString(R.string.subject_geography);
        } else {
            subject = getString(R.string.subject_unregistered);
        }

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");


        emailIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.email_shareScoreMessage));
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Try Learn Quest for free! I'm level " + String.valueOf(usuario.getLevel()) + "," + String.valueOf(usuario.getSublevel()) + " and I just got a score of " + String.valueOf(score) + " exp points in " + subject + "Quest, " + "quiz number" + String.valueOf(quizId));

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finished sending email...", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(FinalQuizActivity.this,
                    R.string.email_errorToast, Toast.LENGTH_SHORT).show();
        }
    }
}