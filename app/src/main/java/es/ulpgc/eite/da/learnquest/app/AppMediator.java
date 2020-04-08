package es.ulpgc.eite.da.learnquest.app;

import android.app.Application;

import es.ulpgc.eite.da.learnquest.finalQuiz.FinalQuizState;
import es.ulpgc.eite.da.learnquest.login.LoginState;
import es.ulpgc.eite.da.learnquest.logros.LogrosState;
import es.ulpgc.eite.da.learnquest.profile.ProfileState;
import es.ulpgc.eite.da.learnquest.question.QuestionState;
import es.ulpgc.eite.da.learnquest.quests.QuestsState;
import es.ulpgc.eite.da.learnquest.quizUnit.QuizUnitState;

public class AppMediator extends Application {

    private QuestionState questionState;
    private LoginState loginState;
    private QuestsState questsState;
    private QuizUnitState quizUnitState;
    private ProfileState profileState;
    private FinalQuizState finalQuizState;
    private LogrosState logrosState;

    @Override
    public void onCreate() {
        super.onCreate();
        questionState = new QuestionState();
    }
    public ProfileState getProfileState() {
        return profileState;
    }

    public void setProfileState(ProfileState profileState) {
        this.profileState = profileState;
    }

    public QuestsState getQuestsState() {
        return questsState;
    }

    public void setQuestsState(QuestsState questScreenState) {
        this.questsState = questScreenState;
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

    public LogrosState getLogrosState(){
        return logrosState;
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

    public void setLogrosState(LogrosState state){
        logrosState = state;
    }

}
