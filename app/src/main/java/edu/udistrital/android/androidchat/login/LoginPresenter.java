package edu.udistrital.android.androidchat.login;

/**
 * Created by wisuarez on 13/06/2016.
 * Se comunica con la Vista
 */
public interface LoginPresenter {
    void onDestroy();
    void checkForAuthenticateUser();
    void validateLogin(String email, String password);
    void registerNewUser(String email, String password);

}
