package es.ulpgc.eite.da.learnquest.questionGeography;

import java.util.List;

import es.ulpgc.eite.da.learnquest.data.QuestionGeographyItem;
import es.ulpgc.eite.da.learnquest.data.QuestionMathItem;
import es.ulpgc.eite.da.learnquest.data.QuizUnitItem;

public class QuestionGeographyViewModel {

    // put the view state here
    public String data;

    public String geoQuestionNumber;
    public String geoAnswerText;
    public String geoUserAnswerText;

    public boolean geoButtonsEnabled;
    public boolean geoNextEnabled;
    public boolean geoHintEnabled;
    public boolean geoEnterEnabled;

    /////////-------///////////

    public QuizUnitItem quizUnitItem;
    public QuestionMathItem questionMathItem;
    public List<QuestionGeographyItem> questionGeographyItems;
}
