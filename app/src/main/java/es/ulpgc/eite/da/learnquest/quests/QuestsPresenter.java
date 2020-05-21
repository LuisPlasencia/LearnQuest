package es.ulpgc.eite.da.learnquest.quests;

import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.eite.da.learnquest.data.QuestItem;
import es.ulpgc.eite.da.learnquest.data.RepositoryContract;

public class QuestsPresenter implements QuestsContract.Presenter {

    public static String TAG = QuestsPresenter.class.getSimpleName();

    private WeakReference<QuestsContract.View> view;
    private QuestsState state;
    private QuestsContract.Model model;
    private QuestsContract.Router router;

    public QuestsPresenter(QuestsState state) {
        this.state = state;
    }

    @Override
    public void fetchQuestsData() {
        // call the model

      model.fetchQuestListData(new RepositoryContract.GetQuestListCallback() {
            @Override
            public void setQuestList(List<QuestItem> questList) {
                state.questItems = questList;
                state.user = model.getUser();
                view.get().displayData(state);
            }
        });

    }

//
//    @Override
//    public void onRestart(){
//        model.onRestartScreen(state);
//    }
//
//    @Override
//    public void onResume() {
//
//        state.mathLevel = model.getMathLevel();
//        state.englishLevel = model.getEnglishLevel();
//        state.geographyLevel = model.getGeographyLevel();
//
//        state.mathPhoto = model.getMathPhoto();
//        state.englishPhoto = model.getEnglishPhoto();
//        state.geographyPhoto = model.getGeographyPhoto();
//
//        // update the view
//        view.get().displayData(state);
//    }
//
//    @Override
//    public void onPause() {
//        state.mathLevel = model.getMathLevel();
//        state.englishLevel = model.getEnglishLevel();
//        state.geographyLevel = model.getGeographyLevel();
//
//        state.mathPhoto = model.getMathPhoto();
//        state.englishPhoto = model.getEnglishPhoto();
//        state.geographyPhoto = model.getGeographyPhoto();
//    }

//    @Override
//    public void onSubjectButtonClicked(String subject) {
//        state.subject=subject;
//        if (state.subject.equals("Maths")){      //cambiamos el id del repositorio para que finalQuiz reconozca la asignatura
//            model.setSubjectID(1);
//        } else if(state.subject.equals("English")){
//            model.setSubjectID(2);
//        } else if (state.subject.equals("Geography")) {
//            model.setSubjectID(3);
//        }
//        QuestToQuizUnitState newState = new QuestToQuizUnitState(subject);
//        router.passDataToQuizUnitScreen(newState);
//        router.navigateToNextScreen();
//    }

    @Override
    public void selectQuestData(QuestItem item) {
        state.subject = item.getSubject();
        state.subjectId = item.getId();
        Log.d("hola", String.valueOf(state.subjectId));
        model.setSubjectID(state.subjectId);
        router.passDataToQuizUnitScreen(item);
       // router.navigateToQuizUnitScreen();
        view.get().navigateToQuizUnitScreen();
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
