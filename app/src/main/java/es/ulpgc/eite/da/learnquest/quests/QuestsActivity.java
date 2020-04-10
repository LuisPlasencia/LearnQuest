package es.ulpgc.eite.da.learnquest.quests;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import es.ulpgc.eite.da.learnquest.R;

public class QuestsActivity
        extends AppCompatActivity implements QuestsContract.View {

    public static String TAG = QuestsActivity.class.getSimpleName();

    private QuestsContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quests);

        // do the setup
        QuestsScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // load the data

        presenter.fetchData();
    }

    @Override
    public void displayData(QuestsViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        //((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }

    public void onButtonClicked(View view){

        switch(view.getId()){
            case R.id.math_button:
                presenter.onSubjectButtonClicked(getResources().getString(R.string.maths_text));
            break;
            case R.id.english_button:
                presenter.onSubjectButtonClicked(getResources().getString(R.string.english_text));
            break;
            case R.id.geography_button:
                presenter.onSubjectButtonClicked(getResources().getString(R.string.geography_text));
            break;

        }

    }

    @Override
    public void injectPresenter(QuestsContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
