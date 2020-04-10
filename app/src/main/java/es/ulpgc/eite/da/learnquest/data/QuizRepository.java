package es.ulpgc.eite.da.learnquest.data;


import java.lang.reflect.Array;
import java.util.ArrayList;

import es.ulpgc.eite.da.learnquest.R;

public class QuizRepository implements RepositoryContract {

    private static QuizRepository INSTANCE;

    private ArrayList<Question> questions;
    private ArrayList<User> usuarios;
    private ArrayList<QuizUnit> quizUnits;

    public static RepositoryContract getInstance() {
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
                                                "Hint: It might be option 2", 1, 3);

        questions = new ArrayList<Question>();
        questions.add(question1);
        questions.add(question2);
        questions.add(question3);

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
        return null;
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

}
