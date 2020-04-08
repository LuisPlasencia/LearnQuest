package es.ulpgc.eite.da.learnquest.login;

import android.util.Log;

import java.lang.ref.WeakReference;

public class LoginPresenter implements LoginContract.Presenter {

    public static String TAG = LoginPresenter.class.getSimpleName();

    private WeakReference<LoginContract.View> view;
    private LoginState state;
    private LoginContract.Model model;
    private LoginContract.Router router;

    public LoginPresenter(LoginState state) {
        this.state = state;
    }

    @Override
    public void onStart() {
        // Log.e(TAG, "onStart()");

        // initialize the state if is necessary
        if (state == null) {
            state = new LoginState();
        }
    }

    @Override
    public void onRestart() {
        // Log.e(TAG, "onRestart()");
    }

    @Override
    public void onResume() {
        // Log.e(TAG, "onResume()");

        // update the view
        view.get().onDataUpdated(state);
    }


    @Override
    public void onLetsGoClicked() {
        //TODO pasarle el estado de la informacion de perfil y contraseña a Profile y lo que conlleva
        router.passStateToProfileScreen(state);
        router.navigateToProfileScreen();
    }

    @Override
    public void injectView(WeakReference<LoginContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(LoginContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(LoginContract.Router router) {
        this.router = router;
    }
}
