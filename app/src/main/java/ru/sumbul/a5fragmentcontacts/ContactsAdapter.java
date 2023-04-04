package ru.sumbul.a5fragmentcontacts;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

public class ContactsAdapter extends BaseAdapter {

    Context context;
    List<Contacts> contactsList;

    public ContactsAdapter(Context context, List<Contacts> contactsList) {
        this.context = context;
        this.contactsList = contactsList;
    }


    @Override
    public int getCount() {
        return contactsList == null ? 0 : contactsList.size();
    }

    @Override
    public Contacts getItem(int i) {
        return contactsList == null ? null : contactsList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null)
            view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, null);
        Contacts contact = getItem(i);
        TextView nameTextView = (TextView) view.findViewById(android.R.id.text1);
        nameTextView.setText(contact.getName());
        return view;
    }
}

