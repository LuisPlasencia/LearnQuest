package es.ulpgc.eite.da.learnquest.questScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import es.ulpgc.eite.da.learnquest.R;

public class QuestScreenActivity
        extends AppCompatActivity implements QuestScreenContract.View {

    public static String TAG = QuestScreenActivity.class.getSimpleName();

    private QuestScreenContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest_screen);

        // do the setup
        QuestScreenScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // load the data
        presenter.fetchData();
    }

    @Override
    public void displayData(QuestScreenViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }

    @Override
    public void injectPresenter(QuestScreenContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
