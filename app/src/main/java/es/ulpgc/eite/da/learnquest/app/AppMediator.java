package es.ulpgc.eite.da.learnquest.app;

import android.app.Application;

import es.ulpgc.eite.da.learnquest.login.LoginState;
import es.ulpgc.eite.da.learnquest.perfil.PerfilState;
import es.ulpgc.eite.da.learnquest.question.QuestionState;

public class AppMediator extends Application {

    private QuestionState questionState;
    private LoginState loginState;
    private PerfilState perfilState;

    @Override
    public void onCreate() {
        super.onCreate();
        questionState = new QuestionState();
    }

    public QuestionState getQuestionState() {
        return questionState;
    }

    public LoginState getLoginState(){
        return loginState;
    }

    public PerfilState getPerfilState(){
        return perfilState;
    }

    public void setQuestionState(QuestionState state) {
        questionState = state;
    }

    public void setLoginState(LoginState state){
        loginState = state;
    }

    public void setPerfilState(PerfilState state){
        perfilState = state;
    }

}
