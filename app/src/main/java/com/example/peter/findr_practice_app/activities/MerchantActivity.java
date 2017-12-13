package com.example.peter.findr_practice_app.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;

import com.example.peter.findr_practice_app.R;
import com.example.peter.findr_practice_app.callbacks.AppCallback;
import com.example.peter.findr_practice_app.logics.MerchantLogic;
import com.example.peter.findr_practice_app.models.Merchant;

import java.util.List;

/**
 * Created by peter on 12/14/17.
 */

public class MerchantActivity extends AppCompatActivity implements AppCallback<List<Merchant>> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_merchant);
    }

    @Override
    protected void onResume() {
        super.onResume();
        MerchantLogic merchantLogic = new MerchantLogic();
        merchantLogic.getMerchantList(this);
    }

    @Override
    public void onSuccess(List<Merchant> object) {

    }

    @Override
    public void onError(String error) {

    }
}
