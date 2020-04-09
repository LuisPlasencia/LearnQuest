package es.ulpgc.eite.da.learnquest.data;

import java.util.ArrayList;

public class QuizRepository implements RepositoryContract {

    private static QuizRepository INSTANCE;

    private ArrayList<Question> questions;

    public static RepositoryContract getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new QuizRepository();
        }
        return INSTANCE;
    }

    private QuizRepository() {
        Question question1 = new Question("Question 1: Opt1",
                                            "Option 1", "Option 2","Option 3",
                                                "Hint: It might be option 1", 1, 1);

        Question question2 = new Question("Question 2: Opt1",
                                            "Option 1", "Option 2","Option 3",
                                                "Hint: It might be option 1", 1, 2);

        Question question3 = new Question("Question 3: Opt2",
                                            "Option 1", "Option 2","Option 3",
                                                "Hint: It might be option 2", 1, 3);

        ArrayList<Question> questions = new ArrayList<Question>();
        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }
}
