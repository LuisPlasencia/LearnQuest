package es.ulpgc.eite.da.learnquest.quests;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

import es.ulpgc.eite.da.learnquest.app.AppMediator;

public class QuestsScreen {

    public static void configure(QuestsContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        QuestsState state = mediator.getQuestsState();

        QuestsContract.Router router = new QuestsRouter(mediator);
        QuestsContract.Presenter presenter = new QuestsPresenter(state);
        QuestsContract.Model model = new QuestsModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}