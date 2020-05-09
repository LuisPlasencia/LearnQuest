package es.ulpgc.eite.da.learnquest.quizUnit;

import es.ulpgc.eite.da.learnquest.app.AppMediator;
import es.ulpgc.eite.da.learnquest.app.QuestToQuizUnitState;
import es.ulpgc.eite.da.learnquest.app.QuizUnitToQuestionState;
import es.ulpgc.eite.da.learnquest.data.QuestItem;
import es.ulpgc.eite.da.learnquest.data.QuestionMathItem;
import es.ulpgc.eite.da.learnquest.data.QuizUnitItem;

public class QuizUnitRouter implements QuizUnitContract.Router {

    public static String TAG = QuizUnitRouter.class.getSimpleName();

    private AppMediator mediator;

    public QuizUnitRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    /*@Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, QuestionActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }*/

    @Override
    public void passDataToNextScreen(QuizUnitState state) {
        mediator.setQuizUnitState(state);
    }

    /*@Override
    public QuizUnitState getDataFromPreviousScreen() {

        QuizUnitState state = mediator.getQuizUnitState();
        return state;
    }*/

    @Override
    public QuestToQuizUnitState getStateFromQuestScreen(){
        QuestToQuizUnitState state = mediator.getQuestionToQuizUnitState();
        return state;
    }

    @Override
    public void passDataToQuestionScreen(QuizUnitToQuestionState state){
        mediator.setQuizUnitToQuestionState(state);
    }

    @Override
    public void passDataToQuestionMathScreen(QuizUnitItem item) {
        mediator.setQuizUnit(item);
    }
    //// JSON //////
    @Override
    public QuestItem getDataFromQuestListScreen(){
        QuestItem quest = mediator.getQuest();
        return quest;
    }

}
