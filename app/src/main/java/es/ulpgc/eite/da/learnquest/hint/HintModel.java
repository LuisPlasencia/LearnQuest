package es.ulpgc.eite.da.learnquest.hint;

import android.util.Log;

public class HintModel implements HintContract.Model {

    public static String TAG = HintModel.class.getSimpleName();

    public HintModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
