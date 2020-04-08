package es.ulpgc.eite.da.learnquest.profile;

import java.lang.ref.WeakReference;

public interface ProfileContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void onDataUpdated(ProfileViewModel viewModel);
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
        void navigateToNextScreen();

        void passStateToNextScreen(ProfileState state);

        ProfileState getStateFromPreviousScreen();

 //       PerfilState getStateFromNextScreen();

   //     void passStateToPreviousScreen(PerfilState state);
    }
}
