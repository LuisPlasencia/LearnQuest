package es.ulpgc.eite.da.learnquest.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import es.ulpgc.eite.da.learnquest.R;
import es.ulpgc.eite.da.learnquest.app.AppMediator;
import es.ulpgc.eite.da.learnquest.profile.ProfileActivity;
import es.ulpgc.eite.da.learnquest.registro.RegistroActivity;

public class LoginActivity
        extends AppCompatActivity implements LoginContract.View {

    public static String TAG = LoginActivity.class.getSimpleName();

    private LoginContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //  if(savedInstanceState == null) AppMediator.resetInstance();

        // do the setup
        if (savedInstanceState == null) {
            AppMediator.resetInstance();
        }

        LoginScreen.configure(this);

        presenter.fetchUserListData();

        if (savedInstanceState == null) {
            presenter.onStart();

        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        // load the data
        presenter.onResume();
    }


    @Override
    public void injectPresenter(LoginContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayCurrentData(LoginState state) {
        EditText username = (EditText) findViewById(R.id.username_input);
        EditText password = (EditText) findViewById(R.id.password_input);
        username.setText(state.username);
        password.setText(state.password);
    }

    public void onLetsGoClicked(View view) {
        EditText username = (EditText) findViewById(R.id.username_input);
        EditText password = (EditText) findViewById(R.id.password_input);
        presenter.onLetsGoClicked(String.valueOf(username.getText()), String.valueOf(password.getText()));
    }

    public void onCreateAccountButton(View view) {
        presenter.onCreateAccountButton();
    }

    @Override
    public void navigateToProfileScreen() {
        Intent intent = new Intent(this, ProfileActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public void navigateToRegistroScreen() {
        Intent intent = new Intent(this, RegistroActivity.class);
        startActivity(intent);
    }

    @Override
    public void displayWarning(int tipo) {
        String warningText = "";
        if (tipo == 1){
            warningText = "Invalid username";
        } else if(tipo == 2){
            warningText = "Wrong password";
        }
        Toast warning = Toast.makeText(this, warningText, Toast.LENGTH_SHORT);
        warning.show();
    }

}
