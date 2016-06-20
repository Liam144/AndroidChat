package edu.udistrital.android.androidchat.chat.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import edu.udistrital.android.androidchat.R;
import edu.udistrital.android.androidchat.entities.ChatMessage;

public class ChatActivity extends AppCompatActivity implements ChatView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
    }

    @Override
    public void onMessageReceived(ChatMessage chatMessage) {

    }
}
