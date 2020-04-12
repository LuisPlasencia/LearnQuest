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
    public void signUpUser(String username, String password, String email) {
        User newUser = new User(username, password, 90);
        repository.addUser(newUser);
    }

    @Override
    public boolean isFilledTextEmpty(String username, String password, String email) {
        return (username.isEmpty()) || ((password.isEmpty()) || (email.isEmpty()));
    }
}
