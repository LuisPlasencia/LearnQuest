package es.ulpgc.eite.da.learnquest.quizUnit;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import es.ulpgc.eite.da.learnquest.data.RepositoryContract;

public class QuizUnitModel implements QuizUnitContract.Model {

    public static String TAG = QuizUnitModel.class.getSimpleName();

    private QuizUnitContract.Presenter presenter;

    private String T1Topic, T1Subtopic, T1Description;

    private String T2Topic, T2Subtopic, T2Description;

    private String subject;

    private int quizIndex;
    private RepositoryContract quizRepository;


    public QuizUnitModel() {

        T1Topic = "null";
        T1Subtopic = "null";
        T1Description = "null";
        subject = "";
    }

   /*@Override
    public void setT1Fields() {
        subject = presenter.getSubject();
    }*/

    @Override
    public void onRestartScreen(QuizUnitState data) {
        T1Topic = data.t1Topic;
        T1Subtopic = data.t1SubTopic;
        T1Description = data.t1Description;
        subject = data.subject;
    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
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
    public void setT2Topic(String T1Topic) {

    }

    @Override
    public void setT2Subtopic(String T2SubTopic) {

    }

    @Override
    public void setT2Description(String T2Description) {

    }

}
