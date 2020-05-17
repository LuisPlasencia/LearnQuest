package es.ulpgc.eite.da.learnquest.data;

import java.util.ArrayList;
import java.util.List;

public interface RepositoryContract {
    ArrayList<QuestionEnglishItem> getQuestionEnglishItems();

    QuestionEnglishItem getQuestion(int index);

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

    void resetExperienceCollected();

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

    int getNumberOfUsers();

    void addQuizResult(QuizUnitResult quizUnitResult, AddQuizResultCallback callback);

    void getQuizUnitsResultList(QuestItem quest, GetQuizUnitResultListCallback getQuizUnitResultListCallback);

    List<QuestionEnglishItem> loadQuestionEnglish();

    List<QuestionMathItem> loadQuestionMaths();

    List<QuestionGeographyItem> loadQuestionGeography();

    void updateHalfExperienceCollected();


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

    interface GetQuizUnitResultListCallback {
        void setQuizUnitResultList(List<QuizUnitResult> quizResults);
    }

    interface GetQuestionMathListCallback {
        void setQuestionMathList(List<QuestionMathItem> questionMathItem);
    }

    interface GetQuestionEnglishListCallback {
        void setQuestionEnglishList(List<QuestionEnglishItem> questionEnglishItem);
    }

    interface GetQuestionGeoListCallback {
        void setQuestionGeoList(List<QuestionGeographyItem> questionGeoItem);
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

    interface RemoveUserCallback {
        void onUserRemoved();
    }

    interface UpdateUserCallback {
        void onUserUpdated();
    }

    interface AddQuizResultCallback {
        void addQuizResultCallback();
    }

    void loadSubject(FetchSubjectDataCallback callback);

    void loadUsers(
            boolean clearFirst, QuizRepository.FetchUserDataCallback callback);

    void getQuizUnitList(
            QuestItem quest, GetQuizUnitListCallback callback);

    void getQuizUnitList(
            int categoryId, GetQuizUnitListCallback callback);


    void getQuestList(GetQuestListCallback callback);

    ////////////////////////////////////////////// JSON MATH /////////////


    void getUserList(QuizRepository.GetUserListCallback callback);

    void addUser(
            User user, RepositoryContract.AddUserCallback callback);

    void updateUser(
            RepositoryContract.UpdateUserCallback callback);

    void removeUser(
            User user, RepositoryContract.RemoveUserCallback callback);


}
