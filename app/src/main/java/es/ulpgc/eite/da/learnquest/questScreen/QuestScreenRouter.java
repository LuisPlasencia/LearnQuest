package es.ulpgc.eite.da.learnquest.questScreen;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.eite.da.learnquest.app.AppMediator;

public class QuestScreenRouter implements QuestScreenContract.Router {

    public static String TAG = QuestScreenRouter.class.getSimpleName();

    private AppMediator mediator;

    public QuestScreenRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, QuestScreenActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(QuestScreenState state) {
        mediator.setQuestScreenState(state);
    }

    @Override
    public QuestScreenState getDataFromPreviousScreen() {
        QuestScreenState state = mediator.getQuestScreenState();
        return state;
    }
}
