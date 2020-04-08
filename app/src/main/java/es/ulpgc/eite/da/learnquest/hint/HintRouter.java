package es.ulpgc.eite.da.learnquest.hint;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.eite.da.learnquest.app.AppMediator;

public class HintRouter implements HintContract.Router {

    public static String TAG = HintRouter.class.getSimpleName();

    private AppMediator mediator;

    public HintRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, HintActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(HintState state) {
        mediator.setHintState(state);
    }

    @Override
    public HintState getDataFromPreviousScreen() {
        HintState state = mediator.getHintState();
        return state;
    }
}
