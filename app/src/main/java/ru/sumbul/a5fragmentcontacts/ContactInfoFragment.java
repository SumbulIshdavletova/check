package ru.sumbul.a5fragmentcontacts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import org.w3c.dom.Text;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ContactInfoFragment extends Fragment {
    private final String[] contactNames = new String[]{"Lee Taeyong", "Moon Taeil", "Johnny Soh"};
    private final int[] contactNumbers = new int[]{19950701, 19940614, 19950209};

    TextView contactName;
    TextView number;
    String num;


    public ContactInfoFragment() {
        super(R.layout.fragment_contact_info);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_contact_info, container, false);


        contactName = rootView.findViewById(R.id.name);
        number = rootView.findViewById(R.id.number);

        getParentFragmentManager().setFragmentResultListener("requestKey", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
                String result = bundle.getString("bundleKey");
                num = String.valueOf(getNumberByName(result));
                contactName.setText(result);
                number.setText(num);
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


