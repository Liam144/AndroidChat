package edu.udistrital.android.androidchat.login;

/**
 * Created by wisuarez on 13/06/2016.
 * Se encarga de los casos de uso
 */
public interface LoginInteractor {
    void checkSession();
    void doSignUp(String email, String password);
    void doSignIn(String email, String password);
}
