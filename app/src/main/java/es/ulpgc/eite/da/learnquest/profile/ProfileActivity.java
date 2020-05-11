package es.ulpgc.eite.da.learnquest.profile;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import es.ulpgc.eite.da.learnquest.R;
import es.ulpgc.eite.da.learnquest.login.LoginActivity;
import es.ulpgc.eite.da.learnquest.statistics.StatisticsActivity;
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
        presenter.onBackPressed();
    }


    @Override
    public void displayProfileData(ProfileViewModel viewModel) {
        //Log.e(TAG, "onDataUpdated()");

        // deal with the data
        ((TextView) findViewById(R.id.profile_name)).setText(viewModel.username);
        ((TextView) findViewById(R.id.level_display)).setText(String.valueOf("Level: " + viewModel.level));
        ((TextView) findViewById(R.id.exp_to_display)).setText(String.valueOf(viewModel.sublevel + " / 100"));
        String photo = presenter.getPhoto();
        Log.d("displayProfileData", photo);
        if(photo.equals("Predeterminada")){
            ((ImageView) findViewById(R.id.profile_photo)).setImageResource(android.R.drawable.ic_menu_camera);
        }else if(photo.equals("Patata")){
            ((ImageView) findViewById(R.id.profile_photo)).setImageResource(R.drawable.patata);
        }else if(photo.equals("Rabano")){
            ((ImageView) findViewById(R.id.profile_photo)).setImageResource(R.drawable.rabano);
        }else if(photo.equals("Lechuga")){
            ((ImageView) findViewById(R.id.profile_photo)).setImageResource(R.drawable.lechuga);
        }
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
        switch (view.getId()){
            case R.id.statistics_button:
                presenter.onStatisticsButtonClicked();
                break;
            case R.id.go_button:
                presenter.onGoQuestButtonClicked();
                break;
            case R.id.log_out_button:
                presenter.onLogOutButtonClicked();
                break;
            case R.id.removeUser_button:
                presenter.onRemoveButtonClicked();
        }
    }


    @Override
    public void finishView(){
        finish();
    }


    @Override
    public void navigateToQuestsScreen() {
        Intent intent = new Intent(this, QuestsActivity.class);

        startActivity(intent);
    }

    @Override
    public void navigateStatisticsScreen() {
        Intent intent = new Intent(this, StatisticsActivity.class);
        startActivity(intent);
    }

    @Override
    public void navigateLoginScreen() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

        startActivity(intent);
    }

    @Override
    public void alertDialogLogOut() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("Logout");
        builder.setMessage("¿Are you sure you want to logout?");
        builder.setPositiveButton("Confirm",
            new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    presenter.logout();
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
    public void alertDialogRemove() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("Remove User");
        builder.setMessage("Are you sure you want to remove this User from the database forever?");
        builder.setPositiveButton("Eliminate it!",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        presenter.removeUser();
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
