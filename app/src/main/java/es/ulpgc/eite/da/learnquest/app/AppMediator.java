package es.ulpgc.eite.da.learnquest.app;

import android.app.Application;

import es.ulpgc.eite.da.learnquest.finalQuiz.FinalQuizState;
import es.ulpgc.eite.da.learnquest.hint.HintState;
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
    private HintState hintState;
    private QuestToQuizUnitState questToQuizUnitState;
    private HintToQuestionState hintToQuestionState;
    private QuestionToHintState questionToHintState;
    private QuizUnitToQuestionState quizUnitToQuestionState;

    @Override
    public void onCreate() {
        super.onCreate();
        questionState = new QuestionState();
        finalQuizState = new FinalQuizState();
    }
    public ProfileState getProfileState() {
        if(profileState == null){
            profileState = new ProfileState();
        }
        return profileState;
    }

    public void setQuizUnitToQuestionState(QuizUnitToQuestionState state){
        quizUnitToQuestionState = state;
    }

    public QuizUnitToQuestionState getQuizUnitToQuestionState(){
        return quizUnitToQuestionState;
    }

    public void setProfileState(ProfileState profileState) {
        this.profileState = profileState;
    }

    public QuestsState getQuestsState() {
        if(questsState == null){
            questsState = new QuestsState();
        }
        return questsState;
    }

    public void setQuestsState(QuestsState questScreenState) {
        this.questsState = questScreenState;
    }

    public QuizUnitState getQuizUnitState() {
        if(quizUnitState == null){
            quizUnitState = new QuizUnitState();
        }
        return quizUnitState;
    }

    public HintState getHintState() {
        if(hintState == null) {
            hintState = new HintState();
        }
        return hintState;
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

    public void setHintState(HintState hintState) {
        this.hintState = hintState;
    }

    public QuestToQuizUnitState getQuestionToQuizUnitState() {
        return questToQuizUnitState;
    }

    public void setHintToQuestionState(HintToQuestionState state) {
        hintToQuestionState = state;
    }

    public QuestionToHintState getQuestionToHintState() {
        return questionToHintState;
    }

    public void setQuestionToHintState(QuestionToHintState state) {
        questionToHintState = state;
    }

    public HintToQuestionState getHintToQuestionState() {
        return hintToQuestionState;
    }

    public void setQuestToQuizUnitState(QuestToQuizUnitState state) {
        questToQuizUnitState = state;
    }
}
