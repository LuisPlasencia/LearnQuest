package es.ulpgc.eite.da.learnquest.profile;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.da.learnquest.data.RepositoryContract;
import es.ulpgc.eite.da.learnquest.login.LoginState;

public class ProfilePresenter implements ProfileContract.Presenter {

    public static String TAG = "ProfilePresenter";

    private WeakReference<ProfileContract.View> view;
    private ProfileState state;
    private ProfileContract.Model model;
    private ProfileContract.Router router;

    public ProfilePresenter(ProfileState state) {
        this.state = state;
    }

    @Override
    public void onStart() {
        LoginState loginState = router.getLoginState();
        if (loginState != null){
//            state.user = model.getUser(loginState.username, loginState.password);
//            model.setUserActual(state.user);
//            state.username = model.getUsername();
        } else{
//            state.user = model.getUserActual();
//            state.username = model.getUsername();
        }
        state.user = model.getUserActual();
        state.username = model.getUsername();
        state.level = model.getLevel();
        state.sublevel = model.getSublevel();
        view.get().displayProfileData(state);
        Log.d("ProfilePresenter", state.user.getPhotoAdress());

    }

    @Override
    public void onResume() {
        // Log.e(TAG, "onResume()");
        state.level = model.getLevel();
        state.sublevel = model.getSublevel();
        model.updateQuestParameters();
        view.get().displayProfileData(state);

    }

    @Override
    public void onBackPressed() {
        // Log.e(TAG, "onBackPressed()");
        onLogOutButtonClicked();
    }


    @Override
    public void onGoQuestButtonClicked(){
        router.passStateToNextScreen(state);
        view.get().navigateToQuestsScreen();

    }

    @Override
    public void onLogOutButtonClicked() {
        Log.d("hola", "hola");
        view.get().alertDialogLogOut();
    }

    @Override
    public void logout(){
        LoginState loginState = router.getLoginState();
        if(loginState!= null){
            loginState.username = "";
            loginState.password = "";
        }

        model.logout();
        state.user = null;
        state.username = "";
        state.sublevel = 0;
        state.level = 0;

        view.get().navigateLoginScreen();
    }

    @Override
    public void onRemoveButtonClicked() {
        Log.d("hola", "hola");
        view.get().alertDialogRemove();
    }

    @Override
    public void removeUser() {
        model.removeUser(state.user, new RepositoryContract.RemoveUserCallback(){
            @Override
            public void onUserRemoved(){
                logout();
            }
        });
    }

    @Override
    public void onStatisticsButtonClicked() {
        router.passStateToNextScreen(state);
        view.get().navigateStatisticsScreen();

    }

    @Override
    public String getPhoto() {
        return model.getPhoto();
    }


    @Override
    public void injectView(WeakReference<ProfileContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(ProfileContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(ProfileContract.Router router) {
        this.router = router;
    }
}
