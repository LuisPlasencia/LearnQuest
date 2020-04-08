package es.ulpgc.eite.da.learnquest.login;

import java.lang.ref.WeakReference;

public interface LoginContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void onDataUpdated(LoginViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void onResume();

        void onStart();

        void onRestart();

        void onLetsGoClicked();
    }

    interface Model {
    }

    interface Router {
        void navigateToProfileScreen();

        void passStateToProfileScreen(LoginState state);

    }
}
