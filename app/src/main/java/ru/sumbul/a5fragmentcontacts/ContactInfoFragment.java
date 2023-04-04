package ru.sumbul.a5fragmentcontacts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.ViewModelProvider;

import org.w3c.dom.Text;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ContactInfoFragment extends Fragment {


    EditText contactName;
    EditText number;
    Button save;
    Contacts contact;
    Contacts editContact;

    public ContactInfoFragment() {
        super(R.layout.fragment_contact_info);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact_info, container, false);
        save = view.findViewById(R.id.save);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ContactViewModel viewModel = new ViewModelProvider(this).get(ContactViewModel.class);
        List<Contacts> contactsList = viewModel.generateContactsList();
        Bundle bundle = getArguments();
        assert bundle != null;
        if (bundle.containsKey("contact")) {
            contact = (Contacts) bundle.getSerializable("contact");
            contactName = view.findViewById(R.id.name);
            number = view.findViewById(R.id.number);
            int position = contact.getId();

            editContact = contactsList.get(position);

            contactName.setText(editContact.getName());
            number.setText(String.valueOf(editContact.getNumber()));


        }

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editContact.setName(String.valueOf(contactName.getText()));
                editContact.setNumber(Integer.parseInt(String.valueOf(number.getText())));
//
//                Contacts contact2 = new Contacts();
//                contact2.setName(String.valueOf(contactName.getText()));
//                contact2.setId(contact.getId());
//                contact2.setNumber(Integer.parseInt(String.valueOf(number.getText())));

                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("contact", editContact);
                ContactsListFragment contactsListFragment = new ContactsListFragment();
                contactsListFragment.setArguments(bundle2);
                bundle2.putSerializable("requestKey", editContact);
                getParentFragmentManager().setFragmentResult("requestKey", bundle2);
                if (bundle != null) {
                getParentFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.framelayout_left, contactsListFragment)
                        .addToBackStack("info")
                        .commit();
                        }
            }
        });

    }


}


