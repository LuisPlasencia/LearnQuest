package es.ulpgc.eite.da.learnquest.quizUnit;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

public class QuizUnitScreen {

    public static void configure(QuizUnitContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        QuizUnitState state = mediator.getQuizUnitState();

        QuizUnitContract.Router router = new QuizUnitRouter(mediator);
        QuizUnitContract.Presenter presenter = new QuizUnitPresenter(state);
        QuizUnitContract.Model model = new QuizUnitModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}