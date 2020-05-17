package es.ulpgc.eite.da.learnquest.hint;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.da.learnquest.app.HintToQuestionState;
import es.ulpgc.eite.da.learnquest.app.QuestionToHintState;

public interface HintContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(HintViewModel viewModel);

        void resetAnswer();

        void onFinish();
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void onYesButtonClicked();

        void onNoButtonClicked();

        void onReturnToQuestionButton();

        void onBackPressed();

        void onStart();

        void onResume();
    }

    interface Model {

        void setQuizHint(String hint);

        String getHint();
    }

    interface Router {
        void passDataToQuestiontScreen(HintToQuestionState state);

        QuestionToHintState getDataFromQuestionScreen();
    }
}
