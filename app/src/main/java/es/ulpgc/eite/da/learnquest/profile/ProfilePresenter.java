package es.ulpgc.eite.da.learnquest.profile;

import android.util.Log;

import java.lang.ref.WeakReference;

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
            state.user = model.getUser(loginState.username, loginState.password);
            model.setUserActual(state.user);
            state.username = model.getUsername();
            if(state.user.getId() == 0 && !loginState.username.equals("")){
                state.username = loginState.username;
                model.setUsername(state.username);
            }
        } else{
            state.user = model.getUserActual();
            state.username = model.getUsername();
        }
        state.level = model.getLevel();
        state.sublevel = model.getSublevel();
        view.get().displayProfileData(state);

    }

    @Override
    public void onResume() {
        // Log.e(TAG, "onResume()");
        state.level = model.getLevel();
        state.sublevel = model.getSublevel();
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
        router.navigateToQuestsScreen();

    }

    @Override
    public void onLogOutButtonClicked() {
        LoginState loginState = router.getLoginState();
        if(loginState!= null){
            loginState.username = "";
            loginState.password = "";
            if(state.user.getId()==0){
                model.resetDefaultUser();
            }
        }

        model.logout();
        state.user = null;
        state.username = "";
        state.sublevel = 0;
        state.level = 0;
        router.navigateLoginScreen();
    }

    @Override
    public void onAchievementsButtonClicked() {
        router.passStateToNextScreen(state);
        router.navigateAchievementsScreen();

    }

    @Override
    public Integer getPhoto() {
        if(state.user != null){
            return model.getPhoto();
        }
        return 0;

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
