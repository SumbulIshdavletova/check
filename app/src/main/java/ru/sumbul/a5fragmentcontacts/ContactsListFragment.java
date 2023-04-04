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
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactsListFragment extends Fragment {


//    public List<Contacts> generateContactsList() {
//        List<Contacts> contacts = new ArrayList<Contacts>(10);
//
//        Contacts ty = new Contacts();
//        ty.setName("Lee");
//        ty.setNumber(19950701);
//        contacts.add(ty);
//
//        Contacts tl = new Contacts();
//        tl.setName("Moon");
//        tl.setNumber(19960614);
//        contacts.add(tl);
//
//        Contacts jh = new Contacts();
//        jh.setName("Johnny Soh");
//        jh.setNumber(19950209);
//        contacts.add(jh);
//
//        return contacts;
//    }

    //  List<Contacts> updatedList = generateContactsList();
    OnFragmentInteractionListener listener;
    int position;

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
        HashMap<Integer, Contacts> hashMap = new HashMap<>();
        Contacts n = new Contacts();
        n.setName("name");
        n.setNumber(2);
        hashMap.put(0, n);

        Contacts ty = new Contacts();
        ty.setName("Lee");
        ty.setNumber(19950701);
        hashMap.put(1, ty);

        Contacts tl = new Contacts();
        tl.setName("Moon");
        tl.setNumber(19960614);
        hashMap.put(2, tl);

        Contacts jh = new Contacts();
        jh.setName("Johnny Soh");
        jh.setNumber(19950209);
        hashMap.put(3, jh);

        Collection<Contacts> values = hashMap.values();
        ArrayList<Contacts> contactsList = new ArrayList<Contacts>(values);
        ListView contactsListView = (ListView) view.findViewById(android.R.id.list);
        ContactsAdapter contactsAdapter = new ContactsAdapter(getActivity(), contactsList);
        contactsListView.setAdapter(contactsAdapter);
        contactsListView.setOnItemClickListener(onContactListViewItemClickListener);

        getParentFragmentManager().setFragmentResultListener("requestKey", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
                bundle = getArguments();
                Contacts contact = (Contacts) bundle.getSerializable("requestKey");
                hashMap.put(position, contact);
                contactsAdapter.notifyDataSetChanged();
            }
        });




        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        ListView contactsListView = (ListView) view.findViewById(android.R.id.list);
//
//        ContactsAdapter contactsAdapter = new ContactsAdapter(getActivity(), updatedList);
//        contactsListView.setAdapter(contactsAdapter);
//
//        contactsListView.setOnItemClickListener(onContactListViewItemClickListener);

    }

    AdapterView.OnItemClickListener onContactListViewItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Contacts contact = (Contacts) adapterView.getItemAtPosition(i);
            position = i;
            if (listener != null)
                listener.onContactSelected(contact);

        }
    };


}

