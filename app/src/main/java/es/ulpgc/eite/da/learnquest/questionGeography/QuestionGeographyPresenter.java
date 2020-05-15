package es.ulpgc.eite.da.learnquest.questionGeography;

import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.eite.da.learnquest.data.QuestionGeographyItem;
import es.ulpgc.eite.da.learnquest.data.QuestionMathItem;
import es.ulpgc.eite.da.learnquest.data.QuizUnitItem;
import es.ulpgc.eite.da.learnquest.data.RepositoryContract;

public class QuestionGeographyPresenter implements QuestionGeographyContract.Presenter {

    public static String TAG = QuestionGeographyPresenter.class.getSimpleName();

    private WeakReference<QuestionGeographyContract.View> view;
    private QuestionGeographyState state;
    private QuestionGeographyContract.Model model;
    private QuestionGeographyContract.Router router;

    public QuestionGeographyPresenter(QuestionGeographyState state) {
        this.state = state;
    }


    @Override
    public void fetchQuestionGeoData() {

        // call the model
        QuizUnitItem quizUnitItem = router.getDataFromQuizUnitScreen();

        if (quizUnitItem != null) {
            state.quizUnitItem = quizUnitItem;
        }

        // call the model
        model.fetchQuestionGeoListData(state.quizUnitItem,
                new RepositoryContract.GetQuestionGeoListCallback() {

                    @Override
                    public void setQuestionGeoList(List<QuestionGeographyItem> questionGeoItems) {
                        state.questionGeographyItems = questionGeoItems;
                        view.get().displayData(state);
                    }
                });
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onRestart() {
        // Log.e(TAG, "onRestart()");

        // update the model if is necessary
        model.onRestartScreen(state.data);
    }

    @Override
    public void onResume() {
    }

    @Override
    public void onBackPressed() {
        // Log.e(TAG, "onBackPressed()");
        model.resetExperience();
        view.get().navigateToQuizUnitScreen();
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
    public void injectView(WeakReference<QuestionGeographyContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(QuestionGeographyContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(QuestionGeographyContract.Router router) {
        this.router = router;
    }
}
