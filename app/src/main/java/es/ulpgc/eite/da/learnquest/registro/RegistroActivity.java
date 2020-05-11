package es.ulpgc.eite.da.learnquest.registro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import es.ulpgc.eite.da.learnquest.R;
import es.ulpgc.eite.da.learnquest.app.AppMediator;
import es.ulpgc.eite.da.learnquest.login.LoginActivity;

public class RegistroActivity
        extends AppCompatActivity implements RegistroContract.View {

    public static String TAG = RegistroActivity.class.getSimpleName();

    private RegistroContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        getSupportActionBar().setTitle(getResources().getString(R.string.registro_screen_title));


        Spinner spinner = findViewById(R.id.image_selection);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                presenter.onSelectionClicked(selectedItem);
            }
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //if(savedInstanceState == null ) AppMediator.resetInstance();

        // do the setup
        RegistroScreen.configure(this);
    }

    @Override
    public void displayPictureSelected(String selectedItem) {
        if (selectedItem.equals("Predeterminada")) {
            ((ImageView) findViewById(R.id.imagenDePerfil)).setImageResource(android.R.drawable.ic_menu_camera);
        } else if(selectedItem.equals("Patata")){
            ((ImageView) findViewById(R.id.imagenDePerfil)).setImageResource(R.drawable.patata);
        } else if(selectedItem.equals("Rabano")){
            ((ImageView) findViewById(R.id.imagenDePerfil)).setImageResource(R.drawable.rabano);
        }else if(selectedItem.equals("Lechuga")){
            ((ImageView) findViewById(R.id.imagenDePerfil)).setImageResource(R.drawable.lechuga);
        }
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
    public void displayWarning(int tipo) {
        if(tipo == 1){
            String warningText = getResources().getString(R.string.registro_warning_text);
            Toast warning = Toast.makeText(this, warningText, Toast.LENGTH_LONG);
            warning.show();
        } else if(tipo == 2){
            String warningText = getResources().getString(R.string.registro_warning_text_same_user);
            Toast warning = Toast.makeText(this, warningText, Toast.LENGTH_LONG);
            warning.show();
        }

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

    public void navigateToLogInScreen() {

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void onSelectionClicked(View view) {
        int id = view.getId();
        Spinner spinner = (Spinner) findViewById(id);
        spinner.getSelectedItem();
//        presenter.onSelectionClicked(view.getId());
//        int id = view.getId();
//        Spinner spinner = (Spinner) findViewById(R.id.image_selection);
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
//            public void onItemSelected(AdapterView<?> spn, android.view.View v, int position, long id){
//                Toast.makeText(spn.getContext(), "Has seleccionado " + spn.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
//            }
//        }
//
//        );
        Log.d("perris", String.valueOf(spinner.getSelectedItem()));
    }


}
