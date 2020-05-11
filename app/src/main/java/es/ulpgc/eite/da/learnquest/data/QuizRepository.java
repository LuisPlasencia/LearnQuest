package es.ulpgc.eite.da.learnquest.data;


import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.room.Room;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import es.ulpgc.eite.da.learnquest.R;
import es.ulpgc.eite.da.learnquest.database.UserDao;
import es.ulpgc.eite.da.learnquest.database.UserDatabase;

public class QuizRepository implements RepositoryContract {

    public static String TAG = QuizRepository.class.getSimpleName();
    public static final String DB_FILE = "catalog.db";
    public static final String JSON_SUBJECT_FILE = "subject.json";
    public static final String JSON_SUBJECT_ROOT = "quests";
    public static final String JSON_USER_ROOT = "users";
    public static final String JSON_MATH_FILE = "mathQuestion.json";
    public static final String JSON_MATH_ROOT = "mathQuestion";

    private Context context;
    private UserDatabase database;
    private static QuizRepository INSTANCE;

    private final int XP_PER_QUESTION = 30;

    private ArrayList<Question> questions;
 //   private ArrayList<User> usuarios;
//    private User usuariodefault;
    private User usuarioActual;
    private Integer experienceCollected;
    private Integer quizId;
    private Integer subjectId;
    //private ArrayList<QuizUnit> quizUnits;
    private List<QuizUnitItem> quizUnits;
    private List<QuestItem> questList;
    private List<User> userList;
    private List<QuestionMathItem> mathList;

    public static RepositoryContract getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new QuizRepository(context);
        }
        return INSTANCE;
    }


    private QuizRepository(Context context) {
        this.context = context;

        database = Room.databaseBuilder(
                context, UserDatabase.class, DB_FILE
        ).build();

        quizUnits = new ArrayList<>();
        quizUnits.add(new QuizUnitItem("Unit 1", "Quiz 1",
                "Description of quiz", "Subject", 9, 1, false));
        quizUnits.add(new QuizUnitItem("Unit 1", "Quiz 2",
                "Description of quiz", "Subject", 9, 2, false));
        quizUnits.add(new QuizUnitItem("Unit 1", "Quiz 3",
                "Description of quiz", "Subject", 9, 3, false));
        quizUnits.add(new QuizUnitItem("Unit 1", "Quiz 4",
                "Description of quiz", "Subject", 9, 4, false));
        quizUnits.add(new QuizUnitItem("Unit 1", "Quiz 5",
                "Description of quiz", "Subject", 9, 5, false));


        Question question1 = new Question("First question: Option 1",
                "Option 1", "Option 2", "Option 3",
                "Hint: It might be option 1", 1, 1);

        Question question2 = new Question("Second Question: Option 1",
                "Option 1", "Option 2", "Option 3",
                "Hint: It might be option 1", 1, 2);

        Question question3 = new Question("Third Question: Option 2",
                "Option 1", "Option 2", "Option 3",
                "Hint: It might be option 2", 2, 3);

        questions = new ArrayList<Question>();
        questions.add(question1);
        questions.add(question2);
        questions.add(question3);

//        inicializarUsuarios();
        experienceCollected = 0;

        quizId = 0;
        subjectId = 0;
    }


