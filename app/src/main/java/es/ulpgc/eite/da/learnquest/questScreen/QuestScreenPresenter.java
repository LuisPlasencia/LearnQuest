package es.ulpgc.eite.da.learnquest.questScreen;

import android.util.Log;

import java.lang.ref.WeakReference;

public class QuestScreenPresenter implements QuestScreenContract.Presenter {

    public static String TAG = QuestScreenPresenter.class.getSimpleName();

    private WeakReference<QuestScreenContract.View> view;
    private QuestScreenState state;
    private QuestScreenContract.Model model;
    private QuestScreenContract.Router router;

    public QuestScreenPresenter(QuestScreenState state) {
        this.state = state;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // initialize the state if is necessary
        if (state == null) {
            state = new QuestScreenState();
        }

        // use passed state if is necessary
        QuestScreenState savedState = router.getDataFromPreviousScreen();
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
    public void injectView(WeakReference<QuestScreenContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(QuestScreenContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(QuestScreenContract.Router router) {
        this.router = router;
    }
}
