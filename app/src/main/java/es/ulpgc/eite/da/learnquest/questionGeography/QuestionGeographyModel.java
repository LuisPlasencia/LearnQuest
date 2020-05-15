package es.ulpgc.eite.da.learnquest.questionGeography;

import android.util.Log;

import es.ulpgc.eite.da.learnquest.data.QuizUnitItem;
import es.ulpgc.eite.da.learnquest.data.RepositoryContract;

public class QuestionGeographyModel implements QuestionGeographyContract.Model {

    public static String TAG = QuestionGeographyModel.class.getSimpleName();

    private String data;
    private RepositoryContract quizRepository;

    public QuestionGeographyModel(RepositoryContract quizRepository) {
        this.data = data;
        this.quizRepository = quizRepository;
    }

    @Override
    public String getStoredData() {
        // Log.e(TAG, "getStoredData()");
        return data;
    }

    @Override
    public void fetchQuestionGeoListData(
            QuizUnitItem quizUnit, final RepositoryContract.GetQuestionGeoListCallback callback) {
        quizRepository.getQuestionGeoList(quizUnit,callback);

    }

    @Override
    public void onRestartScreen(String data) {
        // Log.e(TAG, "onRestartScreen()");
    }

    @Override
    public void onDataFromNextScreen(String data) {
        // Log.e(TAG, "onDataFromNextScreen()");
    }

    @Override
    public void onDataFromPreviousScreen(String data) {
        // Log.e(TAG, "onDataFromPreviousScreen()");
    }
}
