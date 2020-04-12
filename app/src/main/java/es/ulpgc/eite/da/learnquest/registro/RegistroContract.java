package es.ulpgc.eite.da.learnquest.registro;

import java.lang.ref.WeakReference;

public interface RegistroContract {

    interface View {
        void injectPresenter(Presenter presenter);
        
        String getPasswordInput();
        
        String getEmailInput();
        
        String getUsernameInput();

        void displayWarning();

        void onFinish();
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void onSignUpButtonClicked();

        void onBackPressed();
    }

    interface Model {
        void signUpUser(String username, String password, String email);

        boolean isFilledTextEmpty(String username, String password, String email);
    }

    interface Router {
        void navigateToLogInScreen();
    }
}
