package es.ulpgc.eite.da.learnquest.finalQuiz;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.eite.da.learnquest.app.AppMediator;

public class FinalQuizRouter implements FinalQuizContract.Router {

    public static String TAG = FinalQuizRouter.class.getSimpleName();

    private AppMediator mediator;

    public FinalQuizRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, FinalQuizActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public void passStateToNextScreen(FinalQuizState state) {
        mediator.setFinalQuizState(state);
    }

//    @Override
//    public void passStateToPreviousScreen(FinalQuizState state) {
//        mediator.setPreviousFinalQuizScreenState(state);
//    }

    @Override
    public FinalQuizState getStateFromPreviousScreen() {
        return mediator.getFinalQuizState();
    }

//    @Override
//    public FinalQuizState getStateFromNextScreen() {
//        return mediator.getNextFinalQuizScreenState();
//    }
}
