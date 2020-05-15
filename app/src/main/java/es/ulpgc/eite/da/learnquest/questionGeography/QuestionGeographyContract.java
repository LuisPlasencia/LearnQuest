package es.ulpgc.eite.da.learnquest.questionGeography;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.da.learnquest.data.QuizUnitItem;
import es.ulpgc.eite.da.learnquest.data.RepositoryContract;

public interface QuestionGeographyContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(QuestionGeographyViewModel viewModel);

        String getUserSolution();

        void resetUserAnswer();

        String getSolution(QuestionGeographyViewModel viewModel);

        void displaySolutionCorrect();

        void displaySolutionIncorrect();

        void onDataUpdated(QuestionGeographyViewModel viewModel);

        void navigateToNextScreen();

        void alertDialogReturn();

        void navigateToQuizUnitScreen();

        void navigateToFinalQuizScreen();
    }

    interface Presenter {
        int getIndex();

        void onEnterButtonClicked();

        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void onResume();

        void fetchQuestionGeoData();

        void onStart();

        void onRestart();

        void onNextButtonClicked();

        void onBackPressed();

        void onPause();

        void onDestroy();
    }

    interface Model {
        String getStoredData();

        void onDataFromNextScreen(String data);

        void fetchQuestionGeoListData(
                QuizUnitItem quizUnit, RepositoryContract.GetQuestionGeoListCallback callback);

        void updateNextQuestion();

        int getQuizIndex();

        void setQuizIndex(int index);

        boolean isQuizFinished();

        String getCurrentQuestionNumber();

        void updateExperienceCollected();

        void onRestartScreen(String data);

        void onDataFromPreviousScreen(String data);

        void resetExperience();
    }

    interface Router {
        QuizUnitItem getDataFromQuizUnitScreen();

//        NextToQuestionGeographyState getStateFromNextScreen();
//
//        void passStateToNextScreen(QuestionGeographyToNextState state);
//
//        void passStateToPreviousScreen(QuestionGeographyToPreviousState state);
//
//        PreviousToQuestionGeographyState getStateFromPreviousScreen();
    }
}
