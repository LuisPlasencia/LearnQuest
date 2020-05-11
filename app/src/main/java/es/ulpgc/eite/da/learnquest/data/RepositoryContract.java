package es.ulpgc.eite.da.learnquest.data;

import java.util.ArrayList;
import java.util.List;

public interface RepositoryContract {
    ArrayList<Question> getQuestions();

    Question getQuestion(int index);

    User getUser(String username, String password);


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

    String getPhoto();

    String getUsername();

    boolean existingUsername(String username);

    void setUsername(String username);

    int experienceToNextLevel();

    void addExperienceToUser();

    QuizUnit getQuizUnit(String subject);

    Integer getSubjectPercentage(int id);

    int getSubjectPhoto(int id);

    void updateExperienceCollected();

    List<QuizUnitItem> getQuizUnits();

    List<QuestItem> getQuestList();

    void updateQuestParameters();

    void getQuizUnitList(GetQuizUnitListCallback callback);

    int getNumberOfUsers();

    ///////////////////////////////////////// JSON //////////////////////////////////

    interface FetchSubjectDataCallback {
        void onSubjectDataFetched(boolean error);
    }

    interface FetchUserDataCallback {
        void onUserDataFetched(boolean error);
    }

    interface GetQuizUnitListCallback {
        void setQuizUnitList(List<QuizUnitItem> quizUnits);
    }

    interface GetQuizUnitCallback {
        void setQuizUnit(QuizUnitItem quizUnit);
    }

    interface GetQuestionMathListCallback {
        void setQuestionMathList(List<QuestionMathItem> questionMathItem);
    }

    interface GetQuestionMathCallback {
        void setQuestionMath(QuestionMathItem questionMathItem);
    }

    interface GetQuestListCallback {
        void setQuestList(List<QuestItem> quests);
    }

    interface GetQuestCallback {
        void setQuest(QuestItem quest);
    }

    interface GetUserListCallback {
        void setUserList(List<User> users);
    }

    interface AddUserCallback {
        void onUserAdded();
    }

    interface UpdateUserCallback {
        void onUserUpdated();
    }

   // void loadSubject(QuizRepository.FetchSubjectDataCallback callback);

    void loadSubject(FetchSubjectDataCallback callback);

    void loadUsers(
            boolean clearFirst, QuizRepository.FetchUserDataCallback callback);

    //void loadSubject(FetchSubjectDataCallback callback);

    void getQuizUnitList(
            QuestItem quest, GetQuizUnitListCallback callback);

    void getQuizUnitList(
            int categoryId, GetQuizUnitListCallback callback);

    void getQuestionMathList(
            QuizUnitItem quizUnit, GetQuestionMathListCallback callback);

    void getQuestionMathList(
            int quizUnitId, GetQuestionMathListCallback callback);

    void getQuestionMath(int id, GetQuestionMathCallback callback);

    void getQuizUnit(int id, GetQuizUnitCallback callback);

    void getQuest(int id, GetQuestCallback callback);

    void getQuestList(GetQuestListCallback callback);

    ////////////////////////////////////////////// JSON MATH /////////////


    void getUserList(QuizRepository.GetUserListCallback callback);

    void addUser(
            User user, RepositoryContract.AddUserCallback callback);

    void updateUser(
            RepositoryContract.UpdateUserCallback callback);


}
