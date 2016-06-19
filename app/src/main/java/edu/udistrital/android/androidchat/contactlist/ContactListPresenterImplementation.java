package edu.udistrital.android.androidchat.contactlist;

import org.greenrobot.eventbus.Subscribe;

import edu.udistrital.android.androidchat.contactlist.events.ContactListEvent;
import edu.udistrital.android.androidchat.contactlist.ui.ContactListView;
import edu.udistrital.android.androidchat.entities.User;
import edu.udistrital.android.androidchat.lib.EventBus;
import edu.udistrital.android.androidchat.lib.GreenRobotEventBus;

/**
 * Created by ASUS on 19/06/2016.
 */
public class ContactListPresenterImplementation implements ContactListPresenter{

    private EventBus eventBus;
    private ContactListView view;
    private ContactListIterator listIterator;
    private ContactListSessionIterator sessionIterator;

    public ContactListPresenterImplementation(ContactListView view) {
        this.view = view;
        this.eventBus = GreenRobotEventBus.getInstance();
        this.listIterator = new ContactListIteratorImplementation();
        this.sessionIterator = new ContactListSessionIteratorImplementation();
    }

    @Override
    public void onPause() {
        sessionIterator.changeConnectionStatus(User.OFFLINE);
        listIterator.unsubscribe();
    }

    @Override
    public void onResume() {
        sessionIterator.changeConnectionStatus(User.ONLINE);
        listIterator.subscribe();

    }

    @Override
    public void onCreate() {
        eventBus.register(this);


    }

    @Override
    public void onDestroy() {
      eventBus.unregister(this);
      listIterator.destroyListener();
      view = null;

    }

    @Override
    public void signOff() {
        sessionIterator.changeConnectionStatus(User.OFFLINE);
        listIterator.unsubscribe();
        listIterator.destroyListener();
        sessionIterator.signOff();
    }

    @Override
    public String getCurrentUserEmail() {
        return sessionIterator.getCurrentUserEmail();
    }

    @Override
    public void removeContact(String email) {
        listIterator.removeContact(email);

    }

    @Override
    @Subscribe
    public void onEventMainThread(ContactListEvent event) {
        User user = event.getUser();
        switch (event.getEventType()){
            case ContactListEvent.onContactAdded:
                onContactAdded(user);
                break;
            case ContactListEvent.onContactChanged:
                onContactChanged(user);
                break;
            case ContactListEvent.onContactRemoved:
                onContactRemoved(user);
                break;
        }
    }

    private void onContactAdded(User user){
        if (view != null){
            view.onContactAdded(user);
        }
    }

    private void onContactChanged(User user){
        if (view != null){
            view.onContactChanged(user);
        }
    }

    private void onContactRemoved(User user){
        if (view != null){
            view.onContactRemoved(user);
        }
    }
}
