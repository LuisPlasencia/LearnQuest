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

        void fetchData();

        void onSubjectButtonClicked(String subject);

    }

    interface Model {
        String fetchData();

        String setMathLevel();
        String setEnglishLevel();
        String setGeographyLevel();
    }

    interface Router {
        void navigateToNextScreen();

        //void passDataToNextScreen(QuestsState state);
        void passDataToQuizUnitScreen(QuestToQuizUnitState state);

        QuestsState getDataFromPreviousScreen();
    }
}
