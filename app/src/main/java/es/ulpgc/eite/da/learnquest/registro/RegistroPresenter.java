package es.ulpgc.eite.da.learnquest.registro;

import android.util.Log;
import android.view.View;
import android.widget.Spinner;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.da.learnquest.R;
import es.ulpgc.eite.da.learnquest.data.RepositoryContract;

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
        Log.d("hola", state.usernameImage);
        if(!model.isFilledTextEmpty(username, password, email)) {
            model.addUser(username, password, email, state.usernameImage, new RepositoryContract.AddUserCallback(){
                @Override
                public void onUserAdded(){
                    onBackPressed();
                }
        });
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
    public void onSelectionClicked(String selectedItem) {
        state.usernameImage = selectedItem;
        view.get().displayPictureSelected(selectedItem);

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
