package es.ulpgc.eite.da.learnquest.questionMath;

import java.util.List;

import es.ulpgc.eite.da.learnquest.data.QuestionMathItem;
import es.ulpgc.eite.da.learnquest.data.QuizUnitItem;

public class QuestionMathViewModel {

    // put the view state here
    public String mathQuestionNumber;
    public String mathQuestionText;
    public String mathAnswerText;

    public boolean numberClicked;
    public int number;

    public boolean mathNumbersEnabled;
    public boolean mathNextEnabled;
    public boolean mathHintEnabled;
    public boolean mathEnterEnabled;

    //////////--------///////

    public QuizUnitItem quizUnitItem;
    public QuestionMathItem questionMathItem;
    public List<QuestionMathItem> questionMathItems;


}
