package es.ulpgc.eite.da.learnquest.questionMath;

import android.util.Log;
import android.widget.Button;

import java.lang.ref.WeakReference;

public class QuestionMathPresenter implements QuestionMathContract.Presenter {

    public static String TAG = QuestionMathPresenter.class.getSimpleName();

    private WeakReference<QuestionMathContract.View> view;
    private QuestionMathState state;
    private QuestionMathContract.Model model;
    private QuestionMathContract.Router router;
    private int digit;

    public QuestionMathPresenter(QuestionMathState state) {
        this.state = state;
    }


    @Override
    public void fetchData() {
        if(state == null) {
            state = new QuestionMathState();
        }
        view.get().displayData(state);

    }
    @Override
    public void onStart() {

        state.mathQuestionNumber = "200";
        state.mathQuestionText = "Texto de prueba";

        //view.get().resetReply();

        state.mathNextEnabled = false;
        state.mathEnterEnabled = true;

        disableNextButton();
        view.get().displayData(state);


    }

    @Override
    public void onRestart() {
        model.setQuizIndex(state.quizIndex);

    }

    @Override
    public void onResume() {


    }

    private void disableNextButton(){
        state.mathNumbersEnabled = true;
        state.mathHintEnabled = true;
        state.mathNextEnabled = false;
    }

    private void enableNextButton() {
        state.mathNextEnabled = true;
        state.mathHintEnabled = false;
    }




    @Override
    public void onBackPressed() {
        // Log.e(TAG, "onBackPressed()");
    }

    @Override
    public void onPause() {
        // Log.e(TAG, "onPause()");
    }

    @Override
    public void onDestroy() {
        // Log.e(TAG, "onDestroy()");
    }

    @Override
    public void onNumberClicked() {
    }


    @Override
    public void injectView(WeakReference<QuestionMathContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(QuestionMathContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(QuestionMathContract.Router router) {
        this.router = router;
    }
}
