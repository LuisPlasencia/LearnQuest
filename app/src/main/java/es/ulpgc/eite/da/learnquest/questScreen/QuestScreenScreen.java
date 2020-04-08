package es.ulpgc.eite.da.learnquest.questScreen;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

import es.ulpgc.eite.da.learnquest.app.AppMediator;

public class QuestScreenScreen {

    public static void configure(QuestScreenContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        QuestScreenState state = mediator.getQuestScreenState();

        QuestScreenContract.Router router = new QuestScreenRouter(mediator);
        QuestScreenContract.Presenter presenter = new QuestScreenPresenter(state);
        QuestScreenContract.Model model = new QuestScreenModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
