package edu.udistrital.android.androidchat.login;

/**
 * Created by wisuarez on 14/06/2016.
 */
public class LoginInteractorImplementation implements LoginInteractor {

    private LoginRepository loginRepository;

    public LoginInteractorImplementation() {
        this.loginRepository = new LoginRepositoryImplementation();
    }

    @Override
    public void checkSession() {
        loginRepository.checkSesion();
    }

    @Override
    public void doSignUp(String email, String password) {
        loginRepository.signUp(email,password);
    }

    @Override
    public void doSignIn(String email, String password) {
        loginRepository.signIn(email,password);
    }
}
