package es.ulpgc.eite.da.learnquest.quizUnit;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.eite.da.learnquest.app.AppMediator;

public class QuizUnitRouter implements QuizUnitContract.Router {

    public static String TAG = QuizUnitRouter.class.getSimpleName();

    private AppMediator mediator;

    public QuizUnitRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, QuizUnitActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(QuizUnitState state) {
        mediator.setQuizUnitState(state);
    }

    @Override
    public QuizUnitState getDataFromPreviousScreen() {
        QuizUnitState state = mediator.getQuizUnitState();
        return state;
    }
}
