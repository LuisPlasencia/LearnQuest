package es.ulpgc.eite.da.learnquest.data;


import java.util.ArrayList;

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
    private ArrayList<QuizUnit> quizUnits;

    public static RepositoryContract getInstance(){
        if (INSTANCE == null) {
            INSTANCE = new QuizRepository();
        }
        return INSTANCE;
    }

    private QuizRepository() {
        QuizUnit quizUnit1 = new QuizUnit("T1.Topic", "Subtopic",
                "Description of the subtopic","T2.Topic","Subtopic",
                "Description of the subtopic","Maths");
        QuizUnit quizUnit2 = new QuizUnit("T1.Topic", "Subtopic",
                "Description of the subtopic","T2.Topic","Subtopic",
                "Description of the subtopic","English");

        QuizUnit quizUnit3 = new QuizUnit("T1.Topic", "Subtopic",
                "Description of the subtopic","T2.Topic","Subtopic",
                "Description of the subtopic","Geography");

        quizUnits = new ArrayList<>();
        quizUnits.add(quizUnit1);
        quizUnits.add(quizUnit2);
        quizUnits.add(quizUnit3);


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
        usuariodefault.setMathPercentage(27);
        usuariodefault.setEnglishPercentage(66);
        usuariodefault.setGeographyPercentage(5);

        usuario1.setLevel(8);
        usuario1.setSublevel(60);
        usuario1.setPhoto(R.drawable.patata);
        usuario1.setMathPercentage(80);
        usuario1.setEnglishPercentage(95);
        usuario1.setGeographyPercentage(66);

        usuario2.setLevel(11);
        usuario2.setSublevel(40);
        usuario2.setPhoto(R.drawable.rabano);
        usuario1.setMathPercentage(80);
        usuario1.setEnglishPercentage(95);
        usuario1.setGeographyPercentage(66);

        usuario3.setLevel(3);
        usuario3.setSublevel(90);
        usuario3.setPhoto(R.drawable.lechuga);
        usuario1.setMathPercentage(80);
        usuario1.setEnglishPercentage(95);
        usuario1.setGeographyPercentage(66);

        usuarios = new ArrayList<User>();
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        usuarios.add(usuario3);
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
    public QuizUnit getQuizUnit(String subject) {
        for (int i = 0; i<quizUnits.size(); i++){
            if(quizUnits.get(i).getSubject().equals(subject)){
                return quizUnits.get(i);
            }
        }
        return null;
    }


    @Override
    public void resetDefaultUser(){
        usuariodefault.setUsername("Username");
        usuariodefault.setLevel(0);
        usuariodefault.setSublevel(0);
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
        if (quizId == 0){
            if(experienceCollected > 75){
                return R.drawable.gold_medal;
            } else if(experienceCollected > 50){
                return R.drawable.silver_medal;
            } else{
                return R.drawable.bronze_medal;
            }
        } return R.drawable.gold_medal;

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
        if(id == 1 ){
            return usuarioActual.getMathPercentage();
        } else if (id == 2){
            return usuarioActual.getEnglishPercentage();
        } else if(id == 3){
            return usuarioActual.getGeographyPercentage();
        } else{
            return 0;
        }
    }

    @Override
    public int getSubjectPhoto(int id) {
        if(id == 1) {
            if (usuarioActual.getMathPercentage() > 50) {
                return R.drawable.dragon;
            } else if (usuarioActual.getMathPercentage() > 10) {
                return R.drawable.pig;
            }
        } else if(id == 2){
            if (usuarioActual.getEnglishPercentage() > 50) {
                return R.drawable.dragon;
            } else if (usuarioActual.getEnglishPercentage() > 10) {
                return R.drawable.pig;
            }
        } else if(id == 3){
            if (usuarioActual.getGeographyPercentage() > 50) {
                return R.drawable.dragon;
            } else if (usuarioActual.getGeographyPercentage() > 10) {
                return R.drawable.pig;
            }
        }
        return R.drawable.child;
    }
}
