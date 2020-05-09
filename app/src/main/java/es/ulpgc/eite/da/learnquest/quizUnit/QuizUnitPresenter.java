package es.ulpgc.eite.da.learnquest.quizUnit;

import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.eite.da.learnquest.R;
import es.ulpgc.eite.da.learnquest.app.QuestToQuizUnitState;
import es.ulpgc.eite.da.learnquest.app.QuizUnitToQuestionState;
import es.ulpgc.eite.da.learnquest.data.QuestItem;
import es.ulpgc.eite.da.learnquest.data.QuizUnit;
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
        QuestItem quest = router.getDataFromQuestListScreen();

        if (quest != null) {
            state.quest = quest;
        }

        // call the model
        model.fetchQuizUnitListData(state.quest,
                new RepositoryContract.GetQuizUnitListCallback() {

                    @Override
                    public void setQuizUnitList(List<QuizUnitItem> quizUnits) {
                        state.quizUnitItems = quizUnits;

                        view.get().displayData(state);
                    }
                });


     //  state.quizUnitItems = model.fetchQuizUnitData();
       //view.get().displayData(state);
    }

    @Override
    public void onOptionClicked(QuizUnitItem option) {
        //router.navigateToNextScreen();
        state.quizId = option.getId();
        model.setQuizId(state.quizId);
        QuizUnitToQuestionState newState = new QuizUnitToQuestionState(state.quizId);
        router.passDataToQuestionScreen(newState);
        view.get().navigateToNextScreen();
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


//    @Override
//    public void onOptionClicked(int option) {
//        state.quizId = option;
//        model.setQuizId(state.quizId);
//        QuizUnitToQuestionState newState = new QuizUnitToQuestionState(state.quizId);
//        router.passDataToQuestionScreen(newState);
//        //router.navigateToNextScreen();
//        view.get().navigateToNextScreen();
//    }
    @Override
    public String getSubject() {
      int subjectId  =  model.getSubjectId();
      if(subjectId == 1){
          return "Maths";
      } else if(subjectId == 2){
          return "English";
      } else {
          return "Geography";
      }
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
