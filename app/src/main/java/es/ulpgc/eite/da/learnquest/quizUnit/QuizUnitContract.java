package es.ulpgc.eite.da.learnquest.quizUnit;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.eite.da.learnquest.app.QuestToQuizUnitState;
import es.ulpgc.eite.da.learnquest.app.QuizUnitToQuestionState;
import es.ulpgc.eite.da.learnquest.data.QuestItem;
import es.ulpgc.eite.da.learnquest.data.QuestionMathItem;
import es.ulpgc.eite.da.learnquest.data.QuizUnitItem;
import es.ulpgc.eite.da.learnquest.data.RepositoryContract;

public interface QuizUnitContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(QuizUnitViewModel viewModel);

        void navigateToNextScreen();

    }

    interface Presenter {
        //    @Override
        //    public void onOptionClicked(int option) {
        //        state.quizId = option;
        //        model.setQuizId(state.quizId);
        //        QuizUnitToQuestionState newState = new QuizUnitToQuestionState(state.quizId);
        //        router.passDataToQuestionScreen(newState);
        //        //router.navigateToNextScreen();
        //        view.get().navigateToNextScreen();
        //    }
        String getSubject();

        void injectView(WeakReference<View> view);
        void injectModel(Model model);
        void injectRouter(Router router);
       // void fetchData();
        void setSubject();
        //String getT1Items();
        void onStart();
        void onOptionClicked(QuizUnitItem option);

        void fetchQuizUnitData();

        //void selectQuizUnitData(QuizUnitItem item);
    }

    interface Model {
        //String fetchData();

        void fetchQuizUnitListData(
                QuestItem quest, RepositoryContract.GetQuizUnitListCallback callback);

        int getSubjectId();

        void setSubject(String subject);
        void setQuizId(int quizId);
        List<QuizUnitItem> fetchQuizUnitData();


        void fetchQuizUnitResultList(
                QuestItem quest, RepositoryContract.GetQuizUnitResultListCallback getQuizUnitResultListCallback);
    }
    interface Router {
      //  void navigateToNextScreen();

        void passDataToNextScreen(QuizUnitState state);

        //QuizUnitState getDataFromPreviousScreen();

        QuestToQuizUnitState getStateFromQuestScreen();

        void passDataToQuestionScreen(QuizUnitToQuestionState state);

        void passDataToQuestionMathScreen(QuizUnitItem item);

        QuestItem getDataFromQuestListScreen();


    }
}
