package es.ulpgc.eite.da.learnquest.questScreen;

import java.lang.ref.WeakReference;

public interface QuestScreenContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(QuestScreenViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchData();
    }

    interface Model {
        String fetchData();
    }

    interface Router {
        void navigateToNextScreen();

        void passDataToNextScreen(QuestScreenState state);

        QuestScreenState getDataFromPreviousScreen();
    }
}
