package ru.sumbul.a5fragmentcontacts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.ViewModelProvider;

import java.util.Arrays;

public class ContactsListFragment extends Fragment {

    private final String[] contactNames = new String[]{"Lee Taeyong", "Moon Taeil", "Johnny Soh"};

    private final Contacts[] contacts = new Contacts[]{
            new Contacts(0, "Lee Taeyong", 19950701),
            new Contacts(1, "Moon Taeil", 19960614),
            new Contacts(2, "Johnny Soh", 19950209),
    };

    TextView contact1;
    TextView contact2;
    TextView contact3;
    String result;

    public ContactsListFragment() {
        super(R.layout.fragment_contacts_list);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_contacts_list, container, false);


        contact1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle result = new Bundle();
                result.putInt("bundleKey", contacts[0].id);
                getParentFragmentManager().setFragmentResult("requestKey", result);

                getParentFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.fragment_container_view, ContactInfoFragment.class, null)
                        .addToBackStack("info")
                        .commit();
            }
        });

        return rootView;
    }


}


