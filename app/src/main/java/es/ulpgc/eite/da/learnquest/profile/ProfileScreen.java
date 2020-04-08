package es.ulpgc.eite.da.learnquest.profile;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

import es.ulpgc.eite.da.learnquest.R;
import es.ulpgc.eite.da.learnquest.app.AppMediator;

public class ProfileScreen {

    public static void configure(ProfileContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        String data = context.get().getString(R.string.app_name);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        ProfileState state = mediator.getProfileState();

        ProfileContract.Router router = new ProfileRouter(mediator);
        ProfileContract.Presenter presenter = new ProfilePresenter(state);
        ProfileContract.Model model = new ProfileModel(data);
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
