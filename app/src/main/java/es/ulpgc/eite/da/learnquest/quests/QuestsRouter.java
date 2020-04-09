package es.ulpgc.eite.da.learnquest.quests;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.eite.da.learnquest.app.AppMediator;
import es.ulpgc.eite.da.learnquest.quizUnit.QuizUnitActivity;

public class QuestsRouter implements QuestsContract.Router {

    public static String TAG = QuestsRouter.class.getSimpleName();

    private AppMediator mediator;

    public QuestsRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, QuizUnitActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(QuestsState state) {
        mediator.setQuestsState(state);
    }

    @Override
    public QuestsState getDataFromPreviousScreen() {
        QuestsState state = mediator.getQuestsState();
        return state;
    }
}
