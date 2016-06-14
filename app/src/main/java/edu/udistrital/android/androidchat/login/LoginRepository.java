package edu.udistrital.android.androidchat.login;

/**
 * Created by wisuarez on 13/06/2016.
 * Interacion con el backend Firesbase
 */
public interface LoginRepository {
    void signUp(String email, String password);
    void signIn(String email, String password);
    void checkSesion();
}
