package es.ulpgc.eite.da.learnquest.questionMath;

import android.util.Log;

import java.util.List;

import es.ulpgc.eite.da.learnquest.data.QuestionMathItem;
import es.ulpgc.eite.da.learnquest.data.QuizUnitItem;
import es.ulpgc.eite.da.learnquest.data.RepositoryContract;

public class QuestionMathModel implements QuestionMathContract.Model {

    public static String TAG = QuestionMathModel.class.getSimpleName();

   private int quizIndex;
   private int solutionIndex;
   private RepositoryContract quizRepository;

    public QuestionMathModel(RepositoryContract quizRepository) {
       quizIndex = 0;
       solutionIndex=0;
       this.quizRepository = quizRepository;
    }


    @Override
    public void updateNextQuestion(){
        quizIndex++;
    }

    @Override
    public void updateSolutionIndex(){
        solutionIndex++;
    }

    @Override
    public int getQuizIndex(){
        return quizIndex;
    }

    @Override
    public int getSolutionIndex(){
        return solutionIndex;
    }

    @Override
    public boolean isQuizFinished() {
        return (quizIndex == 4);
    }

    @Override
    public void setQuizIndex(int index) {
        this.quizIndex = index;
    }

    @Override
    public void setSolutionIndex(int index) {
        this.solutionIndex = index;
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
    public String getCurrentQuestionNumber() {
        int tempQuizIndex = quizIndex+1;
        return "Question " + tempQuizIndex;
    }

    @Override
    public void updateExperienceCollected() {
        quizRepository.updateExperienceCollected();
    }

    @Override
    public boolean getAnswer(){
       return false;
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

    @Override
    public void resetExperience(){
        quizRepository.resetExperienceCollected();
    }

    @Override
    public List<QuestionMathItem> getMathsListData() {
        return quizRepository.loadQuestionMaths();
    }


}
