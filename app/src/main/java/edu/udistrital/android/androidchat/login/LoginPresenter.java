package edu.udistrital.android.androidchat.login;

import edu.udistrital.android.androidchat.login.events.LoginEvent;

/**
 * Created by wisuarez on 13/06/2016.
 * Se comunica con la Vista
 */
public interface LoginPresenter {
    void onCreate();
    void onDestroy();
    void checkForAuthenticateUser();
    void validateLogin(String email, String password);
    void registerNewUser(String email, String password);
    void onEventMainThread(LoginEvent event);

}
