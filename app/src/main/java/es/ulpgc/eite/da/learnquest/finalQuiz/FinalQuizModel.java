package es.ulpgc.eite.da.learnquest.finalQuiz;

import android.util.Log;

import es.ulpgc.eite.da.learnquest.data.QuizUnitResult;
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
        Log.d("finalquiz", String.valueOf(repository.getNumberOfUsers()));
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
    public void addQuizResult(int userId, int questId, int quizId, int mark, RepositoryContract.AddQuizResultCallback callback) {
        QuizUnitResult quizUnitResult = new QuizUnitResult(quizId, questId, quizId, userId, mark, true);
        repository.addQuizResult(quizUnitResult, callback);
    }

    @Override
    public int getSubjectId() {
        return repository.getSubjectId();
    }

}


