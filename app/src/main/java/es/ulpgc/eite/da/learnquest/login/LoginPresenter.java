package es.ulpgc.eite.da.learnquest.login;

import android.util.Log;
import android.widget.EditText;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.eite.da.learnquest.R;
import es.ulpgc.eite.da.learnquest.data.RepositoryContract;
import es.ulpgc.eite.da.learnquest.data.User;

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
        for(int i = 0; i<state.users.size();i++){
            if(username.equals(state.users.get(i).getUsername())){
                if(!password.equals(state.users.get(i).getPassword())){
                    view.get().displayWarning(2);
                    return;
                }
                model.setUsuarioActual(state.users.get(i));
                router.passStateToProfileScreen(state);
//                Log.d("holas", String.valueOf(state.users.get(i).quizUnitResultList.size()));
//                Log.d("holas", state.users.get(i).username);
//                Log.d("holas", state.users.get(i).quizUnitResultList.get(0).getMedalla());

//                Log.d("onLetsGoClicked", String.valueOf(state.users.size()));
//                Log.d("onLetsGoClicked",state.users.get(i).getPhotoAdress() + " " + state.users.get(i).getId() + " " + state.users.get(i).getUsername() + " " + state.users.get(i).getPassword() );
                view.get().navigateToProfileScreen();
                return;
            }
        }
        view.get().displayWarning(1);
    }

    @Override
    public void onResume() {
        model.getDatabaseUsers(new RepositoryContract.GetUserListCallback(){
            @Override
            public void setUserList(List<User> users){
                state.users = users;
                Log.d("fetchUserListData", String.valueOf(state.users.size()));
            }
        });
        state.username = "";
        state.password = "";
        view.get().displayCurrentData(state);
    }

    @Override
    public void onCreateAccountButton() {
        view.get().navigateToRegistroScreen();
    }

    @Override
    public void fetchUserListData() {
        if(model.getNumberOfUsers() != 0){
            return;
        }
        model.fetchUserListData(new RepositoryContract.GetUserListCallback(){
        @Override
        public void setUserList(List<User> users){
            state.users = users;
            Log.d("fetchUserListData2", String.valueOf(state.users.size()));
         //   view.get().displayUserData(state);
        }
        });
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
