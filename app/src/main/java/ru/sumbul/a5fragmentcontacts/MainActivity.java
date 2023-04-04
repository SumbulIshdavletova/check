package ru.sumbul.a5fragmentcontacts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity implements OnFragmentInteractionListener { //FragmentActivity


    public MainActivity() {
        super(R.layout.activity_main);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        ContactsListFragment contactsListFragment = new ContactsListFragment();

        if (savedInstanceState == null) {

            Contacts contact2 = new Contacts();
            contact2.setName("Jeno");
            contact2.setNumber(20000423);

            Bundle bundle2 = new Bundle();
            bundle2.putSerializable("contact", contact2);

            contactsListFragment.setArguments(bundle2);
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.framelayout_left, contactsListFragment)
                    .addToBackStack("list")
                    .commit();


            if (findViewById(R.id.framelayout_right) != null) {
                Contacts contact = new Contacts();
                contact.setName("choose the contact");
                contact.setNumber(00000000);

                Bundle bundle = new Bundle();
                bundle.putSerializable("contact", contact);
                ContactInfoFragment contactInfoFragment = new ContactInfoFragment();

                contactInfoFragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.framelayout_right, contactInfoFragment)
                        .commit();
            }

        }
    }


    @Override
    public void onBackPressed() {

        int count = getSupportFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            super.onBackPressed();
        } else {
            getSupportFragmentManager().popBackStack();
        }

    }

    @Override
    public void onContactSelected(Contacts contact) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        int containerViewId = R.id.framelayout_left;

        if (findViewById(R.id.framelayout_right) != null)
            containerViewId = R.id.framelayout_right;

        Bundle bundle = new Bundle();
        bundle.putSerializable("contact", contact);

        ContactInfoFragment animalDetailFragment = new ContactInfoFragment();
        animalDetailFragment.setArguments(bundle);
        fragmentTransaction.replace(containerViewId, animalDetailFragment);
        if (findViewById(R.id.framelayout_right) == null)
            fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}