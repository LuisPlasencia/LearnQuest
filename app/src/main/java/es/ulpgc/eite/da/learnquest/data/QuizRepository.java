package es.ulpgc.eite.da.learnquest.data;


import java.lang.reflect.Array;
import java.util.ArrayList;

import es.ulpgc.eite.da.learnquest.R;

public class QuizRepository implements RepositoryContract {

    private static QuizRepository INSTANCE;

    private ArrayList<Question> questions;
    private ArrayList<User> usuarios;
    private User usuariodefault;
    private User usuarioActual;
    private Integer experienceCollected;
    private Integer quizId;
    private ArrayList<QuizUnit> quizUnits;

    public static RepositoryContract getInstance(){
        if (INSTANCE == null) {
            INSTANCE = new QuizRepository();
        }
        return INSTANCE;
    }

    private QuizRepository() {
        QuizUnit quizUnit1 = new QuizUnit("T1. Triangles", "Cosen theorem",
                "In this quiz you will learn about cosines and sines","T2. Equations","First and second",
                "In this quiz you will learn about equations in deep","Maths");
        //QuizUnit quizUnit2 = new QuizUnit("T2. Equations", "First and second equations ",
          //      "In this quiz you will learn about equations in deep", "Maths");

        quizUnits = new ArrayList<>();
        quizUnits.add(quizUnit1);
        //quizUnits.add(quizUnit2);


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

        quizId = 0;

    }

    private void inicializarUsuarios() {
        usuariodefault = new User("Username", "", 0);
        User usuario1 = new User("Luis", "patata", 1);
        User usuario2 = new User("Ruben", "rabano", 2);
        User usuario3 = new User("Cunwang", "lechuga", 3);

        usuario1.setLevel(8);
        usuario1.setSublevel(60);
        usuario1.setPhoto(R.drawable.patata);

        usuario2.setLevel(11);
        usuario2.setSublevel(40);
        usuario2.setPhoto(R.drawable.rabano);

        usuario3.setLevel(3);
        usuario3.setSublevel(90);
        usuario3.setPhoto(R.drawable.lechuga);

        usuarios = new ArrayList<User>();
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        usuarios.add(usuario3);

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
    public Integer getExperienceCollected(){
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
    public void setQuizId(Integer quizId){
        this.quizId = quizId;
    }

    @Override
    public void resetQuizId(){
        this.quizId = 0;
    }


    @Override
    public Integer getLevel() {
        if(usuarioActual!= null){
            return usuarioActual.getLevel();
        }
        return 0;
    }

    @Override
    public Integer getSublevel(){
        if(usuarioActual!= null){
            return usuarioActual.getSublevel();
        }
        return 0;
    }

    @Override
    public Integer getPhoto(){
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
    public void addExperience() {
        usuarioActual.addExperience(experienceCollected);
        experienceCollected = 0;
    }

    @Override
    public Integer getSubjectPercentage(Integer id){
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

}
