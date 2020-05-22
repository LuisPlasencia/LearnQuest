package es.ulpgc.eite.da.learnquest.questionMath;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.eite.da.learnquest.data.QuestItem;
import es.ulpgc.eite.da.learnquest.data.QuestionMathItem;
import es.ulpgc.eite.da.learnquest.data.QuizUnitItem;
import es.ulpgc.eite.da.learnquest.data.RepositoryContract;

public class QuestionMathPresenter implements QuestionMathContract.Presenter {

    public static String TAG = QuestionMathPresenter.class.getSimpleName();

    private WeakReference<QuestionMathContract.View> view;
    private QuestionMathState state;
    private QuestionMathContract.Model model;
    private QuestionMathContract.Router router;

    public QuestionMathPresenter(QuestionMathState state) {
        this.state = state;
    }

    @Override
    public void fetchQuestionMathData() {

        // Log.e(TAG, "fetchCategoryListData()");

        // call the model
        QuizUnitItem quizUnitItem = router.getDataFromQuizUnitScreen();

        if (quizUnitItem != null) {
            state.quizUnitItem = quizUnitItem;
        }

        // call the model
        state.questionMathItems = model.getMathsListData();
        view.get().displayData(state);

    }

    @Override
    public void fetchData() {
        if (state == null) {
            state = new QuestionMathState();
        }
        view.get().displayData(state);

    }

    @Override
    public void onStart() {
        state.mathQuestionNumber = model.getCurrentQuestionNumber();
        disableNextButton();
        view.get().displayData(state);

    }

    @Override
    public void onRestart() {
        model.setQuizIndex(state.quizIndex);
    }

    @Override
    public void onResume() {
        view.get().displayData(state);
    }

    private void disableNextButton() {
        state.mathNumbersEnabled = true;
        state.mathHintEnabled = true;
        state.mathCleanEnabled = true;
        state.mathEnterEnabled = true;
        state.mathNextEnabled = false;
    }

    @Override
    public void onNextButtonClicked() {
        model.updateNextQuestion();
        model.setSolutionIndex(0);
        state.tries = 0;
        if (model.isQuizFinished()) {
            state.mathAnswerText = "";
            view.get().resetButtons();
            view.get().navigateToFinalQuizScreen();
            return;

        }
        state.mathAnswerText = "";
        state.mathUserAnswerText = "";
        view.get().resetButtons();
        onStart();

    }

    @Override
    public int getIndex() {
        return model.getQuizIndex();
    }

    @Override
    public void resetHintIndex() {
        model.setSolutionIndex(0);
    }

    @Override
    public void onEnterButtonClicked() {
        String solution = state.quizUnitItem.questionMathItems.get(getIndex()).mathSolution;
        String userSolution = view.get().getUserSolution();
        model.setSolutionIndex(0);
        state.tries++;
        if(state.tries == 2){
            state.mathHintEnabled=true;
            state.mathEnterEnabled = false;
            state.mathNextEnabled = true;
            state.mathNumbersEnabled = false;
            state.mathHintEnabled = false;
            state.mathCleanEnabled = false;

            InCorrectLabel();
            view.get().displayData(state);
            return;
        }

        if (solution.equals(userSolution)) {
            state.mathHintEnabled=true;
            state.mathEnterEnabled = false;
            state.mathNextEnabled = true;
            state.mathCleanEnabled = false;
            state.mathNumbersEnabled = false;
            state.mathHintEnabled = false;
            if(!state.questionNulled){
                model.updateExperienceCollected();
                state.questionNulled = false;
            }

            correctLabel();
        } else {
            state.mathEnterEnabled = true;
            state.mathNextEnabled = false;
            InCorrectLabel();
        }
        view.get().displayData(state);

    }

    public void correctLabel() {
        state.mathAnswerText = "Correct";
        view.get().displaySolutionCorrect();
    }

    public void InCorrectLabel() {
        state.mathAnswerText = "Incorrect";
        view.get().displaySolutionIncorrect();
    }
    @Override
    public void onNumberClicked(){
        view.get().displayData(state);
    }
    @Override
    public void onCleanClicked(){
       // state.mathUserAnswerText="";
        view.get().displayData(state);
    }

    @Override
    public char onHintButtonClicked() {
        String solution = state.quizUnitItem.questionMathItems.get(getIndex()).mathSolution;
        char chSolution = solution.charAt(model.getSolutionIndex());

            if (model.getSolutionIndex() == solution.length() - 1) {
                state.mathHintEnabled = false;
                view.get().displayData(state);
                model.setSolutionIndex(0);
                state.questionNulled = true;
                return chSolution;
            }

        model.updateSolutionIndex();
        return chSolution;

    }

    @Override
    public void cleanAnswer(){
        state.mathAnswerText="";
    }


    @Override
    public void onBackPressed() {
        // Log.e(TAG, "onBackPressed()");
        view.get().alertDialogReturn();

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
    public void injectView(WeakReference<QuestionMathContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(QuestionMathContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(QuestionMathContract.Router router) {
        this.router = router;
    }
}
