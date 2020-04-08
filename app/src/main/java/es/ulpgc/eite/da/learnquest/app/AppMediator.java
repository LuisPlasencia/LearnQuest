package es.ulpgc.eite.da.learnquest.app;

import android.app.Application;

import es.ulpgc.eite.da.learnquest.questScreen.QuestScreenState;
import es.ulpgc.eite.da.learnquest.question.QuestionState;
import es.ulpgc.eite.da.learnquest.quizUnit.QuizUnitState;

public class AppMediator extends Application {

    private QuestionState questionState;
    private QuestScreenState questScreenState;
    private QuizUnitState quizUnitState;

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

    public void setQuestScreenState(QuestScreenState state) {
        this.questScreenState=state;

    }
    public void setQuizUnitState(QuizUnitState state) {
        this.quizUnitState=state;

    }

    public QuestScreenState getQuestScreenState() {
        return this.questScreenState;
    }

    public QuizUnitState getQuizUnitState() {
        return this.quizUnitState;
    }
}
