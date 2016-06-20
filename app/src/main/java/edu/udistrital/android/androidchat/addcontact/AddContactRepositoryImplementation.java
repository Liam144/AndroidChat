package edu.udistrital.android.androidchat.addcontact;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import edu.udistrital.android.androidchat.addcontact.events.AddContactEvent;
import edu.udistrital.android.androidchat.domain.FirebaseHelper;
import edu.udistrital.android.androidchat.entities.User;
import edu.udistrital.android.androidchat.lib.EventBus;
import edu.udistrital.android.androidchat.lib.GreenRobotEventBus;

/**
 * Created by wisuarez on 20/06/2016.
 */
public class AddContactRepositoryImplementation implements AddContactRepository {
    private EventBus eventBus;
    private FirebaseHelper helper;

    public AddContactRepositoryImplementation() {
        this.helper = FirebaseHelper.getInstance();
        this.eventBus = GreenRobotEventBus.getInstance();
    }

    @Override
    public void addContact(final String email) {
       final String key = email.replace(".","_");
       Firebase userReference = helper.getUserReference(email);
       userReference.addListenerForSingleValueEvent(new ValueEventListener() {
           @Override
           public void onDataChange(DataSnapshot dataSnapshot) {
            User user = dataSnapshot.getValue(User.class);
               if (user != null){
                   Firebase myContactReference = helper.getMyContactsReference();
                   myContactReference.child(key).setValue(user.isOnline());

                   String currentUserKey = helper.getAuthUserEmail();
                   currentUserKey = currentUserKey.replace(".","_");
                   Firebase reverseContactReference = helper.getContactsReference(email);
                   reverseContactReference.child(currentUserKey).setValue(User.ONLINE);

                   postSuccess();
               }
               else
                   postError();
           }

           @Override
           public void onCancelled(FirebaseError firebaseError) {
            postError();
           }
       });
    }

    private void postSuccess() {
        post(false);
    }

    private void postError() {
        post(true);
    }

    private void post(boolean error) {
        AddContactEvent event = new AddContactEvent();
        event.setError(error);
        eventBus.post(event);
    }


}
