package es.ulpgc.eite.da.learnquest.question;

import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.eite.da.learnquest.app.HintToQuestionState;
import es.ulpgc.eite.da.learnquest.app.QuestionToHintState;
import es.ulpgc.eite.da.learnquest.data.QuestionEnglishItem;
import es.ulpgc.eite.da.learnquest.data.QuizUnitItem;
import es.ulpgc.eite.da.learnquest.data.RepositoryContract;

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
        state.numberOfQuestions = state.questionEnglishItems.size();
        state.hint = state.questionEnglishItems.get(state.questionNumber).getHint();
        state.questionText = state.questionEnglishItems.get(state.questionNumber).getQuestion();  //model.getCurrentQuestion();
        state.option1 = state.questionEnglishItems.get(state.questionNumber).getOption1();  //model.getOption1();
        state.option2 = state.questionEnglishItems.get(state.questionNumber).getOption2();  //model.getOption2();
        state.option3 = state.questionEnglishItems.get(state.questionNumber).getOption3(); //model.getOption3();
        state.correctOption =  state.questionEnglishItems.get(state.questionNumber).correctOption;
        model.setCorrectOption(state.correctOption);

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
            if(state.hintEnabled){
                model.updateExperienceCollected();
                view.get().setOptionColorCorrect(option);
            } else if(!state.hintEnabled){
                model.updateHalfExperienceCollected();
                view.get().setOptionColorCorrect(option);
            }

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
        state.hint = this.state.hint;
        router.passDataToHintScreen(state);
        //router.navigateToHintScreen();
        view.get().navigateToHintScreen();
    }

    @Override
    public void onTimerFinish() {
        enableNextButton();
        disableOptionsButtons();
        int correctOption = state.correctOption;
        view.get().setOptionColorCorrect(correctOption);
        view.get().updateReplyTimeFinished();
        view.get().displayData(state);
    }

    @Override
    public void fetchQuestionEnglishData() {
        // call the model
        state.quizIndex = model.getQuizId();

        // call the model
        state.questionEnglishItems = model.getEnglishListData();
        Log.d("hola",  state.questionEnglishItems.get(0).getOption1());

    }

    @Override
    public void onNextButtonClicked() {
        model.updateNextQuestion();
        if(state.numberOfQuestions-1 == state.questionNumber) {
           // router.navigateToFinalQuizScreen();
            view.get().navigateToFinalQuizScreen();
            return;
        }
        state.questionNumber++;
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
        model.resetExperience();
        view.get().alertDialogReturn();
    }
}
