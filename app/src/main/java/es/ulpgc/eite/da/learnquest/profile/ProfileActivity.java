package es.ulpgc.eite.da.learnquest.profile;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import es.ulpgc.eite.da.learnquest.R;
import es.ulpgc.eite.da.learnquest.login.LoginActivity;
import es.ulpgc.eite.da.learnquest.logros.LogrosActivity;
import es.ulpgc.eite.da.learnquest.quests.QuestsActivity;

public class ProfileActivity
        extends AppCompatActivity implements ProfileContract.View {

    public static String TAG = ProfileActivity.class.getSimpleName();

    private ProfileContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //  if(savedInstanceState == null) AppMediator.resetInstance();

        // do the setup
        ProfileScreen.configure(this);

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
    public void displayProfileData(ProfileViewModel viewModel) {
        //Log.e(TAG, "onDataUpdated()");

        // deal with the data

        ((TextView) findViewById(R.id.profile_name)).setText(viewModel.username);
        ((TextView) findViewById(R.id.level_display)).setText(String.valueOf("Level: " + viewModel.level));
        ((TextView) findViewById(R.id.exp_to_display)).setText(String.valueOf(viewModel.sublevel + " / 100"));
        int photo = presenter.getPhoto();
        ((ImageView) findViewById(R.id.profile_photo)).setImageResource(photo);
        displayprogressBar(viewModel.sublevel);
    }

    private void displayprogressBar(int sublevel) {
        final ProgressBar mProgressBar;
        mProgressBar = (ProgressBar)findViewById(R.id.progressBar);
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
    public void injectPresenter(ProfileContract.Presenter presenter) {
        this.presenter = presenter;
    }

    public void onButtonClicked(View view){
        //TODO Implementar create new quest Button
        switch (view.getId()){
            case R.id.achievements_button:
                presenter.onAchievementsButtonClicked();
                break;
            case R.id.go_button:
                presenter.onGoQuestButtonClicked();
                break;
            case R.id.log_out_button:
                presenter.onLogOutButtonClicked();
        }
    }


    @Override
    public void finishView(){
        finish();
    }


    @Override
    public void navigateToQuestsScreen() {
        Intent intent = new Intent(this, QuestsActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public void navigateAchievementsScreen() {
        Intent intent = new Intent(this, LogrosActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public void navigateLoginScreen() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

}
