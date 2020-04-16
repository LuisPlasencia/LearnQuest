package es.ulpgc.eite.da.learnquest.quests;

import android.content.Context;
import android.content.Intent;

import es.ulpgc.eite.da.learnquest.app.AppMediator;
import es.ulpgc.eite.da.learnquest.app.QuestToQuizUnitState;
import es.ulpgc.eite.da.learnquest.data.QuestItem;
import es.ulpgc.eite.da.learnquest.quizUnit.QuizUnitActivity;

public class QuestsRouter implements QuestsContract.Router {

    public static String TAG = QuestsRouter.class.getSimpleName();

    private AppMediator mediator;

    public QuestsRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToQuizUnitScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, QuizUnitActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    /*@Override
    public void passDataToNextScreen(QuestsState state) {
        mediator.setQuestsState(state);
    }*/
    @Override
    public void passDataToQuizUnitScreen(QuestItem item){
        mediator.setQuestItem(item);
    }

    @Override
    public QuestsState getDataFromPreviousScreen() {
        QuestsState state = mediator.getQuestsState();
        return state;
    }
}
