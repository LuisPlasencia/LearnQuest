package es.ulpgc.eite.da.learnquest.app;

import android.app.Application;

import es.ulpgc.eite.da.learnquest.finalQuiz.FinalQuizState;
import es.ulpgc.eite.da.learnquest.login.LoginState;
import es.ulpgc.eite.da.learnquest.questScreen.QuestScreenState;
import es.ulpgc.eite.da.learnquest.question.QuestionState;
import es.ulpgc.eite.da.learnquest.quizUnit.QuizUnitState;

public class AppMediator extends Application {

    private QuestionState questionState;
    private LoginState loginState;
    private QuestScreenState questScreenState;
    private QuizUnitState quizUnitState;
    private FinalQuizState finalQuizState;

    @Override
    public void onCreate() {
        super.onCreate();
        questionState = new QuestionState();
    }

    public QuestScreenState getQuestScreenState() {
        return questScreenState;
    }

    public void setQuestScreenState(QuestScreenState questScreenState) {
        this.questScreenState = questScreenState;
    }

    public QuizUnitState getQuizUnitState() {
        return quizUnitState;
    }

    public void setQuizUnitState(QuizUnitState quizUnitState) {
        this.quizUnitState = quizUnitState;
    }


    public QuestionState getQuestionState() {
        return questionState;
    }

    public LoginState getLoginState(){
        return loginState;
    }

    public FinalQuizState getFinalQuizState(){
        return finalQuizState;
    }

    public void setQuestionState(QuestionState state) {
        questionState = state;
    }

    public void setLoginState(LoginState state){
        loginState = state;
    }

    public void setFinalQuizState(FinalQuizState state){
        finalQuizState = state;
    }

}
