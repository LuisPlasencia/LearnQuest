package es.ulpgc.eite.da.learnquest.quests;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.da.learnquest.app.QuestToQuizUnitState;

public class QuestsPresenter implements QuestsContract.Presenter {

    public static String TAG = QuestsPresenter.class.getSimpleName();

    private WeakReference<QuestsContract.View> view;
    private QuestsState state;
    private QuestsContract.Model model;
    private QuestsContract.Router router;

    public QuestsPresenter(QuestsState state) {
        this.state = state;
    }

   /* @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // initialize the state if is necessary
        if (state == null) {
            state = new QuestsState();
        }

        // use passed state if is necessary
        QuestsState savedState = router.getDataFromPreviousScreen();
        if (savedState != null) {

            // update view and model state
            state.subject = savedState.subject;

            // update the view
            view.get().displayData(state);

            return;
        }

        // call the model
        String data = model.fetchData();

        // set view state
        state.subject = data;

        // update the view
        view.get().displayData(state);

    }*/

    @Override
    public void onRestart(){
        model.onRestartScreen(state);
    }

    @Override
    public void onResume() {

        state.mathLevel = model.getMathLevel();
        state.englishLevel = model.getEnglishLevel();
        state.geographyLevel = model.getGeographyLevel();

        state.mathPhoto = model.getMathPhoto();
        state.englishPhoto = model.getEnglishPhoto();
        state.geographyPhoto = model.getGeographyPhoto();


        // update the view
        view.get().displayData(state);
    }

    @Override
    public void onPause() {
        state.mathLevel = model.getMathLevel();
        state.englishLevel = model.getEnglishLevel();
        state.geographyLevel = model.getGeographyLevel();

        state.mathPhoto = model.getMathPhoto();
        state.englishPhoto = model.getEnglishPhoto();
        state.geographyPhoto = model.getGeographyPhoto();

    }

    @Override
    public void onSubjectButtonClicked(String subject) {
        state.subject=subject;
        QuestToQuizUnitState newState = new QuestToQuizUnitState(subject);
        router.passDataToQuizUnitScreen(newState);
        router.navigateToNextScreen();
    }
    @Override
    public void updateLevels(){
        model.setSubjectLevels();
    }
    @Override
    public void setSubjectImage(){
        model.setSubjectImage();
    }

    @Override
    public void injectView(WeakReference<QuestsContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(QuestsContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(QuestsContract.Router router) {
        this.router = router;
    }
}
