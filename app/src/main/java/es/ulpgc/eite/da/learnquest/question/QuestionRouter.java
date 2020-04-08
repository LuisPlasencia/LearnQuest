package es.ulpgc.eite.da.learnquest.question;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.eite.da.learnquest.app.AppMediator;

public class QuestionRouter implements QuestionContract.Router {

    public static String TAG = QuestionRouter.class.getSimpleName();

    private AppMediator mediator;

    public QuestionRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, QuestionActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(QuestionState state) {
        mediator.setQuestionState(state);
    }

    @Override
    public QuestionState getDataFromPreviousScreen() {
        QuestionState state = mediator.getQuestionState();
        return state;
    }
}
