package es.ulpgc.eite.da.learnquest.quizUnit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // boton para darle back

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

        ((TextView) findViewById(R.id.t2_topic)).setText(viewModel.t2Topic);
        ((TextView) findViewById(R.id.t2_topic_title)).setText(viewModel.t2SubTopic);
        ((TextView) findViewById(R.id.t2_description)).setText(viewModel.t2Description);

    }

    public void onButtonOptionClicked(View view){

        switch(view.getId()){
            case R.id.t1_topic_solve:
                presenter.onOptionClicked(Integer.parseInt(getResources().getString(R.string.t1_solve_option)));
                break;
            case R.id.t2_topic_solve:
                presenter.onOptionClicked(Integer.parseInt(getResources().getString(R.string.t2_solve_option)));
                break;
        }

    }
    @Override
    public void injectPresenter(QuizUnitContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
