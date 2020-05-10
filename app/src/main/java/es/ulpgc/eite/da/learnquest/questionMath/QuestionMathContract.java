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

        void updateReply(boolean isCorrect);

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

        void onBackPressed();

        void onPause();

        void onDestroy();

    }

    interface Model {

        void fetchQuestionMathListData(
               QuizUnitItem quizUnit, RepositoryContract.GetQuestionMathListCallback callback);

        void updateNextQuestion();

        int getQuizIndex();

        boolean isQuizFinished();

        void setQuizIndex(int index);

        boolean isCorrectOption(int option);

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
