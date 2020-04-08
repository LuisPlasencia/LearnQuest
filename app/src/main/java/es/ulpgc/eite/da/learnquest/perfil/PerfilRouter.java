package es.ulpgc.eite.da.learnquest.perfil;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.eite.da.learnquest.app.AppMediator;

public class PerfilRouter implements PerfilContract.Router {

    public static String TAG = PerfilRouter.class.getSimpleName();

    private AppMediator mediator;

    public PerfilRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, PerfilActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public void passStateToNextScreen(PerfilState state) {
        mediator.setPerfilState(state);
    }

//    @Override
//    public void passStateToPreviousScreen(PerfilState state) {
//        mediator.setPreviousPerfilScreenState(state);
//    }

    @Override
    public PerfilState getStateFromPreviousScreen() {
        return mediator.getPerfilState();
    }

//    @Override
//    public PerfilState getStateFromNextScreen() {
//        return mediator.getNextPerfilScreenState();
//    }
}
