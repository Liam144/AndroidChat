package edu.udistrital.android.androidchat.login;



import android.util.Log;

import edu.udistrital.android.androidchat.domain.FirebaseHelper;

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
        Log.e("LoginRepositoryImplementation", "signUp");
    }

    @Override
    public void signIn(String email, String password) {
        Log.e("LoginRepositoryImplementation", "signIn");
    }

    @Override
    public void checkSesion() {
        Log.e("LoginRepositoryImplementation", "check sesion");
    }
}
