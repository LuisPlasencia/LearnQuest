package es.ulpgc.eite.da.learnquest.hint;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.da.learnquest.app.HintToQuestionState;
import es.ulpgc.eite.da.learnquest.app.QuestionToHintState;

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
    public void onResume() {
        Log.e(TAG, "fetchData()");

        // initialize the state if is necessary
        if (state == null) {
            state = new HintState();
        }

        // use passed state if is necessary
        QuestionToHintState savedState = router.getDataFromQuestionScreen();
        if (savedState != null) {
            model.setQuizIndex(savedState.quizIndex);

            if(state.hintDisplayed) {
                state.answer = model.fetchQuestionHint();
            }
        }

        view.get().displayData(state);
        if(state.answer == null) {
            view.get().resetAnswer();
        }
    }


    @Override
    public void onStart() {
        state.yesNoButtonEnabled = true;
        state.hintDisplayed = false;
        state.answer = null;

        view.get().resetAnswer();
    }

    @Override
    public void onYesButtonClicked() {
        state.answer = model.fetchQuestionHint();
        state.yesNoButtonEnabled = false;
        view.get().displayData(state);
    }

    @Override
    public void onNoButtonClicked() {
        onBackPressed();
    }

    @Override
    public void onReturnToQuestionButton() {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        HintToQuestionState stateToQuestion = new HintToQuestionState();
        stateToQuestion.hintDisplayed = state.hintDisplayed;
        router.passDataToQuestiontScreen(stateToQuestion);
        view.get().onFinish();
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
