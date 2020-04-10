package es.ulpgc.eite.da.learnquest.finalQuiz;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import es.ulpgc.eite.da.learnquest.R;

public class FinalQuizActivity
        extends AppCompatActivity implements FinalQuizContract.View {

    public static String TAG = FinalQuizActivity.class.getSimpleName();

    private FinalQuizContract.Presenter presenter;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_quiz);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

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
        ((TextView) findViewById(R.id.earned)).setText(String.valueOf("You earned " + viewModel.experience_earned + "xp!"));
        ((TextView) findViewById(R.id.exp_to_nextlevel)).setText(String.valueOf("You need " + viewModel.experience_needed + "exp to reach level " + viewModel.level+1));
        ((TextView) findViewById(R.id.level_display)).setText(String.valueOf(viewModel.level));
        int photo = presenter.getMedalPhoto();
        ((ImageView) findViewById(R.id.medal)).setImageResource(photo);
        displayprogressBar(viewModel.sublevel);
    }

    private void displayprogressBar(int sublevel) {
        final ProgressBar mProgressBar;
        mProgressBar = (ProgressBar)findViewById(R.id.progressBar2);
        final int actualExperience = sublevel;
        final int[] mProgressStatus = {0};
        final Handler mHandler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(mProgressStatus[0] < actualExperience){
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
        }) .start();
    }

    @Override
    public void injectPresenter(FinalQuizContract.Presenter presenter) {
        this.presenter = presenter;
    }

    public void onReturnClicked(View view) {
        presenter.onReturnClicked();
    }
}
