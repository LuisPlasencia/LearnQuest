package es.ulpgc.eite.da.learnquest.quests;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.eite.da.learnquest.data.QuestItem;
import es.ulpgc.eite.da.learnquest.data.RepositoryContract;

public interface QuestsContract {

    interface View {

        void injectPresenter(Presenter presenter);

        void displayData(QuestsViewModel viewModel);

        void navigateToQuizUnitScreen();
    }

    interface Presenter {
        void fetchQuestsData();

        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);


        void selectQuestData(QuestItem item);
    }

    interface Model {


        void setSubjectID(int subjectID);

        List<QuestItem> fetchQuestsData();

        void updateQuestParameters();

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

