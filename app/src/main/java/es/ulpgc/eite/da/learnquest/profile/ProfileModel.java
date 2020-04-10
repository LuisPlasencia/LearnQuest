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
    public Integer getLevel(User user) {
        if(user!= null){
            return user.getLevel();
        }
        return 0;

    }

    @Override
    public Integer getSublevel(User user){
        if(user!= null){
            return user.getSublevel();
        }
        return 0;

    }

    @Override
    public Integer getPhoto(User user){
        if(user!=null){
            return user.getPhoto();
        }
        return 0;
    }

    @Override
    public String getUsername(User user) {
        if(user!=null){
            return user.getUsername();
        }
        return "";
    }

    @Override
    public void setUsername(User user, String username) {
        if(user!=null){
            user.setUsername(username);
        }
    }


}
