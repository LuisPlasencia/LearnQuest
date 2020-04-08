package es.ulpgc.eite.da.learnquest.logros;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import es.ulpgc.eite.da.learnquest.R;

public class LogrosActivity
        extends AppCompatActivity implements LogrosContract.View {

    public static String TAG = LogrosActivity.class.getSimpleName();

    private LogrosContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logros);
        getSupportActionBar().setTitle(R.string.app_name);

        // do the setup
        LogrosScreen.configure(this);

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
    public void onDataUpdated(LogrosViewModel viewModel) {
        //Log.e(TAG, "onDataUpdated()");

        // deal with the data
   //     ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }

    @Override
    public void injectPresenter(LogrosContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
