package es.ulpgc.eite.da.learnquest.questionMath;

import android.util.Log;

import es.ulpgc.eite.da.learnquest.data.QuizUnitItem;
import es.ulpgc.eite.da.learnquest.data.RepositoryContract;

public class QuestionMathModel implements QuestionMathContract.Model {

    public static String TAG = QuestionMathModel.class.getSimpleName();

   private int quizIndex;
   private RepositoryContract quizRepository;

    public QuestionMathModel(RepositoryContract quizRepository) {
       quizIndex = 0;
       this.quizRepository = quizRepository;
    }

   // @Override
    //public void fetchQuestionMathListData(
      //      QuizUnitItem quizUnit, final RepositoryContract.GetQuestionMathListCallback callback) {
        //quizRepository.getQuestionMathList(quizUnit,callback);

    //}

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
    public boolean isCorrectOption(int option) {
        int quizCorrectOption = quizRepository.getQuestion(quizIndex).getCorrectOption();
        if(option == quizCorrectOption) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getStoredData() {
        // Log.e(TAG, "getStoredData()");
        return null;
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
