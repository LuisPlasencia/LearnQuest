package es.ulpgc.eite.da.learnquest.finalQuiz;

import android.util.Log;

import java.lang.ref.WeakReference;

public class FinalQuizPresenter implements FinalQuizContract.Presenter {

    public static String TAG = FinalQuizPresenter.class.getSimpleName();

    private WeakReference<FinalQuizContract.View> view;
    private FinalQuizState state;
    private FinalQuizContract.Model model;
    private FinalQuizContract.Router router;

    public FinalQuizPresenter(FinalQuizState state) {
        this.state = state;
    }

    @Override
    public void onStart() {
        // Log.e(TAG, "onStart()");

        // initialize the state if is necessary
        if (state == null) {
            state = new FinalQuizState();
        }

        // use passed state if is necessary
        FinalQuizState savedState = router.getStateFromPreviousScreen();
        if (savedState != null) {

            // update the model if is necessary
            model.onDataFromPreviousScreen(savedState.data);
        }
    }

    @Override
    public void onRestart() {
        // Log.e(TAG, "onRestart()");

        // update the model if is necessary
        model.onRestartScreen(state.data);
    }

    @Override
    public void onResume() {
        // Log.e(TAG, "onResume()");

        // use passed state if is necessary
//        FinalQuizState savedState = router.getStateFromNextScreen();
//        if (savedState != null) {
//
//            // update the model if is necessary
//            model.onDataFromNextScreen(savedState.data);
//        }
//
//        // call the model and update the state
//        state.data = model.getStoredData();
//
//        // update the view
//        view.get().onDataUpdated(state);

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
    public void injectView(WeakReference<FinalQuizContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(FinalQuizContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(FinalQuizContract.Router router) {
        this.router = router;
    }
}
