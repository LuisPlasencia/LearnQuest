package es.ulpgc.eite.da.learnquest.profile;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.eite.da.learnquest.app.AppMediator;
import es.ulpgc.eite.da.learnquest.quests.QuestsActivity;

public class ProfileRouter implements ProfileContract.Router {

    public static String TAG = ProfileRouter.class.getSimpleName();

    private AppMediator mediator;

    public ProfileRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, QuestsActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public void passStateToNextScreen(ProfileState state) {
        mediator.setProfileState(state);
    }

//    @Override
//    public void passStateToPreviousScreen(PerfilState state) {
//        mediator.setPreviousPerfilScreenState(state);
//    }

    @Override
    public ProfileState getStateFromPreviousScreen() {
        return mediator.getProfileState();
    }

//    @Override
//    public PerfilState getStateFromNextScreen() {
//        return mediator.getNextPerfilScreenState();
//    }
}
