package es.ulpgc.eite.da.learnquest.quizUnit;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.da.learnquest.R;
import es.ulpgc.eite.da.learnquest.app.QuestToQuizUnitState;
import es.ulpgc.eite.da.learnquest.app.QuizUnitToQuestionState;
import es.ulpgc.eite.da.learnquest.data.QuizUnitItem;
import es.ulpgc.eite.da.learnquest.data.RepositoryContract;

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
    public void fetchQuizUnitData() {
        // Log.e(TAG, "fetchCategoryListData()");

        // call the model
       state.quizUnitItems = model.fetchQuizUnitData();
        view.get().displayData(state);
    }



    @Override
    public void selectQuizUnitData(int item) {
        router.navigateToNextScreen();
    }

    @Override
    public void onStart() {
        if (state == null) {
            state = new QuizUnitState();
        }
    }


    @Override
    public void setSubject() {
        QuestToQuizUnitState savedState = router.getStateFromQuestScreen();
        if(savedState != null){
            String subject = savedState.subject;
            model.setSubject(subject);
        }else{
            String subject = "Maths";
            model.setSubject(subject);
        }
    }


    @Override
    public void onOptionClicked(int option) {
        state.quizId = option;
        model.setQuizId(state.quizId);
        QuizUnitToQuestionState newState = new QuizUnitToQuestionState(state.quizId);
        router.passDataToQuestionScreen(newState);
        router.navigateToNextScreen();
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
