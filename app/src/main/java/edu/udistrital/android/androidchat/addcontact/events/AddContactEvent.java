package edu.udistrital.android.androidchat.addcontact.events;

/**
 * Created by ASUS on 19/06/2016.
 */
public class AddContactEvent {
    boolean error = false;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}
