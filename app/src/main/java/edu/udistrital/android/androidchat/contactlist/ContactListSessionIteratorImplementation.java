package edu.udistrital.android.androidchat.contactlist;

/**
 * Created by ASUS on 19/06/2016.
 */
public class ContactListSessionIteratorImplementation implements ContactListSessionIterator {
    ContactListRepository repository;

    public ContactListSessionIteratorImplementation() {
        repository = new ContactListRepositoryImplementation();
    }

    @Override
    public void signOff() {
        repository.signoff();
    }

    @Override
    public String getCurrentUserEmail() {
        return repository.getCurrentUserEmail();
    }

    @Override
    public void changeConnectionStatus(boolean online) {
        repository.changeConnectionStatus(online);
    }
}
