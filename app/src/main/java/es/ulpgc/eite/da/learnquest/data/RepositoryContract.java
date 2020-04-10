package es.ulpgc.eite.da.learnquest.data;

import java.util.ArrayList;

public interface RepositoryContract {
    Question getQuestion(int index);

    User getUser(String username, String password);

    void resetDefaultUser();

    void setUserActual(User user);

    User getUserActual();

    Integer getExperienceCollected();

    void logout();

    int getMedalImage();

    int getQuizId();

    void setQuizId(Integer quizId);

    void resetQuizId();

    Integer getLevel();

    Integer getSublevel();

    Integer getPhoto();

    String getUsername();

    void setUsername(String username);

    int experienceToNextLevel();

    void addExperience();

    QuizUnit getQuizUnit(String subject);

    Integer getSubjectPercentage(Integer id);
}
