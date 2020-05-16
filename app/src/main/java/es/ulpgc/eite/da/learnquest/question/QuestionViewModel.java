package es.ulpgc.eite.da.learnquest.question;

import java.util.List;

import es.ulpgc.eite.da.learnquest.data.QuestionEnglishItem;
import es.ulpgc.eite.da.learnquest.data.QuizUnitItem;

public class QuestionViewModel {

    public QuizUnitItem quizUnitItem;
    public List<QuestionEnglishItem> questionEnglishItems;

    public int questionNumber;
    public String questionText;
    public String option1;
    public String option2;
    public String option3;

    public boolean optionClicked;
    public int option;

    public boolean optionEnabled;
    public boolean nextEnabled;
    public boolean hintEnabled;
}
