package es.ulpgc.eite.da.learnquest.statistics;

import java.lang.ref.WeakReference;

public class StatisticsPresenter implements StatisticsContract.Presenter {

    public static String TAG = StatisticsPresenter.class.getSimpleName();

    private WeakReference<StatisticsContract.View> view;
    private StatisticsState state;
    private StatisticsContract.Model model;
    private StatisticsContract.Router router;

    public StatisticsPresenter(StatisticsState state) {
        this.state = state;
    }

    @Override
    public void onStart() {
        // Log.e(TAG, "onStart()");

        // initialize the state if is necessary
        if (state == null) {
            state = new StatisticsState();
        }

        // use passed state if is necessary
        StatisticsState savedState = router.getStateFromPreviousScreen();
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
//        LogrosState savedState = router.getStateFromNextScreen();
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
    public void injectView(WeakReference<StatisticsContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(StatisticsContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(StatisticsContract.Router router) {
        this.router = router;
    }
}
