package es.ulpgc.eite.da.learnquest.registro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import es.ulpgc.eite.da.learnquest.R;

public class RegistroActivity
        extends AppCompatActivity implements RegistroContract.View {

    public static String TAG = RegistroActivity.class.getSimpleName();

    private RegistroContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        getSupportActionBar().setTitle(getResources().getString(R.string.registro_screen_title));

        // do the setup
        RegistroScreen.configure(this);
    }

    @Override
    public String getPasswordInput() {
        return ((EditText) findViewById(R.id.registro_password)).getText().toString();
    }

    @Override
    public String getEmailInput() {
        return ((EditText) findViewById(R.id.registro_email)).getText().toString();
    }

    @Override
    public String getUsernameInput() {
        return ((EditText) findViewById(R.id.registro_username)).getText().toString();
    }

    public void onSignUpButtonClicked(View view) {
        presenter.onSignUpButtonClicked();
    }

    @Override
    public void displayWarning() {
        String warningText = getResources().getString(R.string.registro_warning_text);
        Toast warning = Toast.makeText(this, warningText, Toast.LENGTH_LONG);
        warning.show();
    }

    @Override
    public void onFinish() {
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        presenter.onBackPressed();
    }

    @Override
    public void injectPresenter(RegistroContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
