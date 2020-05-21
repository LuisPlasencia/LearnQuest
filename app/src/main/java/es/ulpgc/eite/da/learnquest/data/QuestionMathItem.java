package es.ulpgc.eite.da.learnquest.data;

public class QuestionMathItem extends Question{

    //public int quizUnitId;
    public String mathSolution;

    public QuestionMathItem(int id, String question, String mathSolution) {
        super(id, question);
        this.mathSolution = mathSolution;
    }

    public String getMathSolution() {
        return mathSolution;
    }

    public void setMathSolution(String mathSolution) {
        this.mathSolution = mathSolution;
    }
}
