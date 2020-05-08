package es.ulpgc.eite.da.learnquest.quests;

import android.util.Log;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.eite.da.learnquest.data.QuestItem;
import es.ulpgc.eite.da.learnquest.data.RepositoryContract;

public class QuestsModel implements QuestsContract.Model {

    public static String TAG = QuestsModel.class.getSimpleName();
    private List<QuestItem> questList;

    private RepositoryContract quizRepository;

    public QuestsModel(RepositoryContract quizRepository) {
        this.quizRepository=quizRepository;
        this.questList = new ArrayList<>();
    }

    @Override
    public void fetchQuestListData(
            final RepositoryContract.GetQuestListCallback callback) {
        Log.e(TAG, "fetchCategoryListData()");
        quizRepository.loadSubject(new RepositoryContract.FetchSubjectDataCallback() {

            @Override
            public void onSubjectDataFetched(boolean error) {
                if(!error) {
                    quizRepository.getQuestList(callback);
                }
            }
        });

    }

    @Override
    public void setSubjectID(int subjectId) {
        quizRepository.setSubjectId(subjectId);
    }

    @Override
    public List<QuestItem> fetchQuestsData() {
        return quizRepository.getQuestList();
    }

    @Override
    public void updateQuestParameters() {
        quizRepository.updateQuestParameters();
    }

}
