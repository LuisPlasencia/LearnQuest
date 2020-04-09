package es.ulpgc.eite.da.learnquest.login;

import android.util.Log;
import android.widget.EditText;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.da.learnquest.R;

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
    public void onLetsGoClicked(String username, String password) {
        state.username = username;
        state.password = password;
        Log.d("LoginPresenter", state.password);
        router.passStateToProfileScreen(state);
        router.navigateToProfileScreen();
    }

    @Override
    public void onResume() {
        state.username = "";
        state.password = "";
        view.get().displayCurrentData(state);
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
