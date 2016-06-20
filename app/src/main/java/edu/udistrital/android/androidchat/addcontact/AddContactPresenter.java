package edu.udistrital.android.androidchat.addcontact;

import edu.udistrital.android.androidchat.addcontact.events.AddContactEvent;

/**
 * Created by ASUS on 19/06/2016.
 */
public interface AddContactPresenter {
    void onShow();
    void onDestroy();

    void addContact(String email);
    void onEventMaininThread(AddContactEvent event);

}
