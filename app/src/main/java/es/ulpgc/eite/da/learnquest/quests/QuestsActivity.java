package es.ulpgc.eite.da.learnquest.quests;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import es.ulpgc.eite.da.learnquest.R;
import es.ulpgc.eite.da.learnquest.data.QuestItem;

public class QuestsActivity
        extends AppCompatActivity implements QuestsContract.View {

    public static String TAG = QuestsActivity.class.getSimpleName();

    private QuestsContract.Presenter presenter;
    private QuestsAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quests);
        getSupportActionBar().setTitle(R.string.quests_unit_title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // boton para darle back

        listAdapter = new QuestsAdapter(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                QuestItem item = (QuestItem) view.getTag();
                presenter.selectQuestData(item);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.quests_list);
        recyclerView.setAdapter(listAdapter);

        // do the setup
        QuestsScreen.configure(this);
//        presenter.updateLevels();
//        presenter.setSubjectImage();
        presenter.fetchQuestsData();
        presenter.fecthQuestsDataPercentageAndImage();
    }


//    @Override
//    protected void onResume() {
//        super.onResume();
//
//        // load the data
//        presenter.onResume();
//    }
    @Override
    public void displayData(final QuestsViewModel viewModel) {
        //Log.e(TAG, "displayData()");
        // deal with the data
        runOnUiThread(new Runnable() {

            @Override
            public void run() {

                // deal with the data
                listAdapter.setItems(viewModel.questItems);
            }

        });

    }
    @Override
    public void displayDataPercentageAndImage(QuestsViewModel viewModel){
        listAdapter.setItems(viewModel.questItems);
    }

    @Override
    public void injectPresenter(QuestsContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
