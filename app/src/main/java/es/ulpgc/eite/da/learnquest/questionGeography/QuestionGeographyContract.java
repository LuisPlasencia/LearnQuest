package es.ulpgc.eite.da.learnquest.questionGeography;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.da.learnquest.data.QuizUnitItem;
import es.ulpgc.eite.da.learnquest.data.RepositoryContract;

public interface QuestionGeographyContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(QuestionGeographyViewModel viewModel);

        void onDataUpdated(QuestionGeographyViewModel viewModel);

        void navigateToNextScreen();
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void onResume();

        void fetchQuestionGeoData();

        void onStart();

        void onRestart();

        void onBackPressed();

        void onPause();

        void onDestroy();
    }

    interface Model {
        String getStoredData();

        void onDataFromNextScreen(String data);

        void fetchQuestionGeoListData(
                QuizUnitItem quizUnit, RepositoryContract.GetQuestionGeoListCallback callback);

        void onRestartScreen(String data);

        void onDataFromPreviousScreen(String data);
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
