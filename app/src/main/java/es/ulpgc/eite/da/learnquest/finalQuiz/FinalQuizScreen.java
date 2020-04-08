package es.ulpgc.eite.da.learnquest.finalQuiz;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

import es.ulpgc.eite.da.learnquest.R;
import es.ulpgc.eite.da.learnquest.app.AppMediator;

public class FinalQuizScreen {

    public static void configure(FinalQuizContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        String data = context.get().getString(R.string.app_name);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        FinalQuizState state = mediator.getFinalQuizState();

        FinalQuizContract.Router router = new FinalQuizRouter(mediator);
        FinalQuizContract.Presenter presenter = new FinalQuizPresenter(state);
        FinalQuizContract.Model model = new FinalQuizModel(data);
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
