package es.ulpgc.eite.da.learnquest.perfil;

import android.util.Log;

import java.lang.ref.WeakReference;

public class PerfilPresenter implements PerfilContract.Presenter {

    public static String TAG = PerfilPresenter.class.getSimpleName();

    private WeakReference<PerfilContract.View> view;
    private PerfilState state;
    private PerfilContract.Model model;
    private PerfilContract.Router router;

    public PerfilPresenter(PerfilState state) {
        this.state = state;
    }

    @Override
    public void onStart() {
        // Log.e(TAG, "onStart()");

        // initialize the state if is necessary
        if (state == null) {
            state = new PerfilState();
        }

        // use passed state if is necessary
        PerfilState savedState = router.getStateFromPreviousScreen();
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
//        PerfilState savedState = router.getStateFromNextScreen();
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
    public void injectView(WeakReference<PerfilContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(PerfilContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(PerfilContract.Router router) {
        this.router = router;
    }
}
