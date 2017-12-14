package com.example.peter.findr_practice_app.activities.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.peter.findr_practice_app.PracticeApp;
import com.example.peter.findr_practice_app.R;
import com.example.peter.findr_practice_app.callbacks.AppCallback;
import com.example.peter.findr_practice_app.logics.MerchantLogic;
import com.example.peter.findr_practice_app.models.Base;

import java.util.List;

/**
 * Created by peter on 12/14/17.
 */

public class MerchantArrayAdapter extends ArrayAdapter<Base> implements AppCallback<String> {

    private int i;

    public MerchantArrayAdapter(@NonNull Context context, int resource, @NonNull List<Base> objects) {
        super(context, resource, objects);
        i = resource;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(PracticeApp.getContext()).inflate(i, parent, false);

            final Base base = getItem(position);
            CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.cb_status);

            ((TextView) convertView.findViewById(R.id.tv_name)).setText("Name: " + base.getMerchant().getName());
            ((TextView) convertView.findViewById(R.id.tv_business)).setText("Business " + base.getMerchant().getInfo().getBusiness().getName());
            ((TextView) convertView.findViewById(R.id.tv_credits)).setText("Findr Credits" + base.getFindrCredits());
            ((TextView) convertView.findViewById(R.id.tv_points)).setText("Findr Points" + base.getFindrPoints());
            checkBox.setChecked(base.getMerchant().isActive());

            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    MerchantLogic merchantLogic = new MerchantLogic();
                    merchantLogic.getStatus(base.getMerchant().getId(), b, MerchantArrayAdapter.this);
                }
            });

        }
        return convertView;
    }

    @Override
    public void onSuccess(String object) {
        Log.w("Activated", object);
    }

    @Override
    public void onError(String error) {
        Log.w("Activated", error);
    }
}
