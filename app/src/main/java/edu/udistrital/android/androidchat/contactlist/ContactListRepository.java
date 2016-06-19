package edu.udistrital.android.androidchat.contactlist;

/* Responde ante los eventos
 * Created by ASUS on 17/06/2016.
 */
public interface ContactListRepository {
    void signoff();
    String getCurrentUserEmail();
    void removeContact(String email);
    void destroyListener();
    void subscribeToContactListEvents();
    void unsubscribeToContactListEvents();
    void changeConnectionStatus(boolean online);
}
