package es.ulpgc.eite.da.learnquest.profile;

import es.ulpgc.eite.da.learnquest.data.RepositoryContract;
import es.ulpgc.eite.da.learnquest.data.User;

public class ProfileModel implements ProfileContract.Model {

    public static String TAG = ProfileModel.class.getSimpleName();

    private RepositoryContract repository;

    public ProfileModel(RepositoryContract repository) {
        this.repository = repository;
    }

    @Override
    public User getUser(String username, String password){
        return repository.getUser(username, password);
    }

    @Override
    public void setUserActual(User user){
        repository.setUserActual(user);
    }

    @Override
    public Integer getLevel() {
        return repository.getLevel();
    }

    @Override
    public Integer getSublevel(){
        return repository.getSublevel();
    }

    @Override
    public Integer getPhoto(){
        return repository.getPhoto();
    }

    @Override
    public String getUsername() {
        return repository.getUsername();
    }

    @Override
    public void setUsername(String username) {
        repository.setUsername(username);
    }

    @Override
    public void resetDefaultUser(){
        repository.resetDefaultUser();
    }


    @Override
    public void logout(){
        repository.logout();
    }

    @Override
    public User getUserActual() {
        return repository.getUserActual();
    }


    @Override
    public void updateQuestParameters() {
        repository.updateQuestParameters();
    }

}
