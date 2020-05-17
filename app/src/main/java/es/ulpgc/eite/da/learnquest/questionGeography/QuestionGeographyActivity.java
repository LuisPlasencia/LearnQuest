package es.ulpgc.eite.da.learnquest.questionGeography;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.concurrent.TimeUnit;

import es.ulpgc.eite.da.learnquest.R;
import es.ulpgc.eite.da.learnquest.data.QuizUnitItem;
import es.ulpgc.eite.da.learnquest.finalQuiz.FinalQuizActivity;
import es.ulpgc.eite.da.learnquest.questionMath.QuestionMathViewModel;
import es.ulpgc.eite.da.learnquest.quizUnit.QuizUnitActivity;

public class QuestionGeographyActivity
        extends AppCompatActivity implements QuestionGeographyContract.View {

    public static String TAG = QuestionGeographyActivity.class.getSimpleName();

    private QuestionGeographyContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_geography);
        setupToolbar();

        // do the setup
        QuestionGeographyScreen.configure(this);
        ImageView imageView = findViewById(R.id.geoHint_image);
        imageView.setVisibility(View.INVISIBLE);
        presenter.fetchQuestionGeoData();

        if (savedInstanceState == null) {
            presenter.onStart();

        } else {
            presenter.onRestart();
        }
    }

    @Override
    public void displayData(final QuestionGeographyViewModel viewModel) {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // deal with the data
                QuizUnitItem quizUnitItem = viewModel.quizUnitItem;

                ((TextView) findViewById(R.id.geoTitle)).
                        setText(quizUnitItem.questionGeographyItems.get(presenter.getIndex()).geoTitle);

                ((TextView) findViewById(R.id.answer_geo)).setText(viewModel.geoAnswerText);
                ((TextView) findViewById(R.id.question_geo_number)).setText(viewModel.geoQuestionNumber);
                //((TextView) findViewById(R.id.user_answer_geo)).setText(viewModel.geoUserAnswerText);


                findViewById(R.id.geo_quiz_hint).setEnabled(viewModel.geoHintEnabled);
                findViewById(R.id.geo_quiz_next).setEnabled(viewModel.geoNextEnabled);
               // findViewById(R.id.geo_quiz_enter).setEnabled(viewModel.geoEnterEnabled);

                findViewById(R.id.valencia_button).setEnabled(viewModel.geoButtonsEnabled);
                findViewById(R.id.madrid_button).setEnabled(viewModel.geoButtonsEnabled);
                findViewById(R.id.baleares_button).setEnabled(viewModel.geoButtonsEnabled);
                findViewById(R.id.canarias_button).setEnabled(viewModel.geoButtonsEnabled);
                findViewById(R.id.andalucia_button).setEnabled(viewModel.geoButtonsEnabled);
                findViewById(R.id.extremadura_button).setEnabled(viewModel.geoButtonsEnabled);
                findViewById(R.id.murcia_button).setEnabled(viewModel.geoButtonsEnabled);
                findViewById(R.id.cantabria_button).setEnabled(viewModel.geoButtonsEnabled);
                findViewById(R.id.pais_vasco_button).setEnabled(viewModel.geoButtonsEnabled);
                findViewById(R.id.galicia_button).setEnabled(viewModel.geoButtonsEnabled);
                findViewById(R.id.castilla_la_macha_button).setEnabled(viewModel.geoButtonsEnabled);
                findViewById(R.id.castilla_y_leon_button).setEnabled(viewModel.geoButtonsEnabled);
                findViewById(R.id.aragon_button).setEnabled(viewModel.geoButtonsEnabled);
                findViewById(R.id.la_rioja_button).setEnabled(viewModel.geoButtonsEnabled);
                findViewById(R.id.cataluña_button).setEnabled(viewModel.geoButtonsEnabled);

                loadImageFromURL(
                        (ImageView) findViewById(R.id.geoHint_image),
                        quizUnitItem.questionGeographyItems.get(presenter.getIndex()).geoHint
                );
            }
        });
    }

    public void onNextButtonClickedGeo(View view){
        presenter.onNextButtonClicked();
        ((TextView) findViewById(R.id.user_answer_geo)).setText("");
        ImageView imageView = findViewById(R.id.geoHint_image);
        imageView.setVisibility(View.INVISIBLE);
    }

    public void onLocationClicked(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();
        ((TextView) findViewById(R.id.user_answer_geo)).setText(buttonText);
        presenter.onEnterButtonClicked();
    }

    public void onHintButtonClickedGeo(View view) {


//        Toast toast = new Toast(getApplicationContext());
//        ImageView imageView = new ImageView(getApplicationContext());
//
//        imageView.setImageResource(R.drawable.spain_map_1_1);
//        imageView.setImageResource();
//
//        toast.setView(imageView);
//        toast.show();

//        LayoutInflater inflater = getLayoutInflater();
//        view = inflater.inflate(R.layout.custom_toast_layout,
//                (ViewGroup)findViewById(R.id.relativeLayout1));
//
//        Toast toast = new Toast(this);
//        toast.setView(view);
//        toast.show();

//        Button hintButton = findViewById(R.id.geo_quiz_hint);
//        hintButton.setVisibility(View.INVISIBLE);

        Button button = (Button) view;
        button.setText(R.string.button_hide_geoQuiz);
        button.setBackgroundResource(R.drawable.button_background_profile_red);

        ImageView imageView = findViewById(R.id.geoHint_image);

        if(imageView.getVisibility() == View.VISIBLE){
            imageView.setVisibility(View.INVISIBLE);

            button.setBackgroundResource(R.drawable.button_background_profile_blue);
            button.setText(R.string.hint_button_text);
        } else {
            imageView.setVisibility(View.VISIBLE);
        }


//        Toast toast = Toast.makeText(getApplicationContext(),
//                "You just got Bamboozled 😂😂😂",
//                Toast.LENGTH_LONG);
//
//        ViewGroup group = (ViewGroup) toast.getView();
//        TextView messageTextView = (TextView) group.getChildAt(0);
//        messageTextView.setTextSize(50);
//        toast.setGravity(Gravity.FILL_HORIZONTAL, 0, 0);
//
//        toast.show();
    }

    private void loadImageFromURL(ImageView imageView, String imageUrl){
        RequestManager reqManager = Glide.with(imageView.getContext());
        RequestBuilder reqBuilder = reqManager.load(imageUrl);
        RequestOptions reqOptions = new RequestOptions();
        reqOptions.diskCacheStrategy(DiskCacheStrategy.ALL);
        reqBuilder.apply(reqOptions);
        reqBuilder.into(imageView);
    }

    @Override
    public String getUserSolution() {
        TextView textView = findViewById(R.id.user_answer_geo);
        String userSolution = textView.getText().toString();
        return userSolution;
    }

    @Override
    public void resetUserAnswer(){
        ((TextView) findViewById(R.id.user_answer_geo)).setText("");
    }

    @Override
    public String getSolution(final QuestionGeographyViewModel viewModel) {
        QuizUnitItem quizUnitItem = viewModel.quizUnitItem;
        return quizUnitItem.questionGeographyItems.get(presenter.getIndex()).geoSolution;
    }

    @Override
    protected void onResume() {
        super.onResume();

        // load the data
        presenter.onResume();
    }

    @Override
    public void onBackPressed() {
  //      super.onBackPressed();

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

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.question_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            String questionTitle = getResources().getString(R.string.geography_toolbar);
            actionBar.setTitle(questionTitle);
        }
    }

    @Override
    public void displaySolutionCorrect() {
        Toast toast = Toast.makeText(getApplicationContext(),
                "Naisuuuuuuuuuuuuuuuuuuuuuuuuu",
                Toast.LENGTH_SHORT);

        toast.show();
    }

    @Override
    public void displaySolutionIncorrect() {
        Toast toast = Toast.makeText(getApplicationContext(),
                "Try again",
                Toast.LENGTH_SHORT);

        toast.show();
    }


    @Override
    public void onDataUpdated(QuestionGeographyViewModel viewModel) {
        //Log.e(TAG, "onDataUpdated()");

        // deal with the data

    }

    @Override
    public void navigateToNextScreen() {
        Intent intent = new Intent(this, QuestionGeographyActivity.class);
        startActivity(intent);
    }

    @Override
    public void injectPresenter(QuestionGeographyContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void alertDialogReturn() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(R.string.message_returnQuizAlert);
        builder.setMessage(R.string.details_returnQuizAlert);
        builder.setPositiveButton(R.string.confirm,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        navigateToQuizUnitScreen();
                    }
                });
        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                return;
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void navigateToQuizUnitScreen() {
        Intent intent = new Intent(this, QuizUnitActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
        finish();
    }
    @Override
    public void navigateToFinalQuizScreen() {
        Intent intent = new Intent(this, FinalQuizActivity.class);
        startActivity(intent);
    }
}
