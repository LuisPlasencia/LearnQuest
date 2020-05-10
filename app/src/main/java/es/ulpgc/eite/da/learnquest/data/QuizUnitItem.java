package es.ulpgc.eite.da.learnquest.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class QuizUnitItem {
    public String unit, subject, title, description;
    public int mark, id;
    private boolean solved;
    public int questId;
    public String mathTitle, mathDescription;
    ///public String subSubject;


    public QuizUnitItem(String unit, String title, String description, String subject, int mark, int id, boolean solved) {
        this.unit = unit;
        this.subject = subject;
        this.title = title;
        this.description = description;
        this.mark = mark;
        this.solved = solved;
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public boolean isSolved() {
        return solved;
    }

    public void setSolved(boolean solved) {
        this.solved = solved;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return title;
    }

    @SerializedName("subSubjects")
    public List<QuestionMathItem> questionMathItems;
}