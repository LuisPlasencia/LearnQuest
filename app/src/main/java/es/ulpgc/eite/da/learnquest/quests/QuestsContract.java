package es.ulpgc.eite.da.learnquest.quests;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.da.learnquest.app.QuestToQuizUnitState;

public interface QuestsContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(QuestsViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

       // void fetchData();

        void onSubjectButtonClicked(String subject);

        void onResume();

        void onPause();

        void updateLevels();

        void onRestart();



    }

    interface Model {
        String fetchData();

        String getMathLevel();
        String getEnglishLevel();
        String getGeographyLevel();

        void setMathLevel(String mathLevel);
        void setEnglishLevel(String englishLevel);
        void setGeographyLevel(String geographyLevel);

        void setSubjectLevels();

        void onRestartScreen(QuestsState data);
    }

    interface Router {
        void navigateToNextScreen();

        //void passDataToNextScreen(QuestsState state);
        void passDataToQuizUnitScreen(QuestToQuizUnitState state);

        QuestsState getDataFromPreviousScreen();
    }
}
