package es.ulpgc.eite.da.learnquest.quests;

import android.util.Log;

public class QuestsModel implements QuestsContract.Model {

    public static String TAG = QuestsModel.class.getSimpleName();

    public QuestsModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }


    @Override
    public String setMathLevel() {
        return null;
    }

    @Override
    public String setEnglishLevel() {
        return null;
    }

    @Override
    public String setGeographyLevel() {
        return null;
    }
}
