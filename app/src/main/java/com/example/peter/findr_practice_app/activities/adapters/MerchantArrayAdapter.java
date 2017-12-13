package com.example.peter.findr_practice_app.activities.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.peter.findr_practice_app.PracticeApp;
import com.example.peter.findr_practice_app.models.Merchant;

import java.util.List;

/**
 * Created by peter on 12/14/17.
 */

public class MerchantArrayAdapter extends ArrayAdapter<Merchant> {

    private int i;

    public MerchantArrayAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull List<Merchant> objects) {
        super(context, resource, textViewResourceId, objects);
        i = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(PracticeApp.getContext()).inflate(i, parent, false);


        }
        return convertView;
    }
}
