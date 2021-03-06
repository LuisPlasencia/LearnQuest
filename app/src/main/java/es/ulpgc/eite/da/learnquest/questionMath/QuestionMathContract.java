package es.ulpgc.eite.da.learnquest.questionMath;

import android.view.View;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.eite.da.learnquest.data.QuestionMathItem;
import es.ulpgc.eite.da.learnquest.data.QuizUnitItem;
import es.ulpgc.eite.da.learnquest.data.RepositoryContract;

public interface QuestionMathContract {

    interface View {
        void navigateToFinalQuizScreen();

        void injectPresenter(Presenter presenter);

        void resetReply();

        void resetAnswer();

        void displayData(QuestionMathViewModel viewModel);

        String getSolution(QuestionMathViewModel viewModel);

        String getUserSolution();

        void displaySolutionCorrect();

        void displaySolutionIncorrect();

        void navigateToNextScreen();

        void navigateToQuizUnitScreen();

        void alertDialogReturn();

        void resetButtons();
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void onResume();

        void fetchQuestionMathData();

        void fetchData();

        void onStart();

        void onRestart();

        void onNextButtonClicked();

        int getIndex();

        void resetHintIndex();

        void onEnterButtonClicked();

        void onNumberClicked();

        void onCleanClicked();

        char onHintButtonClicked();

        void cleanAnswer();

        void onBackPressed();

        void onPause();

        void onDestroy();

    }

    interface Model {

        void updateNextQuestion();

        void updateSolutionIndex();

        int getQuizIndex();

        int getSolutionIndex();

        boolean isQuizFinished();

        void setQuizIndex(int index);

        void setSolutionIndex(int index);

        boolean isCorrectOption(int option);

        String getCurrentQuestionNumber();

        void updateExperienceCollected();

        boolean getAnswer();

        String getStoredData();

        void onDataFromNextScreen(String data);

        void onRestartScreen(String data);

        void onDataFromPreviousScreen(String data);

        void resetExperience();

        List<QuestionMathItem> getMathsListData();

    }

    interface Router {
        QuizUnitItem getDataFromQuizUnitScreen();

        //NextToQuestionMathState getStateFromNextScreen();

        //void passStateToNextScreen(QuestionMathToNextState state);

       //void passStateToPreviousScreen(QuestionMathToPreviousState state);

        //PreviousToQuestionMathState getStateFromPreviousScreen();
    }
}
