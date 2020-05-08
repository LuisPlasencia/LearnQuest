package es.ulpgc.eite.da.learnquest.finalQuiz;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

import es.ulpgc.eite.da.learnquest.R;
import es.ulpgc.eite.da.learnquest.app.AppMediator;
import es.ulpgc.eite.da.learnquest.data.QuizRepository;
import es.ulpgc.eite.da.learnquest.data.RepositoryContract;

public class FinalQuizScreen {

    public static void configure(FinalQuizContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

     //   AppMediator mediator = (AppMediator) context.get().getApplication();
        AppMediator mediator = AppMediator.getInstance();
        FinalQuizState state = mediator.getFinalQuizState();
        RepositoryContract repository = QuizRepository.getInstance(context.get());


        FinalQuizContract.Router router = new FinalQuizRouter(mediator);
        FinalQuizContract.Presenter presenter = new FinalQuizPresenter(state);
        FinalQuizContract.Model model = new FinalQuizModel(repository);
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
