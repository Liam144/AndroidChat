package edu.udistrital.android.androidchat.addcontact;

import edu.udistrital.android.androidchat.addcontact.events.AddContactEvent;
import edu.udistrital.android.androidchat.addcontact.ui.AddContactFragment;
import edu.udistrital.android.androidchat.addcontact.ui.AddContactView;

/**
 * Created by wisuarez on 20/06/2016.
 */
public class AddContactPresenterImplementation implements AddContactPresenter {

    private AddContactView view;

    public AddContactPresenterImplementation( AddContactView view) {
        this.view = view;
    }

    @Override
    public void onShow() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void addContact(String email) {

    }

    @Override
    public void onEventMaininThread(AddContactEvent event) {

    }
}
