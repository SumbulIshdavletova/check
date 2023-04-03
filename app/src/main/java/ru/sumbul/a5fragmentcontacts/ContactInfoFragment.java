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
import java.util.Map;
import java.util.Set;

public class ContactInfoFragment extends Fragment {

    private final Contacts[] contacts = new Contacts[]{
            new Contacts(0, "Lee Taeyong", 19950701),
            new Contacts(1, "Moon Taeil", 19960614),
            new Contacts(2, "Johnny Soh", 19950209),
    };


    private final String[] contactNames = new String[]{"Lee Taeyong", "Moon Taeil", "Johnny Soh"};
    private final int[] contactNumbers = new int[]{19950701, 19940614, 19950209};

    EditText contactName;
    EditText number;
    String num;
    Button save;
    Integer result;


    public ContactInfoFragment() {
        super(R.layout.fragment_contact_info);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_contact_info, container, false);

        ContactViewModel model = new ViewModelProvider(this).get(ContactViewModel.class);
        contactName = rootView.findViewById(R.id.name);
        number = rootView.findViewById(R.id.number);
        save = rootView.findViewById(R.id.save);

        getParentFragmentManager().setFragmentResultListener("requestKey", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
                result = bundle.getInt("bundleKey");
                num = String.valueOf(getNumberByName(contacts[result].name));
                contactName.setText(contacts[result].name);
                number.setText(num);
            }
        });


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nn = contactName.getText().toString();
                int nnum = Integer.parseInt(number.getText().toString());

                model.editContact(result, nn, nnum);
                model.setContacts(result);

                Bundle result1 = new Bundle();
                result1.putInt("bundleKey", result);
                getParentFragmentManager().setFragmentResult("requestKey", result1);

                getParentFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.fragment_container_view, ContactsListFragment.class, null)
                        .addToBackStack("info")
                        .commit();


            }
        });

        return rootView;
    }

    public int getNumberByName(String name) {
        if (name.equals(contactNames[0])) {

            return contactNumbers[0];
        }
        if (name.equals(contactNames[1])) {
            return contactNumbers[1];
        } else {
            return contactNumbers[2];
        }
    }


}


