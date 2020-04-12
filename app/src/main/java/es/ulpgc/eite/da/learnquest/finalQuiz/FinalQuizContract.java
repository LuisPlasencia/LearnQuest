package es.ulpgc.eite.da.learnquest.finalQuiz;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.da.learnquest.data.User;

public interface FinalQuizContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayFinalQuizData(FinalQuizViewModel viewModel);

        void finishView();
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void onResume();

        void onStart();

        void onBackPressed();

        void onReturnClicked();

        int getMedalPhoto();
    }

    interface Model {
        User getUserActual();

        Integer getStoredExperience();

        void addExperience();

        Integer getLevel();

        Integer getSubLevel();

        int getMedalImage();

        int getExperienceNeeded();

        int getQuizId();

        void resetQuizId();

        int getSubjectId();

        void resetSubjectId();
    }

    interface Router {

        void passStateToNextScreen(FinalQuizState state);

        void navigateToQuizUnitsScreen();

        void navigateToProfileScreen();


    }
}
