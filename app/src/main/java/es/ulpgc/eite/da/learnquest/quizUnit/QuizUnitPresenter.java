package es.ulpgc.eite.da.learnquest.quizUnit;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.da.learnquest.R;
import es.ulpgc.eite.da.learnquest.app.QuestToQuizUnitState;

public class QuizUnitPresenter implements QuizUnitContract.Presenter {

    public static String TAG = QuizUnitPresenter.class.getSimpleName();

    private WeakReference<QuizUnitContract.View> view;
    private QuizUnitState state;
    private QuizUnitContract.Model model;
    private QuizUnitContract.Router router;

    public QuizUnitPresenter(QuizUnitState state) {
        this.state = state;
    }

    @Override
    public void onStart() {
        if (state == null) {
            state = new QuizUnitState();
        }
    }

    @Override
    public void onRestart() {
        model.onRestartScreen(state);
    }

    @Override
    public void onResume() {
        QuestToQuizUnitState savedState = router.getStateFromQuestScreen();

        /*if (savedState != null) {
            model.setSubject(savedState.subject);
        }*/

        state.t1Topic = model.getT1Topic();
        state.t1SubTopic = model.getT1SubTopic();
        state.t1Description = model.getT1Description();


        // update the view
        view.get().displayData(state);
    }

    @Override
    public void onPause() {
        state.t1Topic = model.getT1Topic();
        state.t1SubTopic = model.getT1SubTopic();
        state.t1Description = model.getT1Description();
    }

   /* @Override
    public String getSubject() {
        QuestToQuizUnitState savedState = router.getStateFromQuestScreen();
        if(savedState.subject.equals("Maths")){
            return "Maths";
        } else if(savedState.subject.equals("English")){
            return "English";
        }
        return "Geography";
    }*/

    @Override
    public void setT1Items() {

        QuestToQuizUnitState savedState = router.getStateFromQuestScreen();

       if (savedState.subject.equals("Maths")) {
            model.setT1Topic("AAAAAAAAAAAAA");
            model.setT1SubTopic("BBBBBBB");
            model.setT1Description("CCCCCCCCCC");
            view.get().displayData(state);
        } else if (savedState.subject.equals("English")) {
            model.setT1Topic("222222222222222");
            model.setT1SubTopic("333333333333333");
            model.setT1Description("11111111111111");
        }else{
            model.setT1Topic("$$$$$$$$$$$$$$$");
            model.setT1SubTopic("%%%%%%%%%%%%%");
            model.setT1Description("············");
        }
    }

    /*@Override
    public String getT1Items() {
        return model.getT1Topic();
    }*/

    @Override
    public void injectView(WeakReference<QuizUnitContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(QuizUnitContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(QuizUnitContract.Router router) {
        this.router = router;
    }
}
