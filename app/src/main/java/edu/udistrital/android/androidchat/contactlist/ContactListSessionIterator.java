package edu.udistrital.android.androidchat.contactlist;

/**
 * Created by ASUS on 17/06/2016.
 */
public interface ContactListSessionIterator {

    void signOff();
    String getCurrentUserEmail();
    void changeConnectionStatus(boolean online);
}
