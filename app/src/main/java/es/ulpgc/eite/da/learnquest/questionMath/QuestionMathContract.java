package es.ulpgc.eite.da.learnquest.questionMath;

import android.view.View;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.da.learnquest.data.QuizUnitItem;
import es.ulpgc.eite.da.learnquest.data.RepositoryContract;

public interface QuestionMathContract {

    interface View {
        void navigateToFinalQuizScreen();

        void injectPresenter(Presenter presenter);

        void resetReply();

        void displayData(QuestionMathViewModel viewModel);

        String getSolution(QuestionMathViewModel viewModel);

        String getUserSolution();

        void displaySolutionCorrect();

        void displaySolutionIncorrect();

        void navigateToNextScreen();

        void navigateToQuizUnitScreen();
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

        void onEnterButtonClicked();

        String onHintButtonClicked();

        void onBackPressed();

        void onPause();

        void onDestroy();

    }

    interface Model {

        void fetchQuestionMathListData(
               QuizUnitItem quizUnit, RepositoryContract.GetQuestionMathListCallback callback);

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

    }

    interface Router {
        QuizUnitItem getDataFromQuizUnitScreen();

        //NextToQuestionMathState getStateFromNextScreen();

        //void passStateToNextScreen(QuestionMathToNextState state);

       //void passStateToPreviousScreen(QuestionMathToPreviousState state);

        //PreviousToQuestionMathState getStateFromPreviousScreen();
    }
}
