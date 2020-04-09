package es.ulpgc.eite.da.learnquest.profile;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

import es.ulpgc.eite.da.learnquest.R;
import es.ulpgc.eite.da.learnquest.app.AppMediator;
import es.ulpgc.eite.da.learnquest.data.QuizRepository;
import es.ulpgc.eite.da.learnquest.data.RepositoryContract;

public class ProfileScreen {

    public static void configure(ProfileContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        ProfileState state = mediator.getProfileState();
        RepositoryContract repository = QuizRepository.getInstance();

        ProfileContract.Router router = new ProfileRouter(mediator);
        ProfileContract.Presenter presenter = new ProfilePresenter(state);
        ProfileContract.Model model = new ProfileModel(repository);
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
