package edu.udistrital.android.androidchat.contactlist;

/*
 * Created by ASUS on 17/06/2016.
 */
public interface ContactListIterator {
    void subscribe();
    void unsubscribe();
    void destroyListener();
    void removeContact(String email);
}
