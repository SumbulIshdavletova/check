package ru.sumbul.a5fragmentcontacts;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ContactViewModel extends ViewModel {


    public ArrayList<Contacts> generateContactsList() {
        ArrayList<Contacts> contacts = new ArrayList<Contacts>(10);

        Contacts ty = new Contacts();
        ty.setId(0);
        ty.setName("Lee");
        ty.setNumber(19950701);
        contacts.add(ty);

        Contacts tl = new Contacts();
        tl.setId(1);
        tl.setName("Moon");
        tl.setNumber(19960614);
        contacts.add(tl);

        Contacts jh = new Contacts();
        jh.setId(2);
        jh.setName("Johnny Soh");
        jh.setNumber(19950209);
        contacts.add(jh);

        return contacts;
    }


//    public void setContactsList(List<Contacts> contactsList) {
//        this.contacts.addAll(contactsList);
//    }
//

//    private List<Contacts> contacts = new ArrayList<Contacts>(Arrays.asList(
//            new Contacts(0, "Lee Taeyong", 19950701),
//            new Contacts(1, "Moon Taeil", 19960614),
//            new Contacts(2, "Johnny Soh", 19950209)
//    ));
//
//    public Contacts getContactById(int id) {
//        return contacts.get(id);
//    }
//
//    private final MutableLiveData<Contacts> contactsMutableLiveData =
//            new MutableLiveData(new Contacts(0, null, 0));
//
//    public LiveData<Contacts> getContacts() {
//        return contactsMutableLiveData;
//    }
//
//    public void setContacts(int id) {
//        contactsMutableLiveData.setValue(contacts.get(id));
//    }
//
//    public void editContact(int id, String name, int newNumber) {
//        Contacts c = contacts.set(id, new Contacts(id, name, newNumber));
//        contactsMutableLiveData.setValue(c);
//    }


}
