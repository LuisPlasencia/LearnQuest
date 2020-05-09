package es.ulpgc.eite.da.learnquest.quizUnit;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.eite.da.learnquest.data.QuestItem;
import es.ulpgc.eite.da.learnquest.data.QuizUnit;
import es.ulpgc.eite.da.learnquest.data.QuizUnitItem;
import es.ulpgc.eite.da.learnquest.data.RepositoryContract;

public class QuizUnitModel implements QuizUnitContract.Model {

    public static String TAG = QuizUnitModel.class.getSimpleName();

    private RepositoryContract quizRepository;


    private List<QuizUnitItem> quizUnitItems;

    public QuizUnitModel(RepositoryContract quizRepository) {
        this.quizRepository=quizRepository;
        this.quizUnitItems = new ArrayList<>();
    }

    @Override
    public void fetchQuizUnitListData(
            QuestItem quest, RepositoryContract.GetQuizUnitListCallback callback) {

        Log.e(TAG, "fetchProductListData()");
        quizRepository.getQuizUnitList(quest, callback);
    }

    @Override
    public int getSubjectId(){
        return quizRepository.getSubjectId();
    }



    @Override
    public void setSubject(String subject) {
        quizRepository.setSubjectId(0);
    }

    @Override
    public void setQuizId(int quizId) {
        quizRepository.setQuizId(quizId);
    }

    @Override
    public List<QuizUnitItem> fetchQuizUnitData(){
        return quizRepository.getQuizUnits();
    }

}
