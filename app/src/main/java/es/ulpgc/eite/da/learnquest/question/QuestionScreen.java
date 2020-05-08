package es.ulpgc.eite.da.learnquest.question;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

import es.ulpgc.eite.da.learnquest.app.AppMediator;
import es.ulpgc.eite.da.learnquest.data.QuizRepository;
import es.ulpgc.eite.da.learnquest.data.RepositoryContract;

public class QuestionScreen {

    public static void configure(QuestionContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        QuestionState state = mediator.getQuestionState();
        RepositoryContract quizRepository = QuizRepository.getInstance(context.get());

        QuestionContract.Router router = new QuestionRouter(mediator);
        QuestionContract.Presenter presenter = new QuestionPresenter(state);
        QuestionContract.Model model = new QuestionModel(quizRepository);
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
