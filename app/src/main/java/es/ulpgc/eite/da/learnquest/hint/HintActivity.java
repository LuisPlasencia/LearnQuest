package es.ulpgc.eite.da.learnquest.hint;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import es.ulpgc.eite.da.learnquest.R;

public class HintActivity
        extends AppCompatActivity implements HintContract.View {

    public static String TAG = HintActivity.class.getSimpleName();

    private HintContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_hint);

        // do the setup
        HintScreen.configure(this);

        if(savedInstanceState == null) {
            presenter.onStart();
        }
    }

    public void onReturnToQuestionButtonClicked(View view) {
        presenter.onReturnToQuestionButton();
    }

    public void onYesButtonClicked(View view) {
        presenter.onYesButtonClicked();
    }

    public void onNoButtonClicked(View view) {
        presenter.onNoButtonClicked();
    }

    @Override
    protected void onResume() {
        super.onResume();

        // load the data
        presenter.onResume();
    }

    @Override
    public void displayData(HintViewModel viewModel) {
        Log.e(TAG, "displayData()");

        ((TextView) findViewById(R.id.answer_text)).setText(viewModel.answer);
        ((Button) findViewById(R.id.yesButton)).setEnabled(viewModel.yesNoButtonEnabled);
        ((Button) findViewById(R.id.noButton)).setEnabled(viewModel.yesNoButtonEnabled);
    }

    @Override
    public void resetAnswer() {
        ((TextView) findViewById(R.id.answer_text)).setText(R.string.empty_string);
    }

    @Override
    public void onFinish() {
        finish();
    }

    @Override
    public void onBackPressed() {
        presenter.onBackPressed();
    }

    @Override
    public void injectPresenter(HintContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
