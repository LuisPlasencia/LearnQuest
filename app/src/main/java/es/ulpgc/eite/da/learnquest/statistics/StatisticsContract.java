package es.ulpgc.eite.da.learnquest.statistics;

import java.lang.ref.WeakReference;

public interface StatisticsContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void onDataUpdated(StatisticsViewModel viewModel);

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
//        void navigateToNextScreen();

        void passStateToNextScreen(StatisticsState state);

        StatisticsState getStateFromPreviousScreen();

//        LogrosState getStateFromNextScreen();
//
//        void passStateToPreviousScreen(LogrosState state);
    }
}
