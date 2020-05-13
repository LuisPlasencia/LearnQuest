package es.ulpgc.eite.da.learnquest.questionGeography;

import java.lang.ref.WeakReference;

public interface QuestionGeographyContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void onDataUpdated(QuestionGeographyViewModel viewModel);

        void navigateToNextScreen();
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void onResume();

        void onStart();

        void onRestart();

        void onBackPressed();

        void onPause();

        void onDestroy();
    }

    interface Model {
        String getStoredData();

        void onDataFromNextScreen(String data);

        void onRestartScreen(String data);

        void onDataFromPreviousScreen(String data);
    }

    interface Router {

//        NextToQuestionGeographyState getStateFromNextScreen();
//
//        void passStateToNextScreen(QuestionGeographyToNextState state);
//
//        void passStateToPreviousScreen(QuestionGeographyToPreviousState state);
//
//        PreviousToQuestionGeographyState getStateFromPreviousScreen();
    }
}
