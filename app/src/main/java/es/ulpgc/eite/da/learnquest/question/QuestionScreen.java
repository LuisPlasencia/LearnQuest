package es.ulpgc.eite.da.learnquest.question;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

import es.ulpgc.eite.da.learnquest.app.AppMediator;

public class QuestionScreen {

    public static void configure(QuestionContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        QuestionState state = mediator.getQuestionState();

        QuestionContract.Router router = new QuestionRouter(mediator);
        QuestionContract.Presenter presenter = new QuestionPresenter(state);
        QuestionContract.Model model = new QuestionModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
