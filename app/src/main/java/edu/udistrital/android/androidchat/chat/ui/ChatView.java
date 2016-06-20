package edu.udistrital.android.androidchat.chat.ui;

import edu.udistrital.android.androidchat.entities.ChatMessage;

/**
 * Created by wisuarez on 20/06/2016.
 */
public interface ChatView {
    void onMessageReceived(ChatMessage chatMessage);

}
