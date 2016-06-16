package edu.udistrital.android.androidchat.login;

import android.util.Log;

import edu.udistrital.android.androidchat.lib.EventBus;
import edu.udistrital.android.androidchat.lib.GreenRobotEventBus;
import edu.udistrital.android.androidchat.login.events.LoginEvent;
import edu.udistrital.android.androidchat.login.ui.LoginView;

/*
 * Created by wisuarez on 14/06/2016.
 */
public class LoginPresenterImplementation implements LoginPresenter {

    private EventBus eventBus;
    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenterImplementation(LoginView loginView) {
        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImplementation();
        this.eventBus = GreenRobotEventBus.getInstance();
    }


    //nos registramos
    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        loginView= null;
        eventBus.unregister(this);
    }

    @Override
    public void checkForAuthenticateUser() {
        if (loginView != null){
            loginView.disableInputs();
            loginView.showProgress();
        }
        loginInteractor.checkSession();
    }

    @Override
    public void validateLogin(String email, String password) {
        if (loginView != null){
            loginView.disableInputs();
            loginView.showProgress();
        }
        loginInteractor.doSignIn(email, password);
    }

    @Override
    public void registerNewUser(String email, String password) {
        if (loginView != null){
            loginView.disableInputs();
            loginView.showProgress();
        }
        loginInteractor.doSignUp(email, password);
    }

    //Recibe las respuestas de EventBus
    @Override
    public void onEventMainThread(LoginEvent event) {
        switch (event.getEventType()){
            case LoginEvent.onSignInSuccess:
                onSignInSuccess();
                break;
            case LoginEvent.onSignUpSuccess:
                onSignUpSuccess();
                break;
            case LoginEvent.onSignInError:
                onSignInError(event.getErrorMessage());
                break;
            case LoginEvent.onSignUpError:
                onSignUpError(event.getErrorMessage());
                break;
            case LoginEvent.onFailedToRecoverSession:
                onFailedToRecoverSession();
                break;
        }
    }
    //Cuando no hay una Session
    private void onFailedToRecoverSession(){
        if (loginView != null) {
            loginView.hideProgress();
            loginView.enableInputs();
        }

    }

    private void onSignInSuccess(){
        if (loginView != null){
            loginView.navigateToMainScreen();
        }

    }

    private void onSignUpSuccess(){
        if (loginView != null){
            loginView.newUserSuccess();
        }
    }

    private void onSignInError(String error){
        if (loginView != null){
            loginView.hideProgress();
            loginView.enableInputs();
            loginView.loginError(error);
        }
    }

    private void onSignUpError(String error){
        if (loginView != null){
            loginView.hideProgress();
            loginView.enableInputs();
            loginView.newUserError(error);
        }
    }

}
