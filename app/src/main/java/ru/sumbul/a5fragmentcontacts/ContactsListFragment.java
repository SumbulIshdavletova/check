package ru.sumbul.a5fragmentcontacts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContactsListFragment extends Fragment {

    private final String[] contactNames = new String[]{"Lee Taeyong", "Moon Taeil", "Johnny Soh"};

    private List<Contacts> generateContactsList() {
        List<Contacts> contacts = new ArrayList<Contacts>(6);

        Contacts ty = new Contacts();
        ty.setId(2);
        ty.setName("Lee");
        ty.setNumber(19950701);
        contacts.add(ty);

        Contacts tl = new Contacts();
        tl.setId(1);
        tl.setName("Moon");
        tl.setNumber(19960614);
        contacts.add(tl);

        Contacts jh = new Contacts();
        jh.setId(0);
        jh.setName("Johnny Soh");
        jh.setNumber(19950209);
        contacts.add(jh);

        return contacts;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_contacts_list, container, false);
        ListView contactsListView = (ListView) view.findViewById(android.R.id.list);
        ContactsAdapter contactsAdapter = new ContactsAdapter(getActivity(), generateContactsList());
        contactsListView.setAdapter(contactsAdapter);

//        contact1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Bundle result = new Bundle();
//                result.putInt("bundleKey", contacts[0].id);
//                getParentFragmentManager().setFragmentResult("requestKey", result);
//
//                getParentFragmentManager().beginTransaction()
//                        .setReorderingAllowed(true)
//                        .replace(R.id.fragment_container_view, ContactInfoFragment.class, null)
//                        .addToBackStack("info")
//                        .commit();
//            }
//        });

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListView contactsListView = (ListView) view.findViewById(android.R.id.list);
        ContactsAdapter contactsAdapter = new ContactsAdapter(getActivity(), generateContactsList());
        contactsListView.setAdapter(contactsAdapter);
    }


}


