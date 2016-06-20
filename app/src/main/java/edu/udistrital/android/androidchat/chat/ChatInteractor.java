package edu.udistrital.android.androidchat.chat;

/**
 * Created by wisuarez on 20/06/2016.
 */
public interface ChatInteractor {
    void sendMessage(String msg);
    void setRecipient(String recipient);

    void subscribe();
    void unsubscribe();
    void destroyListener();

}
