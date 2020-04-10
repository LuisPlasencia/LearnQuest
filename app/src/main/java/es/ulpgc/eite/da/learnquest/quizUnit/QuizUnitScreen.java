package es.ulpgc.eite.da.learnquest.quizUnit;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

import es.ulpgc.eite.da.learnquest.app.AppMediator;
import es.ulpgc.eite.da.learnquest.data.QuizRepository;
import es.ulpgc.eite.da.learnquest.data.RepositoryContract;

public class QuizUnitScreen {

    public static void configure(QuizUnitContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        QuizUnitState state = mediator.getQuizUnitState();
        RepositoryContract quizRepository = QuizRepository.getInstance();

        QuizUnitContract.Router router = new QuizUnitRouter(mediator);
        QuizUnitContract.Presenter presenter = new QuizUnitPresenter(state);
        QuizUnitContract.Model model = new QuizUnitModel(quizRepository);
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
