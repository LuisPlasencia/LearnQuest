package es.ulpgc.eite.da.learnquest.registro;

import android.util.Log;

import es.ulpgc.eite.da.learnquest.data.RepositoryContract;
import es.ulpgc.eite.da.learnquest.data.User;

public class RegistroModel implements RegistroContract.Model {

    public static String TAG = RegistroModel.class.getSimpleName();
    private RepositoryContract repository;

    public RegistroModel(RepositoryContract quizRepository) {
        this.repository = quizRepository;
    }

    @Override
    public void addUser(String username, String password, String email, RepositoryContract.AddUserCallback callback) {
        User newUser = new User(username, password, repository.getNumberOfUsers());
        repository.addUser(newUser, callback);
    }


    @Override
    public boolean isFilledTextEmpty(String username, String password, String email) {
        return (username.isEmpty()) || ((password.isEmpty()) || (email.isEmpty()));
    }
}
