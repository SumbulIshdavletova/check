package ru.sumbul.a5fragmentcontacts;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContactViewModel extends ViewModel {

    private List<Contacts> contacts = new ArrayList<Contacts>(Arrays.asList(
            new Contacts(0, "Lee Taeyong", 19950701),
            new Contacts(1, "Moon Taeil", 19960614),
            new Contacts(2, "Johnny Soh", 19950209)
    ));

    public Contacts getContactById(int id) {
        return contacts.get(id);
    }

    private final MutableLiveData<Contacts> contactsMutableLiveData =
            new MutableLiveData(new Contacts(0, null, 0));

    public LiveData<Contacts> getContacts() {
        return contactsMutableLiveData;
    }

    public void setContacts(int id) {
        contactsMutableLiveData.setValue(contacts.get(id));
    }

    public void editContact(int id, String name, int newNumber) {
        Contacts c = contacts.set(id, new Contacts(id, name, newNumber));
        contactsMutableLiveData.setValue(c);
    }


//    public void rollDice() {
//        Random random = new Random();
//        uiState.setValue(
//                new DiceUiState(
//                        random.nextInt(7) + 1,
//                        random.nextInt(7) + 1,
//                        uiState.getValue().getNumberOfRolls() + 1
//                )
//        );
//    }

}
