package es.ulpgc.eite.da.learnquest.finalQuiz;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.da.learnquest.data.RepositoryContract;
import es.ulpgc.eite.da.learnquest.data.User;

public interface FinalQuizContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayFinalQuizData(FinalQuizViewModel viewModel);

        void navigateToQuizUnitsScreen();

        void navigateToProfileScreen();

        void finishView();

        void sendEmail(User usuario, int quizId, int subjectId, int score);
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

        void sendEmail();
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

        void updateUser(RepositoryContract.UpdateUserCallback callback);
    }

    interface Router {

        void passStateToNextScreen(FinalQuizState state);

     //   void navigateToQuizUnitsScreen();

     //   void navigateToProfileScreen();


    }
}
