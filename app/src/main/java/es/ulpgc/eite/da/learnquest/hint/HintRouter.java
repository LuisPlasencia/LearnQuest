package es.ulpgc.eite.da.learnquest.hint;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.eite.da.learnquest.app.AppMediator;
import es.ulpgc.eite.da.learnquest.app.HintToQuestionState;
import es.ulpgc.eite.da.learnquest.app.QuestionToHintState;

public class HintRouter implements HintContract.Router {

    public static String TAG = HintRouter.class.getSimpleName();

    private AppMediator mediator;

    public HintRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void passDataToQuestiontScreen(HintToQuestionState state) {
        mediator.setHintToQuestionState(state);
    }

    @Override
    public QuestionToHintState getDataFromQuestionScreen() {
        QuestionToHintState state = mediator.getQuestionToHintState();
        return state;
    }
}
