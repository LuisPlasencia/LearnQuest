package es.ulpgc.eite.da.learnquest.statistics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;

import es.ulpgc.eite.da.learnquest.R;
import es.ulpgc.eite.da.learnquest.data.QuestItem;
import es.ulpgc.eite.da.learnquest.data.User;
import es.ulpgc.eite.da.learnquest.quests.QuestsViewModel;

public class StatisticsActivity
        extends AppCompatActivity implements StatisticsContract.View {

    public static String TAG = StatisticsActivity.class.getSimpleName();

    private StatisticsContract.Presenter presenter;
    private StatisticsAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
//        getSupportActionBar().setTitle(R.string.statistics_text);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listAdapter = new StatisticsAdapter(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        RecyclerView recyclerView = findViewById(R.id.statistics_list);
        recyclerView.setAdapter(listAdapter);

        // do the setup
        StatisticsScreen.configure(this);

        presenter.fetchUserData();

//        if (savedInstanceState == null) {
//            presenter.onStart();
//
//        } else {
//            presenter.onRestart();
//        }
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

    @Override
    public void displayData(final StatisticsViewModel viewModel) {
        //Log.e(TAG, "displayData()");
        // deal with the data
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // deal with the data
                listAdapter.setItems(viewModel.userList);
            }
        });
    }



}


