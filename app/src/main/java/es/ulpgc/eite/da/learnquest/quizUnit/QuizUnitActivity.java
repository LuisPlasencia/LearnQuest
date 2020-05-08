package es.ulpgc.eite.da.learnquest.quizUnit;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import es.ulpgc.eite.da.learnquest.R;
import es.ulpgc.eite.da.learnquest.data.QuestItem;
import es.ulpgc.eite.da.learnquest.data.QuizUnitItem;

public class QuizUnitActivity
        extends AppCompatActivity implements QuizUnitContract.View {

    public static String TAG = QuizUnitActivity.class.getSimpleName();

    private QuizUnitContract.Presenter presenter;

    private QuizUnitAdapter listAdapter;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_unit);
        getSupportActionBar().setTitle(R.string.quiz_unit_title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // boton para darle back

        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        listAdapter = new QuizUnitAdapter(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                QuizUnitItem item = (QuizUnitItem) view.getTag();
                if(item == null){
                    Log.d(TAG,"item es caca");
                }
                presenter.selectQuizUnitData(item.getId());
            }
        });

        RecyclerView recyclerView = findViewById(R.id.quiz_unit_list);
        recyclerView.setAdapter(listAdapter);

        // do the setup
        QuizUnitScreen.configure(this);

        presenter.fetchQuizUnitData();

        if(savedInstanceState == null){
            presenter.onStart();
        }

    }


    @Override
    public void displayData(final QuizUnitViewModel viewModel) {
        // deal with the data

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // deal with the data
                QuestItem quest = viewModel.quest;
                if (actionBar != null) {
                    actionBar.setTitle(quest.subjectName);
                    // actionBar.setIcon(category.mImage); //////////////////////////////
                }

                listAdapter.setItems(viewModel.quizUnitItems);
            }
        });
    }

       // listAdapter.setItems(viewModel.quizUnitItems);

    @Override
    public void injectPresenter(QuizUnitContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
