package edu.udistrital.android.androidchat.contactlist;

/**
 * Created by ASUS on 19/06/2016.
 */
public class ContactListIteratorImplementation implements ContactListIterator{
    private ContactListRepository repository;

    public ContactListIteratorImplementation() {
        repository = new ContactListRepositoryImplementation();
    }

    @Override
    public void subscribe() {
        repository.subscribeToContactListEvents();
    }

    @Override
    public void unsubscribe() {
        repository.unsubscribeToContactListEvents();
    }

    @Override
    public void destroyListener() {
        repository.destroyListener();
    }

    @Override
    public void removeContact(String email) {
        repository.removeContact(email);
    }
}
