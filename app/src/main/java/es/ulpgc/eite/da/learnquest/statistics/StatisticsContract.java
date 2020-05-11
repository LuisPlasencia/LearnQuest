package es.ulpgc.eite.da.learnquest.statistics;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.da.learnquest.data.RepositoryContract;
import es.ulpgc.eite.da.learnquest.data.User;

public interface StatisticsContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void onDataUpdated(StatisticsViewModel viewModel);

        void navigateToNextScreen();

        void displayData(StatisticsViewModel viewModel);

    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void onResume();

//        void onStart();

//        void onRestart();

        void onBackPressed();

        void onPause();

        void onDestroy();

        void fetchUserData();
    }

    interface Model {
        void onDataFromNextScreen(String data);

        void onRestartScreen(String data);

        void onDataFromPreviousScreen(String data);

        void getDatabaseUsers(RepositoryContract.GetUserListCallback callback);
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
