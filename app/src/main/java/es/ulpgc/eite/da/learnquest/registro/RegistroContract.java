package es.ulpgc.eite.da.learnquest.registro;

import android.view.View;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.da.learnquest.data.RepositoryContract;

public interface RegistroContract {

    interface View {
        void injectPresenter(Presenter presenter);
        
        String getPasswordInput();
        
        String getEmailInput();
        
        String getUsernameInput();

        void displayWarning(int tipo);

        void onFinish();

        void displayPictureSelected(String selectedItem);

    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void onSignUpButtonClicked();

        void onBackPressed();

        void onSelectionClicked(String selectedItem);

    }

    interface Model {
        void addUser(String username, String password, String email, String usernameImage, RepositoryContract.AddUserCallback callback);

        boolean isFilledTextEmpty(String username, String password, String email);

        boolean existingUsername(String username);
    }

    interface Router {
        //void navigateToLogInScreen();
    }
}
