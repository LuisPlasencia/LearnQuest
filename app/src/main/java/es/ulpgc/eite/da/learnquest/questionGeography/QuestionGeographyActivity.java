package es.ulpgc.eite.da.learnquest.questionGeography;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;;
import android.util.Log;
import android.widget.TextView;

import es.ulpgc.eite.da.learnquest.R;

public class QuestionGeographyActivity
        extends AppCompatActivity implements QuestionGeographyContract.View {

    public static String TAG = QuestionGeographyActivity.class.getSimpleName();

    private QuestionGeographyContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_geography);
      //  getSupportActionBar().setTitle(R.string.app_name);

        // do the setup
        QuestionGeographyScreen.configure(this);

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
    public void onDataUpdated(QuestionGeographyViewModel viewModel) {
        //Log.e(TAG, "onDataUpdated()");

        // deal with the data

    }


    @Override
    public void navigateToNextScreen() {
        Intent intent = new Intent(this, QuestionGeographyActivity.class);
        startActivity(intent);
    }

    @Override
    public void injectPresenter(QuestionGeographyContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
