package es.ulpgc.eite.da.learnquest.quizUnit;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.da.learnquest.app.QuestToQuizUnitState;

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

       // String getSubject();

        void setT1Items();

        //String getT1Items();

        void onStart();

        void onRestart();

        void onResume();

        void onPause();


    }

    interface Model {
        String fetchData();

        void onRestartScreen(QuizUnitState data);

       // void setT1Fields();

        void setT1Topic(String T1Topic);
        void setT1SubTopic(String T1SubTopic);
        void setT1Description(String T1Description);

        String getT1Topic();
        String getT1SubTopic();
        String getT1Description();

        void setT2Topic(String T1Topic);
        void setT2Subtopic(String T2SubTopic);
        void setT2Description(String T2Description);
    }

    interface Router {
        void navigateToNextScreen();

        void passDataToNextScreen(QuizUnitState state);

        //QuizUnitState getDataFromPreviousScreen();

        QuestToQuizUnitState getStateFromQuestScreen();
    }
}
