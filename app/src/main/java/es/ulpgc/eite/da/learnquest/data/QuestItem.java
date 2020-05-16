package es.ulpgc.eite.da.learnquest.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class QuestItem {

    public String subjectName; // cambiado de subject a subjectname
    public int id;
    private int photo;
    private int percentage;
    @SerializedName("quizUnits")
    public List<QuizUnitItem> quizUnitItems;



    public QuestItem(int percentage, int id) {
       // this.subjectName = subject;
        this.percentage = percentage;
        this.id = id;
    }

    public String getSubject() {
        return subjectName;
    }

    public void setSubject(String subject) {
        this.subjectName = subject;
    }

    public int getPercentage(){
        return percentage;
    }

    public void setPercentage(int percentage){
        this.percentage = percentage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo){
        this.photo = photo;
    }

    public List<QuizUnitItem> getQuizUnitItems(){
        return quizUnitItems;
    }

    @Override
    public String toString(){
        return subjectName;
    }


}
