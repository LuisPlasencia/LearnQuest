package es.ulpgc.eite.da.learnquest.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import es.ulpgc.eite.da.learnquest.R;

public class LoginActivity
        extends AppCompatActivity implements LoginContract.View {

    public static String TAG = LoginActivity.class.getSimpleName();

    private LoginContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // do the setup
        LoginScreen.configure(this);

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
    public void onDataUpdated(LoginViewModel viewModel) {
        //Log.e(TAG, "onDataUpdated()");

        // deal with the data
        EditText username = (EditText)findViewById(R.id.username_input);
        username.setText(viewModel.username);
        EditText password = (EditText)findViewById(R.id.password_input);
        password.setText(viewModel.password);

    }

    @Override
    public void injectPresenter(LoginContract.Presenter presenter) {
        this.presenter = presenter;
    }

    public void onLetsGoClicked(View view) {
        presenter.onLetsGoClicked();
    }
}
