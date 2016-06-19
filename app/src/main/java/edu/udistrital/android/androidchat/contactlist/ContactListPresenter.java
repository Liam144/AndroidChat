package edu.udistrital.android.androidchat.contactlist;

import edu.udistrital.android.androidchat.contactlist.events.ContactListEvent;

/**
 * Created by ASUS on 17/06/2016.
 */
public interface ContactListPresenter {
    void onPause();
    void onResume();
    void onCreate();
    void onDestroy();

    void signOff();
    String getCurrentUserEmail();
    void removeContact(String email);
    void onEventMainThread(ContactListEvent event);
}
