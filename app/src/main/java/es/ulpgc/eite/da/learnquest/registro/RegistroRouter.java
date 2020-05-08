package es.ulpgc.eite.da.learnquest.registro;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.eite.da.learnquest.app.AppMediator;
import es.ulpgc.eite.da.learnquest.login.LoginActivity;
import es.ulpgc.eite.da.learnquest.profile.ProfileActivity;

public class RegistroRouter implements RegistroContract.Router {

    public static String TAG = RegistroRouter.class.getSimpleName();

    private AppMediator mediator;

    public RegistroRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    /*@Override
    public void navigateToLogInScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }*/
}
