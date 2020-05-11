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
        state.username = view.get().getUsernameInput();
        if(state.username.length() > 8){
            view.get().displayWarning(3);
            return;
        }
        state.password = view.get().getEmailInput();
        state.email = view.get().getPasswordInput(); //El email se usará más adelante (siguiente sprint)
        Log.d("hola", state.usernameImage);
        if(model.existingUsername(state.username)){
            view.get().displayWarning(2);
        }
        else if(!model.isFilledTextEmpty(state.username, state.password, state.email)){
            model.addUser(state.username, state.password, state.email, state.usernameImage, new RepositoryContract.AddUserCallback(){
                @Override
                public void onUserAdded(){
                    onBackPressed();
                }
            });
        } else {
            Log.d(TAG, state.username + state.password + state.email);
            view.get().displayWarning(1);
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
