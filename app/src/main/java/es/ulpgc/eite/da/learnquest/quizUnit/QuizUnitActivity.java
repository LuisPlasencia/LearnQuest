package es.ulpgc.eite.da.learnquest.quizUnit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import es.ulpgc.eite.da.learnquest.R;

public class QuizUnitActivity
        extends AppCompatActivity implements QuizUnitContract.View {

    public static String TAG = QuizUnitActivity.class.getSimpleName();

    private QuizUnitContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_unit);

        getSupportActionBar().setTitle(R.string.quiz_unit_title);

        // do the setup
        QuizUnitScreen.configure(this);

        presenter.setT1Items();

        if(savedInstanceState == null){
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
    public void displayData(QuizUnitViewModel viewModel) {
        //Log.e(TAG, "onDataUpdated()");

        // deal with the data
        ((TextView) findViewById(R.id.t1_topic)).setText(viewModel.t1Topic);
        ((TextView) findViewById(R.id.t1_topic_title)).setText(viewModel.t1SubTopic);
        ((TextView) findViewById(R.id.t1_description)).setText(viewModel.t1Description);

    }

    @Override
    public void injectPresenter(QuizUnitContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
