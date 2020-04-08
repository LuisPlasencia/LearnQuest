package es.ulpgc.eite.da.learnquest.finalQuiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import es.ulpgc.eite.da.learnquest.R;

public class FinalQuizActivity
        extends AppCompatActivity implements FinalQuizContract.View {

    public static String TAG = FinalQuizActivity.class.getSimpleName();

    private FinalQuizContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_quiz);
        getSupportActionBar().setTitle(R.string.app_name);

        // do the setup
        FinalQuizScreen.configure(this);

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
    public void onDataUpdated(FinalQuizViewModel viewModel) {
        //Log.e(TAG, "onDataUpdated()");

        // deal with the data
  //      ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }

    @Override
    public void injectPresenter(FinalQuizContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
