package es.ulpgc.eite.da.learnquest.questionGeography;

import android.util.Log;

import java.lang.ref.WeakReference;

public class QuestionGeographyPresenter implements QuestionGeographyContract.Presenter {

    public static String TAG = QuestionGeographyPresenter.class.getSimpleName();

    private WeakReference<QuestionGeographyContract.View> view;
    private QuestionGeographyState state;
    private QuestionGeographyContract.Model model;
    private QuestionGeographyContract.Router router;

    public QuestionGeographyPresenter(QuestionGeographyState state) {
        this.state = state;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onRestart() {
        // Log.e(TAG, "onRestart()");

        // update the model if is necessary
        model.onRestartScreen(state.data);
    }

    @Override
    public void onResume() {


    }

    @Override
    public void onBackPressed() {
        // Log.e(TAG, "onBackPressed()");
    }

    @Override
    public void onPause() {
        // Log.e(TAG, "onPause()");
    }

    @Override
    public void onDestroy() {
        // Log.e(TAG, "onDestroy()");
    }

    @Override
    public void injectView(WeakReference<QuestionGeographyContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(QuestionGeographyContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(QuestionGeographyContract.Router router) {
        this.router = router;
    }
}
