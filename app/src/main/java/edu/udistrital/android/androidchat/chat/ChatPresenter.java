package edu.udistrital.android.androidchat.chat;

import edu.udistrital.android.androidchat.chat.events.ChatEvent;

/**
 * Created by wisuarez on 20/06/2016.
 */
public interface ChatPresenter {
    void onPause();
    void onResume();
    void onCreate();
    void onDestroy();

    void setChatRecipient(String recipient);
    void sendMessage(String msg);
    void onEventMainThread(ChatEvent event);


}
