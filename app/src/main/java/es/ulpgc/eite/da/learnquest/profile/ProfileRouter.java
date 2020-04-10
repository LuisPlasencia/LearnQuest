package es.ulpgc.eite.da.learnquest.profile;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.eite.da.learnquest.app.AppMediator;
import es.ulpgc.eite.da.learnquest.login.LoginActivity;
import es.ulpgc.eite.da.learnquest.login.LoginState;
import es.ulpgc.eite.da.learnquest.logros.LogrosActivity;
import es.ulpgc.eite.da.learnquest.quests.QuestsActivity;

public class ProfileRouter implements ProfileContract.Router {

    public static String TAG = ProfileRouter.class.getSimpleName();

    private AppMediator mediator;

    public ProfileRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void passStateToNextScreen(ProfileState state) {
        mediator.setProfileState(state);
    }

    @Override
    public LoginState getLoginState() {
        return mediator.getLoginState();
    }

    @Override
    public void navigateToQuestsScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, QuestsActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public void navigateAchievementsScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, LogrosActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

}
