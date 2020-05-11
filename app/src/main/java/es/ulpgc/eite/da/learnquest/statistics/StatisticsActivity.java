package es.ulpgc.eite.da.learnquest.statistics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import es.ulpgc.eite.da.learnquest.R;
import es.ulpgc.eite.da.learnquest.data.QuestItem;

public class StatisticsActivity
        extends AppCompatActivity implements StatisticsContract.View {

    public static String TAG = StatisticsActivity.class.getSimpleName();

    private StatisticsContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        getSupportActionBar().setTitle(R.string.achievements);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        listAdapter = new StatisticsAdapter(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                QuestItem item = (QuestItem) view.getTag();
//                presenter.selectQuestData(item);
//            }
//        });
//
//        RecyclerView recyclerView = findViewById(R.id.quests_list);
//        recyclerView.setAdapter(listAdapter);

        // do the setup
        StatisticsScreen.configure(this);

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
    public void onDataUpdated(StatisticsViewModel viewModel) {
        //Log.e(TAG, "onDataUpdated()");

        // deal with the data
   //     ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }

    @Override
    public void injectPresenter(StatisticsContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void navigateToNextScreen() {
    Intent intent = new Intent(this, StatisticsActivity.class);
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    startActivity(intent);
    }

}


