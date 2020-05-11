package es.ulpgc.eite.da.learnquest.statistics;

import es.ulpgc.eite.da.learnquest.data.RepositoryContract;

public class StatisticsModel implements StatisticsContract.Model {

    public static String TAG = StatisticsModel.class.getSimpleName();

    private RepositoryContract repository;

    public StatisticsModel(RepositoryContract repository) {
        this.repository = repository;
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

    @Override
    public void getDatabaseUsers(RepositoryContract.GetUserListCallback callback) {
        repository.getUserList(callback);
    }
}
