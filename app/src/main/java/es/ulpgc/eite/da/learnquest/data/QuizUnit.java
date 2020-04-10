package es.ulpgc.eite.da.learnquest.data;

public class QuizUnit {


    private String T1Topic, T1Subtopic, T1Description;
    private String T2Topic, T2Subtopic, T2Description;
    private String subject;

    public QuizUnit(String t1Topic, String t1Subtopic, String t1Description,String t2Topic, String t2Subtopic, String t2Description, String subject) {
        T1Topic = t1Topic;
        T1Subtopic = t1Subtopic;
        T1Description = t1Description;
        T2Topic = t2Topic;
        T2Subtopic = t2Subtopic;
        T2Description = t2Description;
        this.subject = subject;
    }


    public String getSubject(){
        return subject;
    }

    public String getT1Topic() {
        return T1Topic;
    }

    public String getT1SubTopic() {
        return T1Subtopic;
    }

    public String getT1Description() {
        return T1Description;
    }

    public String getT2Topic() {
        return T2Topic;
    }

    public String getT2SubTopic() {
        return T2Subtopic;
    }

    public String getT2Description() {
        return T2Description;
    }

}
