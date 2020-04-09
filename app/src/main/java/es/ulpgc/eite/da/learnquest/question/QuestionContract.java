package es.ulpgc.eite.da.learnquest.question;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.da.learnquest.app.HintToQuestionState;
import es.ulpgc.eite.da.learnquest.app.QuestionToHintState;

public interface QuestionContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(QuestionViewModel viewModel);

        void resetReply();

        void updateReply(boolean isCorrect);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchData();

        void onStart();

        void onRestart();

        void onResume();

        void onOptionButtonClicked(int option);

        void onHintButtonClicked();

        void onNextButtonClicked();
    }

    interface Model {
        String getCurrentQuestionNumber();

        String getCurrentQuestion();

        String getOption1();

        String getOption2();

        String getOption3();

        void updateNextQuestion();

        int getQuizIndex();

        void setQuizIndex(int index);

        boolean isCorrectOption(int option);

        boolean isQuizFinished();
    }

    interface Router {
        void navigateToHintScreen();

        void navigateToFinalQuizScreen();

        void passDataToHintScreen(QuestionToHintState state);

        HintToQuestionState getDataFromHintScreen();
    }
}
