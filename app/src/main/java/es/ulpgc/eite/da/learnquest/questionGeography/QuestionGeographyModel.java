package es.ulpgc.eite.da.learnquest.questionGeography;

import android.util.Log;

import java.util.List;

import es.ulpgc.eite.da.learnquest.data.QuestionGeographyItem;
import es.ulpgc.eite.da.learnquest.data.QuizUnitItem;
import es.ulpgc.eite.da.learnquest.data.RepositoryContract;

public class QuestionGeographyModel implements QuestionGeographyContract.Model {

    public static String TAG = QuestionGeographyModel.class.getSimpleName();

    private int quizIndex;
    private String data;
    private RepositoryContract quizRepository;

    public QuestionGeographyModel(RepositoryContract quizRepository) {
        this.data = data;
        quizIndex = 0;
        this.quizRepository = quizRepository;
    }

    @Override
    public String getStoredData() {
        // Log.e(TAG, "getStoredData()");
        return data;
    }


    @Override
    public void updateNextQuestion(){
        quizIndex++;
    }

    @Override
    public int getQuizIndex(){
        return quizIndex;
    }

    @Override
    public void setQuizIndex(int index) {
        this.quizIndex = index;
    }
    @Override
    public boolean isQuizFinished() {
        return (quizIndex == 4);
    }

    @Override
    public String getCurrentQuestionNumber() {
        int tempQuizIndex = quizIndex+1;
        return "Question " + tempQuizIndex;
    }

    @Override
    public void updateExperienceCollected() {
        quizRepository.updateExperienceCollected();
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

    @Override
    public void resetExperience(){
        quizRepository.resetExperienceCollected();
    }

    @Override
    public List<QuestionGeographyItem> getGeographyListData() {
        return quizRepository.loadQuestionGeography();
    }
}
