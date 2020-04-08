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

        }
    }


    @Override
    public void injectPresenter(LoginContract.Presenter presenter) {
        this.presenter = presenter;
    }

    public void onLetsGoClicked(View view) {
        EditText username = (EditText)findViewById(R.id.username_input);
        EditText password = (EditText)findViewById(R.id.password_input);
        presenter.onLetsGoClicked(String.valueOf(username), String.valueOf(password));
    }
}
