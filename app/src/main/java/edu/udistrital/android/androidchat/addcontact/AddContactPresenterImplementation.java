package edu.udistrital.android.androidchat.addcontact;

import org.greenrobot.eventbus.Subscribe;

import edu.udistrital.android.androidchat.addcontact.events.AddContactEvent;
import edu.udistrital.android.androidchat.addcontact.ui.AddContactView;
import edu.udistrital.android.androidchat.lib.EventBus;
import edu.udistrital.android.androidchat.lib.GreenRobotEventBus;

/**
 * Created by wisuarez on 20/06/2016.
 */
public class AddContactPresenterImplementation implements AddContactPresenter {

    private EventBus eventBus;
    private AddContactView view;
    private AddContactIterator iterator;

    public AddContactPresenterImplementation( AddContactView view) {
        this.view = view;
        this.eventBus = GreenRobotEventBus.getInstance();
        this.iterator = new AddContactIteratorImplementation();
    }

    @Override
    public void onShow() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        view = null;
        eventBus.unregister(this);
    }

    @Override
    public void addContact(String email) {
        if (view != null){
            view.hideInput();
            view.showProgress();
        }
        iterator.execute(email);

    }

    @Override
    @Subscribe
    public void onEventMaininThread(AddContactEvent event) {
        if (view != null){
            view.showInput();
            view.hideProgress();

            if (event.isError())
                view.contactNoAdded();
            else
                view.contactAdded();
        }

    }
}
