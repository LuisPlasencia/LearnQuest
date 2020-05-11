package es.ulpgc.eite.da.learnquest.profile;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.da.learnquest.data.RepositoryContract;
import es.ulpgc.eite.da.learnquest.data.User;
import es.ulpgc.eite.da.learnquest.login.LoginState;

public interface ProfileContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void finishView();

        void displayProfileData(ProfileViewModel viewModel);

        void navigateToQuestsScreen();

        void navigateStatisticsScreen();

        void navigateLoginScreen();

        void alertDialogLogOut();

        void alertDialogRemove();
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void onResume();

        void onStart();

        void onBackPressed();

        void onGoQuestButtonClicked();

        void onLogOutButtonClicked();

        void onStatisticsButtonClicked();

        String getPhoto();

        void logout();

        void onRemoveButtonClicked();

        void removeUser();
    }

    interface Model {

        User getUser(String username, String password);

        Integer getLevel();

        Integer getSublevel();

        String getPhoto();

        String getUsername();

        void setUsername(String username);


        void setUserActual(User user);

        void logout();

        User getUserActual();

        void updateQuestParameters();

        void removeUser(User user, RepositoryContract.RemoveUserCallback callback);

    }

    interface Router {

        void passStateToNextScreen(ProfileState state);

        LoginState getLoginState();

//        void navigateToQuestsScreen();

//        void navigateAchievementsScreen();

//        void navigateLoginScreen();
    }
}
