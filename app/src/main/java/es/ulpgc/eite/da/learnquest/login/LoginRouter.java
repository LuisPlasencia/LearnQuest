package es.ulpgc.eite.da.learnquest.login;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.eite.da.learnquest.app.AppMediator;
import es.ulpgc.eite.da.learnquest.profile.ProfileActivity;
import es.ulpgc.eite.da.learnquest.registro.RegistroActivity;

public class LoginRouter implements LoginContract.Router {

    public static String TAG = LoginRouter.class.getSimpleName();

    private AppMediator mediator;

    public LoginRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

//    @Override
//    public void navigateToProfileScreen() {
//        Context context = mediator.getApplicationContext();
//        Intent intent = new Intent(context, ProfileActivity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        context.startActivity(intent);
//    }

//    @Override
//    public void navigateToRegistroScreen() {
//        Context context = mediator.getApplicationContext();
//        Intent intent = new Intent(context, RegistroActivity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        context.startActivity(intent);
//    }

    @Override
    public void passStateToProfileScreen(LoginState state) {
        mediator.setLoginState(state);
    }



}
