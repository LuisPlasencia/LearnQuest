package es.ulpgc.eite.da.learnquest.quizUnit;

import java.lang.ref.WeakReference;

public interface QuizUnitContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(QuizUnitViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchData();
    }

    interface Model {
        String fetchData();

        String setT1Topic();
        String setT1Subtopic();
        String setT1Description();

        String setT2Topic();
        String setT2Subtopic();
        String setT2Description();
    }

    interface Router {
        void navigateToNextScreen();

        void passDataToNextScreen(QuizUnitState state);

        QuizUnitState getDataFromPreviousScreen();
    }
}
