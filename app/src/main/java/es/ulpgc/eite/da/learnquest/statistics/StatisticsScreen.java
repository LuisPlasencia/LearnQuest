package es.ulpgc.eite.da.learnquest.statistics;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

import es.ulpgc.eite.da.learnquest.R;
import es.ulpgc.eite.da.learnquest.app.AppMediator;
import es.ulpgc.eite.da.learnquest.data.QuizRepository;
import es.ulpgc.eite.da.learnquest.data.RepositoryContract;

public class StatisticsScreen {

    public static void configure(StatisticsContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        String data = context.get().getString(R.string.app_name);

        //   AppMediator mediator = (AppMediator) context.get().getApplication();
        AppMediator mediator = AppMediator.getInstance();
        StatisticsState state = mediator.getStatisticsState();
        RepositoryContract repository = QuizRepository.getInstance(context.get());

        StatisticsContract.Router router = new StatisticsRouter(mediator);
        StatisticsContract.Presenter presenter = new StatisticsPresenter(state);
        StatisticsContract.Model model = new StatisticsModel(repository);
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
