package es.ulpgc.eite.da.learnquest.quizUnit;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import es.ulpgc.eite.da.learnquest.data.RepositoryContract;

public class QuizUnitModel implements QuizUnitContract.Model {

    public static String TAG = QuizUnitModel.class.getSimpleName();

    private String T1Topic, T1Subtopic, T1Description;

    private String T2Topic, T2Subtopic, T2Description;

    private String subject;

    private RepositoryContract quizRepository;

    public QuizUnitModel(RepositoryContract quizRepository) {
        this.quizRepository=quizRepository;
    }

    public QuizUnitModel() {

        T1Topic = "null";
        T1Subtopic = "null";
        T1Description = "null";
        subject = "";
    }

    @Override
    public void setSubject(String subject){
        this.subject=subject;
    }

    @Override
    public void setT1Fields() {
        if (subject.equals("Maths")) {
            setT1Topic(quizRepository.getQuizUnit("Maths").getT1Topic());
            setT1SubTopic(quizRepository.getQuizUnit("Maths").getT1SubTopic());
            setT1Description(quizRepository.getQuizUnit("Maths").getT1Description());

            setT2Topic(quizRepository.getQuizUnit("Maths").getT2Topic());
            setT2SubTopic(quizRepository.getQuizUnit("Maths").getT2SubTopic());
            setT2Description(quizRepository.getQuizUnit("Maths").getT2Description());

        } else if (subject.equals("English")) {
            setT1Topic("ENGLISH");
            setT1SubTopic("ENGLISH");
            setT1Description("ENGLISH");
        } else {
            setT1Topic("GEOGRAPHY");
            setT1SubTopic("GEOGRAPHY");
            setT1Description("GEOGRAPHY");
        }
    }

    @Override
    public void onRestartScreen(QuizUnitState data) {
        T1Topic = data.t1Topic;
        T1Subtopic = data.t1SubTopic;
        T1Description = data.t1Description;
    }

    @Override
    public void setT1Topic(String T1Topic) {
        this.T1Topic = T1Topic;
    }
    @Override
    public void setT1SubTopic(String T1SubTopic) {
        this.T1Subtopic = T1SubTopic;
    }

    @Override
    public void setT1Description(String T1Description) {
        this.T1Description = T1Description;
    }

    @Override
    public String getT1Topic() {
        return T1Topic;
    }

    @Override
    public String getT1SubTopic() {
        return T1Subtopic;
    }

    @Override
    public String getT1Description() {
        return T1Description;
    }

    @Override
    public String getT2Topic() {
        return T2Topic;
    }

    @Override
    public void setT2Topic(String t2Topic) {
        T2Topic = t2Topic;
    }

    @Override
    public String getT2SubTopic() {
        return T2Subtopic;
    }

    @Override
    public void setT2SubTopic(String t2Subtopic) {
        T2Subtopic = t2Subtopic;
    }

    @Override
    public String getT2Description() {
        return T2Description;
    }

    @Override
    public void setT2Description(String t2Description) {
        T2Description = t2Description;
    }

}
