package es.ulpgc.eite.da.learnquest.perfil;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

import es.ulpgc.eite.da.learnquest.R;
import es.ulpgc.eite.da.learnquest.app.AppMediator;

public class PerfilScreen {

    public static void configure(PerfilContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        String data = context.get().getString(R.string.app_name);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        PerfilState state = mediator.getPerfilState();

        PerfilContract.Router router = new PerfilRouter(mediator);
        PerfilContract.Presenter presenter = new PerfilPresenter(state);
        PerfilContract.Model model = new PerfilModel(data);
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
