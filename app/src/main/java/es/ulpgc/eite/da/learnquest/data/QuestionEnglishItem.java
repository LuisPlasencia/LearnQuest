package es.ulpgc.eite.da.learnquest.data;

public class QuestionEnglishItem extends Question{
    public String option1;
    public String option2;
    public String option3;
    public String hint;
    public int correctOption;


    public QuestionEnglishItem(String question, String option1, String option2, String option3, String hint, int correctOption, int id) {
        super(id, question);
        //this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.hint = hint;
        this.correctOption = correctOption;
        //this.id = id;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public int getCorrectOption() {
        return correctOption;
    }

    public void setCorrectOption(int correctOption) {
        this.correctOption = correctOption;
    }
}
