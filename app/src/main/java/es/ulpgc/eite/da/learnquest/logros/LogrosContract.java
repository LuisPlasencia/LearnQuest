package es.ulpgc.eite.da.learnquest.logros;

import java.lang.ref.WeakReference;

public interface LogrosContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void onDataUpdated(LogrosViewModel viewModel);

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

        void passStateToNextScreen(LogrosState state);

        LogrosState getStateFromPreviousScreen();

//        LogrosState getStateFromNextScreen();
//
//        void passStateToPreviousScreen(LogrosState state);
    }
}
