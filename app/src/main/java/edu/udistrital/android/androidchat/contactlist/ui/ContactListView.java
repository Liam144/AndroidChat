package edu.udistrital.android.androidchat.contactlist.ui;

import edu.udistrital.android.androidchat.entities.User;

/**
 * Created by ASUS on 17/06/2016.
 */
public interface ContactListView {
    void onContactAdded(User user);
    void onContactChanged(User user);
    void onContactRemoved(User user);
}
