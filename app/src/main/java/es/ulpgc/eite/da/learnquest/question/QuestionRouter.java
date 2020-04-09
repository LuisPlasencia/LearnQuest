package es.ulpgc.eite.da.learnquest.question;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.eite.da.learnquest.app.AppMediator;
import es.ulpgc.eite.da.learnquest.app.HintToQuestionState;
import es.ulpgc.eite.da.learnquest.app.QuestionToHintState;
import es.ulpgc.eite.da.learnquest.finalQuiz.FinalQuizActivity;
import es.ulpgc.eite.da.learnquest.hint.HintActivity;

public class QuestionRouter implements QuestionContract.Router {

    public static String TAG = QuestionRouter.class.getSimpleName();

    private AppMediator mediator;

    public QuestionRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToHintScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, HintActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public void passDataToHintScreen(QuestionToHintState state) {
        mediator.setQuestionToHintState(state);
    }

    @Override
    public HintToQuestionState getDataFromHintScreen() {
        return mediator.getHintToQuestionState();
    }

    @Override
    public void navigateToFinalQuizScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, FinalQuizActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
