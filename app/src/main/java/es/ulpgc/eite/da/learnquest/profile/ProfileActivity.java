package es.ulpgc.eite.da.learnquest.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import es.ulpgc.eite.da.learnquest.R;

public class ProfileActivity
        extends AppCompatActivity implements ProfileContract.View {

    public static String TAG = ProfileActivity.class.getSimpleName();

    private ProfileContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportActionBar().setTitle(R.string.app_name);

        // do the setup
        ProfileScreen.configure(this);

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

    @Override
    public void onDataUpdated(ProfileViewModel viewModel) {
        //Log.e(TAG, "onDataUpdated()");

        // deal with the data
   //     ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }

    @Override
    public void injectPresenter(ProfileContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
