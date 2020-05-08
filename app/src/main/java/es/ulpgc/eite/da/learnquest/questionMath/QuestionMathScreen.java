package es.ulpgc.eite.da.learnquest.questionMath;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

import es.ulpgc.eite.da.learnquest.R;
import es.ulpgc.eite.da.learnquest.app.AppMediator;
import es.ulpgc.eite.da.learnquest.data.QuizRepository;
import es.ulpgc.eite.da.learnquest.data.RepositoryContract;

public class QuestionMathScreen {

    public static void configure(QuestionMathContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        String data = context.get().getString(R.string.app_name);

        AppMediator mediator = AppMediator.getInstance();
        QuestionMathState state = mediator.getQuestionMathState();
        RepositoryContract quizRepository = QuizRepository.getInstance(context.get());
        QuestionMathContract.Router router = new QuestionMathRouter(mediator);
        QuestionMathContract.Presenter presenter = new QuestionMathPresenter(state);
        QuestionMathContract.Model model = new QuestionMathModel(quizRepository);
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
