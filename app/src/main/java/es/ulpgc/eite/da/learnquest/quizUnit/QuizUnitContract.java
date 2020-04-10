package es.ulpgc.eite.da.learnquest.quizUnit;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.da.learnquest.app.QuestToQuizUnitState;
import es.ulpgc.eite.da.learnquest.app.QuizUnitToQuestionState;

public interface QuizUnitContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(QuizUnitViewModel viewModel);

    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

       // void fetchData();

        void setSubject();

        void setT1Items();

        //String getT1Items();

        void onStart();

        void onRestart();

        void onResume();

        void onPause();

        void onOptionClicked(String option);

    }

    interface Model {
        //String fetchData();
        void onRestartScreen(QuizUnitState data);
        void setT1Fields();
        void setT1Topic(String T1Topic);
        void setT1SubTopic(String T1SubTopic);
        void setT1Description(String T1Description);

        void setSubject(String subject);

        String getT1Topic();
        String getT1SubTopic();
        String getT1Description();

        void setT2Topic(String T2Topic);
        void setT2SubTopic(String T2SubTopic);
        void setT2Description(String T2Description);

        String getT2Topic();
        String getT2SubTopic();
        String getT2Description();




    }
    interface Router {
        void navigateToNextScreen();

        void passDataToNextScreen(QuizUnitState state);

        //QuizUnitState getDataFromPreviousScreen();

        QuestToQuizUnitState getStateFromQuestScreen();

        void passDataToQuestionScreen(QuizUnitToQuestionState state);
    }
}
