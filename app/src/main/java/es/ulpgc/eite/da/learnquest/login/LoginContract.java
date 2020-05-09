package es.ulpgc.eite.da.learnquest.login;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.da.learnquest.data.RepositoryContract;
import es.ulpgc.eite.da.learnquest.data.User;

public interface LoginContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayCurrentData(LoginState state);

        void navigateToRegistroScreen();

        void navigateToProfileScreen();

        void displayWarning(int tipo);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void onStart();

        void onLetsGoClicked(String username, String password);

        void onResume();

        void onCreateAccountButton();

        void fetchUserListData();
    }

    interface Model {
        void fetchUserListData(RepositoryContract.GetUserListCallback callback);

        void setUsuarioActual(User user);
    }

    interface Router {
//        void navigateToProfileScreen();

        void passStateToProfileScreen(LoginState state);

//        void navigateToRegistroScreen();
    }
}
