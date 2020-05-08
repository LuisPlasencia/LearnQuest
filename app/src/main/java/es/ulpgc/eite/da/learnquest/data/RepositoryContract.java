package es.ulpgc.eite.da.learnquest.data;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public interface RepositoryContract {
    ArrayList<Question> getQuestions();

    Question getQuestion(int index);

    User getUser(String username, String password);

    void addUser(User user);

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

    List<QuizUnitItem> getQuizUnits();

    List<QuestItem> getQuestList();

    void initializeQuestList();

    ///////////////////////////////////////// JSON //////////////////////////////////

    interface FetchSubjectDataCallback {
        void onSubjectDataFetched(boolean error);
    }

    interface GetQuizUnitListCallback {
        void setQuizUnitList(List<QuizUnitItem> quizUnits);
    }

    interface GetQuizUnitCallback {
        void setQuizUnit(QuizUnitItem quizUnit);
    }

    interface GetQuestListCallback {
        void setQuestList(List<QuestItem> quests);
    }

    interface GetQuestCallback {
        void setQuest(QuestItem quest);
    }

    void loadSubject(QuizRepository.FetchSubjectDataCallback callback);

   // void loadSubject(FetchSubjectDataCallback callback);

    void getQuizUnitList(
            QuestItem quest, GetQuizUnitListCallback callback);

    void getQuizUnitList(
            int categoryId, GetQuizUnitListCallback callback);

    void getQuizUnit(int id, GetQuizUnitCallback callback);

    void getQuest(int id, GetQuestCallback callback);


    void getQuestList(GetQuestListCallback callback);
}
