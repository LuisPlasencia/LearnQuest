package es.ulpgc.eite.da.learnquest.hint;

import android.util.Log;

import es.ulpgc.eite.da.learnquest.data.RepositoryContract;

public class HintModel implements HintContract.Model {

    public static String TAG = HintModel.class.getSimpleName();

    private String quizHint;
    private RepositoryContract repository;

    public HintModel(RepositoryContract quizRepository) {
        this.repository = quizRepository;
    }


    @Override
    public void setQuizHint(String hint) {
        this.quizHint = hint;
    }

    @Override
    public String getHint(){
        return this.quizHint;
    }
}
