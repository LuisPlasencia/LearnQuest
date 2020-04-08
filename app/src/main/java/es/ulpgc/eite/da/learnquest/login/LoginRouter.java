package es.ulpgc.eite.da.learnquest.login;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.eite.da.learnquest.app.AppMediator;

public class LoginRouter implements LoginContract.Router {

    public static String TAG = LoginRouter.class.getSimpleName();

    private AppMediator mediator;

    public LoginRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public void passStateToNextScreen(LoginState state) {
        mediator.setLoginState(state);
    }

//    @Override
//    public void passStateToPreviousScreen(LoginState state) {
//        mediator.setPreviousLoginScreenState(state);
//    }
//
//    @Override
//    public LoginState getStateFromPreviousScreen() {
//        return mediator.getPreviousLoginScreenState();
//    }
//
//    @Override
//    public LoginState getStateFromNextScreen() {
//        return mediator.getNextLoginScreenState();
//    }
}
