package es.ulpgc.eite.da.learnquest.finalQuiz;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.eite.da.learnquest.app.AppMediator;
import es.ulpgc.eite.da.learnquest.profile.ProfileActivity;
import es.ulpgc.eite.da.learnquest.quizUnit.QuizUnitActivity;

public class FinalQuizRouter implements FinalQuizContract.Router {

    public static String TAG = FinalQuizRouter.class.getSimpleName();

    private AppMediator mediator;

    public FinalQuizRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void passStateToNextScreen(FinalQuizState state) {
        mediator.setFinalQuizState(state);
    }

    @Override
    public void navigateToQuizUnitsScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, QuizUnitActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public void navigateToProfileScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, ProfileActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
