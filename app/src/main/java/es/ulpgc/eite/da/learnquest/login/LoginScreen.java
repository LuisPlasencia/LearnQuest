package es.ulpgc.eite.da.learnquest.login;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

import es.ulpgc.eite.da.learnquest.R;
import es.ulpgc.eite.da.learnquest.app.AppMediator;
import es.ulpgc.eite.da.learnquest.data.QuizRepository;
import es.ulpgc.eite.da.learnquest.data.RepositoryContract;

public class LoginScreen {

    public static void configure(LoginContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        //   AppMediator mediator = (AppMediator) context.get().getApplication();
        AppMediator mediator = AppMediator.getInstance();
        LoginState state = mediator.getLoginState();
        RepositoryContract repository = QuizRepository.getInstance(context.get());

        LoginContract.Router router = new LoginRouter(mediator);
        LoginContract.Presenter presenter = new LoginPresenter(state);
        LoginContract.Model model = new LoginModel(repository);
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);
    }
}
