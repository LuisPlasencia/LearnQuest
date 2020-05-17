package es.ulpgc.eite.da.learnquest.question;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.eite.da.learnquest.app.HintToQuestionState;
import es.ulpgc.eite.da.learnquest.app.QuestionToHintState;
import es.ulpgc.eite.da.learnquest.data.QuestionEnglishItem;
import es.ulpgc.eite.da.learnquest.data.QuizUnitItem;
import es.ulpgc.eite.da.learnquest.data.RepositoryContract;

public interface QuestionContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(QuestionViewModel viewModel);

        void resetReply();

        void updateReply(boolean isCorrect);

        void setOptionColorCorrect(int option);

        void setOptionColorIncorrect(int option);

        void resetOptionColor();

        void initTimer();

        void startTimer();

        void stopTimer();

        void navigateToHintScreen();

        void navigateToFinalQuizScreen();

        void navigateToQuizUnitScreen();

        void updateReplyTimeFinished();

        void alertDialogReturn();
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

        void onBackPressed();

        void onTimerFinish();

        void fetchQuestionEnglishData();
    }

    interface Model {
//        String getCurrentQuestionNumber();
//
//        String getCurrentQuestion();
//
//        String getOption1();
//
//        String getOption2();
//
//        String getOption3();

        void updateNextQuestion();

        int getQuizIndex();

        void setQuizIndex(int index);

        boolean isCorrectOption(int option);


        void updateExperienceCollected();

        void updateHalfExperienceCollected();

//        int getCorrectOption();

        void resetExperience();

        List<QuestionEnglishItem> getEnglishListData();

        int getQuizId();

        void setCorrectOption(int correctOption);
    }

    interface Router {
        //void navigateToHintScreen();

       // void navigateToFinalQuizScreen();

        void passDataToHintScreen(QuestionToHintState state);

        HintToQuestionState getDataFromHintScreen();

        QuizUnitItem getDataFromQuizUnitScreen();
    }
}
