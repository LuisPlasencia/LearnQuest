package es.ulpgc.eite.da.learnquest.finalQuiz;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.da.learnquest.data.QuizUnitResult;
import es.ulpgc.eite.da.learnquest.data.RepositoryContract;
import es.ulpgc.eite.da.learnquest.data.User;


public class FinalQuizPresenter implements FinalQuizContract.Presenter {

    public static String TAG = FinalQuizPresenter.class.getSimpleName();

    private WeakReference<FinalQuizContract.View> view;
    private FinalQuizState state;
    private FinalQuizContract.Model model;
    private FinalQuizContract.Router router;

    public FinalQuizPresenter(FinalQuizState state) {
        this.state = state;
    }

    @Override
    public void onStart() {
        state.user = model.getUserActual();
        state.experience_earned = model.getStoredExperience();
        state.medal_image = model.getMedalImage();
        model.addExperience();
        state.experience_needed = model.getExperienceNeeded();
        state.level = model.getLevel();
        state.sublevel = model.getSubLevel();
        state.subjectId = model.getSubjectId();
        state.quizId = model.getQuizId();
        state.quizUnitResultActual = model.getQuizUnitResultActual();




        for(int i = 0 ; i< state.quizUnitResultActual.size(); i++){
//            Log.d("holaaaa", "state.subjectId = " + String.valueOf(state.subjectId));
//            Log.d("holaaaa", "state.quizUnitResultActual.get(i).questId = " + String.valueOf(state.quizUnitResultActual.get(i).questId));
//
//            Log.d("holaaaa", "state.quizId = " + String.valueOf(state.quizId));
//            Log.d("holaaaa", "state.quizUnitResultActual.get(i).quizUnitId = " + state.quizUnitResultActual.get(i).quizUnitId);
            if((state.quizUnitResultActual.get(i).questId == state.subjectId)  &&  (state.quizUnitResultActual.get(i).quizUnitId == state.quizId)){
                state.quizUnitResult = state.quizUnitResultActual.get(i);
            }
        }

        if(state.quizUnitResult.mark < state.experience_earned){
            state.quizUnitResult.mark = state.experience_earned;
            Log.d("holaaaa", "state.quizUnitResult.medalla = " + state.quizUnitResult.medalla);
            Log.d("holaaaa", "model.getMedalPhotoString() = " + model.getMedalPhotoString(state.experience_earned));
            if(!state.quizUnitResult.medalla.equals(model.getMedalPhotoString(state.experience_earned))){
                state.quizUnitResult.medalla = model.getMedalPhotoString(state.experience_earned);
                Log.d("holaaaa", "state.quizUnitResult.medalla = " + state.quizUnitResult.medalla);
            }

            model.updateQuizResult(state.quizUnitResult, new RepositoryContract.updateQuizResultCallback() {
                @Override
                public void updateQuizResultCallback() {
                    Log.d("holaaaa", "Se ha actualizado el quiz result");
                    model.updateUser(new RepositoryContract.UpdateUserCallback(){
                        @Override
                        public void onUserUpdated(){
                            Log.d("holaaaa", "Se ha añadido el la experiencia");
                        }
                    });
                }
            });
        }
        view.get().displayFinalQuizData(state);

    }


    @Override
    public void onResume() {
        // Log.e(TAG, "onResume()");
        view.get().displayFinalQuizData(state);

    }

    @Override
    public void onBackPressed() {
        onReturnClicked();
    }

    @Override
    public void onReturnClicked() {
        router.passStateToNextScreen(state);
        state.subjectId = 0;
        state.quizId = 0;
        model.resetQuizId();
        model.resetSubjectId();
        view.get().navigateToProfileScreen();
    }

    @Override
    public int getMedalPhoto() {
        return state.medal_image;
    }


    @Override
    public void sendEmail() {
        view.get().sendEmail(state.user, state.quizId, state.subjectId, state.experience_earned);
    }

    @Override
    public void injectView(WeakReference<FinalQuizContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(FinalQuizContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(FinalQuizContract.Router router) {
        this.router = router;
    }


}
