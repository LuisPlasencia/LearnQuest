package es.ulpgc.eite.da.learnquest.hint;

import android.util.Log;

import es.ulpgc.eite.da.learnquest.data.RepositoryContract;

public class HintModel implements HintContract.Model {

    public static String TAG = HintModel.class.getSimpleName();

    private int quizIndex;
    private RepositoryContract repository;

    public HintModel(RepositoryContract quizRepository) {
        this.repository = quizRepository;
    }

    @Override
    public String fetchQuestionHint() {
        return repository.getQuestion(quizIndex).getHint();
    }

    @Override
    public void setQuizIndex(int quizIndex) {
        this.quizIndex = quizIndex;
    }
}
