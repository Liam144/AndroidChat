package edu.udistrital.android.androidchat.addcontact;

/**
 * Created by wisuarez on 20/06/2016.
 */
public class AddContactIteratorImplementation implements AddContactIterator {
    AddContactRepository repository;

    public AddContactIteratorImplementation() {
        repository = new AddContactRepositoryImplementation();
    }

    @Override
    public void execute(String email) {
        repository.addContact(email);
    }
}
