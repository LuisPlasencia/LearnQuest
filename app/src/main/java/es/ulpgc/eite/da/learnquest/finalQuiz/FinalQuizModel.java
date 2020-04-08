package es.ulpgc.eite.da.learnquest.finalQuiz;

import android.util.Log;

public class FinalQuizModel implements FinalQuizContract.Model {

    public static String TAG = FinalQuizModel.class.getSimpleName();

    private String data;

    public FinalQuizModel(String data) {
        this.data = data;
    }

    @Override
    public String getStoredData() {
        // Log.e(TAG, "getStoredData()");
        return data;
    }

    @Override
    public void onRestartScreen(String data) {
        // Log.e(TAG, "onRestartScreen()");
    }

    @Override
    public void onDataFromNextScreen(String data) {
        // Log.e(TAG, "onDataFromNextScreen()");
    }

    @Override
    public void onDataFromPreviousScreen(String data) {
        // Log.e(TAG, "onDataFromPreviousScreen()");
    }
}
