package edu.udistrital.android.androidchat.login;



import android.util.Log;

import com.firebase.client.AuthData;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.Map;

import edu.udistrital.android.androidchat.domain.FirebaseHelper;
import edu.udistrital.android.androidchat.entities.User;
import edu.udistrital.android.androidchat.lib.EventBus;
import edu.udistrital.android.androidchat.lib.GreenRobotEventBus;
import edu.udistrital.android.androidchat.login.events.LoginEvent;

/**
 * Created by wisuarez on 14/06/2016.
 */
public class LoginRepositoryImplementation implements LoginRepository {

    private FirebaseHelper helper;
    private Firebase dataReference;
    private Firebase myUserReference;


    public LoginRepositoryImplementation() {
        this.helper = FirebaseHelper.getInstance();
        this.dataReference = helper.getDataReference();
        this.myUserReference = helper.getMyUserReference();
    }

    @Override
    public void signUp(final String email, final String password) {
        dataReference.createUser(email,password, new Firebase.ValueResultHandler<Map<String, Object>>() {
            @Override
            public void onSuccess(Map<String, Object> stringObjectMap) {
                postEvent(LoginEvent.onSignUpSuccess);
                signIn(email,password);
            }

            @Override
            public void onError(FirebaseError firebaseError) {
                postEvent(LoginEvent.onSignUpError, firebaseError.getMessage());
            }
        });

    }


    @Override
    public void signIn(String email, String password) {
        dataReference.authWithPassword(email,password, new Firebase.AuthResultHandler() {
          //valida usuario con Firebase =dataReference
            @Override
            public void onAuthenticated(AuthData authData) {
               initSignIn();
            }

            @Override
            public void onAuthenticationError(FirebaseError firebaseError) {
                postEvent(LoginEvent.onSignInError, firebaseError.getMessage());
            }
        });

    }

    @Override
    public void checkSesion() {
        if (dataReference.getAuth() != null){
            initSignIn();
        }else{
            postEvent(LoginEvent.onFailedToRecoverSession);
        }
    }

    private void initSignIn(){
        myUserReference = helper.getMyUserReference();
        myUserReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User currentUser = dataSnapshot.getValue(User.class);

                if (currentUser == null){
                  registerNewUser();
                }
                helper.changeUserConnectionStatus(User.ONLINE);
                postEvent(LoginEvent.onSignInSuccess);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {}
        });
    }

    private void registerNewUser() {
        String email = helper.getAuthUserEmail();
        if (email != null){
            User currentUser = new User();
            currentUser.setEmail(email);
            myUserReference.setValue(currentUser);
        }
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
