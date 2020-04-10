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
        state.t2Topic = model.getT2Topic();
        state.t2SubTopic = model.getT2SubTopic();
        state.t2Description = model.getT2Description();
        // update the view
        view.get().displayData(state);
    }

    @Override
    public void onPause() {
        state.t1Topic = model.getT1Topic();
        state.t1SubTopic = model.getT1SubTopic();
        state.t1Description = model.getT1Description();
        state.t2Topic = model.getT2Topic();
        state.t2SubTopic = model.getT2SubTopic();
        state.t2Description = model.getT2Description();

    }

    @Override
    public void setSubject() {
        QuestToQuizUnitState savedState = router.getStateFromQuestScreen();
        String subject = savedState.subject;
        model.setSubject(subject);
    }

    @Override
    public void setT1Items() {
        setSubject();
        model.setT1Fields();

    }

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
