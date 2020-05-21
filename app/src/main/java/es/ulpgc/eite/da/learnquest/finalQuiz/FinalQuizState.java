package es.ulpgc.eite.da.learnquest.finalQuiz;

import java.util.List;

import es.ulpgc.eite.da.learnquest.data.QuizUnitResult;
import es.ulpgc.eite.da.learnquest.data.User;

public class FinalQuizState extends FinalQuizViewModel {

    // put the model state here
    public User user;
    public List<QuizUnitResult> quizUnitResultActual;
    public QuizUnitResult quizUnitResult;
}
