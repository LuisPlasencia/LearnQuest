package es.ulpgc.eite.da.learnquest.question;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import es.ulpgc.eite.da.learnquest.R;

public class QuestionActivity
        extends AppCompatActivity implements QuestionContract.View {

    public static String TAG = QuestionActivity.class.getSimpleName();

    private QuestionContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        // do the setup
        QuestionScreen.configure(this);

        Button hintButton = findViewById(R.id.cheatButton);
        hintButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onHintButtonClicked();
            }
        });

        if(savedInstanceState == null) {
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
    public void resetReply() {
        ((TextView) findViewById(R.id.answer_text)).setText(R.string.empty_string);
    }

    @Override
    public void displayData(QuestionViewModel viewModel) {
        Log.e(TAG, "displayData()");

        // deal with the data
        ((TextView) findViewById(R.id.question_number)).setText(viewModel.questionNumber);
        ((TextView) findViewById(R.id.question_text)).setText(viewModel.questionText);
        ((Button) findViewById(R.id.option1_button)).setText(viewModel.option1);
        ((Button) findViewById(R.id.option2_button)).setText(viewModel.option2);
        ((Button) findViewById(R.id.option3_button)).setText(viewModel.option3);
        ((TextView) findViewById(R.id.question_text)).setText(viewModel.questionText);

        findViewById(R.id.option1_button).setEnabled(viewModel.optionEnabled);
        findViewById(R.id.option2_button).setEnabled(viewModel.optionEnabled);
        findViewById(R.id.option3_button).setEnabled(viewModel.optionEnabled);
        findViewById(R.id.nextButton).setEnabled(viewModel.nextEnabled);
        findViewById(R.id.cheatButton).setEnabled(viewModel.hintEnabled);
    }

    public void onNextButtonClicked(View view) {
        presenter.onNextButtonClicked();
    }


    public void onOptionButtonClicked(View view) {
        int option = Integer.valueOf((String) view.getTag());
        presenter.onOptionButtonClicked(option);
    }

    @Override
    public void updateReply(boolean isCorrect) {
        if(isCorrect){
            ((TextView) findViewById(R.id.answer_text)).setText(R.string.correct_text);
        } else {
            ((TextView) findViewById(R.id.answer_text)).setText(R.string.incorrect_text);
        }
    }


    @Override
    public void injectPresenter(QuestionContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
