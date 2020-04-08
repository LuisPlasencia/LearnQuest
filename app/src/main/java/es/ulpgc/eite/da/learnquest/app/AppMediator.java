package es.ulpgc.eite.da.learnquest.app;

import android.app.Application;

import es.ulpgc.eite.da.learnquest.question.QuestionState;

public class AppMediator extends Application {

    private QuestionState questionState;

    @Override
    public void onCreate() {
        super.onCreate();

        questionState = new QuestionState();
    }

    public QuestionState getQuestionState() {
        return questionState;
    }

    public void setQuestionState(QuestionState state) {
        questionState = state;
    }

}
