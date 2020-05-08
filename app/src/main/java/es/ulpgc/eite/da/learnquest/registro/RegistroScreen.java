package es.ulpgc.eite.da.learnquest.registro;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

import es.ulpgc.eite.da.learnquest.app.AppMediator;
import es.ulpgc.eite.da.learnquest.data.QuizRepository;
import es.ulpgc.eite.da.learnquest.data.RepositoryContract;

public class RegistroScreen {

    public static void configure(RegistroContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        //AppMediator mediator = (AppMediator) context.get().getApplication();
        AppMediator mediator = AppMediator.getInstance();
        RegistroState state = mediator.getRegistroState();
        RepositoryContract quizRepository = QuizRepository.getInstance(context.get());


        RegistroContract.Router router = new RegistroRouter(mediator);
        RegistroContract.Presenter presenter = new RegistroPresenter(state);
        RegistroContract.Model model = new RegistroModel(quizRepository);
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
