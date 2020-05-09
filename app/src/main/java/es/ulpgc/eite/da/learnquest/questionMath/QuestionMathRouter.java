package es.ulpgc.eite.da.learnquest.questionMath;

import es.ulpgc.eite.da.learnquest.app.AppMediator;
import es.ulpgc.eite.da.learnquest.data.QuestionMathItem;
import es.ulpgc.eite.da.learnquest.data.QuizUnitItem;

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

    @Override
    public QuizUnitItem getDataFromQuizUnitScreen(){
        QuizUnitItem quizUnitItem = mediator.getQuizUnit();
        return quizUnitItem;
    }

}
