package es.ulpgc.eite.da.learnquest.logros;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.eite.da.learnquest.app.AppMediator;

public class LogrosRouter implements LogrosContract.Router {

    public static String TAG = LogrosRouter.class.getSimpleName();

    private AppMediator mediator;

    public LogrosRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

//    @Override
//    public void navigateToNextScreen() {
//        Context context = mediator.getApplicationContext();
//        Intent intent = new Intent(context, LogrosActivity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        context.startActivity(intent);
//    }

    @Override
    public void passStateToNextScreen(LogrosState state) {
        mediator.setLogrosState(state);
    }

//    @Override
//    public void passStateToPreviousScreen(LogrosState state) {
//        mediator.setPreviousLogrosScreenState(state);
//    }

    @Override
    public LogrosState getStateFromPreviousScreen() {
        return mediator.getLogrosState();
    }
//
//    @Override
//    public LogrosState getStateFromNextScreen() {
//        return mediator.getNextLogrosScreenState();
//    }
}
