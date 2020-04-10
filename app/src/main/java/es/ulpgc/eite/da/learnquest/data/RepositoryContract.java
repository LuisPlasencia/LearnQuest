package es.ulpgc.eite.da.learnquest.data;

import java.util.ArrayList;

public interface RepositoryContract {
    Question getQuestion(int index);
    User getUser(String username, String password);
    QuizUnit getQuizUnit(String subject);
}
