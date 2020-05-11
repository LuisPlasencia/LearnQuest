package es.ulpgc.eite.da.learnquest.statistics;

import es.ulpgc.eite.da.learnquest.app.AppMediator;

public class StatisticsRouter implements StatisticsContract.Router {

    public static String TAG = StatisticsRouter.class.getSimpleName();

    private AppMediator mediator;

    public StatisticsRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

//    @Override
//    public void navigateToNextScreen() {
//        Context context = mediator.getApplicationContext();
//        Intent intent = new Intent(context, LogrosActivity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        context.startActivity(intent);
//    }

    @Override
    public void passStateToNextScreen(StatisticsState state) {
        mediator.setLogrosState(state);
    }

//    @Override
//    public void passStateToPreviousScreen(LogrosState state) {
//        mediator.setPreviousLogrosScreenState(state);
//    }

    @Override
    public StatisticsState getStateFromPreviousScreen() {
        return mediator.getLogrosState();
    }
//
//    @Override
//    public LogrosState getStateFromNextScreen() {
//        return mediator.getNextLogrosScreenState();
//    }
}
