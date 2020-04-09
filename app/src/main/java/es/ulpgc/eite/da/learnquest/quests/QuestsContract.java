package es.ulpgc.eite.da.learnquest.quests;

import java.lang.ref.WeakReference;

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

        void onMathButtonClicked();
    }

    interface Model {
        String fetchData();
    }

    interface Router {
        void navigateToNextScreen();

        void passDataToNextScreen(QuestsState state);

        QuestsState getDataFromPreviousScreen();
    }
}
