package es.ulpgc.eite.da.learnquest.questionGeography;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;;
import android.util.Log;
import android.widget.TextView;

import es.ulpgc.eite.da.learnquest.R;
import es.ulpgc.eite.da.learnquest.data.QuizUnitItem;
import es.ulpgc.eite.da.learnquest.questionMath.QuestionMathViewModel;

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

        presenter.fetchQuestionGeoData();

        if (savedInstanceState == null) {
            presenter.onStart();

        } else {
            presenter.onRestart();
        }
    }

    @Override
    public void displayData(final QuestionGeographyViewModel viewModel) {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // deal with the data
                QuizUnitItem quizUnitItem = viewModel.quizUnitItem;

                ((TextView) findViewById(R.id.geoTitle)).
                        setText(quizUnitItem.questionGeographyItems.get(0).geoTitle);

//                ((TextView) findViewById(R.id.answer_math)).setText(viewModel.mathAnswerText);
//                ((TextView) findViewById(R.id.question_math_number)).setText(viewModel.mathQuestionNumber);




            }
        });
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
