package es.ulpgc.eite.da.learnquest.data;

public class QuestItem {
    private String subject;
    private int percentage, id;
    private int photo;


    public QuestItem(String subject,  int percentage, int id) {
        this.subject = subject;
        this.percentage = percentage;
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
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
}
