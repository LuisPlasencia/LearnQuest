package es.ulpgc.eite.da.learnquest.questionGeography;

import android.util.Log;
import android.widget.Toast;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.eite.da.learnquest.data.QuestionGeographyItem;
import es.ulpgc.eite.da.learnquest.data.QuestionMathItem;
import es.ulpgc.eite.da.learnquest.data.QuizUnitItem;
import es.ulpgc.eite.da.learnquest.data.RepositoryContract;
import es.ulpgc.eite.da.learnquest.question.QuestionState;
import es.ulpgc.eite.da.learnquest.questionMath.QuestionMathState;

public class QuestionGeographyPresenter implements QuestionGeographyContract.Presenter {

    public static String TAG = QuestionGeographyPresenter.class.getSimpleName();

    private WeakReference<QuestionGeographyContract.View> view;
    private QuestionGeographyState state;
    private QuestionGeographyContract.Model model;
    private QuestionGeographyContract.Router router;

    public QuestionGeographyPresenter(QuestionGeographyState state) {
        this.state = state;
    }


    @Override
    public void fetchQuestionGeoData() {

        // call the model
        QuizUnitItem quizUnitItem = router.getDataFromQuizUnitScreen();

        if (quizUnitItem != null) {
            state.quizUnitItem = quizUnitItem;
        }

        // call the model
        model.fetchQuestionGeoListData(state.quizUnitItem,
                new RepositoryContract.GetQuestionGeoListCallback() {
                    @Override
                    public void setQuestionGeoList(List<QuestionGeographyItem> questionGeoItems) {
                        state.questionGeographyItems = questionGeoItems;
                        view.get().displayData(state);
                    }
                });
    }

    @Override
    public void onStart() {
    state.geoQuestionNumber = model.getCurrentQuestionNumber();
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
        state.geoButtonsEnabled = true;
        state.geoHintEnabled = true;
        state.geoEnterEnabled = true;
        state.geoEnterEnabled = false;
    }

    @Override
    public void onNextButtonClicked(){
        model.updateNextQuestion();
        state.geoAnswerText="";
        state.geoUserAnswerText="";
        onStart();
    }

    @Override
    public void onBackPressed() {
        // Log.e(TAG, "onBackPressed()");
        model.resetExperience();
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
    public int getIndex() {
        return model.getQuizIndex();

    }

    @Override
    public void onEnterButtonClicked(){
        String solution = state.quizUnitItem.questionGeographyItems.get(getIndex()).geoSolution;
        String userSolution = view.get().getUserSolution();
        if(solution.equals(userSolution)){
            state.geoNextEnabled = true;
            state.geoButtonsEnabled = false;
            state.geoHintEnabled = false;
            correctLabel();

        } else {
            state.geoNextEnabled = false;
            InCorrectLabel();
        }
        view.get().displayData(state);
    }

    public void correctLabel() {
        state.geoAnswerText = "Correct";
        view.get().displaySolutionCorrect();
    }

    public void InCorrectLabel() {
        state.geoAnswerText = "Incorrect";
        view.get().displaySolutionIncorrect();
    }

    @Override
    public void injectView(WeakReference<QuestionGeographyContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(QuestionGeographyContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(QuestionGeographyContract.Router router) {
        this.router = router;
    }
}
