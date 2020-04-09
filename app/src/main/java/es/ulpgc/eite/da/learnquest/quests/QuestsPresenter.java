package es.ulpgc.eite.da.learnquest.quests;

import android.util.Log;
import android.view.View;

import java.lang.ref.WeakReference;

public class QuestsPresenter implements QuestsContract.Presenter {

    public static String TAG = QuestsPresenter.class.getSimpleName();

    private WeakReference<QuestsContract.View> view;
    private QuestsState state;
    private QuestsContract.Model model;
    private QuestsContract.Router router;

    public QuestsPresenter(QuestsState state) {
        this.state = state;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // initialize the state if is necessary
        if (state == null) {
            state = new QuestsState();
        }

        // use passed state if is necessary
        QuestsState savedState = router.getDataFromPreviousScreen();
        if (savedState != null) {

            // update view and model state
            state.data = savedState.data;

            // update the view
            view.get().displayData(state);

            return;
        }

        // call the model
        String data = model.fetchData();

        // set view state
        state.data = data;

        // update the view
        view.get().displayData(state);

    }

    @Override
    public void onMathButtonClicked() {
        router.passDataToNextScreen(state);
        router.navigateToNextScreen();

    }

    @Override
    public void injectView(WeakReference<QuestsContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(QuestsContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(QuestsContract.Router router) {
        this.router = router;
    }
}
