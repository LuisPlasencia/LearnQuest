package es.ulpgc.eite.da.learnquest.data;


import java.util.ArrayList;
import java.util.List;

import es.ulpgc.eite.da.learnquest.R;

public class QuizRepository implements RepositoryContract {

    private static QuizRepository INSTANCE;
    private final int XP_PER_QUESTION = 30;

    private ArrayList<Question> questions;
    private ArrayList<User> usuarios;
    private User usuariodefault;
    private User usuarioActual;
    private Integer experienceCollected;
    private Integer quizId;
    private Integer subjectId;
    //private ArrayList<QuizUnit> quizUnits;
    private ArrayList<QuizUnitItem> quizUnits;
    private ArrayList<QuestItem> questList;

    public static RepositoryContract getInstance(){
        if (INSTANCE == null) {
            INSTANCE = new QuizRepository();
        }
        return INSTANCE;
    }



    private QuizRepository() {
        quizUnits = new ArrayList<>();
        quizUnits.add(new QuizUnitItem("Unit 1", "Quiz 1",
                "Description of quiz", "Subject", 9,1, false));
        quizUnits.add(new QuizUnitItem("Unit 1", "Quiz 2",
                "Description of quiz", "Subject", 9, 2,false));
        quizUnits.add(new QuizUnitItem("Unit 1", "Quiz 3",
                "Description of quiz", "Subject", 9, 3,false));
        quizUnits.add(new QuizUnitItem("Unit 1", "Quiz 4",
                "Description of quiz", "Subject", 9,4, false));
        quizUnits.add(new QuizUnitItem("Unit 1", "Quiz 5",
                "Description of quiz", "Subject", 9, 5,false));


        Question question1 = new Question("First question: Option 1",
                                            "Option 1", "Option 2","Option 3",
                                                "Hint: It might be option 1", 1, 1);

        Question question2 = new Question("Second Question: Option 1",
                                            "Option 1", "Option 2","Option 3",
                                                "Hint: It might be option 1", 1, 2);

        Question question3 = new Question("Third Question: Option 2",
                                            "Option 1", "Option 2","Option 3",
                                                "Hint: It might be option 2", 2, 3);

        questions = new ArrayList<Question>();
        questions.add(question1);
        questions.add(question2);
        questions.add(question3);

       inicializarUsuarios();
       experienceCollected = 0;

        quizId = 0;
        subjectId = 0;
    }



    private void inicializarUsuarios() {
        usuariodefault = new User("Username", "", 0);
        User usuario1 = new User("Luis", "patata", 1);
        User usuario2 = new User("Ruben", "rabano", 2);
        User usuario3 = new User("Cunwang", "lechuga", 3);

        usuarioActual = usuariodefault;
        usuariodefault.setMathPercentage(35);
        usuariodefault.setEnglishPercentage(79);
        usuariodefault.setGeographyPercentage(5);

        usuario1.setLevel(8);
        usuario1.setSublevel(60);
        usuario1.setPhoto(R.drawable.patata);
        usuario1.setMathPercentage(91);
        usuario1.setEnglishPercentage(27);
        usuario1.setGeographyPercentage(5);

        usuario2.setLevel(11);
        usuario2.setSublevel(40);
        usuario2.setPhoto(R.drawable.rabano);
        usuario2.setMathPercentage(51);
        usuario2.setEnglishPercentage(10);
        usuario2.setGeographyPercentage(69);

        usuario3.setLevel(3);
        usuario3.setSublevel(90);
        usuario3.setPhoto(R.drawable.lechuga);
        usuario3.setMathPercentage(15);
        usuario3.setEnglishPercentage(56);
        usuario3.setGeographyPercentage(90);

        usuarios = new ArrayList<User>();
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        usuarios.add(usuario3);
    }

    @Override
    public void initializeQuestList() {
        questList = new ArrayList<>();
        questList.add(new QuestItem("Maths", usuarioActual.getMathPercentage(), 1));
        questList.get(0).setPhoto(getSubjectPhoto(questList.get(0).getId()));
        questList.add(new QuestItem("English", usuarioActual.getEnglishPercentage(), 2));
        questList.get(1).setPhoto(getSubjectPhoto(questList.get(1).getId()));
        questList.add(new QuestItem("Geography", usuarioActual.getGeographyPercentage(), 3));
        questList.get(2).setPhoto(getSubjectPhoto(questList.get(2).getId()));

    }

    @Override
    public void addUser(User user) {
        usuarios.add(user);
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
        for(int i= 0 ; i<usuarios.size(); i++){
            if(username.equals(usuarios.get(i).getUsername()) && password.equals(usuarios.get(i).getPassword())){
                return usuarios.get(i);
            }
        }
        return usuariodefault;
    }

    @Override
    public List<QuizUnitItem> getQuizUnits(){
        return quizUnits;
    }

    @Override
    public List<QuestItem> getQuestList(){
        return questList;
    }

    @Override
    public QuizUnit getQuizUnit(String subject) {
        for (int i = 0; i<quizUnits.size(); i++){
            if(quizUnits.get(i).getSubject().equals(subject)){
            //    return quizUnits.get(i);
            }
        }
        return null;
    }


    @Override
    public void resetDefaultUser(){
        usuariodefault.setUsername("Username");
        usuariodefault.setLevel(0);
        usuariodefault.setSublevel(0);
        usuariodefault.setMathPercentage(0);
        usuariodefault.setEnglishPercentage(0);
        usuariodefault.setGeographyPercentage(0);
    }

    @Override
    public void setUserActual(User user){
        usuarioActual = user;
    }

    @Override
    public User getUserActual(){
        return usuarioActual;
    }

    @Override
    public int getExperienceCollected(){
        return experienceCollected;
    }

    @Override
    public void logout(){
        usuarioActual = null;
    }

    @Override
    public int getMedalImage() {
        if(experienceCollected > 75){
            return R.drawable.gold_medal;
        } else if(experienceCollected > 50){
            return R.drawable.silver_medal;
        } else{
            return R.drawable.bronze_medal;
        }

    }

    @Override
    public int getQuizId() {
        return quizId;
    }

    @Override
    public void setQuizId(int quizId){
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
    public void resetQuizId(){
        this.quizId = 0;
    }

    @Override
    public void resetSubjectId(){
        this.subjectId = 0;
    }


    @Override
    public int getLevel() {
        if(usuarioActual!= null){
            return usuarioActual.getLevel();
        }
        return 0;
    }

    @Override
    public int getSublevel() {
        if(usuarioActual!= null){
            return usuarioActual.getSublevel();
        }
        return 0;
    }


    @Override
    public int getPhoto(){
        if(usuarioActual!=null){
            return usuarioActual.getPhoto();
        }
        return 0;
    }

    @Override
    public String getUsername() {
        if(usuarioActual!=null){
            return usuarioActual.getUsername();
        }
        return "";
    }

    @Override
    public void setUsername(String username) {
        if(usuarioActual!=null){
            usuarioActual.setUsername(username);
        }
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
    public Integer getSubjectPercentage(int id){
        if(usuarioActual == null){
            return 0;
        }

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
        if(usuarioActual == null){
            return R.drawable.child;
        }
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
}
