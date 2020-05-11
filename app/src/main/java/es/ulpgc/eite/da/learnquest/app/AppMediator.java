package es.ulpgc.eite.da.learnquest.app;

import es.ulpgc.eite.da.learnquest.data.QuestItem;
import es.ulpgc.eite.da.learnquest.data.QuestionMathItem;
import es.ulpgc.eite.da.learnquest.data.QuizUnitItem;
import es.ulpgc.eite.da.learnquest.finalQuiz.FinalQuizState;
import es.ulpgc.eite.da.learnquest.hint.HintState;
import es.ulpgc.eite.da.learnquest.login.LoginState;
import es.ulpgc.eite.da.learnquest.statistics.StatisticsState;
import es.ulpgc.eite.da.learnquest.profile.ProfileState;
import es.ulpgc.eite.da.learnquest.question.QuestionState;
import es.ulpgc.eite.da.learnquest.questionMath.QuestionMathState;
import es.ulpgc.eite.da.learnquest.quests.QuestsState;
import es.ulpgc.eite.da.learnquest.quizUnit.QuizUnitState;
import es.ulpgc.eite.da.learnquest.registro.RegistroState;

public class AppMediator  {

    private QuestionState questionState;
    private QuestionMathState questionMathState;
    private LoginState loginState;
    private QuestsState questsState;
    private QuizUnitState quizUnitState;
    private ProfileState profileState;
    private FinalQuizState finalQuizState;
    private StatisticsState logrosState;
    private HintState hintState;
    private RegistroState registroState;
    private QuestToQuizUnitState questToQuizUnitState;
    private HintToQuestionState hintToQuestionState;
    private QuestionToHintState questionToHintState;
    private QuizUnitToQuestionState quizUnitToQuestionState;

    private QuestItem questItem;
    private QuizUnitItem quizUnitItem;
    private QuestionMathItem questionMathItem;
    private static AppMediator instance;

    private AppMediator(){
        questionState = new QuestionState();
        finalQuizState = new FinalQuizState();
    }

    public static AppMediator getInstance(){
        if(instance ==null){
            instance = new AppMediator();
        }
        return instance;
    }

    public static void resetInstance(){
        instance = null;
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

    public RegistroState getRegistroState() {
        if(registroState == null) {
            registroState = new RegistroState();
        }
        return registroState;
    }

    public void setRegistroState(RegistroState registroState) {
        this.registroState = registroState;
    }

    public QuestionMathState getQuestionMathState(){
        if(questionMathState == null) {
            questionMathState = new QuestionMathState();
        }
        return questionMathState;
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

    public StatisticsState getLogrosState(){
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

    public void setLogrosState(StatisticsState state){
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
        HintToQuestionState state = hintToQuestionState;
        hintToQuestionState = null;
        return state;
    }

    public void setQuestToQuizUnitState(QuestToQuizUnitState state) {
        questToQuizUnitState = state;
    }

    public void setQuestItem(QuestItem item) {
        this.questItem = item;
    }

    ///////////JSON/////////////

    public QuestItem getQuest(){
        QuestItem item = questItem;
        return item;
    }

    public QuizUnitItem getQuizUnit(){
        QuizUnitItem item = quizUnitItem;
        return item;
    }

    public void setQuizUnit(QuizUnitItem item) {
        quizUnitItem = item;
    }
}
