package com.example.peter.findr_practice_app;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.peter.findr_practice_app.logics.AdminLogic;
import com.example.peter.findr_practice_app.models.Admin;

import java.util.List;

/**
 * Created by peter on 12/4/17.
 */

public class AdminArrayAdapter extends ArrayAdapter<Admin> {

    private int i;

    public AdminArrayAdapter(@NonNull Context context, int resource, @NonNull List<Admin> objects) {
        super(context, resource, objects);
        i = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(i, parent, false);
            TextView mName = (TextView) convertView.findViewById(R.id.tv_name);
            TextView mEmail = (TextView) convertView.findViewById(R.id.tv_email);

            Admin admin = getItem(position);

            mName.setText(admin.getName());
            mEmail.setText(admin.getEmail());
        }
        return convertView;
    }
}
