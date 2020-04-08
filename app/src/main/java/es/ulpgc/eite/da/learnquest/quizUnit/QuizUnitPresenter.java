package es.ulpgc.eite.da.learnquest.quizUnit;

import android.util.Log;

import java.lang.ref.WeakReference;

public class QuizUnitPresenter implements QuizUnitContract.Presenter {

    public static String TAG = QuizUnitPresenter.class.getSimpleName();

    private WeakReference<QuizUnitContract.View> view;
    private QuizUnitState state;
    private QuizUnitContract.Model model;
    private QuizUnitContract.Router router;

    public QuizUnitPresenter(QuizUnitState state) {
        this.state = state;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // initialize the state if is necessary
        if (state == null) {
            state = new QuizUnitState();
        }

        // use passed state if is necessary
        QuizUnitState savedState = router.getDataFromPreviousScreen();
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
    public void injectView(WeakReference<QuizUnitContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(QuizUnitContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(QuizUnitContract.Router router) {
        this.router = router;
    }
}
