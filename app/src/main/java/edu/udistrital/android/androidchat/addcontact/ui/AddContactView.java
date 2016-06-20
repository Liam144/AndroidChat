package edu.udistrital.android.androidchat.addcontact.ui;

/**
 * Created by ASUS on 19/06/2016.
 */
public interface AddContactView {
    void showInput();
    void hideInput();

    void showProgress();
    void hideProgress();

    void contactAdded();
    void contactNoAdded();
}
