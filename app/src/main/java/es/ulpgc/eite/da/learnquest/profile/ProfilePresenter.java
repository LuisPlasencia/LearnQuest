package es.ulpgc.eite.da.learnquest.profile;

import java.lang.ref.WeakReference;

public class ProfilePresenter implements ProfileContract.Presenter {

    public static String TAG = ProfilePresenter.class.getSimpleName();

    private WeakReference<ProfileContract.View> view;
    private ProfileState state;
    private ProfileContract.Model model;
    private ProfileContract.Router router;

    public ProfilePresenter(ProfileState state) {
        this.state = state;
    }

    @Override
    public void onStart() {
        // Log.e(TAG, "onStart()");

        // initialize the state if is necessary
        if (state == null) {
            state = new ProfileState();
        }

        // use passed state if is necessary
        ProfileState savedState = router.getStateFromPreviousScreen();
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
    public void onGoQuestButtonClicked(){
        router.passStateToNextScreen(state);
        router.navigateToNextScreen();

    }

    @Override
    public void injectView(WeakReference<ProfileContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(ProfileContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(ProfileContract.Router router) {
        this.router = router;
    }
}
