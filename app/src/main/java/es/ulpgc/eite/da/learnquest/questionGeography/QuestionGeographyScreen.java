package es.ulpgc.eite.da.learnquest.questionGeography;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

import es.ulpgc.eite.da.learnquest.R;
import es.ulpgc.eite.da.learnquest.app.AppMediator;
import es.ulpgc.eite.da.learnquest.data.QuizRepository;
import es.ulpgc.eite.da.learnquest.data.RepositoryContract;

public class QuestionGeographyScreen {

    public static void configure(QuestionGeographyContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        String data = context.get().getString(R.string.app_name);

        AppMediator mediator = AppMediator.getInstance();
        QuestionGeographyState state = mediator.getQuestionGeographyState();
        RepositoryContract quizRepository = QuizRepository.getInstance(context.get());
        QuestionGeographyContract.Router router = new QuestionGeographyRouter(mediator);
        QuestionGeographyContract.Presenter presenter = new QuestionGeographyPresenter(state);
        QuestionGeographyContract.Model model = new QuestionGeographyModel(quizRepository);
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
