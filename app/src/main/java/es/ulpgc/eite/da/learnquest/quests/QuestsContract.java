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

        void setSubjectImage();


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

        //int getPhoto();
        //void setPhoto(int photo);

        int getMathPhoto();
        int getEnglishPhoto();
        int getGeographyPhoto();

        void setMathPhoto(int mathPhoto);
        void setEnglishPhoto(int englishPhoto);
        void setGeographyPhoto(int geographyPhoto);

        void setSubjectImage();

        void onRestartScreen(QuestsState data);

        void setSubjectID(int subjectID);
    }

    interface Router {
        void navigateToNextScreen();

        //void passDataToNextScreen(QuestsState state);
        void passDataToQuizUnitScreen(QuestToQuizUnitState state);

        QuestsState getDataFromPreviousScreen();
    }
}

