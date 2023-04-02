package ru.sumbul.a5fragmentcontacts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class ContactsListFragment extends Fragment {


    TextView contact1;
    TextView contact2;
    TextView contact3;

    public ContactsListFragment() {
        super(R.layout.fragment_contacts_list);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_contacts_list, container, false);


        contact1 = rootView.findViewById(R.id.contact1);
        contact2 = rootView.findViewById(R.id.contact2);
        contact3 = rootView.findViewById(R.id.contact3);

        contact1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle result = new Bundle();
                result.putString("bundleKey", String.valueOf(contact1.getText()));
                getParentFragmentManager().setFragmentResult("requestKey", result);

                getParentFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.fragment_container_view, ContactInfoFragment.class, null)
                        .addToBackStack("info")
                        .commit();
            }
        });

        contact2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle result = new Bundle();
                result.putString("bundleKey", String.valueOf(contact2.getText()));
                getParentFragmentManager().setFragmentResult("requestKey", result);

                getParentFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.fragment_container_view, ContactInfoFragment.class, null)
                        .addToBackStack("info")
                        .commit();
            }
        });


        contact3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle result = new Bundle();
                result.putString("bundleKey", String.valueOf(contact3.getText()));
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


