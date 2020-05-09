package es.ulpgc.eite.da.learnquest.questionMath;

import java.lang.ref.WeakReference;

public interface QuestionMathContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void resetReply();

        void displayData(QuestionMathViewModel viewModel);

        void updateReply(boolean isCorrect);

        void navigateToNextScreen();
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void onResume();

        void fetchData();

        void onStart();

        void onRestart();

        void onBackPressed();

        void onPause();

        void onDestroy();

        void onNumberClicked();
    }

    interface Model {
        void updateNextQuestion();

        int getQuizIndex();

        void setQuizIndex(int index);

        boolean isCorrectOption(int option);

        String getStoredData();

        void onDataFromNextScreen(String data);

        void onRestartScreen(String data);

        void onDataFromPreviousScreen(String data);

        String getNumber1();
    }

    interface Router {

        //NextToQuestionMathState getStateFromNextScreen();

        //void passStateToNextScreen(QuestionMathToNextState state);

       //void passStateToPreviousScreen(QuestionMathToPreviousState state);

        //PreviousToQuestionMathState getStateFromPreviousScreen();
    }
}
