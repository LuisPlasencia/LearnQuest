package es.ulpgc.eite.da.learnquest.questionGeography;

import android.util.Log;

import es.ulpgc.eite.da.learnquest.app.AppMediator;
import es.ulpgc.eite.da.learnquest.data.QuizUnit;
import es.ulpgc.eite.da.learnquest.data.QuizUnitItem;

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

    @Override
    public QuizUnitItem getDataFromQuizUnitScreen(){
        QuizUnitItem quizUnitItem = mediator.getQuizUnit();
        return quizUnitItem;
    }


}
