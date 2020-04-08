package es.ulpgc.eite.da.learnquest.login;

import java.lang.ref.WeakReference;

public interface LoginContract {

    interface View {
        void injectPresenter(Presenter presenter);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void onStart();

        void onLetsGoClicked(String username, String password);
    }

    interface Model {
    }

    interface Router {
        void navigateToProfileScreen();

        void passStateToProfileScreen(LoginState state);

    }
}
