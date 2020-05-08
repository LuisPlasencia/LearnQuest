package es.ulpgc.eite.da.learnquest.logros;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

import es.ulpgc.eite.da.learnquest.R;
import es.ulpgc.eite.da.learnquest.app.AppMediator;

public class LogrosScreen {

    public static void configure(LogrosContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        String data = context.get().getString(R.string.app_name);

        //   AppMediator mediator = (AppMediator) context.get().getApplication();
        AppMediator mediator = AppMediator.getInstance();
        LogrosState state = mediator.getLogrosState();

        LogrosContract.Router router = new LogrosRouter(mediator);
        LogrosContract.Presenter presenter = new LogrosPresenter(state);
        LogrosContract.Model model = new LogrosModel(data);
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
