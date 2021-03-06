package es.ulpgc.eite.da.learnquest.question;

import java.util.List;

import es.ulpgc.eite.da.learnquest.data.QuestionEnglishItem;
import es.ulpgc.eite.da.learnquest.data.QuizUnitItem;
import es.ulpgc.eite.da.learnquest.data.RepositoryContract;

public class QuestionModel implements QuestionContract.Model {

    public static String TAG = QuestionModel.class.getSimpleName();

    private int quizIndex;
    private int correctOption;
    private RepositoryContract quizRepository;

    public QuestionModel(RepositoryContract quizRepository) {
        quizIndex = 0;
        this.quizRepository = quizRepository;
    }

    @Override
    public void updateNextQuestion() {
        quizIndex++;
    }


    @Override
    public int getQuizIndex() {
        return quizIndex;
    }

    @Override
    public void setQuizIndex(int index) {
        this.quizIndex = index;
    }

    @Override
    public boolean isCorrectOption(int option) {
        if(option == correctOption){
            return true;
        } else{
            return false;
        }
    }
//
//    @Override
//    public int getCorrectOption() {
//        return quizRepository.getQuestion(quizIndex).getCorrectOption();
//    }
//
//    @Override
//    public String getCurrentQuestionNumber() {
//        return "Question " + quizRepository.getQuestion(quizIndex).getId();
//    }
//
//    @Override
//    public String getCurrentQuestion() {
//        return quizRepository.getQuestion(quizIndex).getQuestion();
//    }
//
//    @Override
//    public String getOption1() {
//        return quizRepository.getQuestion(quizIndex).getOption1();
//    }
//
//    @Override
//    public String getOption2() {
//        return quizRepository.getQuestion(quizIndex).getOption2();
//    }
//
//    @Override
//    public String getOption3() {
//        return quizRepository.getQuestion(quizIndex).getOption3();
//    }

    @Override
    public void updateExperienceCollected() {
        quizRepository.updateExperienceCollected();
    }

    @Override
    public void updateHalfExperienceCollected() {
        quizRepository.updateHalfExperienceCollected();
    }

    @Override
    public void resetExperience(){
        quizRepository.resetExperienceCollected();
    }

    @Override
    public List<QuestionEnglishItem> getEnglishListData() {
        return quizRepository.loadQuestionEnglish();

    }

    @Override
    public int getQuizId(){
        return quizRepository.getQuizId();
    }

    @Override
    public void setCorrectOption(int correctOption){
        this.correctOption = correctOption;
    }


}
