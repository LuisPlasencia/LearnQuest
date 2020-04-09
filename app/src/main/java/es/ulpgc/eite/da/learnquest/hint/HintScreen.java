package es.ulpgc.eite.da.learnquest.hint;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

import es.ulpgc.eite.da.learnquest.app.AppMediator;
import es.ulpgc.eite.da.learnquest.data.QuizRepository;
import es.ulpgc.eite.da.learnquest.data.RepositoryContract;

public class HintScreen {

    public static void configure(HintContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        HintState state = mediator.getHintState();
        RepositoryContract quizRepository = QuizRepository.getInstance();

        HintContract.Router router = new HintRouter(mediator);
        HintContract.Presenter presenter = new HintPresenter(state);
        HintContract.Model model = new HintModel(quizRepository);
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
