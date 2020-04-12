package es.ulpgc.eite.da.learnquest.registro;

import android.util.Log;

import java.lang.ref.WeakReference;

public class RegistroPresenter implements RegistroContract.Presenter {

    public static String TAG = RegistroPresenter.class.getSimpleName();

    private WeakReference<RegistroContract.View> view;
    private RegistroState state;
    private RegistroContract.Model model;
    private RegistroContract.Router router;

    public RegistroPresenter(RegistroState state) {
        this.state = state;
    }

    @Override
    public void onSignUpButtonClicked() {
        String username = view.get().getUsernameInput();
        String password = view.get().getEmailInput();
        String email = view.get().getPasswordInput(); //El email se usará más adelante (siguiente sprint)
        if(!model.isFilledTextEmpty(username, password, email)) {
            model.signUpUser(username, password, email);
            onBackPressed();
        } else {
            Log.d(TAG, username + password + email);
            view.get().displayWarning();
        }
    }

    @Override
    public void onBackPressed() {
        view.get().onFinish();
    }

    @Override
    public void injectView(WeakReference<RegistroContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(RegistroContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(RegistroContract.Router router) {
        this.router = router;
    }
}
