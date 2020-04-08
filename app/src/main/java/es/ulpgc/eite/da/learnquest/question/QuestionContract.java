package es.ulpgc.eite.da.learnquest.question;

import java.lang.ref.WeakReference;

public interface QuestionContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(QuestionViewModel viewModel);
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

        void passDataToNextScreen(QuestionState state);

        QuestionState getDataFromPreviousScreen();
    }
}
