package es.ulpgc.eite.da.learnquest.quizUnit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
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

        // do the setup
        QuizUnitScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // load the data
        presenter.fetchData();
    }

    @Override
    public void displayData(QuizUnitViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        //((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }

    @Override
    public void injectPresenter(QuizUnitContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
