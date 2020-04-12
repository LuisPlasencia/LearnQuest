package es.ulpgc.eite.da.learnquest.data;

import java.util.ArrayList;

public interface RepositoryContract {
    ArrayList<Question> getQuestions();

    Question getQuestion(int index);

    User getUser(String username, String password);

    void resetDefaultUser();

    void setUserActual(User user);

    User getUserActual();

    int getExperienceCollected();

    void logout();

    int getMedalImage();

    int getQuizId();

    void setQuizId(int quizId);

    int getSubjectId();

    void setSubjectId(int subjectId);

    void resetSubjectId();

    void resetQuizId();

    int getLevel();

    int getSublevel();

    int getPhoto();

    String getUsername();

    void setUsername(String username);

    int experienceToNextLevel();

    void addExperienceToUser();

    QuizUnit getQuizUnit(String subject);

    Integer getSubjectPercentage(int id);

    int getSubjectPhoto(int id);

    void updateExperienceCollected();
}
