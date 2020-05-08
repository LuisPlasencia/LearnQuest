package es.ulpgc.eite.da.learnquest.quests;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.eite.da.learnquest.app.QuestToQuizUnitState;
import es.ulpgc.eite.da.learnquest.data.QuestItem;
import es.ulpgc.eite.da.learnquest.data.QuizUnitItem;
import es.ulpgc.eite.da.learnquest.data.RepositoryContract;

public interface QuestsContract {

    interface View {
        void displayDataPercentageAndImage(QuestsViewModel viewModel);

        void injectPresenter(Presenter presenter);

        void displayData(QuestsViewModel viewModel);

        void navigateToQuizUnitScreen();
    }

    interface Presenter {
        void fetchQuestsData();

        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);


        void fecthQuestsDataPercentageAndImage();

        void selectQuestData(QuestItem item);
    }

    interface Model {


        void setSubjectID(int subjectID);

        List<QuestItem> fetchQuestsData();

        /////
        void fetchQuestListData(final RepositoryContract.GetQuestListCallback callback);

    }

    interface Router {
       // void navigateToQuizUnitScreen();

        //void passDataToNextScreen(QuestsState state);
        void passDataToQuizUnitScreen(QuestItem item);

        QuestsState getDataFromPreviousScreen();
    }
}

