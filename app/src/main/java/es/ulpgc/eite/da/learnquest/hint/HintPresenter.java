package es.ulpgc.eite.da.learnquest.hint;

import android.util.Log;

import java.lang.ref.WeakReference;

public class HintPresenter implements HintContract.Presenter {

    public static String TAG = HintPresenter.class.getSimpleName();

    private WeakReference<HintContract.View> view;
    private HintState state;
    private HintContract.Model model;
    private HintContract.Router router;

    public HintPresenter(HintState state) {
        this.state = state;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // initialize the state if is necessary
        if (state == null) {
            state = new HintState();
        }

        // use passed state if is necessary
        HintState savedState = router.getDataFromPreviousScreen();
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
    public void injectView(WeakReference<HintContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(HintContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(HintContract.Router router) {
        this.router = router;
    }
}
