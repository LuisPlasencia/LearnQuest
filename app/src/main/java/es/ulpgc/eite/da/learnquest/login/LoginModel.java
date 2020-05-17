package es.ulpgc.eite.da.learnquest.login;

import android.util.Log;

import java.util.List;

import es.ulpgc.eite.da.learnquest.data.RepositoryContract;
import es.ulpgc.eite.da.learnquest.data.User;

public class LoginModel implements LoginContract.Model {

    public static String TAG = LoginModel.class.getSimpleName();
    private RepositoryContract repository;

    public LoginModel(RepositoryContract repository){
        this.repository = repository;
    }


    @Override
    public void fetchUserListData(final RepositoryContract.GetUserListCallback callback) {
        repository.loadUsers(
        true, new RepositoryContract.FetchUserDataCallback() {

            @Override
            public void onUserDataFetched(boolean error) {
                if(!error) {
                    repository.getUserList(callback);
                }
            }
        });
    }


    @Override
    public void getDatabaseUsers(RepositoryContract.GetUserListCallback callback) {
        repository.getUserList(callback);
    }


    @Override
    public void setUsuarioActual(User user) {
        repository.setUserActual(user);
    }

    @Override
    public int getNumberOfUsers(){
        return repository.getNumberOfUsers();
    }

}
