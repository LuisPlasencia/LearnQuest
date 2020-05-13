package es.ulpgc.eite.da.learnquest.question;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.da.learnquest.app.HintToQuestionState;
import es.ulpgc.eite.da.learnquest.app.QuestionToHintState;

public class QuestionPresenter implements QuestionContract.Presenter {

    public static String TAG = QuestionPresenter.class.getSimpleName();

    private WeakReference<QuestionContract.View> view;
    private QuestionState state;
    private QuestionContract.Model model;
    private QuestionContract.Router router;

    public QuestionPresenter(QuestionState state) {
        this.state = state;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // initialize the state if is necessary
        if (state == null) {
            state = new QuestionState();
        }

        // call the model
        //String data = model.fetchData();

        // set view state
        //state.data = data;

        // update the view
        view.get().displayData(state);
    }

    @Override
    public void onStart() {
        state.questionNumber = model.getCurrentQuestionNumber();
        state.questionText = model.getCurrentQuestion();
        state.option1 = model.getOption1();
        state.option2 = model.getOption2();
        state.option3 = model.getOption3();

        view.get().resetReply();

        state.optionClicked = false;
        state.optionEnabled = true;
        state.nextEnabled = false;

        disableNextButton();
        view.get().initTimer();
        view.get().displayData(state);
        view.get().resetOptionColor();
    }

    @Override
    public void onRestart() {
        model.setQuizIndex(state.quizIndex);
        Log.e(TAG, "index: "+ state.quizIndex);

        // update the view
        if(state.optionClicked){
            view.get().updateReply(model.isCorrectOption(state.option));
            //onOptionButtonClicked(state.option);
        } else {
            view.get().resetReply();
        }
    }

    @Override
    public void onResume() {
        HintToQuestionState stateFromHint = router.getDataFromHintScreen();
        if(stateFromHint != null) {
            if(stateFromHint.hintDisplayed) {
                state.hintEnabled = false;
            } else {
                state.hintEnabled = true;
            }
        }
        view.get().displayData(state);
    }

    @Override
    public void onOptionButtonClicked(int option) {
        Log.e(TAG, "onOptionButtonClicked()");

        state.optionClicked=true;
        state.optionEnabled=false;
        state.option=option;

        enableNextButton();

        boolean isCorrect = model.isCorrectOption(option);

        if(isCorrect) {
            model.updateExperienceCollected();
            view.get().setOptionColorCorrect(option);
        } else {
            view.get().setOptionColorIncorrect(option);
        }

        view.get().stopTimer();
        view.get().updateReply(isCorrect);
        view.get().displayData(state);
    }

    @Override
    public void onHintButtonClicked() {
        QuestionToHintState state = new QuestionToHintState();
        state.quizIndex = model.getQuizIndex();
        router.passDataToHintScreen(state);
        //router.navigateToHintScreen();
        view.get().navigateToHintScreen();
    }

    @Override
    public void onTimerFinish() {
        enableNextButton();
        disableOptionsButtons();
        int correctOption = model.getCorrectOption();
        view.get().setOptionColorCorrect(correctOption);
        view.get().updateReplyTimeFinished();
        view.get().displayData(state);
    }

    @Override
    public void onNextButtonClicked() {
        model.updateNextQuestion();
        Log.d(TAG, "Quiz index: " + model.getQuizIndex());
        Log.d(TAG, "Quiz index: " + model.isQuizFinished());
        if(model.isQuizFinished()) {
           // router.navigateToFinalQuizScreen();
            view.get().navigateToFinalQuizScreen();
            return;
        }
        state.quizIndex = model.getQuizIndex();
        onStart();
    }

    private void disableNextButton() {
        state.optionEnabled=true;
        state.hintEnabled=true;
        state.nextEnabled=false;

    }

    private void enableNextButton() {
        state.nextEnabled = true;
        state.hintEnabled = false;
    }

    private void disableOptionsButtons() {
        state.optionClicked=true;
        state.optionEnabled=false;
    }

    @Override
    public void injectView(WeakReference<QuestionContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(QuestionContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(QuestionContract.Router router) {
        this.router = router;
    }

    @Override
    public void onBackPressed() {
        view.get().navigateToQuizUnitScreen();
    }
}
