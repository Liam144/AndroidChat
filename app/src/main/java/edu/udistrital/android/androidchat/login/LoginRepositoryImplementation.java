package edu.udistrital.android.androidchat.login;



import android.util.Log;

import edu.udistrital.android.androidchat.domain.FirebaseHelper;
import edu.udistrital.android.androidchat.lib.EventBus;
import edu.udistrital.android.androidchat.lib.GreenRobotEventBus;
import edu.udistrital.android.androidchat.login.events.LoginEvent;

/**
 * Created by wisuarez on 14/06/2016.
 */
public class LoginRepositoryImplementation implements LoginRepository {

    private FirebaseHelper helper;

    public LoginRepositoryImplementation() {
        this.helper = FirebaseHelper.getInstance();
    }

    @Override
    public void signUp(String email, String password) {
       postEvent(LoginEvent.onSignUpSuccess);
    }

    @Override
    public void signIn(String email, String password) {
       postEvent(LoginEvent.onSignInSuccess);
    }

    @Override
    public void checkSesion() {
       postEvent(LoginEvent.onFailedToRecoverSession);
    }

    private void postEvent(int type, String errorMessage){
        LoginEvent loginEvent = new LoginEvent();
        loginEvent.setEventType(type);
        if (errorMessage != null ){
            loginEvent.setErrorMessage(errorMessage);
        }
        EventBus eventBus = GreenRobotEventBus.getInstance();
        eventBus.post(loginEvent);
    }
    private void postEvent(int type){
        postEvent(type, null);
    }
}
