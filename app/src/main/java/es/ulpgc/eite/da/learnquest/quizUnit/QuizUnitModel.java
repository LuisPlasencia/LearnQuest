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

    @Override
    public String setT1Topic() {
        return null;
    }

    @Override
    public String setT1Subtopic() {
        return null;
    }

    @Override
    public String setT1Description() {
        return null;
    }

    @Override
    public String setT2Topic() {
        return null;
    }

    @Override
    public String setT2Subtopic() {
        return null;
    }

    @Override
    public String setT2Description() {
        return null;
    }
}
