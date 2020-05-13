package es.ulpgc.eite.da.learnquest.questionGeography;

import android.util.Log;

import es.ulpgc.eite.da.learnquest.app.AppMediator;

public class QuestionGeographyRouter implements QuestionGeographyContract.Router {

    public static String TAG = QuestionGeographyRouter.class.getSimpleName();

    private AppMediator mediator;

    public QuestionGeographyRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

//    @Override
//    public NextToQuestionGeographyState getStateFromNextScreen() {
//        return mediator.getNextQuestionGeographyScreenState();
//    }
//
//    @Override
//    public void passStateToNextScreen(QuestionGeographyToNextState state) {
//        mediator.setNextQuestionGeographyScreenState(state);
//    }
//
//    @Override
//    public void passStateToPreviousScreen(QuestionGeographyToPreviousState state) {
//        mediator.setPreviousQuestionGeographyScreenState(state);
//    }
//
//    @Override
//    public PreviousToQuestionGeographyState getStateFromPreviousScreen() {
//        return mediator.getPreviousQuestionGeographyScreenState();
//    }

}
