package ru.sumbul.a5fragmentcontacts;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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

    private List<Contacts> generateContactsList() {
        List<Contacts> contacts = new ArrayList<Contacts>(10);

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
    List<Contacts> updatedList = generateContactsList();
    OnFragmentInteractionListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            listener = (OnFragmentInteractionListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_contacts_list, container, false);


        getParentFragmentManager().setFragmentResultListener("requestKey", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
                bundle = getArguments();
                Contacts contact = (Contacts) bundle.getSerializable("contact");
                Contacts ng = generateContactsList().get(contact.getId());
                ng.setId(contact.getId());
                ng.setNumber(contact.getNumber());
                ng.setName(contact.getName());
                updatedList.set(ng.getId(), ng);
                ListView contactsListView = (ListView) view.findViewById(android.R.id.list);
                ContactsAdapter contactsAdapter = new ContactsAdapter(getActivity(), updatedList);
                contactsListView.setAdapter(contactsAdapter);

            }
        });


        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListView contactsListView = (ListView) view.findViewById(android.R.id.list);
        ContactsAdapter contactsAdapter = new ContactsAdapter(getActivity(), updatedList);
        contactsListView.setAdapter(contactsAdapter);


        contactsListView.setOnItemClickListener(onContactListViewItemClickListener);


    }

    AdapterView.OnItemClickListener onContactListViewItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Contacts contact = (Contacts) adapterView.getItemAtPosition(i);
            if (listener != null)
                listener.onContactSelected(contact);

        }
    };


}

