package es.ulpgc.eite.da.learnquest.finalQuiz;

import es.ulpgc.eite.da.learnquest.data.RepositoryContract;
import es.ulpgc.eite.da.learnquest.data.User;

public class FinalQuizModel implements FinalQuizContract.Model {

    public static String TAG = FinalQuizModel.class.getSimpleName();
    private RepositoryContract repository;

    public FinalQuizModel(RepositoryContract repository) {
        this.repository = repository;
    }

    @Override
    public User getUserActual() {
        return repository.getUserActual();
    }

    @Override
    public Integer getStoredExperience() {
        return repository.getExperienceCollected();
    }


    @Override
    public void addExperience() {
        repository.addExperienceToUser();
    }

    @Override
    public Integer getLevel() {
        return repository.getLevel();
    }

    @Override
    public Integer getSubLevel() {
        return repository.getSublevel();
    }

    @Override
    public int getMedalImage() {
        return repository.getMedalImage();
    }

    @Override
    public int getExperienceNeeded() {
        return repository.experienceToNextLevel();
    }

    @Override
    public int getQuizId() {
        return repository.getQuizId();
    }

    @Override
    public void resetQuizId() {
        repository.resetQuizId();
    }

    @Override
    public void resetSubjectId() {
        repository.resetSubjectId();
    }

    @Override
    public void updateUser(RepositoryContract.UpdateUserCallback callback) {
        repository.updateUser(callback);
    }

    @Override
    public int getSubjectId() {
        return repository.getSubjectId();
    }

}


