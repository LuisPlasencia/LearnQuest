package es.ulpgc.eite.da.learnquest.question;

import android.util.Log;

public class QuestionModel implements QuestionContract.Model {

    public static String TAG = QuestionModel.class.getSimpleName();

    public QuestionModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
