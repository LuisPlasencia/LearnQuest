package es.ulpgc.eite.da.learnquest.questScreen;

import android.util.Log;

public class QuestScreenModel implements QuestScreenContract.Model {

    public static String TAG = QuestScreenModel.class.getSimpleName();

    public QuestScreenModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
