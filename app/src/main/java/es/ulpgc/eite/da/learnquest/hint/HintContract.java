package es.ulpgc.eite.da.learnquest.hint;

import java.lang.ref.WeakReference;

public interface HintContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(HintViewModel viewModel);
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

        void passDataToNextScreen(HintState state);

        HintState getDataFromPreviousScreen();
    }
}
