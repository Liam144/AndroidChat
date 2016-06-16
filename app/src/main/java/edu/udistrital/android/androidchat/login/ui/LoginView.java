package edu.udistrital.android.androidchat.login.ui;

/**
 * Created by wisuarez on 13/06/2016.
 */
public interface LoginView {
    void enableInputs();
    void disableInputs();
    void showProgress();
    void hideProgress();

    void handleSingnUp();
    void handleSignIn();

    void navigateToMainScreen();
    void loginError(String error);

    void newUserSuccess();
    void newUserError(String error);
}
