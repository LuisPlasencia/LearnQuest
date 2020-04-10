package es.ulpgc.eite.da.learnquest.profile;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.da.learnquest.data.User;
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
        state.user = model.getUser(loginState.username, loginState.password);
        if(model.getUsername(state.user).equals("Username") && !loginState.username.equals("")){
            state.username = loginState.username;
            model.setUsername(state.user, state.username);
        } else{
            state.username = model.getUsername(state.user);
        }
        state.level = model.getLevel(state.user);
        state.sublevel = model.getSublevel(state.user);
        view.get().displayProfileData(state);

    }

    @Override
    public void onResume() {
        // Log.e(TAG, "onResume()");
        state.level = model.getLevel(state.user);
        state.sublevel = model.getSublevel(state.user);
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
        state.user = null;
        state.username = "";
        state.sublevel = 0;
        state.level = 0;
        view.get().finishView();
    }

    @Override
    public void onAchievementsButtonClicked() {
        router.passStateToNextScreen(state);
        router.navigateAchievementsScreen();

    }

    @Override
    public Integer getPhoto() {
        if(state.user != null){
            return model.getPhoto(state.user);
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