//    private void inicializarUsuarios() {
//        usuariodefault = new User("Username", "", 0);
//        User usuario1 = new User("Luis", "patata", 1);
//        User usuario2 = new User("Ruben", "rabano", 2);
//        User usuario3 = new User("Cunwang", "lechuga", 3);
//
//        usuarioActual = usuariodefault;
//        usuariodefault.setMathPercentage(35);
//        usuariodefault.setEnglishPercentage(79);
//        usuariodefault.setGeographyPercentage(5);
//
//        usuario1.setLevel(8);
//        usuario1.setSublevel(60);
//        usuario1.setPhoto(R.drawable.patata);
//        usuario1.setMathPercentage(91);
//        usuario1.setEnglishPercentage(27);
//        usuario1.setGeographyPercentage(5);
//
//        usuario2.setLevel(11);
//        usuario2.setSublevel(40);
//        usuario2.setPhoto(R.drawable.rabano);
//        usuario2.setMathPercentage(51);
//        usuario2.setEnglishPercentage(10);
//        usuario2.setGeographyPercentage(69);
//
//        usuario3.setLevel(3);
//        usuario3.setSublevel(90);
//        usuario3.setPhoto(R.drawable.lechuga);
//        usuario3.setMathPercentage(15);
//        usuario3.setEnglishPercentage(56);
//        usuario3.setGeographyPercentage(90);
//
//        usuarios = new ArrayList<User>();
//        usuarios.add(usuario1);
//        usuarios.add(usuario2);
//        usuarios.add(usuario3);
//    }

    @Override
    public void updateQuestParameters() {
        if(questList != null){
            Log.d("updateQuestParameters" , questList.get(0).subjectName);
            for(int i = 0; i<questList.size(); i++){
                if(questList.get(i).getId() == 1){
                    questList.get(i).setPercentage(usuarioActual.getMathPercentage());
                } else if(questList.get(i).getId() == 2){
                    questList.get(i).setPercentage(usuarioActual.getEnglishPercentage());
                } else if(questList.get(i).getId() == 3){
                    questList.get(i).setPercentage(usuarioActual.getGeographyPercentage());
                }
                questList.get(i).setPhoto(getSubjectPhoto(questList.get(i).getId()));
            }
        }
//        questList.add(new QuestItem("Maths", usuarioActual.getMathPercentage(), 1));
//        questList.get(0).setPhoto(getSubjectPhoto(questList.get(0).getId()));
//        questList.add(new QuestItem("English", usuarioActual.getEnglishPercentage(), 2));
//        questList.get(1).setPhoto(getSubjectPhoto(questList.get(1).getId()));
//        questList.add(new QuestItem("Geography", usuarioActual.getGeographyPercentage(), 3));
//        questList.get(2).setPhoto(getSubjectPhoto(questList.get(2).getId()));
    }

    @Override
    public void addUser(
            final User user, final AddUserCallback callback) {
        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if(callback != null) {
                    Log.d("addUser", user.getPhotoAdress() + " " + user.getId() + " " + user.getUsername() + " " + user.getPassword());
                    getUserDao().insertUser(user);
                    userList.add(user);
                    callback.onUserAdded();
                }
            }
        });
    }

    @Override
    public boolean existingUsername(String username){
        for(int i= 0; i<userList.size(); i++){
            if(userList.get(i).getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void updateUser(
            final UpdateUserCallback callback) {
        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if(callback != null) {
                    if(usuarioActual.getId() != 0){
                        getUserDao().updateUser(usuarioActual);
                    }
                    callback.onUserUpdated();
                }
            }
        });
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    @Override
    public Question getQuestion(int index) {
        return questions.get(index);
    }

    @Override
    public User getUser(String username, String password) {
        for (int i = 0; i < userList.size(); i++) {
            if (username.equals(userList.get(i).getUsername()) && password.equals(userList.get(i).getPassword())) {
                return userList.get(i);
            }
        }
        return userList.get(0);
    }

    @Override
    public List<QuizUnitItem> getQuizUnits() {
        return quizUnits;
    }

    @Override
    public List<QuestItem> getQuestList() {
        return questList;
    }

    @Override
    public QuizUnit getQuizUnit(String subject) {
        for (int i = 0; i < quizUnits.size(); i++) {
            if (quizUnits.get(i).getSubject().equals(subject)) {
                //    return quizUnits.get(i);
            }
        }
        return null;
    }


    @Override
    public void setUserActual(User user) {
        usuarioActual = user;
    }

    @Override
    public User getUserActual() {
        return usuarioActual;
    }

    @Override
    public int getExperienceCollected() {
        return experienceCollected;
    }

    @Override
    public void logout() {
        usuarioActual = null;
    }

    @Override
    public int getMedalImage() {
        if (experienceCollected > 75) {
            return R.drawable.gold_medal;
        } else if (experienceCollected > 50) {
            return R.drawable.silver_medal;
        } else {
            return R.drawable.bronze_medal;
        }

    }

    @Override
    public int getQuizId() {
        return quizId;
    }

    @Override
    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }


    @Override
    public int getSubjectId() {
        return subjectId;
    }

    @Override
    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    @Override
    public void resetQuizId() {
        this.quizId = 0;
    }

    @Override
    public void resetSubjectId() {
        this.subjectId = 0;
    }


    @Override
    public int getLevel() {
        return usuarioActual.getLevel();
    }

    @Override
    public int getSublevel() {
        return usuarioActual.getSublevel();
    }


    @Override
    public String getPhoto() {
        Log.d("getPhoto",usuarioActual.getUsername());
        Log.d("getPhoto",usuarioActual.getPhotoAdress());
        return usuarioActual.getPhotoAdress();
    }

    @Override
    public String getUsername() {
        return usuarioActual.getUsername();

    }

    @Override
    public void setUsername(String username) {
        usuarioActual.setUsername(username);
    }

    @Override
    public int experienceToNextLevel() {
        return usuarioActual.experienceToNextLevel();
    }

    @Override
    public void addExperienceToUser() {
        usuarioActual.addExperience(experienceCollected);
        experienceCollected = 0;
    }

    @Override
    public void updateExperienceCollected() {
        experienceCollected += XP_PER_QUESTION;
    }


    @Override
    public Integer getSubjectPercentage(int id) {
        switch (id) {
            case 1:
                return usuarioActual.getMathPercentage();
            case 2:
                return usuarioActual.getEnglishPercentage();
            case 3:
                return usuarioActual.getGeographyPercentage();
            default:
                return 0;
        }
    }

    @Override
    public int getSubjectPhoto(int id) {
        switch (id) {
            case 1:
                if (usuarioActual.getMathPercentage() > 70) {
                    return R.drawable.dragon;
                } else if (usuarioActual.getMathPercentage() > 25) {
                    return R.drawable.pig;
                }
                break;
            case 2:
                if (usuarioActual.getEnglishPercentage() > 70) {
                    return R.drawable.dragon;
                } else if (usuarioActual.getEnglishPercentage() > 25) {
                    return R.drawable.pig;
                }
                break;
            case 3:
                if (usuarioActual.getGeographyPercentage() > 70) {
                    return R.drawable.dragon;
                } else if (usuarioActual.getGeographyPercentage() > 25) {
                    return R.drawable.pig;
                }
                break;
        }
        return R.drawable.child;
    }

    @Override
    public int getNumberOfUsers(){
        if(userList != null){
            return userList.size();
        }
        return 0;
    }

    @Override
    public void removeUser(
            final User user, final RemoveUserCallback callback) {
        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if(callback != null) {
                    getUserDao().deleteUser(user);
                    callback.onUserRemoved();
                }
            }
        });
    }


    ///////////////////////////////////////// JSON //////////////////////////////////

    @Override
    public void loadSubject(final FetchSubjectDataCallback callback) {

        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {

                boolean error = !loadSubjectFromJSON(loadJSONFromAsset());

                if(callback != null) {
                    callback.onSubjectDataFetched(error);
                }
            }
        });

    }
    @Override
    public void getQuizUnitList(
            final QuestItem quest, final GetQuizUnitListCallback callback) {

        getQuizUnitList(quest.id, callback);
    }

    @Override
    public void getQuizUnitList(
            final int categoryId, final GetQuizUnitListCallback callback) {

        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if(callback != null) {
                    callback.setQuizUnitList(loadQuizUnits(categoryId));
                }
            }
        });

    }

   @Override
    public void getQuestionMathList(
            final QuizUnitItem quizUnit, final GetQuestionMathListCallback callback) {

        getQuestionMathList(quizUnit.id, callback);
    }

    @Override
    public void getQuestionMathList(
            final int quizUnitId, final GetQuestionMathListCallback callback) {

        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if(callback != null) {
                    callback.setQuestionMathList(loadQuestionMath(quizUnitId));
                }
            }
        });

    }

    @Override
    public void getQuestionMath(final int id, final GetQuestionMathCallback callback) {

        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if(callback != null) {
                    callback.setQuestionMath(loadQuestionMaths(id));
                }
            }
        });
    }

    @Override
    public void getQuizUnit(final int id, final GetQuizUnitCallback callback) {

        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if(callback != null) {
                    callback.setQuizUnit(loadQuizUnit(id));
                }
            }
        });
    }

    @Override
    public void getQuest(final int id, final GetQuestCallback callback) {

        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if (callback != null) {
                    callback.setQuest(loadQuest(id));
                }
            }


        });

    }

    @Override
    public void getQuestList(final GetQuestListCallback callback) {
        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if (callback != null) {
                    callback.setQuestList(loadQuests());
                }
            }
        });

    }

   @Override
    public void getQuizUnitList(final GetQuizUnitListCallback callback) {
        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if (callback != null) {
                    callback.setQuizUnitList(loadQuizUnit());
                }
            }
        });

    }

    public boolean loadSubjectFromJSON(String json) {

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        try {

            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray(JSON_SUBJECT_ROOT);

            questList = new ArrayList<>();

            if (jsonArray.length() > 0) {

                final List<QuestItem> questList = Arrays.asList(
                        gson.fromJson(jsonArray.toString(), QuestItem[].class)
                );

                for (QuestItem quest : questList) {
                    insertQuest(quest);
                }

             for(QuestItem quest: questList) {
                   for(QuizUnitItem quizUnit: quest.quizUnitItems){
                        quizUnit.questId = quest.id;
                    }
                }

                updateQuestParameters();

                return true;
            }
        } catch (JSONException e) {
            Log.e(TAG, "error: " + e);
        }




        return false;
    }

    public String loadJSONFromAsset() {

        String json = null;

        try {

            InputStream is = context.getAssets().open(JSON_SUBJECT_FILE);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException error) {
            Log.e(TAG, "error: " + error);
        }

        return json;
    }

    private List<QuizUnitItem> loadQuizUnits(int questId) {
        List<QuizUnitItem> quizUnits = new ArrayList();

        for (QuestItem quest: questList) {
            if(quest.id == questId) {
                quizUnits = quest.quizUnitItems;
            }
        }

        return quizUnits;
    }

    private List<QuestionMathItem> loadQuestionMath(int quizUnitId) {
        List<QuestionMathItem> questionMath = new ArrayList();
        for (QuizUnitItem quizUnit: quizUnits) {
            if(quizUnit.id == quizUnitId) {
                questionMath = quizUnit.questionMathItems;
            }
        }

        return questionMath;
    }



   private QuizUnitItem loadQuizUnit(int id) {
        for (QuestItem quest: questList) {
            for (QuizUnitItem quizUnit: quest.quizUnitItems) {
                if(quizUnit.id == id) {
                    return quizUnit;
                }
            }
        }

        return null;
    }

    private QuestionMathItem loadQuestionMaths(int id) {
        for (QuizUnitItem quizUnit: quizUnits) {
            for (QuestionMathItem questionMath: quizUnit.questionMathItems) {
                if(questionMath.id == id) {
                    return questionMath;
                }
            }
        }

        return null;
    }


    private QuestItem loadQuest(int id) {
        for (QuestItem quest : questList) {
            if (quest.id == id) {
                return quest;
            }
        }
        return null;
    }

    private void insertQuest(QuestItem quest) {
        questList.add(quest);
    }

    private void insertQuizUnit(QuizUnitItem quizUnit) {
        quizUnits.add(quizUnit);
    }


    private List<QuestItem> loadQuests() {
        return questList;
    }

    private List<QuizUnitItem> loadQuizUnit() {
        return quizUnits;
    }

