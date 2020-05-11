package es.ulpgc.eite.da.learnquest.statistics;

import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.eite.da.learnquest.data.RepositoryContract;
import es.ulpgc.eite.da.learnquest.data.User;

public class StatisticsPresenter implements StatisticsContract.Presenter {

    public static String TAG = StatisticsPresenter.class.getSimpleName();

    private WeakReference<StatisticsContract.View> view;
    private StatisticsState state;
    private StatisticsContract.Model model;
    private StatisticsContract.Router router;

    public StatisticsPresenter(StatisticsState state) {
        this.state = state;
    }


//    @Override
//    public void onRestart() {
//        // Log.e(TAG, "onRestart()");
//
//        // update the model if is necessary
//        model.onRestartScreen(state.data);
//    }

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
    public void fetchUserData() {
        model.getDatabaseUsers(new RepositoryContract.GetUserListCallback() {
            @Override
            public void setUserList(List<User> users){
                state.userList = users;
                view.get().displayData(state);
            }
        });
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
