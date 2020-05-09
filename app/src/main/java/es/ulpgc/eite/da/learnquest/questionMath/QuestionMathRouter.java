package es.ulpgc.eite.da.learnquest.questionMath;

import android.util.Log;

import es.ulpgc.eite.da.learnquest.app.AppMediator;

public class QuestionMathRouter implements QuestionMathContract.Router {

    public static String TAG = QuestionMathRouter.class.getSimpleName();

    private AppMediator mediator;

    public QuestionMathRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

   /* @Override
    public NextToQuestionMathState getStateFromNextScreen() {
        return mediator.getNextQuestionMathScreenState();
    }

    @Override
    public void passStateToNextScreen(QuestionMathToNextState state) {
        mediator.setNextQuestionMathScreenState(state);
    }

    @Override
    public void passStateToPreviousScreen(QuestionMathToPreviousState state) {
        mediator.setPreviousQuestionMathScreenState(state);
    }

    @Override
    public PreviousToQuestionMathState getStateFromPreviousScreen() {
        return mediator.getPreviousQuestionMathScreenState();
    }*/

}