////////////////////////////MATH JSON///////////////////////

   /* public boolean loadQuestionMathFromJSON(String json) {

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        try {

            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray(JSON_MATH_ROOT);

            mathList = new ArrayList<>();

            if (jsonArray.length() > 0) {

                final List<QuestionMathItem> mathList = Arrays.asList(
                        gson.fromJson(jsonArray.toString(), QuestionMathItem[].class)
                );

                for (QuestionMathItem mathItem : mathList) {
                    insertMathItem(mathItem);
                }

                return true;
            }
        } catch (JSONException e) {
            Log.e(TAG, "error: " + e);
        }

        return false;
    }

    public String loadJSONFromAssetMath() {

        String json = null;

        try {

            InputStream is = context.getAssets().open(JSON_MATH_FILE);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException error) {
            Log.e(TAG, "error: " + error);
        }

        return json;
    }*/


    @Override
    public void getUserList(final GetUserListCallback callback) {
        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if(callback != null) {
                    callback.setUserList(getUserDao().loadUsers());
                }
            }
        });

    }

    private UserDao getUserDao() {
        return database.userDao();
    }


    @Override
    public void loadUsers(
            final boolean clearFirst, final FetchUserDataCallback callback) {

        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if(clearFirst) {
                    database.clearAllTables();
                }

                boolean error = false;
                if(getUserDao().loadUsers().size() == 0 ) {
                    error = !loadUsersFromJSON(loadJSONFromAsset());
                }

                if(callback != null) {
                    callback.onUserDataFetched(error);
                }
            }
        });

    }
//
    private boolean loadUsersFromJSON(String json) {

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        try {

            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray(JSON_USER_ROOT);

            userList = new ArrayList<>();

            if (jsonArray.length() > 0) {

                final List<User> users = Arrays.asList(
                        gson.fromJson(jsonArray.toString(), User[].class)
                );

                for (User user: users) {
                    getUserDao().insertUser(user);
                }
                userList = getUserDao().loadUsers();

                return true;
            }
        } catch (JSONException e) {
            Log.e(TAG, "error: " + e);
        }
        return false;
    }



}
