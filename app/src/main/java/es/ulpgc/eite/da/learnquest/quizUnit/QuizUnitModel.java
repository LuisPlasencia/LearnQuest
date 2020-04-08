package es.ulpgc.eite.da.learnquest.quizUnit;

import android.util.Log;

public class QuizUnitModel implements QuizUnitContract.Model {

    public static String TAG = QuizUnitModel.class.getSimpleName();

    public QuizUnitModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
